package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum

internal interface QuestionsCategoryAssetMapper {
    fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum
}

internal class QuestionsCategoryAssetMapperDefault() : QuestionsCategoryAssetMapper {
    override fun mapCategoryToDomain(category: String): QuestionCategoryDomainEnum {
        TODO()
    }
}
