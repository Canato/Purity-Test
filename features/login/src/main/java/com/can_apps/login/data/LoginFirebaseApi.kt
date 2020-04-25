package com.can_apps.login.data

import com.google.firebase.auth.FirebaseAuth

internal interface LoginFirebaseApi {

    suspend fun createNewUser(login: String, password: String): Boolean
    suspend fun loginExistingUser(login: String, password: String): Boolean
    fun logoutUser()
}

internal class LoginFirebaseApiDefault(private val auth: FirebaseAuth) : LoginFirebaseApi {

    override suspend fun createNewUser(login: String, password: String): Boolean =
        auth.createUserWithEmailAndPassword(login, password).isSuccessful


    override suspend fun loginExistingUser(login: String, password: String): Boolean =
        auth.signInWithEmailAndPassword(login, password).isSuccessful

    override fun logoutUser() {
        auth.signOut()
    }

}