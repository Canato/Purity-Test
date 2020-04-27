package com.can_apps.login.data

import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginErrorDomain
import com.can_apps.login.data.firebase_data_source.FirebaseDto

//todo tomasz crate test for this
internal interface LoginDtoMapper {

    fun toDomain(dto: FirebaseDto): LoginDomain
}

internal class LoginDtoMapperDefault(
    stringResource //tomasz use this to get the string
) : LoginDtoMapper {

    override fun toDomain(dto: FirebaseDto): LoginDomain =
        when(dto) {
            FirebaseDto.Invalid -> LoginDomain.Fail(LoginErrorDomain("Sorry, something wrong"))
            FirebaseDto.Valid -> LoginDomain.Success
        }
}