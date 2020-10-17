package com.can_apps.login

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.login.bresenter.LoginErrorModel
import com.can_apps.login.bresenter.LoginModel
import com.can_apps.login.core.LoginContract
import com.can_apps.login.data.firebase_data_source.FireBaseUserEmail
import com.can_apps.login.data.firebase_data_source.FirebaseApi
import com.can_apps.login.data.firebase_data_source.FirebaseDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class LoginIntegrationTest {

    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @MockK
    private lateinit var firebaseApi: FirebaseApi

    @MockK
    private lateinit var view: LoginContract.View

    private lateinit var presenter: LoginContract.Presenter

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        val serviceLocator = MockLoginServiceLocator(stringResource, firebaseApi)
        presenter = serviceLocator.getPresenter()
        presenter.bind(view)
    }

    //    fun onViewCreated()
    @Test
    fun `WHEN onViewCreated, THEN return default view`() {

        // WHEN
        presenter.onViewCreated()
        // THEN
        verify {
            view.disableCreateUserButton()
            view.disableSignInButton()
            view.showWelcomeMessage()
        }
    }

    //    fun onBackPressed()
    @Test
    fun `WHEN onBackPressed, THEN close the view`() {
        // WHEN
        presenter.onBackPressed()
        // THEN
        verify {
            view.close()
        }
    }

    @Test
    fun `GIVEN valid name and valid password, WHEN values change, THEN enable buttons`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        // WHEN
        presenter.onLoginInputChanged(loginName)
        presenter.onPasswordInputChanged(password)

        // THEN
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

    //    fun onSignClicked(loginName: String, password: String)
    @Test
    fun `GIVEN success, WHEN on sign in clicked, THEN show success`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        val firebaseUserEmail = FireBaseUserEmail(loginName)
        val user = FirebaseDto.Valid(firebaseUserEmail)

        coEvery { firebaseApi.signInExistingUser(loginName, password) } returns user

        // WHEN
        presenter.onSignClicked(loginName, password)

        // THEN
        verify(exactly = 1) {
            view.showSuccess()
            view.cleanLoginTextView()
            view.cleanPasswordTextView()
        }
    }

    @Test
    fun `GIVEN fail, WHEN on sign in clicked, THEN show fail`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        val error = "flipflops"
        val user = FirebaseDto.Invalid

        coEvery { firebaseApi.signInExistingUser(loginName, password) } returns user
        every { stringResource.getString(R.string.firebase_dto_error) } returns error

        // WHEN
        presenter.onSignClicked(loginName, password)

        // THEN
        verify(exactly = 1) {
            view.showError(error)
        }
    }

    //    fun onCreateLoginClicked(loginName: String, password: String)
    @Test
    fun `GIVEN success, WHEN on create user clicked, THEN show success`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        val firebaseUserEmail = FireBaseUserEmail(loginName)
        val user = FirebaseDto.Valid(firebaseUserEmail)

        coEvery { firebaseApi.createNewUser(loginName, password) } returns user

        // WHEN
        presenter.onCreateLoginClicked(loginName, password)

        // THEN
        verify(exactly = 1) {
            view.showSuccess()
            view.cleanLoginTextView()
            view.cleanPasswordTextView()
        }
    }

    @Test
    fun `GIVEN fail, WHEN on create user clicked, THEN show fail`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        val error = "flipflops"
        val user = FirebaseDto.Invalid

        coEvery { firebaseApi.createNewUser(loginName, password) } returns user
        every { stringResource.getString(R.string.firebase_dto_error) } returns error

        // WHEN
        presenter.onCreateLoginClicked(loginName, password)

        // THEN
        verify(exactly = 1) {
            view.showError(error)
        }
    }

    //    fun logoutUser()
    @Test
    fun `WHEN on logoutUser pressed, THEN perform logout user`() {
        // WHEN
        presenter.logoutUser()
        // THEN
        verify {
            runBlocking { firebaseApi.logoutUser() }
        }
    }

    //    fun checkLogIn()
    @Test
    fun `GIVEN firebase check login status success, WHEN checkLogInStatus, THEN show success`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val message = "MidnightGospel"
        val firebaseUserEmail = FireBaseUserEmail(loginName)
        val user = FirebaseDto.Valid(firebaseUserEmail)

        coEvery { firebaseApi.checkLogInStatus() } returns user
        every { stringResource.getString(R.string.sign_in_true) } returns message

        // WHEN
        presenter.checkLogIn()

        // THEN
        verify {
            view.showLogInStatus(message)
        }
    }

    @Test
    fun `GIVEN firebase check login status fail, WHEN checkLogInStatus, THEN show fail`() {
        // GIVEN
        val error = "flipflops"
        val user = FirebaseDto.Invalid

        coEvery { firebaseApi.checkLogInStatus() } returns user
        every { stringResource.getString(R.string.firebase_dto_error) } returns error

        // WHEN
        presenter.checkLogIn()

        // THEN
        verify {
            view.showLogInStatus(error)
        }
    }

    //    fun onLoginInputChanged(login: String)
    @Test
    fun `GIVEN valid login, WHEN onLoginInputChanged, THEN clean error`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val loginModelSuccess = null
        // WHEN
        presenter.onLoginInputChanged(loginName)

        // THEN
        verify {
            view.setLoginCheckBoxAsTrue()
            view.updateLoginTextViewErrorMessage(loginModelSuccess)
        }
    }

    @Test
    fun `GIVEN invalid login, WHEN onLoginInputChanged, THEN show error`() {
        // GIVEN
        val loginName = "TomaszBoyATunittest.com"
        val error = "flipflops"
        val errorModel = LoginErrorModel(error)
        val loginModelError = LoginModel.Error(errorModel)

        coEvery { stringResource.getString(R.string.validation_login_missing_at_sign) } returns error

        // WHEN
        presenter.onLoginInputChanged(loginName)

        // THEN
        verify {
            view.setLoginCheckBoxAsFalse()
            view.updateLoginTextViewErrorMessage(loginModelError)
        }
    }

    //    fun onPasswordInputChanged(password: String)
    @Test
    fun `GIVEN valid password, WHEN onPasswordInputChanged, THEN clean error`() {
        // GIVEN
        val password = "Cr3ateProperIntegrationTest"
        val passwordModelSuccess = null
        // WHEN
        presenter.onPasswordInputChanged(password)

        // THEN
        verify {
            view.setPasswordCheckBoxAsTrue()
            view.updatePasswordTextViewErrorMessage(passwordModelSuccess)
        }
    }

    @Test
    fun `GIVEN invalid password, WHEN onPasswordInputChanged, THEN show error`() {
        // GIVEN
        val password = "short"
        val error = "flipflops"
        val errorModel = LoginErrorModel(error)
        val loginModelError = LoginModel.Error(errorModel)

        coEvery { stringResource.getString(R.string.validation_password_to_small) } returns error

        // WHEN
        presenter.onPasswordInputChanged(password)

        // THEN
        verify {
            view.setPasswordCheckBoxAsFalse()
            view.updatePasswordTextViewErrorMessage(loginModelError)
        }
    }
}
