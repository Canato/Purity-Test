package com.can_apps.login.data

import com.google.firebase.auth.FirebaseAuth

internal interface LoginFirebaseApi {

    fun createNewUser(login: String, password: String): Boolean
    fun loginExistingUser(login: String, password: String): Boolean
}

internal class LoginFirebaseApiDefault (private val auth: FirebaseAuth): LoginFirebaseApi {

    override fun createNewUser(login: String, password: String): Boolean {
        var result = false

        auth.createUserWithEmailAndPassword(login, password)
            .addOnCompleteListener { task ->
                result = task.isSuccessful
            }
        return result
    }

    override fun loginExistingUser(login: String, password: String): Boolean =
        auth.signInWithEmailAndPassword(login, password).isSuccessful

}