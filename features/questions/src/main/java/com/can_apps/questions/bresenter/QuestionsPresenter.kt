package com.can_apps.questions.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapper
import com.can_apps.questions.core.QuestionsContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

internal class QuestionsPresenter(
    private val interactor: QuestionsContract.Interactor,
    private val mapper: QuestionsModelMapper,
    private val dispatcher: CoroutineDispatcherFactory,
    private val stringResource: CommonStringResourceWrapper,
) : QuestionsContract.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = dispatcher.UI + job

    private lateinit var view: QuestionsContract.View
    private var model: QuestionsModel? = null

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
        try {
            model = interactor.retrieveQuestionsDomain(null)?.let { mapper.toModel(it) }
            model?.let { showList(it) } // ?: Go to results screen, nothing else to show
        } catch (e: Exception) {
            showError(e.message ?: stringResource.getString(R.string.questions_dto_error))
        }
    }

    private fun CoroutineScope.retrieveNextList() = launch(dispatcher.IO) {

        try {
            model = interactor.retrieveQuestionsDomain(model?.questionCategory?.name)
                ?.let { mapper.toModel(it) }

            model?.let {
                showList(it)
                if (it.isLastCategory.value) setNewActionButtonFunction()
            } // ?: Go to results screen, nothing else to show
        } catch (e: Exception) {
            showError(e.message ?: stringResource.getString(R.string.questions_dto_error))
        }
    }

    private fun CoroutineScope.showError(message: String) = launch(dispatcher.UI) {
        view.hideLoading()
        view.showError(message)
    }

    private fun CoroutineScope.showList(model: QuestionsModel) =
        launch(dispatcher.UI) {
            view.hideLoading()
            view.showCategory(model.questionCategory.name)
            view.showList(model.questionsModelDetails.toList())
        }

    private fun CoroutineScope.setNewActionButtonFunction() = launch(dispatcher.UI) {
        view.setNewActionButtonFunction()
    }
}
