package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum
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
            QuestionIdModelEnum.DRUGS_USAGE,
            QuestionIdModelEnum.INVALID
        )
        val stringResourceValue =
            listOf("that should be a value", "or this", "maybe this", "definitely this", "here is a question")

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4]
        )

        every { stringResourceWrapper.getString(R.string.drugs_jail) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.drugs_quantity) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.drugs_smoke) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.drugs_usage) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[4]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapDrugsEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapSexEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.SEX_SAME, QuestionIdModelEnum.INVALID)
        val stringResourceValue =
            listOf("that should be a value", "here is a question")

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1]
        )

        every { stringResourceWrapper.getString(R.string.sex_same) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[1]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapSexEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapReligionEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.RELIGION_ANTI, QuestionIdModelEnum.INVALID)
        val stringResourceValue =
            listOf("that should be a value", "here is a question")

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1]
        )

        every { stringResourceWrapper.getString(R.string.religion_anti) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[1]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapReligionEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapRInvalidEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.RELIGION_ANTI)
        val stringResourceValue =
            listOf("that should be a value")

        val expected = listOf(
            stringResourceValue[0]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapInvalidEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
