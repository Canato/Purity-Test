package com.can_apps.questions.bresenter

internal data class QuestionsModel(
    val questionCategory: QuestionCategoryModelEnum,
    val questionsModelDetails: Set<QuestionsModelDetails>
)

internal data class QuestionsModelDetails(
    val questionId: QuestionIdModelEnum,
    val questionText: QuestionTextModel,
    val questionWeight: QuestionWeightModel
)

internal enum class QuestionCategoryModelEnum {
    DRUGS, SEX, RELIGION, INVALID
}

internal enum class QuestionIdModelEnum {
    DRUGS_SMOKE,
    DRUGS_USAGE,
    DRUGS_QUANTITY,
    DRUGS_JAIL,
    SEX_SAME,
    RELIGION_ANTI,
    INVALID
}

internal inline class QuestionTextModel(val value: String)
internal inline class QuestionWeightModel(val value: Int)
