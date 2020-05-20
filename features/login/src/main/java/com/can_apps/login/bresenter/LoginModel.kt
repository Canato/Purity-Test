package com.can_apps.login.bresenter

internal sealed class LoginModel {
    data class Name(val loginName: LoginModelName) : LoginModel()
    data class Password(val password: LoginModelPassword) : LoginModel()
    data class Error(val message: LoginErrorModel) : LoginModel()
}

internal inline class LoginErrorModel(val value: String)
internal inline class LoginModelName(val value: String)
internal inline class LoginModelPassword(val value: String)