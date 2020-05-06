package com.can_apps.login.bresenter

internal sealed class LoginModel {
    data class Name(val value: LoginModelName) : LoginModel()
    data class Password(val value: LoginModelPassword) : LoginModel()
    data class Fail(val error: LoginErrorModel) : LoginModel()
}

internal inline class LoginErrorModel(val value: String)
internal inline class LoginModelName(val value: String)
internal inline class LoginModelPassword(val value: String)