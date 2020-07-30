package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum

internal interface QuestionsTextModelStringMapper {

    fun mapDrugsEnumToString(id: QuestionIdModelEnum): String
    fun mapSexEnumToString(id: QuestionIdModelEnum): String
    fun mapReligionEnumToString(id: QuestionIdModelEnum): String
    fun mapInvalidEnumToString(id: QuestionIdModelEnum): String
    fun mapBanditryEnumToString(id: QuestionIdModelEnum): String
}

internal class QuestionsTextModelStringMapperDefault(private val stringResource: CommonStringResourceWrapper) :
    QuestionsTextModelStringMapper {
    override fun mapDrugsEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.DRUGS_JAIL -> stringResource.getString(R.string.drugs_jail)
            QuestionIdModelEnum.DRUGS_QUANTITY -> stringResource.getString(R.string.drugs_quantity)
            QuestionIdModelEnum.DRUGS_SMOKE -> stringResource.getString(R.string.drugs_smoke)
            QuestionIdModelEnum.DRUGS_USAGE -> stringResource.getString(R.string.drugs_usage)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapSexEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.SEX_SAME -> stringResource.getString(R.string.sex_same)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapReligionEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.RELIGION_ANTI -> stringResource.getString(R.string.religion_anti)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapInvalidEnumToString(id: QuestionIdModelEnum): String =
        stringResource.getString(R.string.questions_id_model_error)

    override fun mapBanditryEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.BANDITRY_ABORTION -> stringResource.getString(R.string.banditry_abortion)
            QuestionIdModelEnum.BANDITRY_ACCUSED -> stringResource.getString(R.string.banditry_accused)
            QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN -> stringResource.getString(R.string.banditry_bought_stolen)
            QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK -> stringResource.getString(R.string.banditry_drive_drunk)
            QuestionIdModelEnum.BANDITRY_JUVENILE -> stringResource.getString(R.string.banditry_juvenile)
            QuestionIdModelEnum.BANDITRY_LOST_LICENCE -> stringResource.getString(R.string.banditry_lost_licence)
            QuestionIdModelEnum.BANDITRY_NOTION -> stringResource.getString(R.string.banditry_notion)
            QuestionIdModelEnum.BANDITRY_POLICE -> stringResource.getString(R.string.banditry_police)
            QuestionIdModelEnum.BANDITRY_PREGNANT -> stringResource.getString(R.string.banditry_pregnant)
            QuestionIdModelEnum.BANDITRY_SOLD_STOLEN -> stringResource.getString(R.string.banditry_sold_stolen)
            QuestionIdModelEnum.BANDITRY_STEALING -> stringResource.getString(R.string.banditry_stealing)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }
    }
