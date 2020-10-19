package com.can_apps.questions

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions_data_source.data.QuestionDataSourceDto
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

internal class QuestionsIntegrationTest {

    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @MockK
    private lateinit var assets: QuestionsDataSourceAssets

    @MockK
    private lateinit var view: QuestionsContract.View

    private lateinit var presenter: QuestionsContract.Presenter

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        val serviceLocator = MockQuestionsServiceLocator(stringResource, assets)
        presenter = serviceLocator.getPresenter()
        presenter.bind(view)
    }

    @Test
    fun `GIVEN valid data, WHEN on create view, THEN show list`() {
        // GIVEN
        coEvery { assets.getQuestions() } returns mockedQuestionsAssetDto
        every { stringResource.getString(R.string.banditry_police) } returns questionFirstOne
        every { stringResource.getString(R.string.banditry_drive_drunk) } returns questionFirstTwo
        every { stringResource.getString(R.string.banditry_lost_licence) } returns questionFirstThree

        // WHEN
        presenter.onViewCreated()

        // THEN
        verify {
            view.showLoading()
            view.hideLoading()
            view.showCategory(questionExpectedModel[0].questionCategory.name)
            view.showList(questionExpectedModel[0].questionsModelDetails.toList())
        }
    }

    @Test
    fun `GIVEN invalid data, WHEN on create view, THEN show error`() {
        // GIVEN
        val message = "ErrorCheck"
        val emptyDto = emptyList<QuestionDataSourceDto>()

        coEvery { assets.getQuestions() } returns emptyDto
        every { stringResource.getString(R.string.questions_dto_error) } returns message
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
    fun `GIVEN valid data, WHEN fetchNextCategoryList, THEN show list`() {
        // GIVEN
        coEvery { assets.getQuestions() } returns mockedQuestionsAssetDto
        every { stringResource.getString(R.string.banditry_police) } returns questionFirstOne
        every { stringResource.getString(R.string.banditry_drive_drunk) } returns questionFirstTwo
        every { stringResource.getString(R.string.banditry_lost_licence) } returns questionFirstThree
        every { stringResource.getString(R.string.make_out_night_party) } returns questionSecondOne
        every { stringResource.getString(R.string.make_out_with_person) } returns questionSecondTwo
        every { stringResource.getString(R.string.make_out_with_same_gender) } returns questionSecondThree

        // WHEN
        presenter.onViewCreated()
        presenter.fetchNextCategoryQuestions()

        // THEN
        verify(exactly = 2) {
            view.showLoading()
            view.hideLoading()
        }

        verify(exactly = 1) {
            view.showCategory(questionExpectedModel[0].questionCategory.name)
            view.showList(questionExpectedModel[0].questionsModelDetails.toList())
            view.showCategory(questionExpectedModel[1].questionCategory.name)
            view.showList(questionExpectedModel[1].questionsModelDetails.toList())
        }

        verify(exactly = 0) {
            view.setNewActionButtonFunction()
        }
    }

    @Test
    fun `GIVEN valid data, WHEN fetchNextCategoryList, THEN show last list`() {
        // GIVEN
        coEvery { assets.getQuestions() } returns mockedQuestionsAssetDto
        every { stringResource.getString(R.string.banditry_police) } returns questionFirstOne
        every { stringResource.getString(R.string.banditry_drive_drunk) } returns questionFirstTwo
        every { stringResource.getString(R.string.banditry_lost_licence) } returns questionFirstThree
        every { stringResource.getString(R.string.make_out_night_party) } returns questionSecondOne
        every { stringResource.getString(R.string.make_out_with_person) } returns questionSecondTwo
        every { stringResource.getString(R.string.make_out_with_same_gender) } returns questionSecondThree
        every { stringResource.getString(R.string.nervous_mouth_without_tongue) } returns questionThirdOne
        every { stringResource.getString(R.string.nervous_mouth_with_tongue) } returns questionThirdTwo
        every { stringResource.getString(R.string.nervous_mouth_opposite_gender) } returns questionThirdThree

        // WHEN
        presenter.onViewCreated()
        presenter.fetchNextCategoryQuestions()
        presenter.fetchNextCategoryQuestions()

        // THEN
        verify(exactly = 3) {
            view.showLoading()
            view.hideLoading()
        }

        verify(exactly = 1) {
            view.showCategory(questionExpectedModel[0].questionCategory.name)
            view.showList(questionExpectedModel[0].questionsModelDetails.toList())
            view.showCategory(questionExpectedModel[1].questionCategory.name)
            view.showList(questionExpectedModel[1].questionsModelDetails.toList())
            view.showCategory(questionExpectedModel[2].questionCategory.name)
            view.showList(questionExpectedModel[2].questionsModelDetails.toList())
            view.setNewActionButtonFunction()
        }
    }
}
