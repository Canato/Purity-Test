package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionTextModel

internal interface QuestionsTextModelStringMapper {

    fun mapDrugsEnumToString(id: QuestionIdModelEnum): QuestionTextModel
    fun mapSexEnumToString(id: QuestionIdModelEnum): QuestionTextModel
    fun mapReligionEnumToString(id: QuestionIdModelEnum): QuestionTextModel
}

internal class QuestionsTextModelStringMapperDefault(private val stringResource: CommonStringResourceWrapper) :
    QuestionsTextModelStringMapper {
    override fun mapDrugsEnumToString(id: QuestionIdModelEnum): QuestionTextModel =
        when (id) {
            QuestionIdModelEnum.DRUGS_JAIL -> QuestionTextModel(stringResource.getString(R.string.drugs_jail))
            QuestionIdModelEnum.DRUGS_QUANTITY -> QuestionTextModel(stringResource.getString(R.string.drugs_quantity))
            QuestionIdModelEnum.DRUGS_SMOKE -> QuestionTextModel(stringResource.getString(R.string.drugs_smoke))
            else -> QuestionTextModel(stringResource.getString(R.string.drugs_usage))
        }

    override fun mapSexEnumToString(id: QuestionIdModelEnum): QuestionTextModel =
        when (id) {
            QuestionIdModelEnum.SEX_SAME -> QuestionTextModel(stringResource.getString(R.string.sex_same))
            else -> QuestionTextModel(stringResource.getString(R.string.sex_same))
        }

    override fun mapReligionEnumToString(id: QuestionIdModelEnum): QuestionTextModel =
        when (id) {
            QuestionIdModelEnum.RELIGION_ANTI -> QuestionTextModel(stringResource.getString(R.string.religion_anti))
            else -> QuestionTextModel(stringResource.getString(R.string.religion_anti))
        }
}
