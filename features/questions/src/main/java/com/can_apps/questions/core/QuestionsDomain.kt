package com.can_apps.questions.core

internal sealed class QuestionsDomain {

    data class Valid(
        val category: QuestionCategoryDomainEnum,
        val questions: Set<QuestionDetailsDomain>
    ) : QuestionsDomain()

    data class Error(
        val message: QuestionErrorDomain
    ) : QuestionsDomain()
}

internal data class QuestionDetailsDomain(
    val id: QuestionIdDomainEnum,
    val weight: QuestionWeightDomain
)

internal enum class QuestionCategoryDomainEnum {
    DRUGS, SEX, RELIGION, INVALID
}

internal enum class QuestionIdDomainEnum {
    DRUGS_SMOKE,
    DRUGS_USAGE,
    DRUGS_QUANTITY,
    DRUGS_JAIL,
    SEX_SAME,
    RELIGION_ANTI,
    INVALID
}

internal inline class QuestionWeightDomain(val value: Int)
internal inline class QuestionErrorDomain(val value: String)
