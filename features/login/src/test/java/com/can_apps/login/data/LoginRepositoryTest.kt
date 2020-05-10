package com.can_apps.login.data

import com.can_apps.login.core.*
import com.can_apps.login.data.firebase_data_source.FireBaseUserEmail
import com.can_apps.login.data.firebase_data_source.FirebaseApi
import com.can_apps.login.data.firebase_data_source.FirebaseDto
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

    @MockK
    private lateinit var dtoMapper: LoginDtoMapper

    @InjectMockKs
    private lateinit var repository: LoginRepository

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    //Method                   TRUE/FALSE/EXCEPTION
    //api.signInExistingUser    ok/ok/ok
    //api.createNewUser         ok/no need/ok
    //api.checkLogInStatus()    ok/ok/ok
    //api.logout()              ok

    @Test
    fun `GIVEN valid parameters, WHEN sign in user, THEN return LoginDomain_Success`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)

        val email = "Mac@Wheels.Pro"
        val userEmailDomain = LoginUserEmailDomain(email)
        val expected = LoginDomain.Success(userEmailDomain)

        val firebaseEmail = "Mac@Wheels.Pro"
        val firebaseEmailDomain = FireBaseUserEmail(firebaseEmail)

        val dto = FirebaseDto.Valid(firebaseEmailDomain)

        coEvery { api.signInExistingUser(name, password)} returns dto
        coEvery { dtoMapper.toDomain(dto) } returns expected

        //WHEN
        val result = runBlocking { repository.signInUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN wrong password, WHEN sign in user, THEN return LoginDomain_Fail`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val wrongPassword = "Sorry, mistaken passport"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val errorDomain = LoginErrorDomain(wrongPassword)
        val dto = FirebaseDto.Invalid
        val expected = LoginDomain.Fail(errorDomain)

        coEvery { api.signInExistingUser(name, password)} returns dto
        coEvery { dtoMapper.toDomain(dto) } returns expected

        //WHEN
        val result = runBlocking { repository.signInUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN exception, WHEN sign in user, THEN return exception`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val noInternetConnection = "missingFlipFlops"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val noInternetConnectionDomain = LoginErrorDomain(noInternetConnection)
        val expected = LoginDomain.Fail(noInternetConnectionDomain)
        val exception = Exception(noInternetConnectionDomain.value)

        coEvery { api.signInExistingUser(name, password) } throws exception

        //WHEN
        val result = runBlocking { repository.signInUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN valid parameters, WHEN create user , THEN return LoginDomain_Success`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val email = "Mac@Wheels.Pro"
        val userEmailDomain = LoginUserEmailDomain(email)
        val expected = LoginDomain.Success(userEmailDomain)

        val firebaseEmail = "Mac@Wheels.Pro"
        val firebaseEmailDomain = FireBaseUserEmail(firebaseEmail)

        val dto = FirebaseDto.Valid(firebaseEmailDomain)

        coEvery { api.createNewUser(name, password)} returns dto
        coEvery { dtoMapper.toDomain(dto) } returns expected

        //WHEN
        val result = runBlocking { repository.createUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN exception, WHEN create user, THEN return exception`() {
        //GIVEN
        val name = "showTest"
        val password = "sandals"
        val wrongLogin = "Sorry, login is taken new test"
        val nameDomain = LoginNameDomain(name)
        val passwordDomain = LoginPasswordDomain(password)
        val errorDomain = LoginErrorDomain(wrongLogin)
        val expected = LoginDomain.Fail(errorDomain)
        val exception = Exception(errorDomain.value)

        coEvery { api.createNewUser(name, password) } throws exception

        //WHEN
        val result = runBlocking { repository.createUser(nameDomain, passwordDomain) }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN api currentUser is not null, WHEN checkLogInStatus , THEN return LoginDomain_Success`() {
        //GIVEN
        val email = "James@Bond.co.uk"
        val userEmailDomain = LoginUserEmailDomain(email)
        val expected = LoginDomain.Success(userEmailDomain)

        val firebaseEmail = "Sherlock@Holmes.au"
        val firebaseEmailDomain = FireBaseUserEmail(firebaseEmail)

        val dto = FirebaseDto.Valid(firebaseEmailDomain)

        coEvery { api.checkLogInStatus()} returns dto
        coEvery { dtoMapper.toDomain(dto) } returns expected

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
        val dto = FirebaseDto.Invalid
        val expected = LoginDomain.Fail(errorDomain)

        coEvery { api.checkLogInStatus()} returns dto
        coEvery { dtoMapper.toDomain(dto) } returns expected

        //WHEN
        val result = runBlocking { repository.checkLogInStatus() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN exception, WHEN checkLogInStatus , THEN return exception`() {
        //GIVEN
        val wrongLogin = "Wingarium Leviosa"
        val errorDomain = LoginErrorDomain(wrongLogin)
        val expected = LoginDomain.Fail(errorDomain)
        val exception = Exception(errorDomain.value)

        coEvery { api.checkLogInStatus() } throws exception

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