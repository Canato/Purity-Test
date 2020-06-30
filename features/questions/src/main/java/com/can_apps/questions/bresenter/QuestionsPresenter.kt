package com.can_apps.questions.bresenter

import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDomain
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

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

    private fun CoroutineScope.retrieveData() = launch(dispatcher.IO) {
        when(val domain = interactor.retrieveList()) {
            is QuestionsDomain.Valid -> {
                val model = mapper.toModel(domain)
                showList(model)
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

    private fun CoroutineScope.showList(model: List<QuestionsModel>) = launch(dispatcher.UI) {
        view.hideLoading()
        view.showList(model)
    }


}