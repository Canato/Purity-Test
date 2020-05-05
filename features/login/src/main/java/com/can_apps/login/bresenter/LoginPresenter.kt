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
    private val mapper: LoginModelMapper,
    private val dispatcher: CoroutineDispatcherFactory,
    private val stringResource: CommonStringResourceWrapper
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
        updateLoginStatus()
    }

    override fun onBackPressed() {
        view.close()
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

    private fun CoroutineScope.userLoginValidation(password: String, loginName: String) =
        launch(dispatcher.IO) {

            val passwordDomain = LoginPasswordDomain(password)
            val loginNameDomain = LoginNameDomain(loginName)
            val isPasswordValid = interactor.passwordValidation(passwordDomain)
            val isLoginValid = interactor.loginNameValidation(loginNameDomain)

            if (isLoginValid && isPasswordValid) {
                when (val result = interactor.signInUser(loginNameDomain, passwordDomain)) {
                    is LoginDomain.Success -> {
                        showSuccess()
                        updateLoginStatus()
                    }
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
                    is LoginDomain.Success -> {
                        showSuccess()
                        updateLoginStatus()
                    }
                    is LoginDomain.Fail -> showError(result.error.value)
                }
            } else
                showError(stringResource.getString(R.string.login_error_message))
        }

    private fun CoroutineScope.updateLoginStatus()= launch(dispatcher.IO) {
        when (val result = interactor.checkLogInStatus()) {
            is LoginDomain.Success -> {
                val model = mapper.toModel(result)
                updateLoginStatusView(
                    stringResource.getString(R.string.update_login_success, result.email.value))
                updateButtonsFunction(true)
            }
            is LoginDomain.Fail -> {
                updateLoginStatusView(stringResource.getString(R.string.update_login_fail))
                updateButtonsFunction(false)
            }
        }
    }

    private fun CoroutineScope.logout() = launch(dispatcher.IO) {
        interactor.logoutUser()
        updateLoginStatus()
    }

    private fun CoroutineScope.showSuccess() = launch(dispatcher.UI) {
        view.showSuccess()
    }

    private fun CoroutineScope.showError(message: String) = launch(dispatcher.UI) {
        view.showError(message)
    }

    private fun CoroutineScope.updateLoginStatusView(message: String) = launch(dispatcher.UI) {
        view.showLoginStatus(message)
    }

    private fun CoroutineScope.updateButtonsFunction(disable: Boolean)  = launch(dispatcher.UI){
        when(disable){
            true -> view.disableLoginButtons()
            false -> view.enableLoginButtons()
        }
    }

}

