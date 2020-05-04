package com.can_apps.login.core

internal interface LoginContract {

    interface View {

        fun showWelcomeMessage()

        fun close()

        fun showError(error: String)

        fun showLogInStatus(message: String)

        fun showSuccess()
    }

    interface Presenter {

        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()

        fun onSignClicked(password: String, loginName: String)

        fun onCreateLoginClicked(password: String, loginName: String)

        fun logoutUser()

        fun checkLogIn()
    }

    interface Interactor {

        fun passwordValidation(password: LoginPasswordDomain): LoginPasswordValidationDomain

        fun loginNameValidation(loginName: LoginNameDomain): Boolean

        suspend fun signInUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun createUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun logoutUser()

        suspend fun checkLogInStatus(): LoginDomain
    }

    interface Repository {

        suspend fun signInUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun createUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun logoutUser()

        suspend fun checkLogInStatus() : LoginDomain
    }
}