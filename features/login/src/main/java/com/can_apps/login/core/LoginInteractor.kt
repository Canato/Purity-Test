package com.can_apps.login.core

import kotlin.random.Random

internal class LoginInteractor : LoginContract.Interactor {
    override fun checkSubmit() : Boolean {
        return Random.nextBoolean()
    }
}