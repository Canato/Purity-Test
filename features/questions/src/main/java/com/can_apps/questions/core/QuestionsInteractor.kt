package com.can_apps.questions.core

internal class QuestionsInteractor(
    private val repository: QuestionsContract.Repository
) : QuestionsContract.Interactor {

    private var questionsDomainList: List<QuestionsDomain> = emptyList()
    private var listPosition = 0

    override suspend fun retrieveList(): QuestionsDomain =
        when (questionsDomainList == emptyList<List<QuestionsDomain>>()) {
            true -> fetchRepositoryList()
            false -> getNextQuestionsDomain()
        }

    override fun checkListSize(): Boolean {
        return listPosition == questionsDomainList.size - 1
    }

    private suspend fun fetchRepositoryList(): QuestionsDomain {
        questionsDomainList = repository.retrieveList()
        return questionsDomainList.first()
    }

    private fun getNextQuestionsDomain(): QuestionsDomain {
        listPosition++
        return questionsDomainList[listPosition]
    }
}
