package com.can_apps.questions_data_source.data

import com.google.gson.annotations.SerializedName


internal class QuestionDataSourceDto(
    @SerializedName("category_name")
    var categoryName: String,

    @SerializedName("questions")
    var questions: Set<Question>
)


internal data class Question(
    @SerializedName("id")
    var id: Int,

    @SerializedName("weight")
    var weight: Int
)