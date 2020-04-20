package com.can_apps.login.core

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {


    override fun passwordValidation(password: LoginPasswordDomain): Boolean {

        if (password.value.length < 8) return false

        val patternLowerCase = Regex(pattern = "[a-z]")
        val patternUpperCase = Regex(pattern = "[A-Z]")
        val patternDigit = Regex(pattern = "[0-9]")
        val pattern = Regex(pattern = "[a-zA-Z0-9]+")

        return (patternLowerCase.containsMatchIn(password.value) &&
                patternUpperCase.containsMatchIn(password.value) &&
                patternDigit.containsMatchIn(password.value) &&
                pattern.matches(password.value))

    }

    override fun loginNameValidation(loginName: LoginNameDomain): Boolean {

        if (loginName.value.length < 4) return false
        val pattern = Regex("[a-z0-9._]+[@][a-z0-9]+[.][a-z]+")

        return (pattern.matches(loginName.value.toLowerCase()))
    }

    override fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain =
        repository.loginUser(loginName, password)
}