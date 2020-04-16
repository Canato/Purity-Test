package com.can_apps.login.app

import android.content.Context
import com.can_apps.login.bresenter.LoginPresenter
import com.can_apps.login.core.LoginContract
import com.can_apps.login.core.LoginInteractor
import com.can_apps.login.data.LoginFirebaseApi
import com.can_apps.login.data.LoginFirebaseApiDefault
import com.can_apps.login.data.LoginRepository
import com.google.firebase.auth.FirebaseAuth

internal class LoginServiceLocator(private val context: Context) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun getPresenter(): LoginContract.Presenter =
        LoginPresenter(
            getInteractor()
        )

    private fun getInteractor(): LoginContract.Interactor = LoginInteractor(getRepository())
    private fun getRepository(): LoginContract.Repository = LoginRepository(getApi())
    private fun getApi(): LoginFirebaseApi = LoginFirebaseApiDefault(auth)
}
