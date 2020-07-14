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

        if (loginName.value == "") return LoginNameValidationDomain.Invalid(LoginValidationError.EmptyLogin)
        else if (loginName.value.length < 4) return LoginNameValidationDomain.Invalid(LoginValidationError.ToSmall)
        else if (!Regex("[@]").containsMatchIn(loginName.value)) return LoginNameValidationDomain.Invalid(LoginValidationError.MissingAtSign)
        else if (!Regex("[.][a-z]{2,}+$").containsMatchIn(loginName.value)) return LoginNameValidationDomain.Invalid(LoginValidationError.WrongEmailDomainUsage)
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]{2,}+[.][a-z]{2,}+[.][a-zA-Z0-9.]+").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Invalid(LoginValidationError.TooLongDomain)
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]{2,}+$").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Valid
        else if (Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]{2,}+[.][a-z]{2,}+$").matches(loginName.value.toLowerCase()))
            return LoginNameValidationDomain.Valid
        return LoginNameValidationDomain.Invalid(LoginValidationError.WrongCharacters)
    }

    override fun passwordValidation(
        password: LoginPasswordDomain
    ): LoginPasswordValidationDomain {
        var i = 0
        while (i < 10000) {
//            Log.i("Delay old school", i.toString())
            i++
        }

        if (password.value == "") return LoginPasswordValidationDomain.Invalid(PasswordValidationError.EmptyPassword)
        else if (password.value.length < 8) return LoginPasswordValidationDomain.Invalid(PasswordValidationError.ToSmall)
        else if (!Regex(pattern = "[A-Z]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoUpperCase)
        } else if (!Regex(pattern = "[a-z]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoLowerCase)
        } else if (!Regex(pattern = "[0-9]").containsMatchIn(password.value)) {
            return LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoDigit)
        } else if (Regex(pattern = "[a-zA-Z0-9]+").matches(password.value))
            return LoginPasswordValidationDomain.Valid

        return LoginPasswordValidationDomain.Invalid(PasswordValidationError.WrongCharacters)
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
