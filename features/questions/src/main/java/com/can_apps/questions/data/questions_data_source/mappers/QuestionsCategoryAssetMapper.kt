package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum

internal interface QuestionsCategoryAssetMapper {
    fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum
}

internal class QuestionsCategoryAssetMapperDefault() : QuestionsCategoryAssetMapper {
    override fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum =
        when (category) {
            "drugs" -> QuestionCategoryDomainEnum.DRUGS
            "sex" -> QuestionCategoryDomainEnum.SEX
            "religion" -> QuestionCategoryDomainEnum.RELIGION
            else -> QuestionCategoryDomainEnum.INVALID
        }
}
