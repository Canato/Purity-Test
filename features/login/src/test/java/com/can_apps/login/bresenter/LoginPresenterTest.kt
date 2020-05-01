package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryUnconfined
import com.can_apps.login.R
import com.can_apps.login.core.*
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class LoginPresenterTest {

    @MockK
    private lateinit var view: LoginContract.View

    @MockK
    private lateinit var interactor: LoginContract.Interactor

    @MockK
    private lateinit var dispatcherFactory: CoroutineDispatcherFactory

    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @InjectMockKs
    private lateinit var presenter: LoginPresenter

    @ExperimentalCoroutinesApi
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
    fun `GIVEN valid parameters, WHEN onSignClicked, THEN show success`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        coEvery { interactor.loginNameValidation(loginDomain) }  returns true
        coEvery { interactor.passwordValidation(passwordDomain) }  returns true
        coEvery { interactor.signInUser(loginDomain, passwordDomain) }  returns LoginDomain.Success

        //WHEN
        presenter.onSignClicked(password, loginName)

        //THEN
        verify {
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN sign in user fail, WHEN onSignClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val error = "flipflops"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val loginErrorDomain = LoginErrorDomain(error)

        coEvery { interactor.loginNameValidation(loginDomain) } returns true
        coEvery { interactor.passwordValidation(passwordDomain) } returns true
        coEvery { interactor.signInUser(loginDomain, passwordDomain) } returns LoginDomain.Fail(loginErrorDomain)

        //WHEN
        presenter.onSignClicked(password, loginName)

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN valid password and invalid loginName, WHEN onSignClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val message = "MidnightGospel"

        coEvery { interactor.loginNameValidation(loginDomain) } returns false
        coEvery { interactor.passwordValidation(passwordDomain) } returns true
        every { stringResource.getString(R.string.login_error_message) } returns message

        //WHEN
        presenter.onSignClicked(password, loginName)

        //THEN
        verify {
            view.showError(message)
        }
        coVerify(exactly = 0) {
            interactor.signInUser(loginDomain, passwordDomain)
            view.showSuccess()
        }

    }

    @Test
    fun `GIVEN invalid password and valid loginName, WHEN onSignClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val message = "MidnightGospel"

        coEvery { interactor.loginNameValidation(loginDomain) } returns true
        coEvery { interactor.passwordValidation(passwordDomain) } returns false
        every { stringResource.getString(R.string.login_error_message) } returns message

        //WHEN
        presenter.onSignClicked(password, loginName)

        //THEN
        verify {
            view.showError(message)
        }
        verify(exactly = 0) {
            runBlocking { interactor.signInUser(loginDomain, passwordDomain) }
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN invalid parameters, WHEN onSignClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val message = "MidnightGospel"

        coEvery { interactor.loginNameValidation(loginDomain) } returns false
        coEvery { interactor.passwordValidation(passwordDomain) } returns false
        every { stringResource.getString(R.string.login_error_message) } returns message

        //WHEN
        presenter.onSignClicked(password, loginName)

        //THEN
        verify {
            view.showError(message)
        }
        verify(exactly = 0) {
            runBlocking { interactor.signInUser(loginDomain, passwordDomain) }
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN valid parameters, WHEN onCreateUserClicked, THEN show success`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        coEvery { interactor.loginNameValidation(loginDomain) } returns true
        coEvery { interactor.passwordValidation(passwordDomain) } returns true
        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns LoginDomain.Success

        //WHEN
        presenter.onCreateLoginClicked(password, loginName)

        //THEN
        verify {
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN create user fail, WHEN onCreateUserClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val error = "flipflops"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val loginErrorDomain = LoginErrorDomain(error)

        coEvery { interactor.loginNameValidation(loginDomain) } returns true
        coEvery { interactor.passwordValidation(passwordDomain) } returns true
        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns LoginDomain.Fail(loginErrorDomain)

        //WHEN
        presenter.onCreateLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN valid password and invalid loginName, WHEN onCreateUserClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val message = "MidnightGospel"

        coEvery { interactor.loginNameValidation(loginDomain) } returns false
        coEvery { interactor.passwordValidation(passwordDomain) } returns true
        every { stringResource.getString(R.string.login_error_message) } returns message

        //WHEN
        presenter.onCreateLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(message)
        }
        verify(exactly = 0) {
            runBlocking { interactor.createUser(loginDomain, passwordDomain) }
            view.showSuccess()
        }

    }

    @Test
    fun `GIVEN invalid password and valid loginName, WHEN onCreateUserClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val message = "MidnightGospel"

        every { runBlocking { interactor.loginNameValidation(loginDomain) } } returns true
        every { runBlocking { interactor.passwordValidation(passwordDomain) } } returns false
        every { stringResource.getString(R.string.login_error_message) } returns message

        //WHEN
        presenter.onCreateLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(message)
        }
        verify(exactly = 0) {
            runBlocking { interactor.createUser(loginDomain, passwordDomain) }
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN invalid parameters, WHEN onCreateUserClicked, THEN show fail`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val message = "MidnightGospel"

        coEvery { interactor.loginNameValidation(loginDomain) } returns false
        coEvery { interactor.passwordValidation(passwordDomain) } returns false
        every { stringResource.getString(R.string.login_error_message) } returns message

        //WHEN
        presenter.onCreateLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(message)
        }
        verify(exactly = 0) {
            runBlocking { interactor.createUser(loginDomain, passwordDomain) }
            view.showSuccess()
        }
    }

    @Test
    fun `GIVEN interactor success, WHEN checkLogInStatus, THEN show success`() {
        //GIVEN
        val error = "flipflops"
        val loginErrorDomain = LoginErrorDomain(error)
        val message = "MidnightGospel"

        coEvery { interactor.checkLogInStatus() } returns LoginDomain.Success
        every { stringResource.getString(R.string.sign_in_true) } returns message

        //WHEN
        presenter.checkLogIn()

        //THEN
        verify {
            view.showLogInStatus(message)
        }

        verify(exactly = 0) {
            view.showLogInStatus(loginErrorDomain.value)
        }
    }

    @Test
    fun `GIVEN interactor fail, WHEN checkLogInStatus, THEN show fail`() {
        //GIVEN
        val message = "sandals"
        val error = "flipflops"
        val loginErrorDomain = LoginErrorDomain(error)
        coEvery { interactor.checkLogInStatus() } returns LoginDomain.Fail(loginErrorDomain)
        every { stringResource.getString(R.string.sign_in_true) } returns message

        //WHEN
        presenter.checkLogIn()

        //THEN
        verify {
            view.showLogInStatus(error)
        }
        verify(exactly = 0) {
            view.showLogInStatus(message)
        }
    }

    @Test
    fun `GIVEN a view, WHEN on logoutUser pressed, THEN perform logout user`() {
        //GIVEN

        //WHEN
        presenter.logoutUser()
        //THEN
        verify {
            runBlocking { interactor.logoutUser() }
        }
    }
}