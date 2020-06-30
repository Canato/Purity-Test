package com.can_apps.questions.data.questions_data_source

import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets


internal interface QuestionsApi {
    fun fetchAsset(): QuestionsDto
}

internal class QuestionsApiDefault(private val assets: QuestionsDataSourceAssets) : QuestionsApi{
    override fun fetchAsset(): QuestionsDto =
        when(val result = assets.getQuestions()){
            null -> QuestionsDto.Invalid
            else -> QuestionsDto.Valid(result)
        }


}