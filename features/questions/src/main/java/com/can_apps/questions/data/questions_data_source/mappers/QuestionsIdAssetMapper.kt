package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdAssetMapper {
    fun mapAssetId(category: QuestionCategoryDomainEnum, id: Int): QuestionIdDomainEnum
}

internal class QuestionsIdAssetMapperDefault(
    private val idDomainMapper: QuestionsIdAssetToDomainMapper
) : QuestionsIdAssetMapper {
    override fun mapAssetId(
        category: QuestionCategoryDomainEnum,
        id: Int
    ): QuestionIdDomainEnum {
            TODO("Not yet implemented")
    }
}
