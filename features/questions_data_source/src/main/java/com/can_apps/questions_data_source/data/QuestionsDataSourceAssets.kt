package com.can_apps.questions_data_source.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface QuestionsDataSourceAssets {
    fun getQuestions(): Set<QuestionsDataSourceDto>
}

class QuestionsDataSourceAssetsDefault(private val context: Context)
    : QuestionsDataSourceAssets {

    override fun getQuestions(): Set<QuestionsDataSourceDto> {
        val gson = Gson()

        val buffer = context.assets.open(QUESTIONS_FILENAME).bufferedReader()
        val jsonString = buffer.use { it.readText() }

        val dto = object : TypeToken<Set<QuestionsDataSourceDto>>() {}.type

        return gson.fromJson(jsonString, dto)
    }

    companion object {
        private const val QUESTIONS_FILENAME = "question.json"
    }
}