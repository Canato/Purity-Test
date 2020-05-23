package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.login.R
import com.can_apps.login.core.LoginNameValidationDomain
import com.can_apps.login.core.LoginPasswordValidationDomain

internal interface LoginModelMapper {

    fun passwordToModel(domain: LoginPasswordValidationDomain): LoginModel

    fun loginToModel(domain: LoginNameValidationDomain): LoginModel
}

internal class LoginModelMapperDefault(
    private val stringResource: CommonStringResourceWrapper
) : LoginModelMapper {
    override fun passwordToModel(domain: LoginPasswordValidationDomain): LoginModel =
        when (domain) {
            is LoginPasswordValidationDomain.Valid -> LoginModel.Password(LoginModelPassword(domain.password.value))
            LoginPasswordValidationDomain.ToSmall -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_to_small)))
            LoginPasswordValidationDomain.WrongCharacters -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_wrong_characters)))
            LoginPasswordValidationDomain.NoUpperCase -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_no_upper_case)))
            LoginPasswordValidationDomain.NoLowerCase -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_no_lower_case)))
            LoginPasswordValidationDomain.NoDigit -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_no_digit)))
            LoginPasswordValidationDomain.EmptyPassword -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_empty_password)))
        }


    override fun loginToModel(domain: LoginNameValidationDomain): LoginModel =
        when (domain) {
            is LoginNameValidationDomain.Valid -> LoginModel.Name(LoginModelName(domain.loginName.value))
            LoginNameValidationDomain.ToSmall -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_to_small)))
            LoginNameValidationDomain.MissingAtSign -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_missing_at_sign)))
            LoginNameValidationDomain.WrongCharacters -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_wrong_characters)))
            LoginNameValidationDomain.WrongEmailDomainUsage -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_wrong_email_domain_usage)))
            LoginNameValidationDomain.TooLongDomain -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_too_long_domain)))
            LoginNameValidationDomain.EmptyLogin -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_empty_login)))
        }

}

