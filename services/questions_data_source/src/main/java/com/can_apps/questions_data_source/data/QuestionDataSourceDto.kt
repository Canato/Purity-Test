package com.can_apps.questions_data_source.data

import com.google.gson.annotations.SerializedName

data class QuestionDataSourceObject(
    @SerializedName("object")
    var objectDto: List<QuestionDataSourceDto>
)

data class QuestionDataSourceDto(
    @SerializedName("subjectName")
    var categoryName: String,

    @SerializedName("questions")
    var questions: Set<Question>
)

data class Question(
    @SerializedName("id")
    var id: Int,

    @SerializedName("score")
    var weight: Int
)
