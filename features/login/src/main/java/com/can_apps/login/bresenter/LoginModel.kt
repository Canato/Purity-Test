package com.can_apps.login.bresenter

internal data class LoginModel(val email: LoginEmailModel?)

internal inline class LoginEmailModel (val value: String)
