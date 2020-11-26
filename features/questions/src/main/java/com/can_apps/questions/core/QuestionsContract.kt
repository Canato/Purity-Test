package com.can_apps.questions.core

import com.can_apps.questions.bresenter.QuestionsModelDetails

internal interface QuestionsContract {

    interface View {
        fun showLoading()

        fun hideLoading()

        fun showList(model: List<QuestionsModelDetails>)

        fun showError(message: String)

        fun close()

        fun showCategory(category: String)

        fun setNewActionButtonFunction()

        fun showScore(score: Int)
    }

    interface Presenter {
        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()

        fun fetchNextCategoryQuestions()

        fun calculateScore(question: QuestionsModelDetails, isChecked: Boolean)

        fun getPurityScore()
    }

    interface Interactor {
        suspend fun retrieveQuestionsDomain(): QuestionsDomain

        suspend fun calculateScore(question: QuestionDetailsDomain, isChecked: Boolean)

        suspend fun getPurityScore() : Int
    }

    interface Repository {
        suspend fun retrieveList(): List<QuestionsDomain>
    }
}
