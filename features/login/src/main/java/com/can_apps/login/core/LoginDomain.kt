package com.can_apps.login.core

internal sealed class LoginDomain {
    object Success : LoginDomain()
    data class Fail(val error: LoginErrorDomain) : LoginDomain()
}

internal sealed class LoginPasswordValidationDomain {
    object Valid : LoginPasswordValidationDomain()
    object WrongCharacters : LoginPasswordValidationDomain()
    object ToSmall : LoginPasswordValidationDomain()
    object NoUpperCase : LoginPasswordValidationDomain()
    object NoLowerCase : LoginPasswordValidationDomain()
    object NoDigit : LoginPasswordValidationDomain()
}

internal sealed class LoginNameValidationDomain {
    object Valid : LoginNameValidationDomain()
    object ToSmall : LoginNameValidationDomain()
    object WrongCharacters : LoginNameValidationDomain()
    object MissingAtSign : LoginNameValidationDomain()
    object MissingDotDomainFinish : LoginNameValidationDomain()
}

internal inline class LoginErrorDomain(val value: String)
internal inline class LoginPasswordDomain(val value: String)
internal inline class LoginNameDomain(val value: String)