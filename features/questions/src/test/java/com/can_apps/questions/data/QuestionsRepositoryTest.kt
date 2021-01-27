package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionsDetailsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapper
import com.can_apps.questions_data_source.data.QuestionDataSourceDto
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
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
        // GIVEN

        val questionsDomain = mockk<QuestionsDetailsDomain>()
        val expected = listOf(questionsDomain)

        val listQuestionsDataSourceDto = listOf(mockk<QuestionDataSourceDto>(relaxed = true))

        coEvery { asset.getQuestions() } returns listQuestionsDataSourceDto
        coEvery { dtoMapper.assetToDomain(listQuestionsDataSourceDto) } returns expected

        // WHEN
        val result = runBlocking { repository.retrieveList() }

        // THEN
        assertEquals(expected, result)
    }
}
