package com.can_apps.login.data

import com.can_apps.login.core.*

internal class LoginRepository(private val api: LoginFirebaseApi) : LoginContract.Repository {

    override suspend fun loginUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain {
        try {
            val result = api.loginExistingUser(loginName.value, password.value)
            if (!result) {
                val result2 = api.createNewUser(loginName.value, password.value)
                if (!result2) {
                   return LoginDomain.Fail(LoginErrorDomain("Sorry, login is not available"))
                }
            }
            return LoginDomain.Success
        } catch (e: Exception) {
            return LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }
    }

    override fun logoutUser() {
        api.logoutUser()
    }
}
