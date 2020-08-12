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
    fun `GIVEN banditry category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.BANDITRY
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToBanditryModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToBanditryModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN make_out category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.MAKE_OUT
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToMakeOutModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToMakeOutModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN nervous_mouth category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.NERVOUS_MOUTH
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToNervousMouthModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToNervousMouthModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN masturbation category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.MASTURBATION
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToMasturbationModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToMasturbationModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sins category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.SINS
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToSinsModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToSinsModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN exhibitionism category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.EXHIBITIONISM
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToExhibitionismModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToExhibitionismModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN crazy_life category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.CRAZY_LIFE
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToCrazyLifeModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToCrazyLifeModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN legal_drugs category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.LEGAL_DRUGS
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToLegalDrugsModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToLegalDrugsModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN illegal_drugs category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.ILLEGAL_DRUGS
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToIllegalDrugsModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToIllegalDrugsModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN university_feelings category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.UNIVERSITY_FEELINGS
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToUniFeelingsModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToUniFeelingsModel(id)
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
    fun `GIVEN purity_seeker category, WHEN mapDomainId, THEN return QuestionIdModelEnum`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.PURITY_SEEKER
        val expected = mockk<QuestionIdModelEnum>()

        every { idModelMapper.mapIdToPurityModel(id) } returns expected

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        verify {
            idModelMapper.mapIdToPurityModel(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN invalid category, WHEN mapDomainId, THEN return QuestionIdModelEnum_Invalid`() {
        // GIVEN
        val id = mockk<QuestionIdDomainEnum>()
        val category = QuestionCategoryModelEnum.INVALID
        val expected = QuestionIdModelEnum.INVALID

        // WHEN
        val result = domainIdMapper.mapDomainId(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }
}
