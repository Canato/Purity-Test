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

        fun cleanLoginTextView()

        fun cleanPasswordTextView()

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

        fun onLoginInputChanged(login: String)

        fun onPasswordInputChanged(password: String)


    }

    interface Interactor {

        fun loginNameValidation(loginName: LoginNameDomain): LoginNameValidationDomain

        fun passwordValidation(password: LoginPasswordDomain): LoginPasswordValidationDomain

        suspend fun signInUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun createUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun checkLogInStatus(): LoginDomain

        fun checkFunction(loginValid: Boolean, passwordValid: Boolean): Boolean

        suspend fun logoutUser()

    }

    interface Repository {

        suspend fun signInUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun createUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain

        suspend fun logoutUser()

        suspend fun checkLogInStatus() : LoginDomain
    }
}