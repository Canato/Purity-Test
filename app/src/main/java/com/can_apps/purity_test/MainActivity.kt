package com.can_apps.purity_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.can_apps.login.app.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.visibility = View.VISIBLE

        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main, LoginFragment.newInstance()).addToBackStack(null).commit()
//            fab.visibility = View.INVISIBLE
        }
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
