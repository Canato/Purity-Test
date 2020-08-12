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
            QuestionCategoryDomainEnum.INVALID -> QuestionCategoryModelEnum.INVALID
            QuestionCategoryDomainEnum.BANDITRY -> QuestionCategoryModelEnum.BANDITRY
            QuestionCategoryDomainEnum.MAKE_OUT -> QuestionCategoryModelEnum.MAKE_OUT
            QuestionCategoryDomainEnum.NERVOUS_MOUTH -> QuestionCategoryModelEnum.NERVOUS_MOUTH
            QuestionCategoryDomainEnum.MASTURBATION -> QuestionCategoryModelEnum.MASTURBATION
            QuestionCategoryDomainEnum.SINS -> QuestionCategoryModelEnum.SINS
            QuestionCategoryDomainEnum.EXHIBITIONISM -> QuestionCategoryModelEnum.EXHIBITIONISM
            QuestionCategoryDomainEnum.CRAZY_LIFE -> QuestionCategoryModelEnum.CRAZY_LIFE
            QuestionCategoryDomainEnum.LEGAL_DRUGS -> QuestionCategoryModelEnum.LEGAL_DRUGS
            QuestionCategoryDomainEnum.ILLEGAL_DRUGS -> QuestionCategoryModelEnum.ILLEGAL_DRUGS
            QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS -> QuestionCategoryModelEnum.UNIVERSITY_FEELINGS
            QuestionCategoryDomainEnum.SEX -> QuestionCategoryModelEnum.SEX
            QuestionCategoryDomainEnum.PURITY_SEEKER -> QuestionCategoryModelEnum.PURITY_SEEKER
        }
}
