package com.can_apps.login.data

import com.can_apps.login.core.*

internal class LoginRepository(private val api: LoginFirebaseApi) : LoginContract.Repository {

    override suspend fun signInUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain {

        return try {
            val result = api.loginExistingUser(loginName.value, password.value)
            if (!result) {
                LoginDomain.Fail(LoginErrorDomain("Sorry, login is not available"))
            } else
                LoginDomain.Success
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }
    }

    override suspend fun createUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain {

        return try {
            val result = api.createNewUser(loginName.value, password.value)
            if (!result) {
                LoginDomain.Fail(LoginErrorDomain("Cannot create new user"))
            } else
                LoginDomain.Success
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }
    }

    override suspend fun logoutUser() {
        api.logoutUser()
    }

    override suspend fun checkUser(): String? {
        return api.checkUser()
    }
}
