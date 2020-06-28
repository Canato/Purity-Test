package com.can_apps.questions.data.questions_data_source

import com.can_apps.questions_data_source.data.QuestionsDataSourceDto


sealed class QuestionsDto {

    data class Valid(val questions: Set<QuestionsDataSourceDto>): QuestionsDto()

    object Invalid: QuestionsDto()
}