package com.can_apps.login.core

internal sealed class LoginDomain {
    object Success : LoginDomain()
    data class Fail(val error: LoginErrorDomain) : LoginDomain()
    data class UserEmail(val email: LoginUserEmailDomain) : LoginDomain()
}

internal inline class LoginErrorDomain(val value: String)
internal inline class LoginUserEmailDomain(val value: String)
internal inline class LoginPasswordDomain(val value: String)
internal inline class LoginNameDomain(val value: String)