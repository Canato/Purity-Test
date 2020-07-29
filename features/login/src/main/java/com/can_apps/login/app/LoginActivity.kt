package com.can_apps.login.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.can_apps.login.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_login, LoginFragment()).commit()
    }
}
