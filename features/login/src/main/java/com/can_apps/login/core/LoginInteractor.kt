package com.can_apps.login.core

internal class LoginInteractor(
    private val repository: LoginContract.Repository
) : LoginContract.Interactor {


    override fun passwordValidation(password: LoginPasswordDomain): Boolean {
        TODO()
    }

    override fun loginNameValidation(loginName: LoginNameDomain): Boolean {
        val loginChar = loginName.value.toCharArray()

        if (loginChar.size < 3)
            return false

        loginChar.forEach { char -> if (char < 'A' || char > 'z') return false }

        return true
    }

    override fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain {
        TODO()
    }

}