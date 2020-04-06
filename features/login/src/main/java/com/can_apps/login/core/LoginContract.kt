package com.can_apps.login.core

internal interface LoginContract {

    interface View {
        fun showWelcomeMessage()

        fun close()

        fun showLoading()

        fun hideLoading()

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
        fun passwordValidation(password: LoginPasswordDomain): Boolean

        fun loginNameValidation(loginName: LoginNameDomain): Boolean

        fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

    }

    interface Repository {
        fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

    }
}