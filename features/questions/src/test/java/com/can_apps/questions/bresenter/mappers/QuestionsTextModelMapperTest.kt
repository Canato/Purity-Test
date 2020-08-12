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
    fun `GIVEN category, WHEN mapText, THEN return string`() {
        // GIVEN
        val id = mockk<QuestionIdModelEnum>()
        val category = listOf(
            QuestionCategoryModelEnum.BANDITRY,
            QuestionCategoryModelEnum.MAKE_OUT,
            QuestionCategoryModelEnum.NERVOUS_MOUTH,
            QuestionCategoryModelEnum.MASTURBATION,
            QuestionCategoryModelEnum.SINS,
            QuestionCategoryModelEnum.EXHIBITIONISM,
            QuestionCategoryModelEnum.CRAZY_LIFE,
            QuestionCategoryModelEnum.LEGAL_DRUGS,
            QuestionCategoryModelEnum.ILLEGAL_DRUGS,
            QuestionCategoryModelEnum.UNIVERSITY_FEELINGS,
            QuestionCategoryModelEnum.SEX,
            QuestionCategoryModelEnum.PURITY_SEEKER,
            QuestionCategoryModelEnum.INVALID
        )
        val expected = listOf(
            "that",
            "should",
            "be",
            "a",
            "value",
            "here",
            "is",
            "question",
            "are",
            "you",
            "fine",
            "finally",
            "pterodactyl"
        )

        every { textStringMapper.mapBanditryEnumToString(id) } returns expected[0]
        every { textStringMapper.mapMakeOutEnumToString(id) } returns expected[1]
        every { textStringMapper.mapNervousMouthEnumToString(id) } returns expected[2]
        every { textStringMapper.mapMasturbationEnumToString(id) } returns expected[3]
        every { textStringMapper.mapSinsEnumToString(id) } returns expected[4]
        every { textStringMapper.mapExhibitionismEnumToString(id) } returns expected[5]
        every { textStringMapper.mapCrazyLifeEnumToString(id) } returns expected[6]
        every { textStringMapper.mapLegalDrugsEnumToString(id) } returns expected[7]
        every { textStringMapper.mapIllegalDrugsEnumToString(id) } returns expected[8]
        every { textStringMapper.mapUniFeelingsEnumToString(id) } returns expected[9]
        every { textStringMapper.mapSexEnumToString(id) } returns expected[10]
        every { textStringMapper.mapPurityEnumToString(id) } returns expected[11]
        every { textStringMapper.mapInvalidEnumToString(id) } returns expected[12]

        // WHEN
        val result = category.map { textMapper.mapText(it, id) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
