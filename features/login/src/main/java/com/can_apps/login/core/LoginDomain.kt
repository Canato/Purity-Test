package com.can_apps.login.core

internal sealed class LoginDomain {

    object Success : LoginDomain()

    data class Fail(val error: LoginErrorDomain) : LoginDomain()
}

internal sealed class LoginPasswordValidationDomain {

    object Valid : LoginPasswordValidationDomain()

    data class Invalid(val error: PasswordValidationError) : LoginPasswordValidationDomain()
}

internal sealed class LoginNameValidationDomain {

    object Valid : LoginNameValidationDomain()

    data class Invalid(val error: LoginValidationError) : LoginNameValidationDomain()
}

internal sealed class LoginValidationError {
    object ToSmall : LoginValidationError()
    object EmptyLogin : LoginValidationError()
    object TooLongDomain : LoginValidationError()
    object MissingAtSign : LoginValidationError()
    object WrongCharacters : LoginValidationError()
    object WrongEmailDomainUsage : LoginValidationError()
}

internal sealed class PasswordValidationError {
    object ToSmall : PasswordValidationError()
    object NoDigit : PasswordValidationError()
    object NoUpperCase : PasswordValidationError()
    object NoLowerCase : PasswordValidationError()
    object EmptyPassword : PasswordValidationError()
    object WrongCharacters : PasswordValidationError()
}

internal inline class LoginErrorDomain(val value: String)
internal inline class LoginPasswordDomain(val value: String)
internal inline class LoginNameDomain(val value: String)
