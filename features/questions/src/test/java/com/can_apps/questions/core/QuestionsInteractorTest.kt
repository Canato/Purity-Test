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
        val repositoryList = listOf<QuestionsDetailsDomain>(mockk(), mockk(), mockk())

        val expected = repositoryList.first()

        coEvery { repository.retrieveList() } returns repositoryList

        // WHEN
        val result = interactor.retrieveQuestionsDomain(null)

        // THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN previously fetched list, WHEN retrieveNextCategory, THEN return domain`() =
        runBlocking {
            // GIVEN
            val repositoryList = listOf<QuestionsDetailsDomain>(mockk(relaxed = true), mockk(relaxed = true))

            val expected = repositoryList[1]

            coEvery { repository.retrieveList() } returns repositoryList
            interactor.retrieveQuestionsDomain(null)

            // WHEN
            val result = interactor.retrieveQuestionsDomain(repositoryList[0].category.name)

            // THEN
            assertEquals(expected, result)
        }
}
