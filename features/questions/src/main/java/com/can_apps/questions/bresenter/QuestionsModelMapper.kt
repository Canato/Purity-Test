package com.can_apps.questions.bresenter

import com.can_apps.questions.core.QuestionSelectedDomain
import com.can_apps.questions.core.QuestionsDomain

internal interface QuestionsModelMapper {

    fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel>
}

internal class QuestionsModelMapperDefault : QuestionsModelMapper {

    override fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel> =

        domain.questions.map {
            QuestionsModel(
                QuestionCategoryModel(it.category.value),
                QuestionIdModel(it.id.value),
                QuestionWeightModel(it.weight.value),
                QuestionSelectedModel(it.isSelected.value)
            )
        }.toList()
}