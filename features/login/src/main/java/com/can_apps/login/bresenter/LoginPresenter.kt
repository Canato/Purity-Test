package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.login.R
import com.can_apps.login.core.*
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

    override fun bind(view: LoginContract.View) { this.view = view }

    override fun unbind() { job.cancel() }

    override fun onViewCreated() { view.showWelcomeMessage() }

    override fun onBackPressed() { view.close() }

    override fun onSignClicked(password: String, loginName: String) { signInUser(password, loginName) }

    override fun onCreateLoginClicked(password: String, loginName: String) { createNewUser(password, loginName) }

    override fun logoutUser() { logout() }

    override fun checkLogIn() { checkLogInStatus() }

    override fun onLoginChanged(login: String) { verifyLogin(login) }

    override fun onPasswordChanged(password: String) { verifyPassword(password) }

    private fun CoroutineScope.verifyLogin(login: String) = launch(dispatcher.IO) {
        when (val domain = interactor.loginNameValidation(LoginNameDomain(login))) {
            is LoginNameValidationDomain.Valid -> {
                checkLoginBox(true)
                val model = modelMapper.loginToModel(domain) as LoginModel.Name
                updateLoginView("")
            }
            else -> {
                checkLoginBox(false)
                val model = modelMapper.loginToModel(domain) as LoginModel.Fail
                updateLoginView(model.error.value)
            }
        }
    }


    private fun CoroutineScope.verifyPassword(password: String) = launch(dispatcher.IO) {
        when (val domain = interactor.passwordValidation(LoginPasswordDomain(password))) {
            is LoginPasswordValidationDomain.Valid -> {
                val model = modelMapper.passwordToModel(domain) as LoginModel.Password
                checkPasswordBox(true)
                updatePasswordView("")

            }
            else -> {
                val model = modelMapper.passwordToModel(domain) as LoginModel.Fail
                checkPasswordBox(false)
                updatePasswordView(model.error.value)
            }
        }
    }

    private fun CoroutineScope.signInUser(password: String, loginName: String) =
        launch(dispatcher.IO) {

            val passwordDomain = LoginPasswordDomain(password)
            val loginNameDomain = LoginNameDomain(loginName)
            when (val result = interactor.signInUser(loginNameDomain, passwordDomain)) {
                is LoginDomain.Success -> showSuccess()
                is LoginDomain.Fail -> showError(result.error.value)
            }
        }

    private fun CoroutineScope.createNewUser(password: String, loginName: String) =
        launch(dispatcher.IO) {

            val loginNameDomain = LoginNameDomain(loginName)
            val passwordDomain = LoginPasswordDomain(password)
            when (val result = interactor.createUser(loginNameDomain, passwordDomain)) {
                is LoginDomain.Success -> showSuccess()
                is LoginDomain.Fail -> showError(result.error.value)
            }
        }

    private fun CoroutineScope.showSuccess() = launch(dispatcher.UI) {
        view.showSuccess()
    }

    private fun CoroutineScope.showError(message: String) = launch(dispatcher.UI) {
        view.showError(message)
    }

    private fun CoroutineScope.checkLogInStatus() = launch(dispatcher.IO) {
        when (val result = interactor.checkLogInStatus()) {
            is LoginDomain.Success -> showLogInStatus(stringResource.getString(R.string.sign_in_true))
            is LoginDomain.Fail -> showLogInStatus(result.error.value)
        }
    }

    private fun CoroutineScope.showLogInStatus(message: String) = launch(dispatcher.UI) {
        view.showLogInStatus(message)
    }

    private fun CoroutineScope.checkLoginBox(checkBox: Boolean) = launch(dispatcher.UI) {
        when (checkBox) {
            true -> view.checkLoginBox()
            false -> view.unCheckLoginBox()
        }
    }

    private fun CoroutineScope.checkPasswordBox(checkBox: Boolean) = launch(dispatcher.UI) {
        when (checkBox) {
            true -> view.checkPasswordBox()
            false -> view.unCheckPasswordBox()
        }
    }

    private fun CoroutineScope.updateLoginView(message: String) = launch(dispatcher.UI) {
        view.updateLoginViewMessage(message)
    }

    private fun CoroutineScope.updatePasswordView(message: String) = launch(dispatcher.UI) {
        view.updatePasswordViewMessage(message)
    }

    private fun CoroutineScope.logout() = launch(dispatcher.IO) {
        interactor.logoutUser()
    }

}

