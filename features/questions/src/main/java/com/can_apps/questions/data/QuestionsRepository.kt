package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionErrorDomain
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsApi
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper

internal class QuestionsRepository(
    private val api: QuestionsApi,
    private val dtoMapper: QuestionsDtoMapper
) : QuestionsContract.Repository {

    override suspend fun retrieveList(): QuestionsDomain =
        try {
            dtoMapper.dtoToDomain(api.fetchAsset())
        } catch (e: Exception) {
            QuestionsDomain.Error(QuestionErrorDomain(e.message.toString()))
        }
}
