package com.can_apps.login.core

internal interface LoginContract {

    interface View {
        fun welcome()

        fun close()

        fun onPositive(message: String)

        fun onNegative(message: String)
    }

    interface Presenter {
        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()

        fun onSubmitPressed()
    }

    interface Interactor {
        fun checkSubmit() : Boolean
    }
    interface Repository {}
}