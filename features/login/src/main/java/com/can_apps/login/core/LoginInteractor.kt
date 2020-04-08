package com.can_apps.login.core

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {


    override fun passwordValidation(password: LoginPasswordDomain): Boolean {
        TODO()
    }

    override fun loginNameValidation(loginName: LoginNameDomain): Boolean {

        val loginSize = loginName.value.length
        if (loginSize < 3)
            return false

        val pattern = Regex(pattern = "[a-zA-Z]{$loginSize}")
        if (pattern.matches(loginName.value)) {
            return true
        }

        return false

    }

    override fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain {
        TODO()
    }

}