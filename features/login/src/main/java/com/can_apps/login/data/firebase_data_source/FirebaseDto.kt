package com.can_apps.login.data.firebase_data_source

import androidx.annotation.Nullable

sealed class FirebaseDto {

    object Invalid: FirebaseDto()

    data class Valid(@Nullable val userEmail: FireBaseUserEmail): FirebaseDto()
}

inline class FireBaseUserEmail(val value: String?)