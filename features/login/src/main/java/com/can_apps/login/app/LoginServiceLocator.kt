package com.can_apps.login.app

import android.content.Context
import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryDefault
import com.can_apps.login.bresenter.LoginModelMapper
import com.can_apps.login.bresenter.LoginModelMapperDefault
import com.can_apps.login.bresenter.LoginPresenter
import com.can_apps.login.core.LoginContract
import com.can_apps.login.core.LoginInteractor
import com.can_apps.login.data.LoginDtoMapper
import com.can_apps.login.data.LoginDtoMapperDefault
import com.can_apps.login.data.firebase_data_source.FirebaseApi
import com.can_apps.login.data.firebase_data_source.FirebaseApiDefault
import com.can_apps.login.data.LoginRepository
import com.google.firebase.auth.FirebaseAuth

internal class LoginServiceLocator(private val context: Context) {

    fun getPresenter(): LoginContract.Presenter =
        LoginPresenter(getInteractor(), getCoroutineDispatcher(), getStringResource(), getModelMapper())

    private fun getStringResource(): CommonStringResourceWrapper = CommonStringResourceWrapper(context)

    private fun getInteractor(): LoginContract.Interactor = LoginInteractor(getRepository())

    private fun getRepository(): LoginContract.Repository = LoginRepository(getApi(), getDtoMapper())

    private fun getDtoMapper(): LoginDtoMapper = LoginDtoMapperDefault(getStringResource())

    private fun getModelMapper(): LoginModelMapper = LoginModelMapperDefault()

    private fun getApi(): FirebaseApi = FirebaseApiDefault(FirebaseAuth.getInstance())

    private fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryDefault()

}
