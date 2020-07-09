package com.can_apps.questions.data.questions_data_source

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.core.*
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions_data_source.data.QuestionsDataSourceDto


internal interface QuestionsDtoMapper {
    fun assetToDomain(asset: Set<QuestionsDataSourceDto>): QuestionsDomain
}

internal class QuestionsDtoMapperDefault(
    private val stringResource: CommonStringResourceWrapper,
    private val assetMapper: QuestionsMapperDomainValid
) :
    QuestionsDtoMapper {

    override fun assetToDomain(asset: Set<QuestionsDataSourceDto>): QuestionsDomain =
        when (asset == emptySet<QuestionsDataSourceDto>()) {
            true -> QuestionsDomain.Error(QuestionErrorDomain(stringResource.getString(R.string.questions_dto_error)))
            false -> assetMapper.mapToDomainValid(asset)
        }
}
