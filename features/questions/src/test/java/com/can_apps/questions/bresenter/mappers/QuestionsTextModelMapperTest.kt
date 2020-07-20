package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionTextModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
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
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.DRUGS
        val expected = mockk<QuestionTextModel>(relaxed = true)

        every { textStringMapper.mapDrugsEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        verify {
            textStringMapper.mapDrugsEnumToString(id)
        }
        verify(exactly = 0) {
            textStringMapper.mapSexEnumToString(id)
            textStringMapper.mapReligionEnumToString(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sex category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.SEX
        val expected = mockk<QuestionTextModel>(relaxed = true)

        every { textStringMapper.mapSexEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        verify {
            textStringMapper.mapSexEnumToString(id)
        }
        verify(exactly = 0) {
            textStringMapper.mapDrugsEnumToString(id)
            textStringMapper.mapReligionEnumToString(id)
        }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN religion category, WHEN mapText, THEN return QuestionTextModel`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = QuestionCategoryModelEnum.RELIGION
        val expected = mockk<QuestionTextModel>(relaxed = true)

        every { textStringMapper.mapReligionEnumToString(id) } returns expected

        // WHEN
        val result = textMapper.mapText(category, id)

        // THEN
        verify {
            textStringMapper.mapReligionEnumToString(id)
        }
        verify(exactly = 0) {
            textStringMapper.mapSexEnumToString(id)
            textStringMapper.mapDrugsEnumToString(id)
        }
        Assert.assertEquals(expected, result)
    }
}
