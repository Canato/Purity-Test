package com.can_apps.login.bresenter

import android.content.Context
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
    private val context: Context
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

    override fun onLoginClicked(password: String, loginName: String) {
        retrieveData(password, loginName)
    }

    private fun CoroutineScope.retrieveData(password: String, loginName: String) = launch(dispatcher.IO) {

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
            view.showError(context.getString(R.string.login_error_message))
    }

}

