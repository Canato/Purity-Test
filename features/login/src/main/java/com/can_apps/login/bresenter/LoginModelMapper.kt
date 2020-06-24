package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.login.R
import com.can_apps.login.core.LoginValidationError
import com.can_apps.login.core.LoginNameValidationDomain
import com.can_apps.login.core.LoginPasswordValidationDomain
import com.can_apps.login.core.PasswordValidationError

internal interface LoginModelMapper {

    fun passwordErrorToModel(domain: LoginPasswordValidationDomain.Invalid): LoginModel.Error
    fun loginErrorToModel(domain: LoginNameValidationDomain.Invalid): LoginModel.Error

}

internal class LoginModelMapperDefault(
    private val stringResource: CommonStringResourceWrapper
) : LoginModelMapper {

    override fun passwordErrorToModel(domain: LoginPasswordValidationDomain.Invalid): LoginModel.Error =
        when (domain) {
            LoginPasswordValidationDomain.Invalid(PasswordValidationError.EmptyPassword) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_empty_password)))
            LoginPasswordValidationDomain.Invalid(PasswordValidationError.ToSmall) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_to_small)))
            LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoUpperCase) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_no_upper_case)))
            LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoLowerCase) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_no_lower_case)))
            LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoDigit) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_no_digit)))
            else -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_password_wrong_characters)))
        }

    override fun loginErrorToModel(domain: LoginNameValidationDomain.Invalid): LoginModel.Error =
        when (domain) {
            LoginNameValidationDomain.Invalid(LoginValidationError.EmptyLogin) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_empty_login)))
            LoginNameValidationDomain.Invalid(LoginValidationError.ToSmall) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_to_small)))
            LoginNameValidationDomain.Invalid(LoginValidationError.MissingAtSign) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_missing_at_sign)))
            LoginNameValidationDomain.Invalid(LoginValidationError.WrongEmailDomainUsage) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_wrong_email_domain_usage)))
            LoginNameValidationDomain.Invalid(LoginValidationError.TooLongDomain) -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_too_long_domain)))
            else -> LoginModel.Error(LoginErrorModel(stringResource.getString(R.string.validation_login_wrong_characters)))
        }

}

