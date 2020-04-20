package com.can_apps.login.core

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {

    private val patternLowerCase = Regex(pattern = "[a-z]")
    private val patternUpperCase = Regex(pattern = "[A-Z]")
    private val patternDigit = Regex(pattern = "[0-9]")

    override fun passwordValidation(password: LoginPasswordDomain): Boolean {

        if (password.value.length < 8) return false
        val pattern = Regex(pattern = "[a-zA-Z0-9]+")

        return (patternLowerCase.containsMatchIn(password.value) &&
                patternUpperCase.containsMatchIn(password.value) &&
                patternDigit.containsMatchIn(password.value) &&
                pattern.matches(password.value))

    }

    override fun loginNameValidation(loginName: LoginNameDomain): Boolean {
        
        if (loginName.value.length < 4) return false
        val pattern = Regex(pattern = "[a-zA-Z]+")

        return (patternLowerCase.containsMatchIn(loginName.value) &&
                patternUpperCase.containsMatchIn(loginName.value) &&
                pattern.matches(loginName.value))
    }

    override fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain = repository.loginUser(loginName, password)
}