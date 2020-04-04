package com.can_apps.login.bresenter

import android.widget.Toast
import com.can_apps.login.core.LoginContract

internal class LoginPresenter : LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun bind(view: LoginContract.View) {
        this.view = view
    }

    override fun unbind() {
    }

    override fun onViewCreated() {
        view.welcome()
    }

    override fun onBackPressed() {
        view.close()
    }

}