package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionTextModel
import com.can_apps.questions.bresenter.QuestionWeightModel
import com.can_apps.questions.bresenter.QuestionsModel
import com.can_apps.questions.bresenter.QuestionsModelDetails
import com.can_apps.questions.core.QuestionsDomain

internal interface QuestionsModelMapper {
    fun toModel(domain: QuestionsDomain.Valid): QuestionsModel
}

internal class QuestionsModelMapperDefault(
    private var categoryMapper: QuestionsCategoryModelMapper,
    private var idMapper: QuestionsIdDomainMapper,
    private var textMapper: QuestionsTextModelMapper
) : QuestionsModelMapper {

    override fun toModel(domain: QuestionsDomain.Valid): QuestionsModel {

        val questionsModelDetails = mutableSetOf<QuestionsModelDetails>()
        val categoryModelEnum =
            categoryMapper.mapCategoryToModel(domain.category)
        domain.questions.forEach { question ->

            val idModelEnum = idMapper.mapDomainId(categoryModelEnum, question.id)
            val textModel = QuestionTextModel(textMapper.mapText(categoryModelEnum, idModelEnum))
            questionsModelDetails.add(
                QuestionsModelDetails(
                    idModelEnum,
                    textModel,
                    QuestionWeightModel(question.weight.value)
                )
            )
        }

        return QuestionsModel(categoryModelEnum, questionsModelDetails)
    }
}
