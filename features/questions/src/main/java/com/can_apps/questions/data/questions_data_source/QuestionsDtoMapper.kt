package com.can_apps.questions.data.questions_data_source

import com.can_apps.questions.core.QuestionsDetailsDomain
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions_data_source.data.QuestionDataSourceDto

internal interface QuestionsDtoMapper {

    fun assetToDomain(asset: List<QuestionDataSourceDto>): List<QuestionsDetailsDomain>
}

internal class QuestionsDtoMapperDefault(
    private val assetMapper: QuestionsMapperDomainValid
) : QuestionsDtoMapper {

    override fun assetToDomain(asset: List<QuestionDataSourceDto>): List<QuestionsDetailsDomain> =
        if (asset.isNotEmpty()) assetMapper.mapToDomainValid(asset) else emptyList()
}
