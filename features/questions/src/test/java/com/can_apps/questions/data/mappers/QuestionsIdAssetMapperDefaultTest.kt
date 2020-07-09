package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapperDefault
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdDomainMapper
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
    private lateinit var idDomainMapper: QuestionsIdDomainMapper

    @InjectMockKs
    private lateinit var assetIdMapper: QuestionsIdAssetMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN drugs category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        //GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.DRUGS
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToDrugsDomain(id) } returns expected

        //WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        //THEN
        verify {
            idDomainMapper.mapIdToDrugsDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sex category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        //GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.SEX
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToSexDomain(id) } returns expected

        //WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        //THEN
        verify {
            idDomainMapper.mapIdToSexDomain(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN religion category, WHEN mapAssetId, THEN return QuestionIdDomainEnum`() {
        //GIVEN
        val id = mockk<Int>(relaxed = true)
        val category = QuestionCategoryDomainEnum.RELIGION
        val expected = mockk<QuestionIdDomainEnum>()

        every { idDomainMapper.mapIdToReligionDomain(id) } returns expected

        //WHEN
        val result = assetIdMapper.mapAssetId(category, id)

        //THEN
        verify {
            idDomainMapper.mapIdToReligionDomain(id)
        }
        Assert.assertEquals(expected, result)
    }
}
