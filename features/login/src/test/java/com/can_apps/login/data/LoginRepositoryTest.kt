package com.can_apps.login.data

import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginErrorDomain
import com.can_apps.login.core.LoginNameDomain
import com.can_apps.login.core.LoginPasswordDomain
import com.can_apps.login.data.firebase_data_source.FirebaseApi
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class LoginRepositoryTest {

    @MockK
    private lateinit var api: FirebaseApi

    @InjectMockKs
    private lateinit var repository: LoginRepository

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    //Method                   TRUE/FALSE/EXCEPTION
    //api.signInExistingUser    ok/ok/EXCEPTION
    //api.createNewUser         TRUE/FALSE/ok tests
    //api.checkLogInStatus()    ok/ok/EXCEPTION

    @Test
    fun `GIVEN wrong password, WHEN sign in user, THEN return LoginDomain_Fail`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val wrongPassword = "Sorry, login is not available"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val errorDomain = LoginErrorDomain(wrongPassword)
        val expected = LoginDomain.Fail(errorDomain)

        //todo tomasz fix this
        coEvery { api.signInExistingUser(name, password) } returns false
        coEvery { api.signInExistingUser(name, password) } returns false

        //WHEN
        val result = runBlocking { repository.signInUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN no internet connection, WHEN sign in user, THEN return LoginDomain_Fail`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val noInternetConnection = "missingFlipFlops"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val noInternetConnectionDomain = LoginErrorDomain(noInternetConnection)
        val expected = LoginDomain.Fail(noInternetConnectionDomain)
        val exception = Exception(noInternetConnectionDomain.value)

        coEvery { api.createNewUser(name, password) } throws exception //todo tomasz name of the test don't fit with method called

        //WHEN
        val result = runBlocking { repository.createUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }
    //todo tomasz delete above or under test
    @Test
    fun `GIVEN exception, WHEN create user, THEN return LoginDomain_Fail`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val wrongLogin = "Sorry, login is taken new test"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val errorDomain = LoginErrorDomain(wrongLogin)
        val expected = LoginDomain.Fail(errorDomain)
        val exception = Exception(errorDomain.value)

        //tomasz what is the behaviour you want? false or exception ?
//        coEvery { api.createNewUser(name, password) } returns false <<< DELETE THIS
        coEvery { api.createNewUser(name, password) } throws exception

        //WHEN
        val result = runBlocking { repository.createUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN valid password, WHEN sign in user, THEN return LoginDomain_Success`() {

        //tomasz  valid password => valid parameters, name is valid too

        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginDomain.Success

        coEvery { api.signInExistingUser(name, password) } returns true

        //WHEN
        val result = runBlocking { repository.signInUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN valid login and password, WHEN create user , THEN return LoginDomain_Success`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginDomain.Success

        coEvery { api.signInExistingUser(name, password) } returns true //tomasz should be create method

        //WHEN
        val result = runBlocking { repository.signInUser(nameDomain, passwordDomain) } //tomasz should be create method

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN api currentUser is not null, WHEN checkLogInStatus , THEN return LoginDomain_Success`() {
        //GIVEN
        val expected = LoginDomain.Success

        coEvery { api.checkLogInStatus() } returns LoginDomain.Success

        //WHEN
        val result = runBlocking { repository.checkLogInStatus() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN api currentUser is null, WHEN checkLogInStatus , THEN return LoginDomain_Fail`() {
        //GIVEN
        val error = "flipflops"
        val errorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(errorDomain)

        every { runBlocking { api.checkLogInStatus() } } returns LoginDomain.Fail(errorDomain)

        //WHEN
        val result = runBlocking { repository.checkLogInStatus() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `WHEN logout, THEN perform repository logout user`() {
        //WHEN
        runBlocking { repository.logoutUser() }

        //THEN
        coVerify {
            api.logoutUser()
        }
    }
}