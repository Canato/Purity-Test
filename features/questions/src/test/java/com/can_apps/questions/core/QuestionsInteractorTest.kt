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
        //GIVEN
        val expected = mockk<QuestionsDomain.Valid>()
        coEvery { repository.retrieveList() } returns expected

        //WHEN
        val result = interactor.retrieveList()

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN invalid return, WHEN retrieve list, THEN return domain`() = runBlocking {
        //GIVEN
        val expected = mockk<QuestionsDomain.Error>()
        coEvery { repository.retrieveList() } returns expected

        //WHEN
        val result = interactor.retrieveList()

        //THEN
        assertEquals(expected, result)
    }
}