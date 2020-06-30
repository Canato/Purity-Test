package com.can_apps.questions.app

import android.content.Context
import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryDefault
import com.can_apps.questions.bresenter.QuestionsModelMapper
import com.can_apps.questions.bresenter.QuestionsModelMapperDefault
import com.can_apps.questions.bresenter.QuestionsPresenter
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsInteractor
import com.can_apps.questions.data.QuestionsRepository
import com.can_apps.questions.data.questions_data_source.QuestionsApi
import com.can_apps.questions.data.questions_data_source.QuestionsApiDefault
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapperDefault
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssetsDefault

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

    private fun getRepository(): QuestionsContract.Repository = QuestionsRepository(getApi(), getDtoMapper())

    private fun getDtoMapper(): QuestionsDtoMapper = QuestionsDtoMapperDefault(getStringResource())

    private fun getStringResource(): CommonStringResourceWrapper = CommonStringResourceWrapper(context)

    private fun getApi(): QuestionsApi = QuestionsApiDefault(QuestionsDataSourceAssetsDefault(context))

    private fun getModelMapper(): QuestionsModelMapper = QuestionsModelMapperDefault()

    private fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryDefault()
}