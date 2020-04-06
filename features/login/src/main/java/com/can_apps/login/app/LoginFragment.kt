package com.can_apps.login.app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.can_apps.login.R
import com.can_apps.login.core.LoginContract

internal class LoginFragment :
    Fragment(R.layout.fragment_login),
    LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    companion object {
        fun newInstance(): Fragment = LoginFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        TODO presenterLocator
//        presenter.bind(this)
//        presenter.onViewCreated()

    }

    override fun showWelcomeMessage() {
        Toast.makeText(activity, "Welcome !", Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        activity?.finish()
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess() {
        TODO("Not yet implemented")
    }
}