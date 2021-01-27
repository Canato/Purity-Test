package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionsDetailsDomain
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValid
import com.can_apps.questions_data_source.data.QuestionDataSourceDto
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class QuestionsDtoMapperDefaultTest {

    @MockK
    private lateinit var assetMapper: QuestionsMapperDomainValid

    @InjectMockKs
    private lateinit var dto: QuestionsDtoMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN questions_dto_valid, WHEN assetToDomain, THEN return questionsdomain_valid`() {
        // GIVEN
        val questionDataSourceSet = mockk<List<QuestionDataSourceDto>>(relaxed = true)
        val expected = mockk<List<QuestionsDetailsDomain>>(relaxed = true)

        every { assetMapper.mapToDomainValid(questionDataSourceSet) } returns expected

        // WHEN
        val result = dto.assetToDomain(questionDataSourceSet)

        // THEN
        assertEquals(expected, result)
    }
}
