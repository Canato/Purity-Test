package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdDomainToModelMapper {
    fun mapIdToDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToReligionModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
}

internal class QuestionsIdDomainToModelMapperDefault() : QuestionsIdDomainToModelMapper {
    override fun mapIdToDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum {
        TODO("Not yet implemented")
    }

    override fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum {
        TODO("Not yet implemented")
    }

    override fun mapIdToReligionModel(id: QuestionIdDomainEnum): QuestionIdModelEnum {
        TODO("Not yet implemented")
    }
}
