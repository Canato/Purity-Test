package com.can_apps.questions.bresenter

import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryUnconfined
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapper
import com.can_apps.questions.core.QuestionErrorDomain
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

internal class QuestionsPresenterTest {

    @MockK
    private lateinit var interactor: QuestionsContract.Interactor

    @MockK
    private lateinit var mapper: QuestionsModelMapper

    @MockK
    private lateinit var dispatcherFactory: CoroutineDispatcherFactory

    @MockK
    private lateinit var view: QuestionsContract.View

    @InjectMockKs
    private lateinit var presenter: QuestionsPresenter

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)

        val unconfinedFactory = CoroutineDispatcherFactoryUnconfined()
        every { dispatcherFactory.IO } returns unconfinedFactory.IO
        every { dispatcherFactory.UI } returns unconfinedFactory.UI

        presenter.bind(view)
    }

    @Test
    fun `GIVEN valid data, WHEN on create view, THEN show list`() {
        // GIVEN
        val domain = mockk<QuestionsDomain.Valid>(relaxed = true)
        val model = mockk<QuestionsModel>(relaxed = true)
        val modelDetails = model.questionsModelDetails.toList()
        val modelCategory = model.questionCategory.name

        coEvery { interactor.retrieveList() } returns domain
        coEvery { mapper.toModel(domain) } returns model

        // WHEN
        presenter.onViewCreated()

        // THEN
        verify {
            view.showLoading()
            view.hideLoading()
            view.showCategory(modelCategory)
            view.showList(modelDetails)
        }
    }

    @Test
    fun `GIVEN invalid data, WHEN on create view, THEN show error`() {
        // GIVEN
        val message = "ErrorCheck"
        val questionErrorDomain = QuestionErrorDomain(message)
        val domain = QuestionsDomain.Error(questionErrorDomain)

        coEvery { interactor.retrieveList() } returns domain

        // WHEN
        presenter.onViewCreated()

        // THEN
        verify {
            view.showLoading()
            view.hideLoading()
            view.showError(message)
        }
        verify(exactly = 0) {
            view.showList(any())
        }
    }

    @Test
    fun `GIVEN non last valid data, WHEN fetchNextCategoryList, THEN show list`() {
        // GIVEN
        val lastCategory = false
        val domain = mockk<QuestionsDomain.Valid>(relaxed = true)
        val model = mockk<QuestionsModel>(relaxed = true)
        val modelDetails = model.questionsModelDetails.toList()
        val modelCategory = model.questionCategory.name

        coEvery { interactor.retrieveList() } returns domain
        coEvery { mapper.toModel(domain) } returns model
        coEvery { interactor.checkListSize() } returns lastCategory

        // WHEN
        presenter.fetchNextCategoryQuestions()

        // THEN
        verify {
            view.showLoading()
            view.hideLoading()
            view.showCategory(modelCategory)
            view.showList(modelDetails)
        }
        verify(exactly = 0) {
            view.setNewActionButtonFunction()
        }
    }

    @Test
    fun `GIVEN last valid data, WHEN fetchNextCategoryList, THEN show list`() {
        // GIVEN
        val lastCategory = true
        val domain = mockk<QuestionsDomain.Valid>(relaxed = true)
        val model = mockk<QuestionsModel>(relaxed = true)
        val modelDetails = model.questionsModelDetails.toList()
        val modelCategory = model.questionCategory.name

        coEvery { interactor.retrieveList() } returns domain
        coEvery { mapper.toModel(domain) } returns model
        coEvery { interactor.checkListSize() } returns lastCategory

        // WHEN
        presenter.fetchNextCategoryQuestions()

        // THEN
        verify {
            view.showLoading()
            view.hideLoading()
            view.showCategory(modelCategory)
            view.showList(modelDetails)
            view.setNewActionButtonFunction()
        }
    }

    @Test
    fun `WHEN back press, THEN close`() {
        // WHEN
        presenter.onBackPressed()

        // THEN
        verify {
            view.close()
        }
    }
}
