package com.can_apps.questions.core

import com.can_apps.questions.bresenter.QuestionsModel

internal interface QuestionsContract {

    interface View {
        fun showLoading()

        fun hideLoading()

        fun showList(model: List<QuestionsModel>)

        fun showError(message: String)

        fun close()
    }

    interface Presenter {
        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()
    }

    interface Interactor {
        suspend fun retrieveList(): QuestionsDomain
    }

    interface Repository {
        suspend fun retrieveList(): QuestionsDomain
    }
}