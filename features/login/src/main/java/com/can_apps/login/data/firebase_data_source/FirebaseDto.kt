package com.can_apps.login.data.firebase_data_source

sealed class FirebaseDto {

    object Invalid: FirebaseDto()

    data class Valid(val userEmail: FireBaseUserEmail?): FirebaseDto()
}

inline class FireBaseUserEmail(val value: String?)