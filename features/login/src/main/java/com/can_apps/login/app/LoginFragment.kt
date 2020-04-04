package com.can_apps.login.app

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.can_apps.login.R
import com.can_apps.login.core.LoginContract
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment :
    Fragment(R.layout.fragment_login),
    LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    companion object {
        fun newInstance(): Fragment = LoginFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val serviceLocator = LoginServiceLocator(context)
        presenter = serviceLocator.getPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.bind(this)
        presenter.onViewCreated()
        loginSubmitButton.setOnClickListener { presenter.onSubmitPressed() }

    }

    override fun welcome() {
        Toast.makeText(activity, "Welcome !", Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        activity?.finish()
    }

    override fun onPositive(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()

    }

    override fun onNegative(message: String) {

        view?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }
    }
}