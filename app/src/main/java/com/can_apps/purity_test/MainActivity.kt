package com.can_apps.purity_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_main,
                com.can_apps.login.app.LoginFragment.newInstance())
            .addToBackStack(null)
            .commit()
        }
    }
}
