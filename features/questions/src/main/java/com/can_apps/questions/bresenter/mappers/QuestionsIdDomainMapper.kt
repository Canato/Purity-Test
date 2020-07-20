package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdDomainMapper {
    fun mapDomainId(
        category: QuestionCategoryModelEnum,
        id: QuestionIdDomainEnum
    ): QuestionIdModelEnum
}

internal class QuestionsIdDomainMapperDefault(
    private val idDomainMapper: QuestionsIdDomainToModelMapper
) : QuestionsIdDomainMapper {
    override fun mapDomainId(
        category: QuestionCategoryModelEnum,
        id: QuestionIdDomainEnum
    ): QuestionIdModelEnum {
        TODO("Not yet implemented")
    }
}
