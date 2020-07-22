package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionObjectDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions_data_source.data.QuestionDataSourceDto

internal interface QuestionsMapperDomainValid {
    fun mapToDomainValid(asset: Set<QuestionDataSourceDto>): QuestionsDomain.Valid
}

internal class QuestionsMapperDomainValidDefault(
    private val assetCategoryMapper: QuestionsCategoryAssetMapper,
    private val assetIdMapper: QuestionsIdAssetMapper
) : QuestionsMapperDomainValid {

    override fun mapToDomainValid(asset: Set<QuestionDataSourceDto>): QuestionsDomain.Valid {
        val objectDomainSet = mutableSetOf<QuestionObjectDomain>()
        val questionDetailsDomainSet = mutableSetOf<QuestionDetailsDomain>()

        asset.forEach { questionDto ->

            val categoryDomainEnum =
                assetCategoryMapper.mapCategoryToDomain(questionDto.categoryName)

            questionDto.questions.forEach { question ->
                questionDetailsDomainSet.add(
                    QuestionDetailsDomain(
                        assetIdMapper.mapAssetId(categoryDomainEnum, question.id),
                        QuestionWeightDomain(question.weight)
                    )
                )

                objectDomainSet.add(
                    QuestionObjectDomain(
                        categoryDomainEnum,
                        questionDetailsDomainSet
                    )
                )
            }
        }

        return QuestionsDomain.Valid(objectDomainSet.toSet())
    }
}
