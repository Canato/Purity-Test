package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.core.QuestionLastCategoryDomain
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
        val questionIdFirst = 1
        val questionIdSecond = 2
        val questionIdThird = 3
        val questionIdFourth = 4
        val questionCategoryFirst = "some fancy category"
        val questionCategorySecond = "some fancier category"
        val questionLastCategoryDomainFirst = QuestionLastCategoryDomain(false)
        val questionLastCategoryDomainSecond = QuestionLastCategoryDomain(true)
        val questionCategoryDomainEnumFirst = mockk<QuestionCategoryDomainEnum>()
        val questionCategoryDomainEnumSecond = mockk<QuestionCategoryDomainEnum>()
        val questionIdDomainEnumFirst = mockk<QuestionIdDomainEnum>()
        val questionIdDomainEnumSecond = mockk<QuestionIdDomainEnum>()
        val questionIdDomainEnumThird = mockk<QuestionIdDomainEnum>()
        val questionIdDomainEnumForth = mockk<QuestionIdDomainEnum>()
        val questionWeightValue = mockk<Int>(relaxed = true)
        val questionWeightDomain = QuestionWeightDomain(questionWeightValue)
        val questionDataSourceList =
            listOf(
                QuestionDataSourceDto(
                    questionCategoryFirst,
                    setOf(
                        Question(questionIdFirst, questionWeightValue)
                    )
                ),
                QuestionDataSourceDto(
                    questionCategorySecond,
                    setOf(
                        Question(questionIdSecond, questionWeightValue),
                        Question(questionIdThird, questionWeightValue),
                        Question(questionIdFourth, questionWeightValue)
                    )
                )
            )

        val questionDomainSetFirst = setOf(
            QuestionDetailsDomain(
                questionIdDomainEnumFirst,
                questionWeightDomain
            )
        )

        val questionDomainSetSecond = setOf(
            QuestionDetailsDomain(
                questionIdDomainEnumSecond,
                questionWeightDomain
            ),
            QuestionDetailsDomain(
                questionIdDomainEnumThird,
                questionWeightDomain
            ),
            QuestionDetailsDomain(
                questionIdDomainEnumForth,
                questionWeightDomain
            )
        )

        val expected =
            listOf(
                QuestionsDomain.Valid(
                    questionCategoryDomainEnumFirst,
                    questionLastCategoryDomainFirst,
                    questionDomainSetFirst
                ),
                QuestionsDomain.Valid(
                    questionCategoryDomainEnumSecond,
                    questionLastCategoryDomainSecond,
                    questionDomainSetSecond
                )
            )

        every {
            assetCategoryMapper.mapCategoryToDomain(questionCategoryFirst)
        } returns questionCategoryDomainEnumFirst

        every {
            assetCategoryMapper.mapCategoryToDomain(questionCategorySecond)
        } returns questionCategoryDomainEnumSecond

        every {
            assetIdMapper.mapAssetId(questionCategoryDomainEnumFirst, questionIdFirst)
        } returns questionIdDomainEnumFirst

        every {
            assetIdMapper.mapAssetId(questionCategoryDomainEnumSecond, questionIdSecond)
        } returns questionIdDomainEnumSecond

        every {
            assetIdMapper.mapAssetId(questionCategoryDomainEnumSecond, questionIdThird)
        } returns questionIdDomainEnumThird

        every {
            assetIdMapper.mapAssetId(questionCategoryDomainEnumSecond, questionIdFourth)
        } returns questionIdDomainEnumForth

        // WHEN
        val result = assetMapper.mapToDomainValid(questionDataSourceList)

        // THEN
        Assert.assertEquals(expected, result)
    }
}
