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
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
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

    @Test
    fun `GIVEN valid name and valid password, WHEN perform sign in, THEN enable buttons`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        val firebaseUserEmail = FireBaseUserEmail(loginName)
        val user = FirebaseDto.Valid(firebaseUserEmail)

        coEvery { firebaseApi.signInExistingUser(loginName, password) } returns user
        // WHEN
        presenter.onLoginInputChanged(loginName)
        presenter.onPasswordInputChanged(password)
        presenter.onSignClicked(loginName, password)

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

    @Test
    fun `GIVEN success, WHEN perform create user, THEN show success`() {
        // GIVEN
        val loginName = "TomaszBoy@unittest.com"
        val password = "Cr3ateProperIntegrationTest"
        val firebaseUserEmail = FireBaseUserEmail(loginName)
        val user = FirebaseDto.Valid(firebaseUserEmail)

        coEvery { firebaseApi.createNewUser(loginName, password) } returns user

        // WHEN
        presenter.onPasswordInputChanged(password)
        presenter.onLoginInputChanged(loginName)
        presenter.onCreateLoginClicked(loginName, password)

        // THEN
        verify(exactly = 1) {
            view.disableCreateUserButton()
            view.disableSignInButton()
            view.updatePasswordTextViewErrorMessage(null)
            view.updateLoginTextViewErrorMessage(null)
            view.setPasswordCheckBoxAsTrue()
            view.setLoginCheckBoxAsTrue()
            view.enableCreateUserButton()
            view.enableSignInButton()
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

    @Test
    fun `WHEN on logoutUser pressed, THEN perform logout user`() {
        // WHEN
        presenter.logoutUser()
        // THEN
        coVerify {
            firebaseApi.logoutUser()
        }
    }

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
