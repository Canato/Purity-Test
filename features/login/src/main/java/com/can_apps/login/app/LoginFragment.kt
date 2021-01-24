package com.can_apps.login.app

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.can_apps.login.R
import com.can_apps.login.bresenter.LoginModel
import com.can_apps.login.core.LoginContract
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

internal class LoginFragment :
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
                loginNameEditText.text.toString(),
                loginPasswordEditText.text.toString()
            )
        }

        createUserButton.setOnClickListener {
            presenter.onCreateLoginClicked(
                loginNameEditText.text.toString(),
                loginPasswordEditText.text.toString()
            )
        }

        loginNameEditText.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    presenter.onLoginInputChanged(loginNameEditText.text.toString())
                }
            }
        )

        loginPasswordEditText.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    presenter.onPasswordInputChanged(loginPasswordEditText.text.toString())
                }
            }
        )

        logoutButton.setOnClickListener { presenter.logoutUser() }

        checkLogInButton.setOnClickListener { presenter.checkLogIn() }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, true) { findNavController().navigateUp() }
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

    override fun setLoginCheckBoxAsTrue() {
        loginCheckBox.isChecked = true
    }

    override fun setLoginCheckBoxAsFalse() {
        loginCheckBox.isChecked = false
    }

    override fun setPasswordCheckBoxAsTrue() {
        passwordCheckBox.isChecked = true
    }

    override fun setPasswordCheckBoxAsFalse() {
        passwordCheckBox.isChecked = false
    }

    override fun updateLoginTextViewErrorMessage(message: LoginModel.Error?) {
        loginNameInputLayout.error = message?.message?.value
    }

    override fun updatePasswordTextViewErrorMessage(message: LoginModel.Error?) {
        loginPassworInputLayout.error = message?.message?.value
    }

    override fun disableSignInButton() {
        signInButton.disableLogin()
    }

    override fun disableCreateUserButton() {
        createUserButton.disableLogin()
    }

    override fun enableSignInButton() {
        signInButton.enableLogin()
    }

    override fun enableCreateUserButton() {
        createUserButton.enableLogin()
    }

    override fun cleanLoginTextView() {
        loginNameEditText.text = null
    }

    override fun cleanPasswordTextView() {
        loginPasswordEditText.text = null
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
