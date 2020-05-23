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

    private var view: LoginContract.View? = null
    private lateinit var loginNameModel: LoginModel.Name
    private lateinit var loginPasswordModel: LoginModel.Password

    private var loginValid = false
    private var passwordValid = false

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = dispatcher.UI + job

    override fun bind(view: LoginContract.View) { this.view = view }

    override fun unbind() {
        job.cancel()
        view = null
    }

    override fun onViewCreated() {
        view?.showWelcomeMessage()
    }

    override fun onBackPressed() { view?.close() }

    override fun onSignClicked(loginName: String, password: String) { signInUser() }

    override fun onCreateLoginClicked(loginName: String, password: String) { createNewUser(loginName, password) }

    override fun logoutUser() { logout() }

    override fun checkLogIn() { checkLogInStatus() }

    override fun onLoginInputChanged(login: String) { verifyLogin(login) }

    override fun onPasswordInputChanged(password: String) { verifyPassword(password) }

    private fun CoroutineScope.verifyLogin(login: String) = launch(dispatcher.IO) {
        when (val domain = interactor.loginNameValidation(LoginNameDomain(login))) {
            is LoginNameValidationDomain.Valid -> {
                checkLoginBox(true)
                updateLoginView(null)
                loginNameModel = modelMapper.loginToModel(domain) as LoginModel.Name
                loginValid = true
            }
            else -> {
                checkLoginBox(false)
                val model = modelMapper.loginToModel(domain) as LoginModel.Error
                updateLoginView(model)
                loginValid = false
            }
        }
    }

    private fun CoroutineScope.verifyPassword(password: String) = launch(dispatcher.IO) {
        when (val domain = interactor.passwordValidation(LoginPasswordDomain(password))) {
            is LoginPasswordValidationDomain.Valid -> {
                checkPasswordBox(true)
                updatePasswordView(null)
                loginPasswordModel = modelMapper.passwordToModel(domain) as LoginModel.Password
                passwordValid = true
            }
            else -> {
                checkPasswordBox(false)
                val model = modelMapper.passwordToModel(domain) as LoginModel.Error
                updatePasswordView(model)
                passwordValid = false
            }
        }
    }

    private fun CoroutineScope.signInUser() =
        launch(dispatcher.IO) {

            val login = loginNameModel.loginName.value
            val password = loginPasswordModel.password.value
            val loginNameDomain = LoginNameDomain(login)
            val passwordDomain = LoginPasswordDomain(password)
            when (val result = interactor.signInUser(loginNameDomain, passwordDomain)) {
                is LoginDomain.Success -> {
                    showSuccess()
                    cleanInputViews()
                }
                is LoginDomain.Fail -> {showError(result.error.value)}
            }
        }

    private fun CoroutineScope.createNewUser(loginName: String, password: String) =
        launch(dispatcher.IO) {

            val loginNameDomain = LoginNameDomain(loginName)
            val passwordDomain = LoginPasswordDomain(password)
            when (val result = interactor.createUser(loginNameDomain, passwordDomain)) {
                is LoginDomain.Success -> {
                    showSuccess()
                    cleanInputViews()
                }
                is LoginDomain.Fail -> showError(result.error.value)
            }
        }

    private fun CoroutineScope.showSuccess() = launch(dispatcher.UI) {
        view?.showSuccess()
    }

    private fun CoroutineScope.showError(message: String) = launch(dispatcher.UI) {
        view?.showError(message)
    }

    private fun CoroutineScope.checkLogInStatus() = launch(dispatcher.IO) {
        when (val result = interactor.checkLogInStatus()) {
            is LoginDomain.Success -> {showLogInStatus(stringResource.getString(R.string.sign_in_true)) }
            is LoginDomain.Fail -> showLogInStatus(result.error.value)
        }
    }

    private fun CoroutineScope.showLogInStatus(message: String) = launch(dispatcher.UI) {
        view?.showLogInStatus(message)
    }

    private fun CoroutineScope.checkLoginBox(checkBox: Boolean) = launch(dispatcher.UI) {
        when (checkBox) {
            true -> view?.setLoginCheckBoxAsTrue()
            false -> view?.setLoginCheckBoxAsFalse()
        }
    }

    private fun CoroutineScope.checkPasswordBox(checkBox: Boolean) = launch(dispatcher.UI) {
        when (checkBox) {
            true -> view?.setPasswordCheckBoxAsTrue()
            false -> view?.setPasswordCheckBoxAsFalse()
        }
    }

    private fun CoroutineScope.updateLoginView(message: LoginModel.Error?) = launch(dispatcher.UI) {
        view?.updateLoginTextViewErrorMessage(message)
    }

    private fun CoroutineScope.updatePasswordView(message: LoginModel.Error?) = launch(dispatcher.UI) {
        view?.updatePasswordTextViewErrorMessage(message)
    }

    private fun CoroutineScope.updateButtonsFunction(enable: Boolean) = launch(dispatcher.UI) {
        when (enable) {
            false -> {
                view?.disableSignInButton()
                view?.disableCreateUserButton()
            }
            true -> {
                view?.enableSignInButton()
                view?.enableCreateUserButton()
            }
        }
    }

    private fun CoroutineScope.cleanInputViews() = launch(dispatcher.UI) {
        view?.cleanLoginTextView()
        view?.cleanPasswordTextView()
    }

    private fun CoroutineScope.logout() = launch(dispatcher.IO) {
        interactor.logoutUser()
    }

}

