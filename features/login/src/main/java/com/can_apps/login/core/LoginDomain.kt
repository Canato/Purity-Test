package com.can_apps.login.core

internal sealed class LoginDomain {

    object Success : LoginDomain()

    data class Fail(val error: LoginErrorDomain) : LoginDomain()
}

internal sealed class LoginPasswordValidationDomain {

    data class Valid(val password: LoginPasswordDomain) : LoginPasswordValidationDomain()

    object ToSmall : LoginPasswordValidationDomain()
    object NoDigit : LoginPasswordValidationDomain()
    object NoUpperCase : LoginPasswordValidationDomain()
    object NoLowerCase : LoginPasswordValidationDomain()
    object EmptyPassword : LoginPasswordValidationDomain()
    object WrongCharacters : LoginPasswordValidationDomain()
}

internal sealed class LoginNameValidationDomain {

    data class Valid(val loginName: LoginNameDomain) : LoginNameValidationDomain()

    object ToSmall : LoginNameValidationDomain()
    object EmptyLogin : LoginNameValidationDomain()
    object TooLongDomain : LoginNameValidationDomain()
    object MissingAtSign : LoginNameValidationDomain()
    object WrongCharacters : LoginNameValidationDomain()
    object WrongEmailDomainUsage : LoginNameValidationDomain()
}

internal inline class LoginErrorDomain(val value: String)
internal inline class LoginPasswordDomain(val value: String)
internal inline class LoginNameDomain(val value: String)
internal inline class LoginUserEmailDomain(val value: String)