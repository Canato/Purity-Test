package com.can_apps.questions.bresenter

import com.can_apps.questions.core.QuestionsDomain

internal interface QuestionsModelMapper {

    fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel>
}

internal class QuestionsModelMapperDefault : QuestionsModelMapper {

    override fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel> =
        domain.questions.map {
            QuestionsModel(
                QuestionModel(it.question.value),
                QuestionIdModel(it.id.value)
            )
        }.toList()
}