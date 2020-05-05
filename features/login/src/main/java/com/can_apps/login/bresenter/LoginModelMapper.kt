package com.can_apps.login.bresenter

import com.can_apps.login.core.LoginDomain

internal interface LoginModelMapper {

    fun toModel(domain: LoginDomain.Success): LoginModel
}

internal class LoginModelMapperDefault : LoginModelMapper {

    override fun toModel(domain: LoginDomain.Success): LoginModel =
        LoginModel(LoginModelEmail(domain.email.value))
}