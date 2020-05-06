package com.can_apps.login.data

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.login.R
import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginErrorDomain
import com.can_apps.login.core.LoginUserEmailDomain
import com.can_apps.login.data.firebase_data_source.FireBaseUserEmail
import com.can_apps.login.data.firebase_data_source.FirebaseDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class LoginDtoMapperDefaultTest {
    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @InjectMockKs
    private lateinit var dto: LoginDtoMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN firebase_dto_valid, WHEN dto_toDomain, THEN return LoginDomain_Success`() {
        //GIVEN
        val email = "JamesBond"
        val fireBaseUserEmail = FireBaseUserEmail(email)
        val loginUserEmailDomain = LoginUserEmailDomain(email)

        val firebaseDto = FirebaseDto.Valid(fireBaseUserEmail)
        val expected = LoginDomain.Success(loginUserEmailDomain)

        //WHEN
        val result = dto.toDomain(firebaseDto)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN firebase_dto_invalid, WHEN dto_toDomain, THEN return LoginDomain_Fail`() {
        //GIVEN
        val firebaseDto = FirebaseDto.Invalid
        val message = "in the bottle"
        val errorDomain = LoginErrorDomain(message)
        val expected = LoginDomain.Fail(errorDomain)

        coEvery { stringResource.getString(R.string.firebase_dto_error) } returns message

        //WHEN
        val result = dto.toDomain(firebaseDto)

        //THEN
        assertEquals(expected, result)
    }
}