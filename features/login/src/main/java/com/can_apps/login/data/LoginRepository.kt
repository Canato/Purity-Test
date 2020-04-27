package com.can_apps.login.data

import com.can_apps.login.core.*

internal class LoginRepository(private val api: LoginFirebaseApi) : LoginContract.Repository {

    override suspend fun signInUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain {

        return try {
            if (!api.signInExistingUser(loginName.value, password.value)) {
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
            if (!api.createNewUser(loginName.value, password.value)) {
                LoginDomain.Fail(LoginErrorDomain("Cannot create new user"))
            } else
                LoginDomain.Success
        } catch (e: Exception) {
            LoginDomain.Fail(LoginErrorDomain(e.message.toString()))
        }
    }

    override suspend fun logoutUser() = api.logoutUser()
    
    override suspend fun checkLogInStatus(): LoginDomain = api.checkLogInStatus()

}
