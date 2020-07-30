package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetToDomainMapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsIdAssetMapperDefaultTest {

    @MockK
    private lateinit var idDomainMapper: QuestionsIdAssetToDomainMapper

    @InjectMockKs
    private lateinit var assetIdMapper: QuestionsIdAssetMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN banditry category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.BANDITRY
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToBanditryDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToBanditryDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN make_out category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.MAKE_OUT
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToMakeOutDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToMakeOutDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN nervous_mouth category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.NERVOUS_MOUTH
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToNervousMouthDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToNervousMouthDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN masturbation category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.MASTURBATION
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToMasturbationDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToMasturbationDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sins category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.SINS
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToSinsDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToSinsDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN exhibitionism category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.EXHIBITIONISM
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToExhibitionismDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToExhibitionismDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN crazy_life category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.CRAZY_LIFE
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToCrazyLifeDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToCrazyLifeDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN legal_drugs category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.LEGAL_DRUGS
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToLegalDrugsDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToLegalDrugsDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN illegal_drugs category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.ILLEGAL_DRUGS
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToIllegalDrugsDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToIllegalDrugsDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN university_feelings category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToUniFeelingsDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToUniFeelingsDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sex category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.SEX
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToSexDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToSexDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN purity_seeker category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.PURITY_SEEKER
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToPurityDomain(id) } returns expected

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        verify {
            idDomainMapper.mapIdToPurityDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN invalid category, WHEN mapAssetId, THEN return QuestionIdDomainEnum_Invalid`() {
        // GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.INVALID
        val expected = QuestionIdDomainEnum.INVALID

        // WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }
}
