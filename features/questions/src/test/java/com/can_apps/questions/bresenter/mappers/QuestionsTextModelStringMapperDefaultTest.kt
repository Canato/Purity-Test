package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionTextModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsTextModelStringMapperDefaultTest {

    @MockK
    private lateinit var stringResourceWrapper: CommonStringResourceWrapper

    @InjectMockKs
    private lateinit var textStringMapper: QuestionsTextModelStringMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN idModelEnum, WHEN mapDrugsEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.DRUGS_JAIL,
            QuestionIdModelEnum.DRUGS_QUANTITY,
            QuestionIdModelEnum.DRUGS_SMOKE,
            QuestionIdModelEnum.DRUGS_USAGE
        )
        val stringResourceValue =
            listOf("that should be a value", "or this", "maybe this", "definitely this")

        val expected = listOf(
            QuestionTextModel(stringResourceValue[0]),
            QuestionTextModel(stringResourceValue[1]),
            QuestionTextModel(stringResourceValue[2]),
            QuestionTextModel(stringResourceValue[3])
        )

        every { stringResourceWrapper.getString(idModelEnum[0].ordinal) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(idModelEnum[1].ordinal) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(idModelEnum[2].ordinal) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(idModelEnum[3].ordinal) } returns stringResourceValue[3]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapDrugsEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapSexEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.SEX_SAME)
        val stringResourceValue =
            listOf("that should be a value")

        val expected = listOf(
            QuestionTextModel(stringResourceValue[0])
        )

        every { stringResourceWrapper.getString(idModelEnum[0].ordinal) } returns stringResourceValue[0]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapSexEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapReligionEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.RELIGION_ANTI)
        val stringResourceValue =
            listOf("that should be a value")

        val expected = listOf(
            QuestionTextModel(stringResourceValue[0])
        )

        every { stringResourceWrapper.getString(idModelEnum[0].ordinal) } returns stringResourceValue[0]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapReligionEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
