package com.can_apps.login.bresenter

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryUnconfined
import com.can_apps.login.R
import com.can_apps.login.core.*
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
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

    @MockK
    private lateinit var modelMapper: LoginModelMapper

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
        val authUser = null
        val loginUserEmailDomain = LoginUserEmailDomain(authUser)
        val expected = LoginDomain.Success(loginUserEmailDomain)

        coEvery { interactor.signInUser(loginDomain, passwordDomain) } returns expected

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
        val expected = LoginDomain.Fail(loginErrorDomain)

        coEvery { interactor.signInUser(loginDomain, passwordDomain) } returns expected

        //WHEN
        presenter.onSignClicked(password, loginName)

        //THEN
        verify {
            view.showError(error)
        }
    }

//    @Test
//    fun `GIVEN valid password and invalid loginName, WHEN onSignClicked, THEN show fail`() {
//        //GIVEN
//        val password = "pass"
//        val loginName = "loginName"
//        val message = "MidnightGospel"
//
//        //WHEN
//        presenter.onSignClicked(password, loginName)
//
//        //THEN
//        verify {
//            view.showError(message)
//        }
//        coVerify(exactly = 0) {
//            view.showSuccess()
//        }
//
//    }
//
//    @Test
//    fun `GIVEN invalid password and valid loginName, WHEN onSignClicked, THEN show fail`() {
//        //GIVEN
//        val password = "pass"
//        val loginName = "loginName"
//        val message = "MidnightGospel"
//
//        //WHEN
//        presenter.onSignClicked(password, loginName)
//
//        //THEN
//        verify {
//            view.showError(message)
//        }
//        verify(exactly = 0) {
//            view.showSuccess()
//        }
//    }
//
//    @Test
//    fun `GIVEN invalid parameters, WHEN onSignClicked, THEN show fail`() {
//        //GIVEN
//        val password = "pass"
//        val loginName = "loginName"
//        val message = "MidnightGospel"
//
//        //WHEN
//        presenter.onSignClicked(password, loginName)
//
//        //THEN
//        verify {
//            view.showError(message)
//        }
//        verify(exactly = 0) {
//            view.showSuccess()
//        }
//    }

    @Test
    fun `GIVEN valid parameters, WHEN onCreateUserClicked, THEN show success`() {
        //GIVEN
        val password = "pass"
        val loginName = "loginName"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        val authUser = null
        val loginUserEmailDomain = LoginUserEmailDomain(authUser)
        val expected = LoginDomain.Success(loginUserEmailDomain)

        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns expected

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
        val expected = LoginDomain.Fail(loginErrorDomain)

        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns expected

        //WHEN
        presenter.onCreateLoginClicked(password, loginName)

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN interactor valid, WHEN on login changed, THEN update message error view as null`() {
        //GIVEN
        val login = "Spyro"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Valid(loginNameDomain)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        //WHEN
        presenter.onLoginChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsTrue()
            view.updateLoginTextViewErrorMessage("")
        }
    }

    @Test
    fun `GIVEN interactor fail to short login, WHEN on login changed, THEN update error message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "spy"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.ToSmall
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with empty, WHEN on login changed, THEN update error message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = ""
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.EmptyLogin
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with wrong domain, WHEN on login changed, THEN update error message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "Spyro@a@"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.WrongEmailDomainUsage
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with missing AT sign, WHEN on login changed, THEN update error message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "SpyroAtgmail.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.MissingAtSign
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with wrong characters, WHEN on login changed, THEN update error message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "__++!!!"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.WrongCharacters
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor valid, WHEN on password changed, THEN update error message view as null`() {
        //GIVEN
        val password = "Flame on"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Valid(passwordDomain)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsTrue()
            view.updatePasswordTextViewErrorMessage("")
        }
    }

    @Test
    fun `GIVEN interactor fail to short password, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "Spy"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.ToSmall
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with empty password, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = ""
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.EmptyPassword
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with no digit password, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "aaaaaaAA"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.NoDigit
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with no lower case password, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "EXPLOSIONS123"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.NoLowerCase
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail no upper case password, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "thatslow123"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.NoUpperCase
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail with wrong characters password, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "no@||ow3d"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.WrongCharacters
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor fail, WHEN on password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "Spyro"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.ToSmall
        val expectedError = LoginModel.Fail(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
        }
    }

    @Test
    fun `GIVEN interactor success, WHEN checkLogInStatus, THEN show success`() {
        //GIVEN
        val error = "flipflops"
        val loginErrorDomain = LoginErrorDomain(error)
        val message = "MidnightGospel"

        val authUser = "Mr. A"
        val loginUserEmailDomain = LoginUserEmailDomain(authUser)
        val expected = LoginDomain.Success(loginUserEmailDomain)

        coEvery { interactor.checkLogInStatus() } returns expected
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