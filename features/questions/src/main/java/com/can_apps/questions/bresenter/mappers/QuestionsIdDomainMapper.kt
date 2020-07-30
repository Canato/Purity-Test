package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdDomainMapper {
    fun mapDomainId(
        category: QuestionCategoryModelEnum,
        id: QuestionIdDomainEnum
    ): QuestionIdModelEnum
}

internal class QuestionsIdDomainMapperDefault(
    private val idDomainMapper: QuestionsIdDomainToModelMapper
) : QuestionsIdDomainMapper {
    override fun mapDomainId(
        category: QuestionCategoryModelEnum,
        id: QuestionIdDomainEnum
    ): QuestionIdModelEnum =
        when (category) {
            QuestionCategoryModelEnum.BANDITRY -> idDomainMapper.mapIdToBanditryModel(id)
            QuestionCategoryModelEnum.MAKE_OUT -> idDomainMapper.mapIdToMakeOutModel(id)
            QuestionCategoryModelEnum.NERVOUS_MOUTH -> idDomainMapper.mapIdToNervousMouthModel(id)
            QuestionCategoryModelEnum.MASTURBATION -> idDomainMapper.mapIdToMasturbationModel(id)
            QuestionCategoryModelEnum.SINS -> idDomainMapper.mapIdToSinsModel(id)
            QuestionCategoryModelEnum.EXHIBITIONISM -> idDomainMapper.mapIdToExhibitionismModel(id)
            QuestionCategoryModelEnum.CRAZY_LIFE -> idDomainMapper.mapIdToCrazyLifeModel(id)
            QuestionCategoryModelEnum.LEGAL_DRUGS -> idDomainMapper.mapIdToLegalDrugsModel(id)
            QuestionCategoryModelEnum.ILLEGAL_DRUGS -> idDomainMapper.mapIdToIllegalDrugsModel(id)
            QuestionCategoryModelEnum.UNIVERSITY_FEELINGS -> idDomainMapper.mapIdToUniFeelingsModel(id)
            QuestionCategoryModelEnum.SEX -> idDomainMapper.mapIdToSexModel(id)
            QuestionCategoryModelEnum.PURITY_SEEKER -> idDomainMapper.mapIdToPurityModel(id)
            QuestionCategoryModelEnum.INVALID -> QuestionIdModelEnum.INVALID
        }
}
