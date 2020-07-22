package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionWeightModel
import com.can_apps.questions.bresenter.QuestionsModel
import com.can_apps.questions.bresenter.QuestionsModelDetails
import com.can_apps.questions.core.QuestionsDomain

internal interface QuestionsModelMapper {
    fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel>
}

internal class QuestionsModelMapperDefault(
    private var categoryMapper: QuestionsCategoryModelMapper,
    private var idMapper: QuestionsIdDomainMapper,
    private var textMapper: QuestionsTextModelMapper
) : QuestionsModelMapper {

    override fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel> {
        val questionsModel = mutableSetOf<QuestionsModel>()
        val questionsModelDetails = mutableSetOf<QuestionsModelDetails>()

        domain.validSet.map { questionsObjectDomain ->
            val categoryModelEnum =
                categoryMapper.mapCategoryToModel(questionsObjectDomain.category)

            questionsObjectDomain.questions.forEach { questionsDetailDomain ->
                val idModelEnum = idMapper.mapDomainId(categoryModelEnum, questionsDetailDomain.id)
                val textModel = textMapper.mapText(categoryModelEnum, idModelEnum)
                questionsModelDetails.add(
                    QuestionsModelDetails(
                        idModelEnum,
                        textModel,
                        QuestionWeightModel(questionsDetailDomain.weight.value)

                    )
                )
                questionsModel.add(
                    QuestionsModel(
                        categoryModelEnum,
                        questionsModelDetails
                    )
                )
            }
        }

        return questionsModel.toList()
    }
}
