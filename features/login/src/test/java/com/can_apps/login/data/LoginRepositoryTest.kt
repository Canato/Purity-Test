package com.can_apps.login.data

import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginErrorDomain
import com.can_apps.login.core.LoginNameDomain
import com.can_apps.login.core.LoginPasswordDomain
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class LoginRepositoryTest {

    @MockK
    private lateinit var api: LoginFirebaseApi

    @InjectMockKs
    private lateinit var repository: LoginRepository

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `GIVEN wrong password, WHEN loginUser, THEN return LoginDomain_Fail`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val wrongPassword = "Sorry, login is not available"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val errorDomain = LoginErrorDomain(wrongPassword)
        val expected = LoginDomain.Fail(errorDomain)
        every { api.loginExistingUser(nameDomain.value, passwordDomain.value) } returns false
        every { api.createNewUser(nameDomain.value, passwordDomain.value) } returns false
        //WHEN

        val result = repository.loginUser(nameDomain, passwordDomain)

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN no internet connection, WHEN loginUser, THEN return LoginDomain_Fail`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val noInternetConnection = "missingFlipFlops"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val noInternetConnectionDomain = LoginErrorDomain(noInternetConnection)
        val expected = LoginDomain.Fail(noInternetConnectionDomain)
        every { api.loginExistingUser(nameDomain.value, passwordDomain.value) } throws Exception(
            noInternetConnectionDomain.value
        )

        //WHEN
        val result = repository.loginUser(nameDomain, passwordDomain)

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN valid password, WHEN loginUser , THEN return LoginDomain_Success`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginDomain.Success
        every { api.loginExistingUser(nameDomain.value, passwordDomain.value) } returns true

        //WHEN
        val result = repository.loginUser(nameDomain, passwordDomain)

        //THEN
        assertEquals(expected, result)
    }

}