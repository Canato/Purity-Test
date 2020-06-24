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
    fun `WHEN on create view, THEN show welcome message`() {
        //WHEN
        presenter.onViewCreated()
        //THEN
        verify {
            view.disableCreateUserButton()
            view.disableSignInButton()
            view.showWelcomeMessage()
        }
    }

    @Test
    fun `WHEN on back pressed, THEN view close`() {
        //WHEN
        presenter.onBackPressed()
        //THEN
        verify {
            view.close()
        }
    }

    @Test
    fun `GIVEN valid name and valid password, WHEN values change, THEN enable buttons`() {
        //GIVEN
        val loginName = "Heyhoy"
        val password = "Tomboy"
        val loginNameDomain = LoginNameDomain(loginName)
        val loginPasswordDomain = LoginPasswordDomain(password)
        val loginNameValidationDomain = LoginNameValidationDomain.Valid
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Valid

        every { interactor.loginNameValidation(loginNameDomain) } returns loginNameValidationDomain
        every { interactor.passwordValidation(loginPasswordDomain)} returns loginPasswordValidationDomain

        //WHEN
        presenter.onLoginInputChanged(loginName)
        presenter.onPasswordInputChanged(password)

        //THEN
        verify(exactly = 1) {
            view.disableCreateUserButton()
            view.disableSignInButton()
            view.updateLoginTextViewErrorMessage(null)
            view.updatePasswordTextViewErrorMessage(null)
            view.setLoginCheckBoxAsTrue()
            view.setPasswordCheckBoxAsTrue()
            view.enableCreateUserButton()
            view.enableSignInButton()
        }
    }

    @Test
    fun `GIVEN valid name and invalid password, WHEN values change, THEN disable buttons`() {
        //GIVEN
        val loginName = "Heyhoy"
        val password = "Tomboy"
        val loginNameDomain = LoginNameDomain(loginName)
        val loginPasswordDomain = LoginPasswordDomain(password)
        val loginNameValidationDomain = LoginNameValidationDomain.Valid
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.ToSmall)

        every { interactor.loginNameValidation(loginNameDomain) } returns loginNameValidationDomain
        every { interactor.passwordValidation(loginPasswordDomain)} returns loginPasswordValidationDomain

        //WHEN
        presenter.onLoginInputChanged(loginName)
        presenter.onPasswordInputChanged(password)

        //THEN
        verify(exactly = 2) {
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
        verify(exactly = 1) {
            view.updateLoginTextViewErrorMessage(null)
            view.setLoginCheckBoxAsTrue()
        }
    }

    @Test
    fun `GIVEN invalid name and valid password, WHEN values change, THEN disable buttons`() {
        //GIVEN
        val loginName = "Heyhoy"
        val password = "Tomboy"
        val loginNameDomain = LoginNameDomain(loginName)
        val loginPasswordDomain = LoginPasswordDomain(password)
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.TooLongDomain)
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Valid

        every { interactor.loginNameValidation(loginNameDomain) } returns loginNameValidationDomain
        every { interactor.passwordValidation(loginPasswordDomain)} returns loginPasswordValidationDomain

        //WHEN
        presenter.onLoginInputChanged(loginName)
        presenter.onPasswordInputChanged(password)

        //THEN
        verify(exactly = 2) {
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
        verify(exactly = 1) {
            view.updatePasswordTextViewErrorMessage(null)
            view.setPasswordCheckBoxAsTrue()
        }
    }

    @Test
    fun `GIVEN invalid name and invalid password, WHEN values change, THEN disable buttons`() {
        //GIVEN
        val loginName = "Heyhoy"
        val password = "Tomboy"
        val loginNameDomain = LoginNameDomain(loginName)
        val loginPasswordDomain = LoginPasswordDomain(password)
        val loginNameValidationDomain = LoginNameValidationDomain.Invalid(LoginValidationError.WrongCharacters)
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.ToSmall)

        every { interactor.loginNameValidation(loginNameDomain) } returns loginNameValidationDomain
        every { interactor.passwordValidation(loginPasswordDomain)} returns loginPasswordValidationDomain

        //WHEN
        presenter.onLoginInputChanged(loginName)
        presenter.onPasswordInputChanged(password)

        //THEN
        verify(exactly = 2) {
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN EmptyLogin name, WHEN name changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = ""
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Invalid(LoginValidationError.EmptyLogin)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN ToSmall name, WHEN name changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "abc"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Invalid(LoginValidationError.ToSmall)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN MissingAtSign name, WHEN name changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "SpyroAtgmail.com"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Invalid(LoginValidationError.MissingAtSign)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN WrongEmailDomainUsage name, WHEN name changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "Spyro@a@"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Invalid(LoginValidationError.WrongEmailDomainUsage)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN TooLongDomain name, WHEN name changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "Spyro@as.com.uk.pl.br.toolong"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Invalid(LoginValidationError.TooLongDomain)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN WrongCharacters name, WHEN name changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val login = "__++!!!"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Invalid(LoginValidationError.WrongCharacters)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { modelMapper.loginErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN empty password, WHEN password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = ""
        val passwordDomain = LoginPasswordDomain(password)
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.EmptyPassword)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns loginPasswordValidationDomain
        coEvery { modelMapper.passwordErrorToModel(loginPasswordValidationDomain) } returns expectedError

        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN ToSmall password, WHEN password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "Spy"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Invalid(PasswordValidationError.ToSmall)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN NoLowerCase password, WHEN password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "EXPLOSIONS123"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoLowerCase)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN NoUpperCase password, WHEN password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "thatslow123"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoUpperCase)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN NoDigit password, WHEN password changed, THEN update message view with error`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "aaaaaaAA"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Invalid(PasswordValidationError.NoDigit)
        val expectedError = LoginModel.Error(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        coEvery { modelMapper.passwordErrorToModel(expected) } returns expectedError

        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError)
        }
    }

    @Test
    fun `GIVEN wrong character, WHEN password changed, THEN update message view with error AND checkbox false`() {
        //GIVEN
        val error = "what?"
        val errorModel = LoginErrorModel(error)
        val password = "abc"
        val passwordDomain = LoginPasswordDomain(password)
        val loginPasswordValidationDomain = LoginPasswordValidationDomain.Invalid(PasswordValidationError.WrongCharacters)
        val errorMessage = LoginModel.Error(errorModel)

        coEvery { interactor.passwordValidation(passwordDomain) } returns loginPasswordValidationDomain
        coEvery { modelMapper.passwordErrorToModel(loginPasswordValidationDomain) } returns errorMessage

        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(errorMessage)
        }
    }

    @Test
    fun `GIVEN Success, WHEN onSignClicked, THEN show success AND clear both text inputs`() {
        //GIVEN
        val domain = LoginDomain.Success
        val loginName = "Mehmet"
        val password = "invitation"

        coEvery {
            interactor.signInUser(LoginNameDomain(loginName), LoginPasswordDomain(password))
        } returns domain

        //WHEN
        presenter.onSignClicked(loginName, password)

        //THEN
        verify {
            view.showSuccess()
            view.cleanLoginTextView()
            view.cleanPasswordTextView()
        }
    }

    @Test
    fun `GIVEN fail, WHEN onSignClicked, THEN show fail`() {
        //GIVEN
        val password = "accessPoint"
        val loginName = "monarch"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val error = "flipflops"
        val loginErrorDomain = LoginErrorDomain(error)
        val domain = LoginDomain.Fail(loginErrorDomain)

        coEvery { interactor.signInUser(loginDomain, passwordDomain) } returns domain

        //WHEN
        presenter.onSignClicked(loginName, password)

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN success, WHEN onCreateUserClicked, THEN show success AND clear both text inputs`() {
        //GIVEN
        val password = "accessPoint"
        val loginName = "monarch"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        val domain = LoginDomain.Success

        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns domain

        //WHEN
        presenter.onCreateLoginClicked(loginName, password)

        //THEN
        verify {
            view.showSuccess()
            view.cleanLoginTextView()
            view.cleanPasswordTextView()
        }
    }

    @Test
    fun `GIVEN fail, WHEN onCreateUserClicked, THEN show fail`() {
        //GIVEN
        val password = "accessPoint"
        val loginName = "monarch"
        val error = "flipflops"

        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val loginErrorDomain = LoginErrorDomain(error)
        val domain = LoginDomain.Fail(loginErrorDomain)

        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns domain

        //WHEN
        presenter.onCreateLoginClicked(loginName, password)

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN interactor success, WHEN checkLogInStatus, THEN show success`() {
        //GIVEN
        val error = "flipflops"
        val loginErrorDomain = LoginErrorDomain(error)
        val message = "MidnightGospel"
        val expected = LoginDomain.Success

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