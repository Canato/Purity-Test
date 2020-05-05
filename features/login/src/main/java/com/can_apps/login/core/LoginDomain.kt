package com.can_apps.login.core

import androidx.annotation.Nullable

internal sealed class LoginDomain {
    data class Fail(val error: LoginErrorDomain) : LoginDomain()
    data class Success(@Nullable val email: LoginUserEmailDomain) : LoginDomain()
}

internal inline class LoginErrorDomain(val value: String)
internal inline class LoginUserEmailDomain(val value: String?)
internal inline class LoginPasswordDomain(val value: String)
internal inline class LoginNameDomain(val value: String)