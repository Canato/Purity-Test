package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdAssetToDomainMapper {
    fun mapIdToDrugsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToReligionDomain(id: Int): QuestionIdDomainEnum
}

internal class QuestionsIdDomainMapperDefault() : QuestionsIdAssetToDomainMapper {
    override fun mapIdToDrugsDomain(id: Int): QuestionIdDomainEnum {
        TODO("Not yet implemented")
    }

    override fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum {
        TODO("Not yet implemented")
    }

    override fun mapIdToReligionDomain(id: Int): QuestionIdDomainEnum {
        TODO("Not yet implemented")
    }
}
