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

    private val categoryList = listOf(
        QuestionCategoryModelEnum.SEX
    )

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

    // TODO next PR - > implementation
    private fun CoroutineScope.retrieveData() = launch(dispatcher.IO) {
        when (val domain = interactor.retrieveList(
//            categoryList[0]
        )) {
            is QuestionsDomain.Valid -> {
                val model = mapper.toModel(domain)
                // TODO logic for category [0] issue
                showList(model[0].questionsModelDetails.toList(), model[0].questionCategory.name)
            }

            is QuestionsDomain.Error -> {
                showError(domain.message.value)
            }
        }
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
}
