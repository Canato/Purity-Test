package com.can_apps.login.bresenter

import com.can_apps.login.core.LoginNameDomain
import com.can_apps.login.core.LoginPasswordValidationDomain

internal interface LoginModelMapper {
    fun passwordToModel(domain: LoginPasswordValidationDomain ) : LoginModel
    fun loginToModel(domain: LoginNameDomain ) : LoginModel
}

internal class LoginModelMapperDefault : LoginModelMapper{
    override fun passwordToModel(domain: LoginPasswordValidationDomain): LoginModel {
        TODO()
    }

    override fun loginToModel(domain: LoginNameDomain): LoginModel {
        TODO("Not yet implemented")
    }

}