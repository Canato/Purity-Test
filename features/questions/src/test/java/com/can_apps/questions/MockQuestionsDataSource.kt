package com.can_apps.questions

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionLastCategoryModel
import com.can_apps.questions.bresenter.QuestionTextModel
import com.can_apps.questions.bresenter.QuestionWeightModel
import com.can_apps.questions.bresenter.QuestionsModel
import com.can_apps.questions.bresenter.QuestionsModelDetails
import com.can_apps.questions_data_source.data.Question
import com.can_apps.questions_data_source.data.QuestionDataSourceDto

internal val questionsFirstCategoryName = "banditry"
internal val questionsSecondCategoryName = "make_out"
internal val questionsThirdCategoryName = "NERVOUS MOUTH"

internal val questionsFirstAssetsSet = setOf(Question(1001, 1), Question(1002, 1), Question(1003, 1))
internal val questionsSecondAssetsSet = setOf(Question(2001, 1), Question(2002, 1), Question(2003, 2))
internal val questionsThirdAssetsSet = setOf(Question(3001, 1), Question(3002, 1), Question(3003, 3))

internal val mockedQuestionsAssetDto = listOf(
    QuestionDataSourceDto(questionsFirstCategoryName, questionsFirstAssetsSet),
    QuestionDataSourceDto(questionsSecondCategoryName, questionsSecondAssetsSet),
    QuestionDataSourceDto(questionsThirdCategoryName, questionsThirdAssetsSet)
)

internal val questionFirstCategoryModel = QuestionCategoryModelEnum.BANDITRY

internal val questionFirstOne = "qf1"
internal val questionFirstTwo = "qf2"
internal val questionFirstThree = "qf3"

internal val questionFirstIdModelEnumOne = QuestionIdModelEnum.BANDITRY_POLICE
internal val questionFirstIdModelEnumTwo = QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK
internal val questionFirstIdModelEnumThree = QuestionIdModelEnum.BANDITRY_LOST_LICENCE

internal val questionFirstModelDetailsOne = QuestionsModelDetails(
    questionFirstIdModelEnumOne, QuestionTextModel(questionFirstOne), QuestionWeightModel(1))
internal val questionFirstModelDetailsTwo = QuestionsModelDetails(
    questionFirstIdModelEnumTwo, QuestionTextModel(questionFirstTwo), QuestionWeightModel(1))
internal val questionFirstModelDetailsThree = QuestionsModelDetails(
    questionFirstIdModelEnumThree, QuestionTextModel(questionFirstThree), QuestionWeightModel(1))

internal val questionsFirstModelSet = setOf(
    questionFirstModelDetailsOne, questionFirstModelDetailsTwo, questionFirstModelDetailsThree)
internal val questionsFirstModel = QuestionsModel(
    questionFirstCategoryModel, QuestionLastCategoryModel(false), questionsFirstModelSet)

internal val questionSecondCategoryModel = QuestionCategoryModelEnum.MAKE_OUT

internal val questionSecondOne = "qs1"
internal val questionSecondTwo = "qs2"
internal val questionSecondThree = "qs3"

internal val questionSecondIdModelEnumOne = QuestionIdModelEnum.MAKE_OUT_NIGHT_PARTY
internal val questionSecondIdModelEnumTwo = QuestionIdModelEnum.MAKE_OUT_WITH_PERSON
internal val questionSecondIdModelEnumThree = QuestionIdModelEnum.MAKE_OUT_WITH_SAME_GENDER

internal val questionSecondModelDetailsOne = QuestionsModelDetails(
    questionSecondIdModelEnumOne, QuestionTextModel(questionSecondOne), QuestionWeightModel(1))
internal val questionSecondModelDetailsTwo = QuestionsModelDetails(
    questionSecondIdModelEnumTwo, QuestionTextModel(questionSecondTwo), QuestionWeightModel(1))
internal val questionSecondModelDetailsThree = QuestionsModelDetails(
    questionSecondIdModelEnumThree, QuestionTextModel(questionSecondThree), QuestionWeightModel(2))

internal val questionsSecondModelSet = setOf(
    questionSecondModelDetailsOne, questionSecondModelDetailsTwo, questionSecondModelDetailsThree)
internal val questionsSecondModel = QuestionsModel(
    questionSecondCategoryModel, QuestionLastCategoryModel(false), questionsSecondModelSet)

internal val questionThirdCategoryModel = QuestionCategoryModelEnum.NERVOUS_MOUTH

internal val questionThirdOne = "qt1"
internal val questionThirdTwo = "qt2"
internal val questionThirdThree = "qt3"

internal val questionThreeIdModelEnumOne = QuestionIdModelEnum.NERVOUS_MOUTH_WITHOUT_TONGUE
internal val questionThreeIdModelEnumTwo = QuestionIdModelEnum.NERVOUS_MOUTH_WITH_TONGUE
internal val questionThreeIdModelEnumThree = QuestionIdModelEnum.NERVOUS_MOUTH_OPPOSITE_GENDER

internal val questionThirdModelDetailsOne = QuestionsModelDetails(
    questionThreeIdModelEnumOne, QuestionTextModel(questionThirdOne), QuestionWeightModel(1))
internal val questionThirdModelDetailsTwo = QuestionsModelDetails(
    questionThreeIdModelEnumTwo, QuestionTextModel(questionThirdTwo), QuestionWeightModel(1))
internal val questionThirdModelDetailsThree = QuestionsModelDetails(
    questionThreeIdModelEnumThree, QuestionTextModel(questionThirdThree), QuestionWeightModel(3))

internal val questionsThirdModelSet = setOf(
    questionThirdModelDetailsOne, questionThirdModelDetailsTwo, questionThirdModelDetailsThree)
internal val questionsThirdModel = QuestionsModel(
    questionThirdCategoryModel, QuestionLastCategoryModel(true), questionsThirdModelSet)

internal val questionExpectedModel = listOf(questionsFirstModel, questionsSecondModel, questionsThirdModel)
