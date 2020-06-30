package com.can_apps.questions.core

internal sealed class QuestionsDomain {

    data class Valid(
        val questions: Set<QuestionDetailsDomain>
    ) : QuestionsDomain()

    data class Error(
        val message: QuestionErrorDomain
    ) : QuestionsDomain()
}

internal data class QuestionDetailsDomain (
    val category: QuestionCategoryDomain,
    val id: QuestionIdDomain,
    val weight: QuestionWeightDomain,
    val isSelected: QuestionSelectedDomain
    )

internal inline class QuestionIdDomain(val value: Int)
internal inline class QuestionWeightDomain(val value: Int)
internal inline class QuestionCategoryDomain(val value: String)
internal inline class QuestionSelectedDomain(val value: Boolean)
internal inline class QuestionErrorDomain(val value: String)
