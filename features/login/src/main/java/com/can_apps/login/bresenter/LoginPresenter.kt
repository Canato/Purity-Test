package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.login.R
import com.can_apps.login.core.LoginContract
import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginNameDomain
import com.can_apps.login.core.LoginPasswordDomain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal class LoginPresenter(
    private val interactor: LoginContract.Interactor,
    private val dispatcher: CoroutineDispatcherFactory,
    private val stringResource: CommonStringResourceWrapper,
    private val modelMapper: LoginModelMapper
) : LoginContract.Presenter, CoroutineScope {

    private lateinit var view: LoginContract.View

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = dispatcher.UI + job


    override fun bind(view: LoginContract.View) {
        this.view = view
    }

    override fun unbind() {
        job.cancel()
    }

    override fun onViewCreated() {
        view.showWelcomeMessage()
    }

    override fun onBackPressed() {
        view.close()
    }

    override fun onPasswordChange(password: String) {
        verifyPassword(password)
    }

    override fun onSignClicked(password: String, loginName: String) {
        userLoginValidation(password, loginName)
    }

    override fun onCreateLoginClicked(password: String, loginName: String) {
        createUserValidation(password, loginName)
    }

    override fun logoutUser() {
        logout()
    }

    override fun checkLogIn() {
        checkLogInStatus()
    }

    private fun verifyPassword(password: String) {
        val domain = interactor.passwordValidation(password)
        val model = modelMapper.toModel(domain)
        when(model) {
            Valid -> showValidPassword()
            Invalid -> showInvalidPassword(model.errorMessage)
        }
    }

    private fun CoroutineScope.userLoginValidation(password: String, loginName: String) =
        launch(dispatcher.IO) {

            val passwordDomain = LoginPasswordDomain(password)
            val loginNameDomain = LoginNameDomain(loginName)
            val isPasswordValid = interactor.passwordValidation(passwordDomain)
            val isLoginValid = interactor.loginNameValidation(loginNameDomain)

            if (isLoginValid && isPasswordValid) {
                when (val result = interactor.signInUser(loginNameDomain, passwordDomain)) {
                    LoginDomain.Success -> showSuccess()
                    is LoginDomain.Fail -> showError(result.error.value)
                }
            } else
                showError(stringResource.getString(R.string.login_error_message))
        }

    private fun CoroutineScope.createUserValidation(password: String, loginName: String) =
        launch(dispatcher.IO) {

            val passwordDomain = LoginPasswordDomain(password)
            val loginNameDomain = LoginNameDomain(loginName)
            val isPasswordValid = interactor.passwordValidation(passwordDomain)
            val isLoginValid = interactor.loginNameValidation(loginNameDomain)

            if (isLoginValid && isPasswordValid) {
                when (val result = interactor.createUser(loginNameDomain, passwordDomain)) {
                    LoginDomain.Success -> showSuccess()
                    is LoginDomain.Fail -> showError(result.error.value)
                }
            } else
                showError(stringResource.getString(R.string.login_error_message))
        }

    private fun CoroutineScope.showSuccess() = launch(dispatcher.UI) {
        view.showSuccess()
    }

    private fun CoroutineScope.showError(message: String) = launch(dispatcher.UI) {
        view.showError(message)
    }

    private fun CoroutineScope.checkLogInStatus() = launch(dispatcher.IO) {
        when (val result = interactor.checkLogInStatus()) {
            LoginDomain.Success -> showLogInStatus(stringResource.getString(R.string.sign_in_true))
            is LoginDomain.Fail -> showLogInStatus(result.error.value)
        }
    }

    private fun CoroutineScope.showLogInStatus(message: String) = launch(dispatcher.UI) {
        view.showLogInStatus(message)
    }

    private fun CoroutineScope.logout() = launch(dispatcher.IO) {
        interactor.logoutUser()
    }

}

