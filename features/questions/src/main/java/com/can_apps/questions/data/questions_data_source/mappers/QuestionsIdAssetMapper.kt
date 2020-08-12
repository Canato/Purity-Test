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
            QuestionCategoryDomainEnum.BANDITRY -> idDomainMapper.mapIdToBanditryDomain(id)
            QuestionCategoryDomainEnum.MAKE_OUT -> idDomainMapper.mapIdToMakeOutDomain(id)
            QuestionCategoryDomainEnum.NERVOUS_MOUTH -> idDomainMapper.mapIdToNervousMouthDomain(id)
            QuestionCategoryDomainEnum.MASTURBATION -> idDomainMapper.mapIdToMasturbationDomain(id)
            QuestionCategoryDomainEnum.SINS -> idDomainMapper.mapIdToSinsDomain(id)
            QuestionCategoryDomainEnum.EXHIBITIONISM -> idDomainMapper.mapIdToExhibitionismDomain(id)
            QuestionCategoryDomainEnum.CRAZY_LIFE -> idDomainMapper.mapIdToCrazyLifeDomain(id)
            QuestionCategoryDomainEnum.LEGAL_DRUGS -> idDomainMapper.mapIdToLegalDrugsDomain(id)
            QuestionCategoryDomainEnum.ILLEGAL_DRUGS -> idDomainMapper.mapIdToIllegalDrugsDomain(id)
            QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS -> idDomainMapper.mapIdToUniFeelingsDomain(id)
            QuestionCategoryDomainEnum.SEX -> idDomainMapper.mapIdToSexDomain(id)
            QuestionCategoryDomainEnum.PURITY_SEEKER -> idDomainMapper.mapIdToPurityDomain(id)
            QuestionCategoryDomainEnum.INVALID -> QuestionIdDomainEnum.INVALID
        }
}
