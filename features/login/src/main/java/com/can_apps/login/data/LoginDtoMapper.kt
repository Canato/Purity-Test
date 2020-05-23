package com.can_apps.login.data

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.login.R
import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginErrorDomain
import com.can_apps.login.data.firebase_data_source.FirebaseDto

internal interface LoginDtoMapper {

    fun toDomain(dto: FirebaseDto): LoginDomain
}

internal class LoginDtoMapperDefault(
    private val stringResource: CommonStringResourceWrapper
) : LoginDtoMapper {

    override fun toDomain(dto: FirebaseDto): LoginDomain =
        when(dto) {
            FirebaseDto.Invalid -> LoginDomain.Fail(LoginErrorDomain(stringResource.getString(R.string.firebase_dto_error)))
         is FirebaseDto.Valid -> LoginDomain.Success
        }
}