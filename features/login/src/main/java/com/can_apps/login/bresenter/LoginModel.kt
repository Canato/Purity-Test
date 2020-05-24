package com.can_apps.login.bresenter

 sealed class LoginModel {
    data class Name(val loginName: LoginModelName?) : LoginModel()
    data class Password(val password: LoginModelPassword?) : LoginModel()
    data class Error(val message: LoginErrorModel) : LoginModel()
}

 inline class LoginErrorModel(val value: String)
 inline class LoginModelName(val value: String)
 inline class LoginModelPassword(val value: String)