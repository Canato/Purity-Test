package com.can_apps.login

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryUnconfined
import com.can_apps.login.app.LoginServiceLocator
import com.can_apps.login.data.firebase_data_source.FirebaseApi
import io.mockk.mockk

internal class MockLoginServiceLocator(
    private val stringResource: CommonStringResourceWrapper,
    private val firebaseApi: FirebaseApi
) : LoginServiceLocator(mockk(relaxed = true)) {

    override fun getStringResource(): CommonStringResourceWrapper = stringResource

    override fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryUnconfined()

    override fun getApi(): FirebaseApi = firebaseApi
}
