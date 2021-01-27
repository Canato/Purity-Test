package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionCategoryDomainEnum.BANDITRY
import com.can_apps.questions.core.QuestionCategoryDomainEnum.CRAZY_LIFE
import com.can_apps.questions.core.QuestionCategoryDomainEnum.EXHIBITIONISM
import com.can_apps.questions.core.QuestionCategoryDomainEnum.ILLEGAL_DRUGS
import com.can_apps.questions.core.QuestionCategoryDomainEnum.INVALID
import com.can_apps.questions.core.QuestionCategoryDomainEnum.LEGAL_DRUGS
import com.can_apps.questions.core.QuestionCategoryDomainEnum.MAKE_OUT
import com.can_apps.questions.core.QuestionCategoryDomainEnum.MASTURBATION
import com.can_apps.questions.core.QuestionCategoryDomainEnum.NERVOUS_MOUTH
import com.can_apps.questions.core.QuestionCategoryDomainEnum.PURITY_SEEKER
import com.can_apps.questions.core.QuestionCategoryDomainEnum.SEX
import com.can_apps.questions.core.QuestionCategoryDomainEnum.SINS
import com.can_apps.questions.core.QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS

internal interface QuestionsCategoryAssetMapper {

    fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum
}

internal class QuestionsCategoryAssetMapperDefault : QuestionsCategoryAssetMapper {
    override fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum =
        when (category) {
            "banditry" -> BANDITRY
            "make_out" -> MAKE_OUT
            "NERVOUS MOUTH" -> NERVOUS_MOUTH
            "masturbation" -> MASTURBATION
            "Sins" -> SINS
            "Exhibitionism" -> EXHIBITIONISM
            "Crazy Life" -> CRAZY_LIFE
            "Legal Drugs" -> LEGAL_DRUGS
            "Illegal Drugs" -> ILLEGAL_DRUGS
            "University Feelings" -> UNIVERSITY_FEELINGS
            "Sex" -> SEX
            "purity_seeker" -> PURITY_SEEKER
            else -> INVALID
        }
}
