package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionSelectedDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions_data_source.data.QuestionsDataSourceDto

internal interface QuestionsMapperDomainValid {
    fun mapToDomainValid(asset: Set<QuestionsDataSourceDto>): QuestionsDomain.Valid
}

internal class QuestionsMapperDomainValidDefault(
    private val assetCategoryMapper: QuestionsCategoryAssetMapper,
    private val assetIdMapper: QuestionsIdAssetMapper
) : QuestionsMapperDomainValid {

    override fun mapToDomainValid(asset: Set<QuestionsDataSourceDto>): QuestionsDomain.Valid {
        val set = mutableSetOf<QuestionDetailsDomain>()
        asset.forEach { questionDto ->
            questionDto.questions.forEach { question ->
                val categoryDomainEnum =
                    assetCategoryMapper.mapCategoryToDomain(questionDto.categoryName)
                set.add(
                    QuestionDetailsDomain(
                        categoryDomainEnum,
                        assetIdMapper.mapAssetId(categoryDomainEnum, question.id),
                        QuestionWeightDomain(question.weight),
                        QuestionSelectedDomain(false)
                    )
                )
            }
        }

        return QuestionsDomain.Valid(set.toSet())
    }
}