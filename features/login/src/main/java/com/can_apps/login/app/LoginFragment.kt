package com.can_apps.login.app

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
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


        loginNameEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.onLoginChanged(loginNameEditText.text.toString())

            }
        })

        loginPasswordEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.onPasswordChanged(loginPasswordEditText.text.toString())
            }

        })

        logoutButton.setOnClickListener { presenter.logoutUser() }

        checkLogInButton.setOnClickListener { presenter.checkLogIn() }
    }

    override fun showWelcomeMessage() {
        Toast.makeText(activity, getString(R.string.welcome), Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        activity?.finish()
    }

    override fun showError(error: String) {
        view?.let { Snackbar.make(it, error, Snackbar.LENGTH_SHORT).show() }
    }

    override fun showLogInStatus(message: String) {
        view?.let { Snackbar.make(it, message, Snackbar.LENGTH_LONG).show() }
    }

    override fun showSuccess() {
        Toast.makeText(activity, getString(R.string.toast_success), Toast.LENGTH_SHORT).show()
    }

    override fun checkLoginBox() {
        loginCheckBox.isChecked = true
    }

    override fun unCheckLoginBox() {
        loginCheckBox.isChecked = false
    }

    override fun checkPasswordBox() {
        passwordCheckBox.isChecked = true
    }
    override fun unCheckPasswordBox() {
        passwordCheckBox.isChecked = false
    }

    override fun updateLoginViewMessage(message: String) {
        loginNameInputLayout.error = message
    }

    override fun updatePasswordViewMessage(message: String) {
        loginPassworInputLayout.error = message
    }

}