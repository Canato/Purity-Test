package com.can_apps.login.bresenter

internal data class LoginModel(val email: LoginModelEmail)

internal inline class LoginModelEmail (val value: String)
