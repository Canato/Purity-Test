package com.can_apps.login.core

internal interface LoginContract {

    interface View {

        fun showWelcomeMessage()

        fun close()

        fun showError(error: String)

        fun showSuccess()
    }

    interface Presenter {

        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()

        fun onLoginClicked(password: String, loginName: String)
    }

    interface Interactor {

        suspend fun passwordValidation(password: LoginPasswordDomain): Boolean

        suspend fun loginNameValidation(loginName: LoginNameDomain): Boolean

        suspend fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain
    }

    interface Repository {

        suspend fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain
    }
}