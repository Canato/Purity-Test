package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionErrorDomain
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

class QuestionsRepositoryTest {

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

        val setQuestionDetailsDomain = setOf(mockk<QuestionDetailsDomain>(relaxed = true))
        val expected = QuestionsDomain.Valid(setQuestionDetailsDomain)

        val setQuestionsDataSourceDto = setOf(mockk<QuestionsDataSourceDto>(relaxed = true))

        coEvery { asset.getQuestions() } returns setQuestionsDataSourceDto
        coEvery { dtoMapper.assetToDomain(setQuestionsDataSourceDto) } returns expected

        //WHEN
        val result = runBlocking { repository.retrieveList() }

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN exception, WHEN retrieveList, THEN return questionsdomain_error`() {
        //GIVEN
        val message = "you shall not pass"
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

}