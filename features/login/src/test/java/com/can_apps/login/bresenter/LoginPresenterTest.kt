package com.can_apps.login.bresenter

import android.content.Context
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryUnconfined
import com.can_apps.login.core.*
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

internal class LoginPresenterTest {


    @MockK
    private lateinit var context: Context

    @MockK
    private lateinit var interactor: LoginContract.Interactor

    @MockK
    private lateinit var view: LoginContract.View

    @MockK
    private lateinit var dispatcherFactory: CoroutineDispatcherFactory

    @InjectMockKs
    private lateinit var presenter: LoginPresenter

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)

        val unconfinedFactory = CoroutineDispatcherFactoryUnconfined()
        every { dispatcherFactory.IO } returns unconfinedFactory.IO
        every { dispatcherFactory.UI } returns unconfinedFactory.UI

        presenter.bind(view)
    }

    @Test
    fun `GIVEN a view, WHEN on create view, THEN show welcome message`() {
        //GIVEN

        //WHEN
        presenter.onViewCreated()
        //THEN
        verify {
            view.showWelcomeMessage()
        }

    }

    @Test
    fun `GIVEN a view, WHEN on back pressed, THEN view close`() {
        //GIVEN

        //WHEN
        presenter.onBackPressed()
        //THEN
        verify {
            view.close()
        }
    }

    @Test
    fun `GIVEN valid password and loginName, WHEN onLoginClicked, THEN show success`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        every { interactor.loginNameValidation(loginDomain) } returns true
        every { interactor.passwordValidation(passwordDomain) } returns true
        every { interactor.loginUser(loginDomain, passwordDomain) } returns LoginDomain.Success

        //WHEN
        presenter.onLoginClicked(password, loginName)

        //THEN
        verify {
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN loginUser fail, WHEN onLoginClicked, THEN show fail`() {
        //GIVEN

        val password = "pass"
        val loginName = "loginName"
        val error = "flipflops"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val loginErrorDomain = LoginErrorDomain(error)

        every { interactor.loginNameValidation(loginDomain) } returns true
        every { interactor.passwordValidation(passwordDomain) } returns true
        every { interactor.loginUser(loginDomain, passwordDomain) } returns LoginDomain.Fail(
            loginErrorDomain
        )

        //WHEN
        presenter.onLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN valid password and invalid loginName, WHEN onLoginClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        every { interactor.loginNameValidation(loginDomain) } returns false
        every { interactor.passwordValidation(passwordDomain) } returns true

        //WHEN
        presenter.onLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(any())
        }
        verify(exactly = 0) {
            interactor.loginUser(loginDomain, passwordDomain)
            view.showSuccess()
        }

    }

    @Test
    fun `GIVEN invalid password and valid loginName, WHEN onLoginClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        every { interactor.loginNameValidation(loginDomain) } returns true
        every { interactor.passwordValidation(passwordDomain) } returns false

        //WHEN
        presenter.onLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(any())
        }
        verify(exactly = 0) {
            interactor.loginUser(loginDomain, passwordDomain)
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN invalid password and loginName, WHEN onLoginClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        every { interactor.loginNameValidation(loginDomain) } returns false
        every { interactor.passwordValidation(passwordDomain) } returns false

        //WHEN
        presenter.onLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(any())
        }
        verify(exactly = 0) {
            interactor.loginUser(loginDomain, passwordDomain)
            view.showSuccess()
        }
    }
}