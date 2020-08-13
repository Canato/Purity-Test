package com.can_apps.questions.bresenter

import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapper
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDomain
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class QuestionsPresenter(
    private val interactor: QuestionsContract.Interactor,
    private val mapper: QuestionsModelMapper,
    private val dispatcher: CoroutineDispatcherFactory
) : QuestionsContract.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = dispatcher.UI + job

    private lateinit var view: QuestionsContract.View

    override fun bind(view: QuestionsContract.View) {
        this.view = view
    }

    override fun unbind() {
        job.cancel()
    }

    override fun onViewCreated() {
        view.showLoading()
        retrieveData()
    }

    override fun onBackPressed() {
        view.close()
    }

    override fun fetchNextCategoryQuestions() {
        view.showLoading()
        retrieveNextList()
    }

    private fun CoroutineScope.retrieveData() = launch(dispatcher.IO) {
        when (val domain = interactor.retrieveQuestionsDomain()) {
            is QuestionsDomain.Valid -> {
                val model = mapper.toModel(domain)
                showList(model.questionsModelDetails.toList(), model.questionCategory.name)
            }

            is QuestionsDomain.Error -> {
                showError(domain.message.value)
            }
        }
    }

    private fun CoroutineScope.retrieveNextList() = launch(dispatcher.IO) {
        when (val domain = interactor.retrieveQuestionsDomain()) {
            is QuestionsDomain.Valid -> {
                val model = mapper.toModel(domain)
                showList(model.questionsModelDetails.toList(), model.questionCategory.name)
                checkIfLastCategory()
            }

            is QuestionsDomain.Error -> {
                showError(domain.message.value)
            }
        }
    }

    private fun checkIfLastCategory() {
        if (interactor.isLastShownCategory())
            setNewActionButtonFunction()
    }

    private fun CoroutineScope.showError(message: String) = launch(dispatcher.UI) {
        view.hideLoading()
        view.showError(message)
    }

    private fun CoroutineScope.showList(model: List<QuestionsModelDetails>, category: String) =
        launch(dispatcher.UI) {
            view.hideLoading()
            view.showCategory(category)
            view.showList(model)
        }

    private fun CoroutineScope.setNewActionButtonFunction() = launch(dispatcher.UI) {
        view.setNewActionButtonFunction()
    }
}
