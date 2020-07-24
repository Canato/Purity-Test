package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum

internal interface QuestionsTextModelStringMapper {

    fun mapDrugsEnumToString(id: QuestionIdModelEnum): String
    fun mapSexEnumToString(id: QuestionIdModelEnum): String
    fun mapReligionEnumToString(id: QuestionIdModelEnum): String
}

internal class QuestionsTextModelStringMapperDefault(private val stringResource: CommonStringResourceWrapper) :
    QuestionsTextModelStringMapper {
    override fun mapDrugsEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.DRUGS_JAIL -> stringResource.getString(R.string.drugs_jail)
            QuestionIdModelEnum.DRUGS_QUANTITY -> stringResource.getString(R.string.drugs_quantity)
            QuestionIdModelEnum.DRUGS_SMOKE -> stringResource.getString(R.string.drugs_smoke)
            else -> stringResource.getString(R.string.drugs_usage)
        }

    override fun mapSexEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.SEX_SAME -> stringResource.getString(R.string.sex_same)
            else -> stringResource.getString(R.string.sex_same)
        }

    override fun mapReligionEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.RELIGION_ANTI -> stringResource.getString(R.string.religion_anti)
            else -> stringResource.getString(R.string.religion_anti)
        }
}
