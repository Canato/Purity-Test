package com.can_apps.questions.bresenter

import com.can_apps.questions.bresenter.mappers.QuestionsCategoryModelMapper
import com.can_apps.questions.bresenter.mappers.QuestionsIdDomainMapper
import com.can_apps.questions.bresenter.mappers.QuestionsModelMapperDefault
import com.can_apps.questions.bresenter.mappers.QuestionsTextModelMapper
import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionCategoryDomain
import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.core.QuestionLastCategoryDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class QuestionsModelMapperTest {

    @MockK
    private lateinit var categoryMapper: QuestionsCategoryModelMapper

    @MockK
    private lateinit var idMapper: QuestionsIdDomainMapper

    @MockK
    private lateinit var textMapper: QuestionsTextModelMapper

    @InjectMockKs
    private lateinit var modelMapper: QuestionsModelMapperDefault

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Test
    fun `GIVEN domain, WHEN map, THEN return model`() {
        // GIVEN
        val questionCategoryDomainEnum = mockk<QuestionCategoryDomainEnum>()
        val questionLastCategoryDomain = mockk<QuestionLastCategoryDomain>(relaxed = true)
        val questionIdDomainEnum = mockk<QuestionIdDomainEnum>()
        val questionWeightValue = mockk<Int>(relaxed = true)
        val questionWeightDomain = QuestionWeightDomain(questionWeightValue)

        val questionDomainSet = setOf(
            QuestionCategoryDomain(
                questionIdDomainEnum,
                questionWeightDomain
            )
        )

        val questionDomain =
            QuestionsDomain.Valid(
                questionCategoryDomainEnum,
                questionLastCategoryDomain,
                questionDomainSet
            )

        val questionsCategoryModelEnum = mockk<QuestionCategoryModelEnum>()
        val questionIdModelEnum = mockk<QuestionIdModelEnum>()
        val questionTextModel = mockk<QuestionTextModel>(relaxed = true)
        val questionWeightModel = QuestionWeightModel(questionWeightValue)
        val questionsModelDetails =
            QuestionsModelDetails(questionIdModelEnum, questionTextModel, questionWeightModel)
        val questionLastCategoryModel = mockk<QuestionLastCategoryModel>(relaxed = true)

        val expected =
            QuestionsModel(questionsCategoryModelEnum, questionLastCategoryModel, setOf(questionsModelDetails))

        every { categoryMapper.mapCategoryToModel(questionCategoryDomainEnum) } returns questionsCategoryModelEnum

        every {
            idMapper.mapDomainId(
                questionsCategoryModelEnum,
                questionIdDomainEnum
            )
        } returns questionIdModelEnum

        every {
            textMapper.mapText(
                questionsCategoryModelEnum,
                questionIdModelEnum
            )
        } returns questionTextModel.value

        // WHEN
        val result = modelMapper.toModel(questionDomain)

        // THEN
        assertEquals(expected, result)
    }
}
