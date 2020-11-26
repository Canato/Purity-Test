package com.can_apps.questions.core

internal class QuestionsInteractor(
    private val repository: QuestionsContract.Repository
) : QuestionsContract.Interactor {

    private var questionsDomainList: List<QuestionsDomain> = emptyList()
    private var listPosition = 0
    private var scoreQuestionsSet: MutableSet<QuestionDetailsDomain> = mutableSetOf()

    override suspend fun retrieveQuestionsDomain(): QuestionsDomain =
        when (questionsDomainList == emptyList<List<QuestionsDomain>>()) {
            true -> fetchRepositoryList()
            false -> getNextQuestionsDomain()
        }

    override suspend fun calculateScore(question: QuestionDetailsDomain, isChecked: Boolean) {
        TODO("Not yet implemented - concept - adds/remove question from the set" +
            "that is dependent on Boolean isChecked value")
    }

    override suspend fun getPurityScore(): Int {
        TODO("Not yet implemented - concept - adds score from each question of set and return the number")
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
