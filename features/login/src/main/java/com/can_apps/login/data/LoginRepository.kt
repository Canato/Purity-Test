package com.can_apps.login.data

import com.can_apps.login.core.*

internal class LoginRepository(private val api: LoginFirebaseApi) : LoginContract.Repository {


    override suspend fun loginUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain =
        try {
            if (!api.loginExistingUser(loginName.value, password.value)) {
                if (!api.createNewUser(loginName.value, password.value)) {
                    LoginDomain.Fail(LoginErrorDomain("Sorry, login is not available"))
                }
            }
            LoginDomain.Success
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }

}
