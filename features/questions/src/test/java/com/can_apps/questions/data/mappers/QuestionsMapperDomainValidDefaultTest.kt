package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsMapperDomainValidDefault
import com.can_apps.questions_data_source.data.Question
import com.can_apps.questions_data_source.data.QuestionDataSourceDto
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
        // GIVEN
        val questionId = mockk<Int>(relaxed = true)
        val questionCategory = "some fancy category"
        val questionCategoryDomainEnum = mockk<QuestionCategoryDomainEnum>()
        val questionIdDomainEnum = mockk<QuestionIdDomainEnum>()
        val questionWeightValue = mockk<Int>(relaxed = true)
        val questionWeightDomain = QuestionWeightDomain(questionWeightValue)
        val questionDataSourceSet =
            setOf(
                QuestionDataSourceDto(
                    questionCategory,
                    setOf(
                        Question(questionId, questionWeightValue)
                    )
                )
            )

        val questionDomainSet = setOf(
            QuestionDetailsDomain(
                questionIdDomainEnum,
                questionWeightDomain
            )
        )

        val expected =
            setOf(QuestionsDomain.Valid(questionCategoryDomainEnum, questionDomainSet))

        every {
            assetCategoryMapper.mapCategoryToDomain(questionCategory)
        } returns questionCategoryDomainEnum

        every {
            assetIdMapper.mapAssetId(questionCategoryDomainEnum, questionId)
        } returns questionIdDomainEnum

        // WHEN
        val result = assetMapper.mapToDomainValid(questionDataSourceSet)

        // THEN
        Assert.assertEquals(expected, result)
    }
}
