package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum

internal interface QuestionsCategoryAssetMapper {
    fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum
}

internal class QuestionsCategoryAssetMapperDefault() : QuestionsCategoryAssetMapper {
    override fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum =
        when (category) {
            "banditry" -> QuestionCategoryDomainEnum.BANDITRY
            "make_out" -> QuestionCategoryDomainEnum.MAKE_OUT
            "NERVOUS MOUTH" -> QuestionCategoryDomainEnum.NERVOUS_MOUTH
            "masturbation" -> QuestionCategoryDomainEnum.MASTURBATION
            "Sins" -> QuestionCategoryDomainEnum.SINS
            "Exhibitionism" -> QuestionCategoryDomainEnum.EXHIBITIONISM
            "Crazy Life" -> QuestionCategoryDomainEnum.CRAZY_LIFE
            "Legal Drugs" -> QuestionCategoryDomainEnum.LEGAL_DRUGS
            "Illegal Drugs" -> QuestionCategoryDomainEnum.ILLEGAL_DRUGS
            "University Feelings" -> QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS
            "Sex" -> QuestionCategoryDomainEnum.SEX
            "purity_seeker" -> QuestionCategoryDomainEnum.PURITY_SEEKER
            else -> QuestionCategoryDomainEnum.INVALID
        }
}
