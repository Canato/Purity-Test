package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.core.QuestionCategoryDomainEnum

internal interface QuestionsCategoryModelMapper {
    fun mapCategoryToModel(category: QuestionCategoryDomainEnum): QuestionCategoryModelEnum
}

internal class QuestionsCategoryModelMapperDefault() :
    QuestionsCategoryModelMapper {
    override fun mapCategoryToModel(category: QuestionCategoryDomainEnum): QuestionCategoryModelEnum {
        TODO("Not yet implemented")
    }
}
