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
    ): QuestionIdDomainEnum =
        when (category) {
            QuestionCategoryDomainEnum.DRUGS -> idDomainMapper.mapIdToDrugsDomain(id)
            QuestionCategoryDomainEnum.SEX -> idDomainMapper.mapIdToSexDomain(id)
            QuestionCategoryDomainEnum.RELIGION -> idDomainMapper.mapIdToReligionDomain(id)
            QuestionCategoryDomainEnum.BANDITRY -> idDomainMapper.mapBanditryToDomain(id)
            QuestionCategoryDomainEnum.INVALID -> QuestionIdDomainEnum.INVALID
        }
}
