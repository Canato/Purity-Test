package com.can_apps.login.data

import com.can_apps.login.core.LoginDomain
import com.can_apps.login.core.LoginErrorDomain
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

internal interface LoginFirebaseApi {

    suspend fun createNewUser(login: String, password: String): Boolean
    suspend fun signInExistingUser(login: String, password: String): Boolean
    suspend fun logoutUser()
    suspend fun checkLogInStatus(): LoginDomain
}

internal class LoginFirebaseApiDefault(private val auth: FirebaseAuth) : LoginFirebaseApi {

    override suspend fun createNewUser(login: String, password: String): Boolean {
        return auth.createUserWithEmailAndPassword(login, password).await().user == null
    }

    override suspend fun signInExistingUser(login: String, password: String): Boolean {
        return auth.signInWithEmailAndPassword(login, password).await().user == null
    }

    override suspend fun checkLogInStatus(): LoginDomain {
        return if (auth.currentUser != null)
            LoginDomain.Success
        else LoginDomain.Fail(LoginErrorDomain("No user currently signed in"))
    }

    override suspend fun logoutUser() = auth.signOut()


}