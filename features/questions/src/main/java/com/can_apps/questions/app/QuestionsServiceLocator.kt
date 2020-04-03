package com.can_apps.questions.app

import android.content.Context
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryDefault
import com.can_apps.questions.bresenter.QuestionsModelMapper
import com.can_apps.questions.bresenter.QuestionsModelMapperDefault
import com.can_apps.questions.bresenter.QuestionsPresenter
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsInteractor
import com.can_apps.questions.data.QuestionsRepository

internal class QuestionsServiceLocator(private val context: Context) {

    fun getPresenter(): QuestionsContract.Presenter =
        QuestionsPresenter(
            getInteractor(),
            getModelMapper(),
            getCoroutineDispatcher()
        )

    fun getRecyclerViewAdapter(questionsFragment: QuestionsFragment): QuestionsRecyclerViewAdapter =
        QuestionsRecyclerViewAdapter(questionsFragment)

    private fun getInteractor(): QuestionsContract.Interactor = QuestionsInteractor(getRepository())

    private fun getRepository(): QuestionsContract.Repository = QuestionsRepository()

    private fun getModelMapper(): QuestionsModelMapper = QuestionsModelMapperDefault()

    private fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryDefault()
}