package com.can_apps.login.bresenter

internal sealed class LoginModel {

    data class Error(val message: LoginErrorModel) : LoginModel()
}

internal inline class LoginErrorModel(val value: String)
