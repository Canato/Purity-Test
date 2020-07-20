package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionTextModel

internal interface QuestionsTextModelMapper {
    fun mapText(categoryModelEnum: QuestionCategoryModelEnum, idModelEnum: QuestionIdModelEnum): QuestionTextModel
}

internal class QuestionsTextModelMapperDefault() : QuestionsTextModelMapper {
    override fun mapText(
        categoryModelEnum: QuestionCategoryModelEnum,
        idModelEnum: QuestionIdModelEnum
    ): QuestionTextModel {
        TODO("Not yet implemented")
    }
}
