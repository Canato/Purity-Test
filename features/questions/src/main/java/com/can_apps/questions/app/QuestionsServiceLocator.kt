package com.can_apps.questions.app

import android.content.Context
import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryDefault
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapper
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapperDefault
import com.can_apps.questions.bresenter.QuestionsPresenter
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsInteractor
import com.can_apps.questions.data.QuestionsRepository
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.*
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdDomainMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValidDefault
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssetsDefault

internal class QuestionsServiceLocator(private val context: Context) {

    fun getPresenter(): QuestionsContract.Presenter =
        QuestionsPresenter(getInteractor(), getModelMapper(), getCoroutineDispatcher())

    fun getRecyclerViewAdapter(questionsFragment: QuestionsFragment): QuestionsRecyclerViewAdapter =
        QuestionsRecyclerViewAdapter(questionsFragment)

    private fun getInteractor(): QuestionsContract.Interactor = QuestionsInteractor(getRepository())

    private fun getRepository(): QuestionsContract.Repository = QuestionsRepository(getAsset(), getDtoMapper())

    private fun getAsset(): QuestionsDataSourceAssets = QuestionsDataSourceAssetsDefault(context)

    private fun getDtoMapper(): QuestionsDtoMapper = QuestionsDtoMapperDefault(getStringResource(), getAssetMapper())

    private fun getAssetMapper(): QuestionsMapperDomainValid = QuestionsMapperDomainValidDefault(getCategoryDomainMapper(), getIdAssetMapper())

    private fun getCategoryDomainMapper(): QuestionsCategoryAssetMapper = QuestionsCategoryAssetMapperDefault()

    private fun getIdAssetMapper(): QuestionsIdAssetMapper = QuestionsIdAssetMapperDefault(getIdDomainMapper())

    private fun getIdDomainMapper(): QuestionsIdDomainMapper = QuestionsIdDomainMapperDefault()

    private fun getStringResource(): CommonStringResourceWrapper = CommonStringResourceWrapper(context)

    private fun getModelMapper(): QuestionsModelMapper = QuestionsModelMapperDefault()

    private fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryDefault()
}