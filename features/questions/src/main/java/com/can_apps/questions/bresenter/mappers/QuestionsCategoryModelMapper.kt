package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.core.QuestionCategoryDomainEnum

internal interface QuestionsCategoryModelMapper {
    fun mapCategoryToModel(category: QuestionCategoryDomainEnum): QuestionCategoryModelEnum
}

internal class QuestionsCategoryModelMapperDefault() :
    QuestionsCategoryModelMapper {
    override fun mapCategoryToModel(category: QuestionCategoryDomainEnum): QuestionCategoryModelEnum =
        when (category) {
            QuestionCategoryDomainEnum.DRUGS -> QuestionCategoryModelEnum.DRUGS
            QuestionCategoryDomainEnum.SEX -> QuestionCategoryModelEnum.SEX
            QuestionCategoryDomainEnum.RELIGION -> QuestionCategoryModelEnum.RELIGION
            QuestionCategoryDomainEnum.INVALID -> QuestionCategoryModelEnum.INVALID
        }
}
