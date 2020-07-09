package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionErrorDomain
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssetsDefault

internal class QuestionsRepository(
    private val asset: QuestionsDataSourceAssets,
    private val dtoMapper: QuestionsDtoMapper
) : QuestionsContract.Repository {

    override suspend fun retrieveList(): QuestionsDomain =
        try {
            dtoMapper.assetToDomain(asset.getQuestions())
        } catch (e: Exception) {
            QuestionsDomain.Error(QuestionErrorDomain(e.message.toString()))
        }
}
