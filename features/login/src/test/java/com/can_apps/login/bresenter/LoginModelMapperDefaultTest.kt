package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.login.R
import com.can_apps.login.core.*
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class LoginModelMapperDefaultTest {

    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @InjectMockKs
    private lateinit var model: LoginModelMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN login domain to small, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.ToSmall)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_login_to_small) } returns message

        //WHEN
        val result = model.loginErrorToModel(loginNameValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login domain with missing at sign, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.MissingAtSign)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_login_missing_at_sign) } returns message

        //WHEN
        val result = model.loginErrorToModel(loginNameValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login domain with wrong characters, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.WrongCharacters)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_login_wrong_characters) } returns message

        //WHEN
        val result = model.loginErrorToModel(loginNameValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login domain with wrong email domain usage, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.WrongEmailDomainUsage)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_login_wrong_email_domain_usage) } returns message

        //WHEN
        val result = model.loginErrorToModel(loginNameValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login domain with too long domain, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.TooLongDomain)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_login_too_long_domain) } returns message

        //WHEN
        val result = model.loginErrorToModel(loginNameValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login domain empty, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.EmptyLogin)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_login_empty_login) } returns message

        //WHEN
        val result = model.loginErrorToModel(loginNameValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password domain to small, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.ToSmall)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_password_to_small) } returns message

        //WHEN
        val result = model.passwordErrorToModel(loginPasswordValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password domain with wrong characters, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.WrongCharacters)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_password_wrong_characters) } returns message

        //WHEN
        val result = model.passwordErrorToModel(loginPasswordValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password domain without uppercase, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoUpperCase)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_password_no_upper_case) } returns message

        //WHEN
        val result = model.passwordErrorToModel(loginPasswordValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password domain without lowercase, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoLowerCase)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_password_no_lower_case) } returns message

        //WHEN
        val result = model.passwordErrorToModel(loginPasswordValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password domain without digit, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoDigit)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_password_no_digit) } returns message

        //WHEN
        val result = model.passwordErrorToModel(loginPasswordValidationDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password domain empty, WHEN map to model, THEN return login model_error with message`() {
        //GIVEN
        val message = "monarch"
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.EmptyPassword)
        val expected = LoginModel.Error(LoginErrorModel(message))

        coEvery { stringResource.getString(R.string.validation_password_empty_password) } returns message

        //WHEN
        val result = model.passwordErrorToModel(loginPasswordValidationDomain)

        //THEN
        assertEquals(expected, result)
    }


}