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
    fun `GIVEN interactor check login status success, WHEN on show login status, view disable login buttons`() {
        //GIVEN
        val message = "flipflops"
        val userMail = "HarryPota"
        val userEmailDomain = LoginUserEmailDomain(userMail)
        val expected = LoginDomain.UserEmail(userEmailDomain)

        coEvery { interactor.checkLogInStatus() } returns expected
        every { stringResource.getString(R.string.update_login_success) } returns message

        //WHEN
        presenter.updateLoginStatus()
        //THEN
        verify {
            view.loginStatus(message)
        }
    }

    @Test
    fun `GIVEN interactor check login status fail, WHEN on show login status, view enable login buttons`() {
        //GIVEN
        val error = "flipflops"
        val message = "Hoquartz"
        val errorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(errorDomain)
        coEvery { interactor.checkLogInStatus() } returns expected
        every { stringResource.getString(R.string.update_login_fail) } returns message

        //WHEN
        presenter.updateLoginStatus()
        //THEN
        verify {
            view.loginStatus(message)
        }
    }

    @Test
    fun `GIVEN boolean value true, WHEN disable login buttons, view update login buttons with value`() {
        //GIVEN
        val boolean = true

        //WHEN
        presenter.disableLoginFunction(boolean)
        //THEN
        verify {
            view.updateLoginButtons(boolean)
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