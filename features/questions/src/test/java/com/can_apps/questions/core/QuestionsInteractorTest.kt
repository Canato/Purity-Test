package com.can_apps.questions.core

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class QuestionsInteractorTest {

    @MockK
    private lateinit var repository: QuestionsContract.Repository

    @InjectMockKs
    private lateinit var interactor: QuestionsInteractor

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `GIVEN valid return, WHEN retrieve list, THEN return domain`() = runBlocking {
        // GIVEN
        val repositoryList =
            listOf<QuestionsDomain>(
                mockk<QuestionsDomain.Valid>(),
                mockk<QuestionsDomain.Valid>(),
                mockk<QuestionsDomain.Valid>()
            )

        val expected = repositoryList.first()

        coEvery { repository.retrieveList() } returns repositoryList

        // WHEN
        val result = interactor.retrieveQuestionsDomain()

        // THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN previously fetched list, WHEN retrieveNextCategory, THEN return domain`() =
        runBlocking {
            // GIVEN
            val repositoryList =
                listOf<QuestionsDomain>(
                    mockk<QuestionsDomain.Valid>(),
                    mockk<QuestionsDomain.Valid>(),
                    mockk<QuestionsDomain.Valid>()
                )

            val expected = repositoryList[1]

            coEvery { repository.retrieveList() } returns repositoryList
            interactor.retrieveQuestionsDomain()

            // WHEN
            val result = interactor.retrieveQuestionsDomain()

            // THEN
            assertEquals(expected, result)
        }

    @Test
    fun `GIVEN fetched first category, WHEN checkIfLastCategory, THEN return false`() =
        runBlocking {
            // GIVEN
            val repositoryList =
                listOf<QuestionsDomain>(
                    mockk<QuestionsDomain.Valid>(),
                    mockk<QuestionsDomain.Valid>(),
                    mockk<QuestionsDomain.Valid>()
                )

            val expected = false

            coEvery { repository.retrieveList() } returns repositoryList
            interactor.retrieveQuestionsDomain()

            // WHEN
            val result = interactor.isLastShownCategory()

            // THEN
            assertEquals(expected, result)
        }

    @Test
    fun `GIVEN fetched middle category, WHEN checkIfLastCategory, THEN return true`() =
        runBlocking {
            // GIVEN
            val repositoryList =
                listOf<QuestionsDomain>(
                    mockk<QuestionsDomain.Valid>(),
                    mockk<QuestionsDomain.Valid>(),
                    mockk<QuestionsDomain.Valid>()
                )

            val expected = false

            coEvery { repository.retrieveList() } returns repositoryList
            interactor.retrieveQuestionsDomain()

            // WHEN
            val result = interactor.isLastShownCategory()

            // THEN
            assertEquals(expected, result)
        }

    @Test
    fun `GIVEN fetched last category, WHEN checkIfLastCategory, THEN return true`() = runBlocking {
        // GIVEN
        val repositoryList =
            listOf<QuestionsDomain>(
                mockk<QuestionsDomain.Valid>(),
                mockk<QuestionsDomain.Valid>(),
                mockk<QuestionsDomain.Valid>()
            )

        val expected = true

        coEvery { repository.retrieveList() } returns repositoryList
        interactor.retrieveQuestionsDomain()
        interactor.retrieveQuestionsDomain()
        interactor.retrieveQuestionsDomain()

        // WHEN
        val result = interactor.isLastShownCategory()

        // THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN invalid return, WHEN retrieve list, THEN return domain`() = runBlocking {
        // GIVEN
        val repositoryList = listOf<QuestionsDomain>(mockk<QuestionsDomain.Error>())

        val expected = repositoryList.first()

        coEvery { repository.retrieveList() } returns repositoryList

        // WHEN
        val result = interactor.retrieveQuestionsDomain()

        // THEN
        assertEquals(expected, result)
    }
}
