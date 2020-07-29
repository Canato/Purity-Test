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
            QuestionCategoryModelEnum.DRUGS -> textStringMapper.mapDrugsEnumToString(idModelEnum)
            QuestionCategoryModelEnum.SEX -> textStringMapper.mapSexEnumToString(idModelEnum)
            QuestionCategoryModelEnum.RELIGION -> textStringMapper.mapReligionEnumToString(idModelEnum)
            QuestionCategoryModelEnum.BANDITRY -> textStringMapper.mapBanditryEnumToString(idModelEnum)
            QuestionCategoryModelEnum.INVALID -> textStringMapper.mapInvalidEnumToString(idModelEnum)
        }
}
