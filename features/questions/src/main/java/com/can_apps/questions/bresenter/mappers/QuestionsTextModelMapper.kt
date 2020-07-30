package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum

internal interface QuestionsTextModelMapper {
    fun mapText(
        categoryModelEnum: QuestionCategoryModelEnum,
        idModelEnum: QuestionIdModelEnum
    ): String
}

internal class QuestionsTextModelMapperDefault(
    private val textStringMapper: QuestionsTextModelStringMapper
) : QuestionsTextModelMapper {
    override fun mapText(
        categoryModelEnum: QuestionCategoryModelEnum,
        idModelEnum: QuestionIdModelEnum
    ): String =
        when (categoryModelEnum) {
            QuestionCategoryModelEnum.BANDITRY -> textStringMapper.mapBanditryEnumToString(idModelEnum)
            QuestionCategoryModelEnum.MAKE_OUT -> textStringMapper.mapMakeOutEnumToString(idModelEnum)
            QuestionCategoryModelEnum.NERVOUS_MOUTH -> textStringMapper.mapNervousMouthEnumToString(idModelEnum)
            QuestionCategoryModelEnum.MASTURBATION -> textStringMapper.mapMasturbationEnumToString(idModelEnum)
            QuestionCategoryModelEnum.SINS -> textStringMapper.mapSinsEnumToString(idModelEnum)
            QuestionCategoryModelEnum.EXHIBITIONISM -> textStringMapper.mapExhibitionismEnumToString(idModelEnum)
            QuestionCategoryModelEnum.CRAZY_LIFE -> textStringMapper.mapCrazyLifeEnumToString(idModelEnum)
            QuestionCategoryModelEnum.LEGAL_DRUGS -> textStringMapper.mapLegalDrugsEnumToString(idModelEnum)
            QuestionCategoryModelEnum.ILLEGAL_DRUGS -> textStringMapper.mapIllegalDrugsEnumToString(idModelEnum)
            QuestionCategoryModelEnum.UNIVERSITY_FEELINGS -> textStringMapper.mapUniFeelingsEnumToString(idModelEnum)
            QuestionCategoryModelEnum.SEX -> textStringMapper.mapSexEnumToString(idModelEnum)
            QuestionCategoryModelEnum.PURITY_SEEKER -> textStringMapper.mapPurityEnumToString(idModelEnum)
            else -> textStringMapper.mapInvalidEnumToString(idModelEnum)
        }
}
