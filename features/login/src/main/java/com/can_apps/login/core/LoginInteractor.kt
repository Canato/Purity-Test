package com.can_apps.login.core

internal class LoginInteractor(
    private val repository: LoginContract.Repository
): LoginContract.Interactor {


    override fun passwordValidation(password: LoginPasswordDomain): Boolean {
        TODO()
    }

    override fun loginNameValidation(loginName: LoginNameDomain): Boolean {
        TODO()
    }

    override fun loginUser(loginName: LoginNameDomain, password: LoginPasswordDomain): LoginDomain {
        TODO()
    }

}