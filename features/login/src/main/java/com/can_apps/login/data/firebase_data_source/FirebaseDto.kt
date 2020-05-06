package com.can_apps.login.data.firebase_data_source

import androidx.annotation.Nullable

sealed class FirebaseDto {

    data class Valid(@Nullable val userEmail: FireBaseUserEmail): FirebaseDto()

    object Invalid: FirebaseDto()
}

inline class FireBaseUserEmail(val value: String?)