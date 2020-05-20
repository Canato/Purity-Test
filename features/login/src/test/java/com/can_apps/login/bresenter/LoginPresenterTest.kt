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
    private lateinit var loginPasswordModel: LoginModel.Password

    @MockK
    private lateinit var loginNameModel: LoginModel.Name

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
    fun `GIVEN a view, WHEN on create view, THEN disable buttons`() {
        //GIVEN

        //WHEN
        presenter.onViewCreated()
        //THEN
        verify {
            view.disableCreateUserButton()
            view.disableSignInButton()
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
    fun `GIVEN login name valid and invalid password, WHEN fetched login input, THEN update login message error view as null AND set login check box as true AND disable buttons`() {
        //GIVEN
        val login = "Spyro"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Valid(loginNameDomain)

        val loginValid = true
        val passwordValid = false

        val loginModel = LoginModelName(login)
        val expectedModel = LoginModel.Name(loginModel)

        coEvery { modelMapper.loginToModel(expected) } returns expectedModel
        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected
        coEvery { interactor.checkFunction(loginValid, passwordValid) } returns false
        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsTrue()
            view.updateLoginTextViewErrorMessage("")
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN login name valid and valid password, WHEN fetched login input, THEN update login message error view as null AND set login check box as true AND enable buttons`() {
        //GIVEN
        val login = "Spyro"
        val loginNameDomain = LoginNameDomain(login)
        val expected = LoginNameValidationDomain.Valid(loginNameDomain)

        val loginValid = true
        val pass = false

        val loginModel = LoginModelName(login)
        val expectedModel = LoginModel.Name(loginModel)

        coEvery { interactor.checkFunction(loginValid, pass) } returns true
        coEvery { modelMapper.loginToModel(expected) } returns expectedModel
        coEvery { interactor.loginNameValidation(loginNameDomain) } returns expected

        //WHEN
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsTrue()
            view.updateLoginTextViewErrorMessage("")
            view.enableCreateUserButton()
            view.enableSignInButton()
        }
    }

    @Test
    fun `GIVEN login validation fail with too short login, WHEN on login changed, THEN update error message view with error AND set login check box as false AND disable buttons`() {
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
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN login validation fail with empty login, WHEN on login changed, THEN update error message view with error AND set login check box as false AND disable buttons`() {
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
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN login validation fail with wrong domain, WHEN on login changed, THEN update error message view with error AND set login check box as false AND disable buttons`() {
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
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN login validation fail with missing AT sign, WHEN on login changed, TTHEN update error message view with error AND set login check box as false AND disable buttons`() {
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
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN login validation fail with wrong input characters, WHEN on login changed, THEN update error message view with error AND set login check box as false AND disable buttons`() {
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
        presenter.onLoginInputChanged(login)

        //THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN valid password and invalid login name, WHEN fetched password input, THEN update error message view as null AND set login check box as true AND disable buttons `() {
        //GIVEN
        val password = "Flame on"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Valid(passwordDomain)

        val loginValid = false
        val passwordValid = true

        val passwordModel = LoginModelPassword(password)
        val expectedModel = LoginModel.Password(passwordModel)

        coEvery { interactor.checkFunction(loginValid, passwordValid) } returns false
        coEvery { modelMapper.passwordToModel(expected) } returns expectedModel
        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsTrue()
            view.updatePasswordTextViewErrorMessage("")
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN valid password and valid login name, WHEN fetched password input, THEN update error message view as null AND set login check box as true AND enable buttons `() {
        //GIVEN
        val password = "Flame on"
        val passwordDomain = LoginPasswordDomain(password)
        val expected = LoginPasswordValidationDomain.Valid(passwordDomain)

        val loginValid = false
        val passwordValid = true

        val passwordModel = LoginModelPassword(password)
        val expectedModel = LoginModel.Password(passwordModel)

        coEvery { interactor.checkFunction(loginValid, passwordValid) } returns true
        coEvery { modelMapper.passwordToModel(expected) } returns expectedModel
        coEvery { interactor.passwordValidation(passwordDomain) } returns expected
        //WHEN
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsTrue()
            view.updatePasswordTextViewErrorMessage("")
            view.enableCreateUserButton()
            view.enableSignInButton()
        }
    }

    @Test
    fun `GIVEN password validation fail with to short password, WHEN fetched password input, THEN update message view with error`() {
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
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN password validation fail with empty password, WHEN fetched password input, THEN update message view with error`() {
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
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN password validation fail with no digit password, WHEN fetched password input, THEN update message view with error`() {
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
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN password validation fail with with no lower case password, WHEN fetched password input, THEN update message view with error`() {
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
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN password validation fail with no upper case password, WHEN fetched password input, THEN update message view with error`() {
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
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN password validation fail with with wrong characters password, WHEN fetched password input, THEN update message view with error`() {
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
        presenter.onPasswordInputChanged(password)

        //THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(expectedError.error.value)
            view.disableCreateUserButton()
            view.disableSignInButton()
        }
    }

    @Test
    fun `GIVEN valid parameters, WHEN onSignClicked, THEN show success AND clear both text inputs`() {
        //GIVEN

        val password = loginPasswordModel.password.value
        val loginName = loginNameModel.loginName.value
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val authUser = "any other string"
        val loginUserEmailDomain = LoginUserEmailDomain(authUser)
        val expected = LoginDomain.Success(loginUserEmailDomain)

        coEvery { interactor.signInUser(loginDomain, passwordDomain) } returns expected

        //WHEN
        presenter.onSignClicked()

        //THEN
        verify {
            view.showSuccess()
            view.cleanLoginTextView()
            view.cleanPasswordTextView()
        }
    }

    @Test
    fun `GIVEN sign in user fail, WHEN onSignClicked, THEN show fail`() {
        //GIVEN
        val password = loginPasswordModel.password.value
        val loginName = loginNameModel.loginName.value
        val error = "flipflops"
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val loginErrorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(loginErrorDomain)

        coEvery { interactor.signInUser(loginDomain, passwordDomain) } returns expected
        //WHEN
        presenter.onSignClicked()

        //THEN
        verify {
            view.showError(error)
        }
    }

    @Test
    fun `GIVEN valid parameters, WHEN onCreateUserClicked, THEN show success AND clear both text inputs`() {
        //GIVEN
        val password = loginPasswordModel.password.value
        val loginName = loginNameModel.loginName.value
        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)

        val authUser = "any other user"
        val loginUserEmailDomain = LoginUserEmailDomain(authUser)
        val expected = LoginDomain.Success(loginUserEmailDomain)

        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns expected

        //WHEN
        presenter.onCreateLoginClicked()

        //THEN
        verify {
            view.showSuccess()
            view.cleanLoginTextView()
            view.cleanPasswordTextView()
        }
    }

    @Test
    fun `GIVEN create user fail, WHEN onCreateUserClicked, THEN show fail`() {
        //GIVEN
        val password = loginPasswordModel.password.value
        val loginName = loginNameModel.loginName.value
        val error = "flipflops"

        val passwordDomain = LoginPasswordDomain(password)
        val loginDomain = LoginNameDomain(loginName)
        val loginErrorDomain = LoginErrorDomain(error)
        val expected = LoginDomain.Fail(loginErrorDomain)

        coEvery { interactor.createUser(loginDomain, passwordDomain) } returns expected

        //WHEN
        presenter.onCreateLoginClicked()

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