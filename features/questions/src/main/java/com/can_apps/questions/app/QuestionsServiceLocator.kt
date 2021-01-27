package com.can_apps.questions.app

import android.content.Context
import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryDefault
import com.can_apps.questions.bresenter.QuestionsPresenter
import com.can_apps.questions.bresenter.mappers.QuestionsCategoryModelMapper
import com.can_apps.questions.bresenter.mappers.QuestionsCategoryModelMapperDefault
import com.can_apps.questions.bresenter.mappers.QuestionsIdDomainMapper
import com.can_apps.questions.bresenter.mappers.QuestionsIdDomainMapperDefault
import com.can_apps.questions.bresenter.mappers.QuestionsIdDomainToModelMapper
import com.can_apps.questions.bresenter.mappers.QuestionsIdDomainToModelMapperDefault
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapper
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapperDefault
import com.can_apps.questions.bresenter.mappers.QuestionsTextModelMapper
import com.can_apps.questions.bresenter.mappers.QuestionsTextModelMapperDefault
import com.can_apps.questions.bresenter.mappers.QuestionsTextModelStringMapper
import com.can_apps.questions.bresenter.mappers.QuestionsTextModelStringMapperDefault
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsInteractor
import com.can_apps.questions.data.QuestionsRepository
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetToDomainMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetToDomainMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValidDefault
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssetsDefault

internal open class QuestionsServiceLocator(private val context: Context) {

    fun getPresenter(): QuestionsContract.Presenter =
        QuestionsPresenter(
            getInteractor(),
            getModelMapper(),
            getCoroutineDispatcher(),
            getStringResource(),
        )

    fun getRecyclerViewAdapter(questionsFragment: QuestionsFragment): QuestionsRecyclerViewAdapter =
        QuestionsRecyclerViewAdapter(questionsFragment)

    private fun getInteractor(): QuestionsContract.Interactor =
        QuestionsInteractor(getRepository())

    private fun getRepository(): QuestionsContract.Repository =
        QuestionsRepository(getAsset(), getDtoMapper())

    open fun getAsset(): QuestionsDataSourceAssets =
        QuestionsDataSourceAssetsDefault(context)

    private fun getDtoMapper(): QuestionsDtoMapper =
        QuestionsDtoMapperDefault(getAssetMapper())

    private fun getAssetMapper(): QuestionsMapperDomainValid =
        QuestionsMapperDomainValidDefault(getCategoryDomainMapper(), getIdAssetMapper())

    private fun getCategoryDomainMapper(): QuestionsCategoryAssetMapper =
        QuestionsCategoryAssetMapperDefault()

    private fun getIdAssetMapper(): QuestionsIdAssetMapper =
        QuestionsIdAssetMapperDefault(getIdAssetToDomainMapper())

    private fun getIdAssetToDomainMapper(): QuestionsIdAssetToDomainMapper =
        QuestionsIdAssetToDomainMapperDefault()

    open fun getStringResource(): CommonStringResourceWrapper =
        CommonStringResourceWrapper(context)

    private fun getModelMapper(): QuestionsModelMapper =
        QuestionsModelMapperDefault(
            getCategoryModelMapper(),
            getIdModelMapper(),
            getTextModelMapper()
        )

    private fun getCategoryModelMapper(): QuestionsCategoryModelMapper =
        QuestionsCategoryModelMapperDefault()

    private fun getIdModelMapper(): QuestionsIdDomainMapper =
        QuestionsIdDomainMapperDefault(getIdDomainToModelMapper())

    private fun getIdDomainToModelMapper(): QuestionsIdDomainToModelMapper =
        QuestionsIdDomainToModelMapperDefault()

    private fun getTextModelMapper(): QuestionsTextModelMapper =
        QuestionsTextModelMapperDefault(getTextModelStringMapper())

    private fun getTextModelStringMapper(): QuestionsTextModelStringMapper =
        QuestionsTextModelStringMapperDefault(getStringResource())

    open fun getCoroutineDispatcher(): CoroutineDispatcherFactory =
        CoroutineDispatcherFactoryDefault()
}
