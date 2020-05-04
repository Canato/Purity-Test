package com.can_apps.login.core

import android.util.Log

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {

    override fun loginNameValidation(loginName: LoginNameDomain): Boolean {
        var i = 0
        while (i < 10000) {
            Log.i("Delay old school", i.toString())
            i++
        }

        if (loginName.value.length < 4) return false
        val pattern = Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]+")

        return (pattern.matches(loginName.value.toLowerCase()))
    }

    override fun passwordValidation(
        password: LoginPasswordDomain
    ): LoginPasswordValidationDomain {
        var i = 0
        while (i < 10000) {
            Log.i("Delay old school", i.toString())
            i++
        }

        if (password.value.length < 8) return LoginPasswordValidationDomain.ToSmall

        if (!Regex(pattern = "[A-Z]").containsMatchIn(password.value)){
            return LoginPasswordValidationDomain.NoUpperCase
        }

        val patternLowerCase = Regex(pattern = "[a-z]")

        val patternDigit = Regex(pattern = "[0-9]")
        val pattern = Regex(pattern = "[a-zA-Z0-9]+")

//        return (patternLowerCase.containsMatchIn(password.value) &&
//                patternDigit.containsMatchIn(password.value) &&
//                pattern.matches(password.value))
        return LoginPasswordValidationDomain.Valid
    }

    override suspend fun signInUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain = repository.signInUser(loginName, password)

    override suspend fun createUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain = repository.createUser(loginName, password)

    override suspend fun checkLogInStatus() : LoginDomain = repository.checkLogInStatus()

    override suspend fun logoutUser() = repository.logoutUser()

}