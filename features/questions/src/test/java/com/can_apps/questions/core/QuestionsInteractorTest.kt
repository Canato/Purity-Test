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
        val result = interactor.retrieveList()

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
        val result = interactor.retrieveList()

        // THEN
        assertEquals(expected, result)
    }
}
