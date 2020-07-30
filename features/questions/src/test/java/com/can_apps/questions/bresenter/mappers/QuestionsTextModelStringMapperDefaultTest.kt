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
    fun `GIVEN idModelEnum, WHEN mapBanditryEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.BANDITRY_POLICE,
            QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK,
            QuestionIdModelEnum.BANDITRY_LOST_LICENCE,
            QuestionIdModelEnum.BANDITRY_ACCUSED,
            QuestionIdModelEnum.BANDITRY_JUVENILE,
            QuestionIdModelEnum.BANDITRY_STEALING,
            QuestionIdModelEnum.BANDITRY_SOLD_STOLEN,
            QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN,
            QuestionIdModelEnum.BANDITRY_NOTION,
            QuestionIdModelEnum.BANDITRY_PREGNANT,
            QuestionIdModelEnum.BANDITRY_ABORTION
        )
        val stringResourceValue =
            listOf("that", "should", "be", "a", "value", "here", "is", "question", "are", "you", "fine", "finally")

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.banditry_police) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.banditry_drive_drunk) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.banditry_lost_licence) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.banditry_accused) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.banditry_juvenile) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.banditry_stealing) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.banditry_sold_stolen) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.banditry_bought_stolen) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.banditry_notion) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.banditry_pregnant) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.banditry_abortion) } returns stringResourceValue[11]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapBanditryEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapSexEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN, QuestionIdModelEnum.INVALID)
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
    fun `GIVEN idModelEnum, WHEN mapInvalidEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.INVALID)
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
