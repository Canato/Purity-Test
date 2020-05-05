package com.can_apps.login.bresenter

import androidx.annotation.Nullable

internal sealed class LoginModel
{
    data class Name(val value: String) : LoginModel()
    data class Password(val value: String) : LoginModel()
    data class Fail(val value: LoginErrorModel) : LoginModel()
}

internal inline class LoginErrorModel(val value: String)