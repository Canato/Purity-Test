package com.can_apps.purity_test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.can_apps.login.app.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.visibility = View.VISIBLE

        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main, LoginFragment.newInstance()).addToBackStack(null)
                .commit()
        }
    }
}
