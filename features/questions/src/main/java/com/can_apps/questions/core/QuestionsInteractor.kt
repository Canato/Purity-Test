package com.can_apps.questions.core

internal class QuestionsInteractor(
    private val repository: QuestionsContract.Repository
) : QuestionsContract.Interactor {

    private var questions: List<QuestionsDetailsDomain> = emptyList()

    override suspend fun retrieveQuestionsDomain(
        categoryId: String?
    ): QuestionsDetailsDomain? =
        when (questions.isEmpty()) {
            true -> {
                questions = repository.retrieveList()
                questions.first()
            }
            else -> {
                val actualIndex = questions.indexOfFirst { it.category.name == categoryId }

                if (actualIndex == -1 || actualIndex == questions.size) null
                else questions[actualIndex + 1]
            }
        }
}
