package com.can_apps.questions.bresenter

internal data class QuestionsModel(
    val question: QuestionModel,
    val questionId: QuestionIdModel
)

internal inline class QuestionIdModel(val value: ULong)
internal inline class QuestionModel(val value: String)
