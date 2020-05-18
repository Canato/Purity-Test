package com.can_apps.login.core

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {

    override fun loginNameValidation(loginName: LoginNameDomain): LoginNameValidationDomain {
        var i = 0
        while (i < 10000) {
//            Log.i("Delay old school", i.toString())
            i++
        }

        if (loginName.value == "") return LoginNameValidationDomain.EmptyLogin
        else if (loginName.value.length < 4) return LoginNameValidationDomain.ToSmall
        else if (!Regex("[@]").containsMatchIn(loginName.value)) return LoginNameValidationDomain.MissingAtSign
        else if (!Regex("[.][a-z]{2,}+$").containsMatchIn(loginName.value)) return LoginNameValidationDomain.WrongEmailDomainUsage
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]{2,}+[.][a-z]{2,}+[.][a-zA-Z0-9.]+").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.TooLongDomain
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]{2,}+$").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Valid(loginName)
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]{2,}+[.][a-z]{2,}+$").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Valid(loginName)
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

        if (password.value == "") return LoginPasswordValidationDomain.EmptyPassword
        else if (password.value.length < 8) return LoginPasswordValidationDomain.ToSmall
        else if (!Regex(pattern = "[A-Z]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.NoUpperCase
        } else if (!Regex(pattern = "[a-z]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.NoLowerCase
        } else if (!Regex(pattern = "[0-9]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.NoDigit
        } else if (Regex(pattern = "[a-zA-Z0-9]+").matches(password.value))
            return LoginPasswordValidationDomain.Valid(password)

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

    override fun checkFunction(loginValid: Boolean, passwordValid: Boolean): Boolean {
        return (loginValid && passwordValid)
    }

}