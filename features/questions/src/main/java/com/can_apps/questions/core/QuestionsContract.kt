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
    }

    interface Presenter {
        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()

        fun fetchNextCategoryQuestions()
    }

    interface Interactor {
        suspend fun retrieveList(): QuestionsDomain

        fun checkListSize(): Boolean
    }

    interface Repository {
        suspend fun retrieveList(): List<QuestionsDomain>
    }
}
