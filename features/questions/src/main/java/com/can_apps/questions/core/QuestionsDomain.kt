package com.can_apps.questions.core

internal sealed class QuestionsDomain {

    data class Valid(
        val questions: Set<QuestionDetailsDomain>
    ) : QuestionsDomain()

    data class Error(
        val message: String
    ) : QuestionsDomain()
}

internal data class QuestionDetailsDomain (
    val id: QuestionIdDomain,
    val question: QuestionDomain,
    val isSelected: Boolean,
    val weight: QuestionWeightDomain,
    val category: QuestionCategoryDomain
    )

internal inline class QuestionDomain(val value: String)
internal inline class QuestionIdDomain(val value: ULong)
internal inline class QuestionWeightDomain(val value: Int)
internal inline class QuestionCategoryDomain(val value: String)