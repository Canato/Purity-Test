package com.can_apps.questions.bresenter

internal data class QuestionsModel(
    val questionCategory: QuestionCategoryModel,
    val questionId: QuestionIdModel,
    val questionWeight: QuestionWeightModel,
    val isSelected: QuestionSelectedModel
)

internal inline class QuestionCategoryModel(val value: String)
internal inline class QuestionIdModel(val value: Int)
internal inline class QuestionWeightModel(val value: Int)
internal inline class QuestionSelectedModel(val value: Boolean)