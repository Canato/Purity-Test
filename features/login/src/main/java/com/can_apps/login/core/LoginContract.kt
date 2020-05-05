package com.can_apps.login.core

internal interface LoginContract {

    interface View {

        fun close()

        fun showError(error: String)

        fun showLoginStatus(message: String)

        fun showSuccess()

        fun disableLoginButtons()

        fun enableLoginButtons()
    }

    interface Presenter {

        fun bind(view: View)

        fun unbind()

        fun onBackPressed()

        fun onSignClicked(password: String, loginName: String)

        fun onCreateLoginClicked(password: String, loginName: String)

        fun onViewCreated()

        fun logoutUser()
    }

    interface Interactor {

        suspend fun passwordValidation(password: LoginPasswordDomain): Boolean

        suspend fun loginNameValidation(loginName: LoginNameDomain): Boolean

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