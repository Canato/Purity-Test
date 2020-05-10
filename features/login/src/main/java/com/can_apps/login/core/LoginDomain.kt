package com.can_apps.login.core

import androidx.annotation.Nullable

internal sealed class LoginDomain {
    data class Success(@Nullable val email: LoginUserEmailDomain?) : LoginDomain()
    data class Fail(val error: LoginErrorDomain) : LoginDomain()
}

internal sealed class LoginPasswordValidationDomain {
    data class Valid(val password: LoginPasswordDomain) : LoginPasswordValidationDomain()
    object EmptyPassword : LoginPasswordValidationDomain()
    object ToSmall : LoginPasswordValidationDomain()
    object WrongCharacters : LoginPasswordValidationDomain()
    object NoUpperCase : LoginPasswordValidationDomain()
    object NoLowerCase : LoginPasswordValidationDomain()
    object NoDigit : LoginPasswordValidationDomain()
}

internal sealed class LoginNameValidationDomain {
    data class Valid(val loginName: LoginNameDomain) : LoginNameValidationDomain()
    object EmptyLogin : LoginNameValidationDomain()
    object ToSmall : LoginNameValidationDomain()
    object WrongCharacters : LoginNameValidationDomain()
    object MissingAtSign : LoginNameValidationDomain()
    object WrongEmailDomainUsage : LoginNameValidationDomain()
}

internal inline class LoginErrorDomain(val value: String)
internal inline class LoginPasswordDomain(val value: String)
internal inline class LoginNameDomain(val value: String)
internal inline class LoginUserEmailDomain(val value: String)