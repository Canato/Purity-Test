package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdAssetToDomainMapper {
    fun mapIdToDrugsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToReligionDomain(id: Int): QuestionIdDomainEnum
    fun mapBanditryToDomain(id: Int): QuestionIdDomainEnum
}

internal class QuestionsIdAssetToDomainMapperDefault() : QuestionsIdAssetToDomainMapper {
    override fun mapIdToDrugsDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1 -> QuestionIdDomainEnum.DRUGS_JAIL
            2 -> QuestionIdDomainEnum.DRUGS_QUANTITY
            3 -> QuestionIdDomainEnum.DRUGS_SMOKE
            4 -> QuestionIdDomainEnum.DRUGS_USAGE
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1 -> QuestionIdDomainEnum.SEX_SAME
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToReligionDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1 -> QuestionIdDomainEnum.RELIGION_ANTI
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapBanditryToDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1001 -> QuestionIdDomainEnum.BANDITRY_POLICE
            1002 -> QuestionIdDomainEnum.BANDITRY_DRIVE_DRUNK
            1003 -> QuestionIdDomainEnum.BANDITRY_LOST_LICENCE
            1004 -> QuestionIdDomainEnum.BANDITRY_ACCUSED
            1005 -> QuestionIdDomainEnum.BANDITRY_JUVENILE
            1006 -> QuestionIdDomainEnum.BANDITRY_STEALING
            1007 -> QuestionIdDomainEnum.BANDITRY_SOLD_STOLEN
            1008 -> QuestionIdDomainEnum.BANDITRY_BOUGHT_STOLEN
            1009 -> QuestionIdDomainEnum.BANDITRY_NOTION
            1011 -> QuestionIdDomainEnum.BANDITRY_PREGNANT
            1012 -> QuestionIdDomainEnum.BANDITRY_ABORTION
            else -> QuestionIdDomainEnum.INVALID
        }
}
