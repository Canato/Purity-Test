package com.can_apps.questions_data_source.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("question")
    @Expose
    var question: String,

    @SerializedName("isSelected")
    @Expose
    var isIsSelected: Boolean,

    @SerializedName("weight")
    @Expose
    var weight: Int
)
