package com.can_apps.login.app

import android.content.Context
import com.can_apps.login.bresenter.LoginPresenter
import com.can_apps.login.core.LoginContract
import com.can_apps.login.core.LoginInteractor

internal class LoginServiceLocator(private val context: Context) {

    fun getPresenter() : LoginContract.Presenter =
        LoginPresenter(
            getInteractor()
        )

    }

    private fun getInteractor(): LoginContract.Interactor = LoginInteractor()
