package com.can_apps.questions.core

internal class QuestionsInteractor(
    private val repository: QuestionsContract.Repository
) : QuestionsContract.Interactor {

    override suspend fun retrieveList(): QuestionsDomain =
        repository.retrieveList().first()
}
