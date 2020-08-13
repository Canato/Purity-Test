package com.can_apps.questions.core

internal class QuestionsInteractor(
    private val repository: QuestionsContract.Repository
) : QuestionsContract.Interactor {

//    private lateinit var

    override suspend fun retrieveList(): QuestionsDomain {
        return repository.retrieveList().first()
    }
}
