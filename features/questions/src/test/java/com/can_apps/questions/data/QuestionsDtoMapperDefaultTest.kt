package com.can_apps.questions.data

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.core.QuestionErrorDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions_data_source.data.QuestionDataSourceDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class QuestionsDtoMapperDefaultTest {

    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @MockK
    private lateinit var assetMapper: QuestionsMapperDomainValid

    @InjectMockKs
    private lateinit var dto: QuestionsDtoMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN questions_dto_valid, WHEN assetToDomain, THEN return questionsdomain_valid`() {
        // GIVEN
        val questionDataSourceSet = mockk<List<QuestionDataSourceDto>>()
        val expected = mockk<List<QuestionsDomain.Valid>>()

        every { assetMapper.mapToDomainValid(questionDataSourceSet) } returns expected

        // WHEN
        val result = dto.assetToDomain(questionDataSourceSet)

        // THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN questions_dto_invalid, WHEN assetToDomain, THEN return questionsdomain_error`() {
        // GIVEN
        val message = "iOS sucks"
        val questionErrorDomain = QuestionErrorDomain(message)
        val emptyList = emptyList<QuestionDataSourceDto>()
        val expected = listOf(QuestionsDomain.Error(questionErrorDomain))

        coEvery { stringResource.getString(R.string.questions_dto_error) } returns message

        // WHEN
        val result = dto.assetToDomain(emptyList)

        // THEN
        assertEquals(expected, result)
    }
}
