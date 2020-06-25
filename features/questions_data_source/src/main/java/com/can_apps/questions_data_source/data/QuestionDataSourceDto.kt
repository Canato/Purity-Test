package com.can_apps.questions_data_source.data

import com.can_apps.questions_data_source.data.model.Question
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuestionDataSourceDto(
    @SerializedName("category_name")
    @Expose
    var categoryName: String,

    @SerializedName("questions")
    @Expose
    var questions: List<Question>
)