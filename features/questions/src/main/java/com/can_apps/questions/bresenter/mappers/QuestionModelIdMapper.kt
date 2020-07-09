package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionTextModel
import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionModelIdMapper {
    fun idTextMapper(categoryDomainEnum: QuestionCategoryDomainEnum, idDomainEnum: QuestionIdDomainEnum) : QuestionTextModel
}

internal class QuestionModelIdMapperDefault() : QuestionModelIdMapper{
    override fun idTextMapper(
        categoryDomainEnum: QuestionCategoryDomainEnum,
        idDomainEnum: QuestionIdDomainEnum
    ): QuestionTextModel
      = TODO()


}