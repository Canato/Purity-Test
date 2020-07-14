package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionErrorDomain
import com.can_apps.questions.core.QuestionValidDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
import com.can_apps.questions_data_source.data.QuestionsDataSourceDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class QuestionsRepositoryTest {

    @MockK
    private lateinit var asset: QuestionsDataSourceAssets

    @MockK
    private lateinit var dtoMapper: QuestionsDtoMapper

    @InjectMockKs
    private lateinit var repository: QuestionsRepository

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN api with set, WHEN retrieveList, THEN return questionsdomain_valid`() {
        //GIVEN

        val setQuestionValidDomain = setOf(mockk<QuestionValidDomain>(relaxed = true))
        val expected = QuestionsDomain.Valid(setQuestionValidDomain)

        val setQuestionsDataSourceDto = setOf(mockk<QuestionsDataSourceDto>(relaxed = true))

        coEvery { asset.getQuestions() } returns setQuestionsDataSourceDto
        coEvery { dtoMapper.assetToDomain(setQuestionsDataSourceDto) } returns expected

        //WHEN
        val result = runBlocking { repository.retrieveList() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN empty set, WHEN retrieveList, THEN return questionsdomain_error`() {
        //GIVEN
        val message = "something is missing here"
        val errorDomain = QuestionErrorDomain(message)
        val emptySet = emptySet<QuestionsDataSourceDto>()
        val expected = QuestionsDomain.Error(errorDomain)


        coEvery { asset.getQuestions() } returns emptySet
        coEvery { dtoMapper.assetToDomain(emptySet) } returns expected

        //WHEN
        val result = runBlocking { repository.retrieveList() }

        //THEN
        assertEquals(expected, result)

    }

    @Test
    fun `GIVEN exception, WHEN retrieveList, THEN return questionsdomain_error`() {
        //GIVEN
        val emptySet = emptySet<QuestionsDataSourceDto>()
        val message = "expect unexpected"
        val errorDomain = QuestionErrorDomain(message)
        val exception = Exception(errorDomain.value)
        val expected = QuestionsDomain.Error(errorDomain)

        coEvery { asset.getQuestions() } throws exception

        //WHEN
        val result = runBlocking { repository.retrieveList() }

        //THEN
        assertEquals(expected, result)

    }

}
