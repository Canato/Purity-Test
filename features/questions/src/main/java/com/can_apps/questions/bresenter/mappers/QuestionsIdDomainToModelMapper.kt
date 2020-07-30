package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdDomainToModelMapper {
    fun mapIdToDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToReligionModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToBanditryModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
}

internal class QuestionsIdDomainToModelMapperDefault() : QuestionsIdDomainToModelMapper {
    override fun mapIdToDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.DRUGS_JAIL -> QuestionIdModelEnum.DRUGS_JAIL
            QuestionIdDomainEnum.DRUGS_QUANTITY -> QuestionIdModelEnum.DRUGS_QUANTITY
            QuestionIdDomainEnum.DRUGS_SMOKE -> QuestionIdModelEnum.DRUGS_SMOKE
            QuestionIdDomainEnum.DRUGS_USAGE -> QuestionIdModelEnum.DRUGS_USAGE
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.SEX_SAME -> QuestionIdModelEnum.SEX_SAME
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToReligionModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.RELIGION_ANTI -> QuestionIdModelEnum.RELIGION_ANTI
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToBanditryModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.BANDITRY_ABORTION -> QuestionIdModelEnum.BANDITRY_ABORTION
            QuestionIdDomainEnum.BANDITRY_ACCUSED -> QuestionIdModelEnum.BANDITRY_ACCUSED
            QuestionIdDomainEnum.BANDITRY_BOUGHT_STOLEN -> QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN
            QuestionIdDomainEnum.BANDITRY_DRIVE_DRUNK -> QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK
            QuestionIdDomainEnum.BANDITRY_JUVENILE -> QuestionIdModelEnum.BANDITRY_JUVENILE
            QuestionIdDomainEnum.BANDITRY_LOST_LICENCE -> QuestionIdModelEnum.BANDITRY_LOST_LICENCE
            QuestionIdDomainEnum.BANDITRY_NOTION -> QuestionIdModelEnum.BANDITRY_NOTION
            QuestionIdDomainEnum.BANDITRY_POLICE -> QuestionIdModelEnum.BANDITRY_POLICE
            QuestionIdDomainEnum.BANDITRY_PREGNANT -> QuestionIdModelEnum.BANDITRY_PREGNANT
            QuestionIdDomainEnum.BANDITRY_SOLD_STOLEN -> QuestionIdModelEnum.BANDITRY_SOLD_STOLEN
            QuestionIdDomainEnum.BANDITRY_STEALING -> QuestionIdModelEnum.BANDITRY_STEALING
            else -> QuestionIdModelEnum.INVALID
        }
}
