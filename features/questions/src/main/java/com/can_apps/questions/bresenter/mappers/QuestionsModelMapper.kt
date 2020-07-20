package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionsModel
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
        TODO()
    }
}
