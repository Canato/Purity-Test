package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdAssetToDomainMapper {
    fun mapIdToDrugsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToReligionDomain(id: Int): QuestionIdDomainEnum
}

internal class QuestionsIdAssetToDomainMapperDefault() : QuestionsIdAssetToDomainMapper {
    override fun mapIdToDrugsDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1 -> QuestionIdDomainEnum.DRUGS_JAIL
            2 -> QuestionIdDomainEnum.DRUGS_QUANTITY
            3 -> QuestionIdDomainEnum.DRUGS_SMOKE
            else -> QuestionIdDomainEnum.DRUGS_USAGE
        }

    override fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1 -> QuestionIdDomainEnum.SEX_SAME
            else -> QuestionIdDomainEnum.SEX_SAME
        }

    override fun mapIdToReligionDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1 -> QuestionIdDomainEnum.RELIGION_ANTI
            else -> QuestionIdDomainEnum.RELIGION_ANTI
        }
}
