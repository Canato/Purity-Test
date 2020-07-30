package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsTextModelMapperTest {

    @MockK
    private lateinit var textStringMapper: QuestionsTextModelStringMapper

    @InjectMockKs
    private lateinit var textMapper: QuestionsTextModelMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN drugs category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = QuestionIdModelEnum.DRUGS_USAGE
        val category = QuestionCategoryModelEnum.DRUGS
        val expected = "mopped"

        every { textStringMapper.mapDrugsEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sex category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.SEX
        val expected = "mopped"

        every { textStringMapper.mapSexEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN religion category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.RELIGION
        val expected = "mopped"

        every { textStringMapper.mapReligionEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN banditry category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.BANDITRY
        val expected = "mopped"

        every { textStringMapper.mapBanditryEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN invalid category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.INVALID
        val expected = "mopped"

        every { textStringMapper.mapInvalidEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        Assert.assertEquals(expected, result)
    }
}
