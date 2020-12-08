package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionLastCategoryModel
import com.can_apps.questions.bresenter.QuestionTextModel
import com.can_apps.questions.bresenter.QuestionWeightModel
import com.can_apps.questions.bresenter.QuestionsModel
import com.can_apps.questions.bresenter.QuestionsModelDetails
import com.can_apps.questions.core.QuestionsDetailsDomain

internal interface QuestionsModelMapper {

    fun toModel(domain: QuestionsDetailsDomain): QuestionsModel
}

internal class QuestionsModelMapperDefault(
    private var categoryMapper: QuestionsCategoryModelMapper,
    private var idMapper: QuestionsIdDomainMapper,
    private var textMapper: QuestionsTextModelMapper,
) : QuestionsModelMapper {

    override fun toModel(domain: QuestionsDetailsDomain): QuestionsModel {
        val categoryEnum = categoryMapper.mapCategoryToModel(domain.category)
        val isLast = QuestionLastCategoryModel(domain.isLastCategory.value)

        val questions = domain.questions.map {
            val idEnum = idMapper.mapDomainId(categoryEnum, it.id)
            QuestionsModelDetails(
                idEnum,
                QuestionTextModel(textMapper.mapText(categoryEnum, idEnum)),
                QuestionWeightModel(it.weight.value),
            )
        }.toSet()

        return QuestionsModel(categoryEnum, isLast, questions)
    }
}
