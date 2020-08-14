package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionLastCategoryDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions_data_source.data.QuestionDataSourceDto

internal interface QuestionsMapperDomainValid {
    fun mapToDomainValid(asset: List<QuestionDataSourceDto>): List<QuestionsDomain.Valid>
}

internal class QuestionsMapperDomainValidDefault(
    private val assetCategoryMapper: QuestionsCategoryAssetMapper,
    private val assetIdMapper: QuestionsIdAssetMapper
) : QuestionsMapperDomainValid {

    override fun mapToDomainValid(asset: List<QuestionDataSourceDto>): List<QuestionsDomain.Valid> {
        val questionDomainValidSet = mutableListOf<QuestionsDomain.Valid>()
        val lastQuestion = asset.last()

        asset.forEach { questionDto ->
            val questionDetailsDomainSet = mutableSetOf<QuestionDetailsDomain>()
            val categoryDomainEnum =
                assetCategoryMapper.mapCategoryToDomain(questionDto.categoryName)

            val lastCategoryValue = lastQuestion == questionDto
            val questionLastCategoryDomain = QuestionLastCategoryDomain(lastCategoryValue)

            questionDto.questions.forEach { question ->
                questionDetailsDomainSet.add(
                    QuestionDetailsDomain(
                        assetIdMapper.mapAssetId(categoryDomainEnum, question.id),
                        QuestionWeightDomain(question.weight)
                    )
                )
            }

            questionDomainValidSet.add(
                QuestionsDomain.Valid(
                    categoryDomainEnum,
                    questionLastCategoryDomain,
                    questionDetailsDomainSet
                )
            )
        }

        return questionDomainValidSet
    }
}
