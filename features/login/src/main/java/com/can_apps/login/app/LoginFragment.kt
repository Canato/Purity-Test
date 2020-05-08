package com.can_apps.login.app

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
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
        signInButton.setOnClickListener {
            presenter.onSignClicked(
                loginPasswordEditText.text.toString(),
                loginNameEditText.text.toString()
            )
        }

        createUserButton.setOnClickListener {
            presenter.onCreateLoginClicked(
                loginPasswordEditText.text.toString(),
                loginNameEditText.text.toString()
            )
        }

        logoutButton.setOnClickListener { presenter.logoutUser() }
    }

    override fun close() {
        activity?.finish()
    }

    override fun showLogInStatus(message: String) {
        loginStatus.text = message
    }

    override fun showSuccess() {
        Toast.makeText(activity, getString(R.string.toast_success), Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        view?.let { Snackbar.make(it, error, Snackbar.LENGTH_SHORT).show() }
    }

    override fun disableSignInButton() {
        signInButton.disableLogin()}

    override fun disableCreateUserButton() {
        createUserButton.disableLogin()
    }

    override fun enableSignInButton() {
        signInButton.enableLogin()}

    override fun enableCreateUserButton() {
        createUserButton.enableLogin()
    }

    private fun Button.disableLogin(): Button {
        this.isClickable = false
        this.alpha = 0.3f
        return this
    }

    private fun Button.enableLogin(): Button {
        this.isClickable = true
        this.alpha = 1f
        return this
    }
}