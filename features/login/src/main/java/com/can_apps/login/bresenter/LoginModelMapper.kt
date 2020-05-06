package com.can_apps.login.bresenter

import com.can_apps.login.core.LoginNameDomain
import com.can_apps.login.core.LoginNameValidationDomain
import com.can_apps.login.core.LoginPasswordValidationDomain

internal interface LoginModelMapper {
    fun passwordToModel(domain: LoginPasswordValidationDomain): LoginModel
    fun loginToModel(domain: LoginNameValidationDomain): LoginModel
}

internal class LoginModelMapperDefault : LoginModelMapper {
    override fun passwordToModel(domain: LoginPasswordValidationDomain): LoginModel =
        when (domain) {
            is LoginPasswordValidationDomain.Valid -> LoginModel.Password(LoginModelPassword(domain.password.value))
            LoginPasswordValidationDomain.ToSmall -> LoginModel.Fail(LoginErrorModel("to short password"))
            LoginPasswordValidationDomain.WrongCharacters -> LoginModel.Fail(LoginErrorModel("wrong characters"))
            LoginPasswordValidationDomain.NoUpperCase -> LoginModel.Fail(LoginErrorModel("no uppercase"))
            LoginPasswordValidationDomain.NoLowerCase -> LoginModel.Fail(LoginErrorModel("no lowercase"))
            LoginPasswordValidationDomain.NoDigit -> LoginModel.Fail(LoginErrorModel("no digit"))
            LoginPasswordValidationDomain.EmptyPassword -> LoginModel.Fail(LoginErrorModel(""))
        }


    override fun loginToModel(domain: LoginNameValidationDomain): LoginModel =
            when (domain) {
                is LoginNameValidationDomain.Valid -> LoginModel.Name(LoginModelName(domain.loginName.value))
                 LoginNameValidationDomain.ToSmall -> LoginModel.Fail(LoginErrorModel("to short login"))
                 LoginNameValidationDomain.MissingAtSign -> LoginModel.Fail(LoginErrorModel("missing @ sign"))
                 LoginNameValidationDomain.WrongCharacters -> LoginModel.Fail(LoginErrorModel("wrong characters"))
                 LoginNameValidationDomain.WrongEmailDomainUsage -> LoginModel.Fail(LoginErrorModel("wrong user email domain"))
                 LoginNameValidationDomain.EmptyLogin -> LoginModel.Fail(LoginErrorModel(""))
            }

    }

