package com.can_apps.questions_data_source.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface QuestionsDataSourceAssets {
    fun getQuestions(): Set<QuestionDataSourceDto>
}

class QuestionsDataSourceAssetsDefault(private val context: Context) :
    QuestionsDataSourceAssets {

    override fun getQuestions(): Set<QuestionDataSourceDto> {

        val gson = Gson()

        val buffer = context.assets.open(QUESTIONS_FILENAME).bufferedReader()
        val jsonString = buffer.use { it.readText() }

        val dto = object : TypeToken<QuestionDataSourceObject>() {}.type
        val questionDataSourceObject: QuestionDataSourceObject = gson.fromJson(jsonString, dto)
        return questionDataSourceObject.objectDto
    }

    companion object {
        private const val QUESTIONS_FILENAME = "questions.json"
    }
}
