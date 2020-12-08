package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomain
import com.can_apps.questions.core.QuestionLastCategoryDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDetailsDomain
import com.can_apps.questions_data_source.data.QuestionDataSourceDto

internal interface QuestionsMapperDomainValid {
    fun mapToDomainValid(asset: List<QuestionDataSourceDto>): List<QuestionsDetailsDomain>
}

internal class QuestionsMapperDomainValidDefault(
    private val assetCategoryMapper: QuestionsCategoryAssetMapper,
    private val assetIdMapper: QuestionsIdAssetMapper
) : QuestionsMapperDomainValid {

    override fun mapToDomainValid(
        asset: List<QuestionDataSourceDto>
    ): List<QuestionsDetailsDomain> =
        asset.map { dto ->
            val enum = assetCategoryMapper.mapCategoryToDomain(dto.categoryName)
            val isLast = QuestionLastCategoryDomain(dto.categoryName == asset.last().categoryName)
            val questions = dto.questions.map {
                QuestionCategoryDomain(
                    assetIdMapper.mapAssetId(enum, it.id),
                    QuestionWeightDomain(it.weight)
                )
            }.toSet()

            QuestionsDetailsDomain(enum, isLast, questions)
        }
}
