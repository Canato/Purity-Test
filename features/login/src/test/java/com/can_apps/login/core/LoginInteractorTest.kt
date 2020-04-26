package com.can_apps.login.core

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
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
    fun `GIVEN repository logout User , WHEN logout, THEN perform interactor logout user`() {
        //GIVEN

        //WHEN
        runBlocking { interactor.logoutUser() }

        //THEN
        verify {
            runBlocking { repository.logoutUser() }
        }
    }

    @Test
    fun `GIVEN valid login name, WHEN validate, THEN return true`() {
        //GIVEN
        val login = "Tomasz@gmail.com"
        val loginNameDomain = LoginNameDomain(login)

        //WHEN
        val result = runBlocking { interactor.loginNameValidation(loginNameDomain) }

        //THEN
        assertTrue(result)
    }

    @Test
    fun `GIVEN login with less than four characters , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tom"
        val loginNameDomain = LoginNameDomain(login)

        //WHEN
        val result = runBlocking { interactor.loginNameValidation(loginNameDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN login with special characters , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tom!sz@gmail.com"
        val loginNameDomain = LoginNameDomain(login)

        //WHEN
        val result = runBlocking { interactor.loginNameValidation(loginNameDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN login with empty character , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tom sz@gmail.com"
        val loginNameDomain = LoginNameDomain(login)

        //WHEN
        val result = runBlocking { interactor.loginNameValidation(loginNameDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN login without AT symbol , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "TomaszATgmail.com"
        val loginNameDomain = LoginNameDomain(login)

        //WHEN
        val result = runBlocking { interactor.loginNameValidation(loginNameDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN login without dot after AT symbol , WHEN validate, THEN return false`() {
        //GIVEN
        val login = "Tomasz@gmailDOTcom"
        val loginNameDomain = LoginNameDomain(login)

        //WHEN
        val result = runBlocking { interactor.loginNameValidation(loginNameDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN password, WHEN validate, THEN return true`() {
        //GIVEN
        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        //WHEN
        val result = runBlocking { interactor.passwordValidation(passwordDomain) }

        //THEN
        assertTrue(result)
    }

    @Test
    fun `GIVEN valid password with non valid extra characters, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWORD1 @!"
        val passwordDomain = LoginPasswordDomain(password)

        //WHEN
        val result = runBlocking { interactor.passwordValidation(passwordDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN password with less than 8 characters, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWO9"
        val passwordDomain = LoginPasswordDomain(password)

        //WHEN
        val result = runBlocking { interactor.passwordValidation(passwordDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN no digit password, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "passWORD"
        val passwordDomain = LoginPasswordDomain(password)

        //WHEN
        val result = runBlocking { interactor.passwordValidation(passwordDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN no lowerCase password, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "PASSWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        //WHEN
        val result = runBlocking { interactor.passwordValidation(passwordDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN no upperCase password, WHEN validate, THEN return false`() {
        //GIVEN
        val password = "password1"
        val passwordDomain = LoginPasswordDomain(password)

        //WHEN
        val result = runBlocking { interactor.passwordValidation(passwordDomain) }

        //THEN
        assertFalse(result)
    }

    @Test
    fun `GIVEN repository success, WHEN loginUser, THEN return LoginDomain Success`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)

        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        val expected = LoginDomain.Success

        every {
            runBlocking {
                repository.signInUser(
                    loginNameDomain,
                    passwordDomain
                )
            }
        } returns expected

        //WHEN
        val result = runBlocking { interactor.signInUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN repository fail, WHEN loginUser, THEN return LoginDomain Fail`() {
        //GIVEN
        val login = "Tomasz"
        val loginNameDomain = LoginNameDomain(login)

        val password = "passWORD1"
        val passwordDomain = LoginPasswordDomain(password)

        val error = "flipflops"
        val errorDomain = LoginErrorDomain(error)

        val expected = LoginDomain.Fail(errorDomain)

        every {
            runBlocking {
                repository.signInUser(
                    loginNameDomain,
                    passwordDomain
                )
            }
        } returns expected

        //WHEN
        val result = runBlocking { interactor.signInUser(loginNameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }


}