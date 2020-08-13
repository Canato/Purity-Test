package com.can_apps.questions.data.questions_data_source

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.core.QuestionErrorDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions_data_source.data.QuestionDataSourceDto

internal interface QuestionsDtoMapper {
    fun assetToDomain(asset: List<QuestionDataSourceDto>): List<QuestionsDomain>
}

internal class QuestionsDtoMapperDefault(
    private val stringResource: CommonStringResourceWrapper,
    private val assetMapper: QuestionsMapperDomainValid
) :
    QuestionsDtoMapper {

    override fun assetToDomain(asset: List<QuestionDataSourceDto>): List<QuestionsDomain> =
        when (asset == emptyList<QuestionDataSourceDto>()) {
            true -> listOf(QuestionsDomain.Error(QuestionErrorDomain(stringResource.getString(R.string.questions_dto_error))))
            false -> assetMapper.mapToDomainValid(asset)
        }
}
