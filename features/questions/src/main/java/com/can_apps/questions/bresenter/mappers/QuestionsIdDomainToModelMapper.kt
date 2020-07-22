package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdDomainToModelMapper {
    fun mapIdToDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToReligionModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
}

// TODO -> questionable usage of mapper. Every when function require else branch
internal class QuestionsIdDomainToModelMapperDefault() : QuestionsIdDomainToModelMapper {
    override fun mapIdToDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.DRUGS_JAIL -> QuestionIdModelEnum.DRUGS_JAIL
            QuestionIdDomainEnum.DRUGS_QUANTITY -> QuestionIdModelEnum.DRUGS_QUANTITY
            QuestionIdDomainEnum.DRUGS_SMOKE -> QuestionIdModelEnum.DRUGS_SMOKE
            else -> QuestionIdModelEnum.DRUGS_USAGE
        }

    override fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.SEX_SAME -> QuestionIdModelEnum.SEX_SAME
            else -> QuestionIdModelEnum.SEX_SAME
        }

    override fun mapIdToReligionModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.RELIGION_ANTI -> QuestionIdModelEnum.RELIGION_ANTI
            else -> QuestionIdModelEnum.RELIGION_ANTI
        }
}
