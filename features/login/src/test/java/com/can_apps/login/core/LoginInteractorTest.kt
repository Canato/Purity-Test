package com.can_apps.login.core

import android.util.Log
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

internal class LoginInteractorTest {

    @MockK
    private lateinit var repository: LoginContract.Repository

    @InjectMockKs
    private lateinit var interactor: LoginInteractor

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN valid login name with single domain, WHEN validate, THEN return true`() {
        //GIVEN
        val login = "Tomasz@gmail.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Valid(loginNameDomain)

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN valid login with double domain, WHEN validate, THEN return true`() {
        //GIVEN
        val login = "Tomasz@gmail.co.uk"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Valid(loginNameDomain)

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN empty login , WHEN validate, THEN return false`() {
        //GIVEN
        val login = ""
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.EmptyLogin

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login with less than four characters, WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tom"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.ToSmall

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login with special characters, WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tom!sz@gmail.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.WrongCharacters

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login with empty character, WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tom sz@gmail.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.WrongCharacters

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login without AT symbol , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tomaszgmail.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.MissingAtSign

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login without dot after AT symbol , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tomasz@gmailcom"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.WrongEmailDomainUsage

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login with one symbol in domain after AT symbol, WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tomasz@gmail.c"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.WrongEmailDomainUsage

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN login with triple domain after AT symbol , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tomasz@gmail.co.uk.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.TooLongDomain

        //WHEN
        val result = interactor.loginNameValidation(loginNameDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN valid password, WHEN validate, THEN return true`() {
        //GIVEN
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Valid(passwordDomain)

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password with non valid extra characters, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWORD1@!"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.WrongCharacters

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password with empty space, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWO  RD1"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.WrongCharacters

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN empty password , WHEN validate, THEN return false`() {
        //GIVEN
        val password = ""
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.EmptyPassword

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password with less than 8 characters, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWO9"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.ToSmall

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password with no digit, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWORD"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.NoDigit

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password with no lowerCase , WHEN validate, THEN return false`() {
        //GIVEN
        val password = "PASSWORD1"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.NoLowerCase

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN password with no upperCase, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "password1"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.NoUpperCase

        //WHEN
        val result = interactor.passwordValidation(passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN non null email domain from repository, WHEN sign in user, THEN return LoginDomain Success`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        val expected = LoginDomain.Success

        coEvery { repository.signInUser(loginNameDomain, passwordDomain) } returns expected

        //WHEN
        val result = runBlocking { interactor.signInUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN null email domain from repository, WHEN sign in user, THEN return LoginDomain Success`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        val expected = LoginDomain.Success

        coEvery { repository.signInUser(loginNameDomain, passwordDomain) } returns expected

        //WHEN
        val result = runBlocking { interactor.signInUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN error message from repository, WHEN sign in user, THEN return LoginDomain Fail`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)
        val error = "flipflops"
        val errorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(errorDomain)

        coEvery { repository.signInUser(loginNameDomain, passwordDomain) } returns expected

        //WHEN
        val result = runBlocking { interactor.signInUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN non null email domain from repository, WHEN create new user, THEN return LoginDomain Success`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        val expected = LoginDomain.Success

        coEvery { repository.createUser(loginNameDomain, passwordDomain) } returns expected

        //WHEN
        val result = runBlocking { interactor.createUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN null email domain from repository, WHEN create new user, THEN return LoginDomain Success`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        val expected = LoginDomain.Success

        coEvery { repository.createUser(loginNameDomain, passwordDomain) } returns expected

        //WHEN
        val result = runBlocking { interactor.createUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN error message from repository, WHEN create new user, THEN return LoginDomain Fail`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)
        val error = "flipflops"
        val errorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(errorDomain)

        coEvery { repository.createUser(loginNameDomain, passwordDomain) } returns expected

        //WHEN
        val result = runBlocking { interactor.createUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN email domain from repository, WHEN checkLogInStatus, THEN return LoginDomain_Success`() {
        //GIVEN
        val expected = LoginDomain.Success

        coEvery { repository.checkLogInStatus() } returns expected

        //WHEN
        val result = runBlocking { interactor.checkLogInStatus() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN error message from repository, WHEN checkLogInStatus, THEN return LoginDomain_Fail`() {
        //GIVEN
        val error = "flipflops"
        val errorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(errorDomain)
        coEvery { repository.checkLogInStatus() } returns expected

        //WHEN
        val result = runBlocking { interactor.checkLogInStatus() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `WHEN logout, THEN perform interactor logout user`() {
        //WHEN
        runBlocking { interactor.logoutUser() }

        //THEN
        coVerify {
            repository.logoutUser()
        }
    }
}