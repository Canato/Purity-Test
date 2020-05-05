package com.can_apps.login.data.firebase_data_source

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

internal interface FirebaseApi {

    suspend fun signInExistingUser(login: String, password: String): FirebaseDto

    suspend fun createNewUser(login: String, password: String): FirebaseDto

    suspend fun logoutUser()

    suspend fun checkLogInStatus(): FirebaseDto
}

internal class FirebaseApiDefault(private val auth: FirebaseAuth) : FirebaseApi {

    override suspend fun signInExistingUser(login: String, password: String): FirebaseDto =
        when (auth.signInWithEmailAndPassword(login, password).await().user) {
            null -> FirebaseDto.Invalid
            else -> FirebaseDto.Valid(FireBaseUserEmail(null))
        }

    override suspend fun createNewUser(login: String, password: String): FirebaseDto =
        when (auth.createUserWithEmailAndPassword(login, password).await().user) {
            null -> FirebaseDto.Invalid
            else -> FirebaseDto.Valid(FireBaseUserEmail(null))
        }

    override suspend fun checkLogInStatus(): FirebaseDto =
        when (val result = auth.currentUser?.email) {
            null -> FirebaseDto.Invalid
            else -> FirebaseDto.Valid(FireBaseUserEmail(result))
        }

    override suspend fun logoutUser() = auth.signOut()
}