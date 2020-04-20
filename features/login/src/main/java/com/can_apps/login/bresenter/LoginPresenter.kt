package com.can_apps.login.bresenter

import com.can_apps.login.core.*

internal class LoginPresenter(
    private val interactor: LoginContract.Interactor
) : LoginContract.Presenter {

    private lateinit var view: LoginContract.View


    override fun bind(view: LoginContract.View) {
        this.view = view
    }

    override fun unbind() {
    }

    override fun onViewCreated() {
        view.showWelcomeMessage()
    }

    override fun onBackPressed() {
        view.close()
    }

    override fun onLoginClicked(password: String, loginName: String) {

        val passwordDomain = LoginPasswordDomain(password)
        val loginNameDomain = LoginNameDomain(loginName)
        val isPasswordValid = interactor.passwordValidation(passwordDomain)
        val isLoginValid = interactor.loginNameValidation(loginNameDomain)

        if (isLoginValid && isPasswordValid) {
            when (val result = interactor.loginUser(loginNameDomain, passwordDomain)) {
                LoginDomain.Success -> view.showSuccess()
                is LoginDomain.Fail -> view.showError(result.error.value)
            }
        } else
            view.showError("Sorry, something is invalid")
    }

}