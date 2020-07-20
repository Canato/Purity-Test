package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsIdDomainMapperDefaultTest {

    @MockK
    private lateinit var idModelMapper: QuestionsIdDomainToModelMapper

    @InjectMockKs
    private lateinit var domainIdMapper: QuestionsIdDomainMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN drugs category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.DRUGS
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToDrugsModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToDrugsModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sex category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.SEX
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToSexModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToSexModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN religion category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.RELIGION
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToReligionModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToReligionModel(id)
        }
        Assert.assertEquals(expected, result)
    }
}
