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
    DRUGS, SEX, RELIGION, INVALID, BANDITRY
}

internal enum class QuestionIdModelEnum {
    DRUGS_SMOKE,
    DRUGS_USAGE,
    DRUGS_QUANTITY,
    DRUGS_JAIL,
    SEX_SAME,
    RELIGION_ANTI,
    INVALID,
    BANDITRY_POLICE,
    BANDITRY_DRIVE_DRUNK,
    BANDITRY_LOST_LICENCE,
    BANDITRY_ACCUSED,
    BANDITRY_JUVENILE,
    BANDITRY_STEALING,
    BANDITRY_SOLD_STOLEN,
    BANDITRY_NOTION,
    BANDITRY_PREGNANT,
    BANDITRY_ABORTION,
    BANDITRY_BOUGHT_STOLEN
}

internal inline class QuestionTextModel(val value: String)
internal inline class QuestionWeightModel(val value: Int)
