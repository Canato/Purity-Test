package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.*
import com.can_apps.questions.bresenter.QuestionCategoryModel
import com.can_apps.questions.bresenter.QuestionIdModel
import com.can_apps.questions.bresenter.QuestionSelectedModel
import com.can_apps.questions.bresenter.QuestionsModel
import com.can_apps.questions.core.QuestionsDomain

internal interface QuestionsModelMapper {
    fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel>
}

internal class QuestionsModelMapperDefault(
) : QuestionsModelMapper {

    override fun toModel(domain: QuestionsDomain.Valid): List<QuestionsModel> =

        TODO()

}