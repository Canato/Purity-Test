package com.can_apps.login.data

import com.can_apps.login.core.*
import com.can_apps.login.data.firebase_data_source.FirebaseApi

internal class LoginRepository(
    private val api: FirebaseApi,
    private val dtoMapper: LoginDtoMapper
) : LoginContract.Repository {

    override suspend fun signInUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain =
        try {
            val dto = api.signInExistingUser(loginName.value, password.value)
            dtoMapper.toDomain(dto)
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }

    override suspend fun createUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain =
        try {
            val dto = api.createNewUser(loginName.value, password.value)
            dtoMapper.toDomain(dto)
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }


    override suspend fun logoutUser() = api.logoutUser()

    override suspend fun checkLogInStatus(): LoginDomain =
        try {
            val dto = api.checkLogInStatus()
            dtoMapper.toDomain(dto)
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }
}
