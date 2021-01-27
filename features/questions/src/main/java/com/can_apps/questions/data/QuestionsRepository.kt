package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDetailsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets

internal class QuestionsRepository(
    private val asset: QuestionsDataSourceAssets,
    private val dtoMapper: QuestionsDtoMapper
) : QuestionsContract.Repository {

    override suspend fun retrieveList(): List<QuestionsDetailsDomain> =
        dtoMapper.assetToDomain(asset.getQuestions())
}
