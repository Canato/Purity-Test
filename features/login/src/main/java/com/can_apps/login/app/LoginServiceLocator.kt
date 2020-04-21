package com.can_apps.login.app

import android.content.Context
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryDefault
import com.can_apps.login.bresenter.LoginPresenter
import com.can_apps.login.core.LoginContract
import com.can_apps.login.core.LoginInteractor
import com.can_apps.login.data.LoginFirebaseApi
import com.can_apps.login.data.LoginFirebaseApiDefault
import com.can_apps.login.data.LoginRepository
import com.google.firebase.auth.FirebaseAuth

internal class LoginServiceLocator(private val context: Context) {

    fun getPresenter(): LoginContract.Presenter = LoginPresenter(getInteractor(), getCoroutineDispatcher())

    private fun getInteractor(): LoginContract.Interactor = LoginInteractor(getRepository())

    private fun getRepository(): LoginContract.Repository = LoginRepository(getApi())

    private fun getApi(): LoginFirebaseApi = LoginFirebaseApiDefault(FirebaseAuth.getInstance())

    private fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryDefault()

}
