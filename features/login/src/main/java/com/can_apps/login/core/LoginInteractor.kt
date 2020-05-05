package com.can_apps.login.core

import android.util.Log

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {

    override fun loginNameValidation(loginName: LoginNameDomain): LoginNameValidationDomain {
        var i = 0
        while (i < 10000) {
//            Log.i("Delay old school", i.toString())
            i++
        }

        if (loginName.value.length < 4) return LoginNameValidationDomain.ToSmall
        else if (!Regex("[@]").containsMatchIn(loginName.value)) return LoginNameValidationDomain.MissingAtSign
        else if (!Regex("[.][a-z]+$").containsMatchIn(loginName.value)) return LoginNameValidationDomain.MissingDotDomainFinish
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]+$").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Valid
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]+[.][a-z]+$").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Valid
        return LoginNameValidationDomain.WrongCharacters
    }

    override fun passwordValidation(
        password: LoginPasswordDomain
    ): LoginPasswordValidationDomain {
        var i = 0
        while (i < 10000) {
//            Log.i("Delay old school", i.toString())
            i++
        }

        if (password.value.length < 8) return LoginPasswordValidationDomain.ToSmall
        else if (!Regex(pattern = "[A-Z]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.NoUpperCase
        } else if (!Regex(pattern = "[a-z]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.NoLowerCase
        } else if (!Regex(pattern = "[0-9]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.NoDigit
        } else if (Regex(pattern = "[a-zA-Z0-9]+").matches(password.value))
            return LoginPasswordValidationDomain.Valid

        return LoginPasswordValidationDomain.WrongCharacters
    }

    override suspend fun signInUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain = repository.signInUser(loginName, password)

    override suspend fun createUser(
        loginName: LoginNameDomain,
        password: LoginPasswordDomain
    ): LoginDomain = repository.createUser(loginName, password)

    override suspend fun checkLogInStatus(): LoginDomain = repository.checkLogInStatus()

    override suspend fun logoutUser() = repository.logoutUser()

}