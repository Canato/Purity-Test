package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.*
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValidDefault
import com.can_apps.questions_data_source.data.QuestionsDataSourceDto
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsMapperDomainValidDefaultTest {

    @MockK
    private lateinit var assetCategoryMapper: QuestionsCategoryAssetMapper

    @MockK
    private lateinit var assetIdMapper: QuestionsIdAssetMapper

    @InjectMockKs
    private lateinit var assetMapper: QuestionsMapperDomainValidDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN asset, WHEN asset_mapToDomainValid, THEN return questionsdomain_valid`() {
        //GIVEN
        val questionId = mockk<Int>()
        val questionCategory = "some fancy category"
        val questionCategoryDomainEnum = mockk<QuestionCategoryDomainEnum>()
        val questionIdDomainEnum = mockk<QuestionIdDomainEnum>()
        val questionDataSourceSet = mockk<Set<QuestionsDataSourceDto>>()
        val questionWeightValue = mockk<Int>()
        val questionWeightDomain = QuestionWeightDomain(questionWeightValue)
        val questionSelectedValue = mockk<Boolean>()
        val questionSelectedDomain = QuestionSelectedDomain(questionSelectedValue)

        val questionDomainSet = setOf(
            QuestionDetailsDomain(
                questionCategoryDomainEnum,
                questionIdDomainEnum,
                questionWeightDomain,
                questionSelectedDomain
            )
        )
        val expected = QuestionsDomain.Valid(questionDomainSet)

        every { assetCategoryMapper.mapCategoryToDomain(questionCategory)
        } returns questionCategoryDomainEnum

        every { assetIdMapper.mapAssetId(questionCategoryDomainEnum, questionId)
        } returns questionIdDomainEnum

        //WHEN
        val result = assetMapper.mapToDomainValid(questionDataSourceSet)

        //THEN
        Assert.assertEquals(expected, result)
    }
}