package com.can_apps.login.core

internal interface LoginContract {

    interface View {

        fun showWelcomeMessage()

        fun close()

        fun showError(error: String)

        fun showLogInStatus(message: String)

        fun showSuccess()

        fun setLoginCheckBoxAsTrue()

        fun setLoginCheckBoxAsFalse()

        fun setPasswordCheckBoxAsTrue()

        fun setPasswordCheckBoxAsFalse()

        fun updateLoginTextViewErrorMessage(message: String)

        fun updatePasswordTextViewErrorMessage(message: String)

        fun disableSignInButton()

        fun enableSignInButton()

        fun disableCreateUserButton()

        fun enableCreateUserButton()

    }

    interface Presenter {

        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()

        fun onSignClicked()

        fun onCreateLoginClicked()

        fun logoutUser()

        fun checkLogIn()

        fun onLoginChanged(login: String)

        fun onPasswordChanged(password: String)


    }

    interface Interactor {

        fun passwordValidation(password: LoginPasswordDomain): LoginPasswordValidationDomain

        fun loginNameValidation(loginName: LoginNameDomain): LoginNameValidationDomain

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