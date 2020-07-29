package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum
import org.junit.Assert
import org.junit.Test

internal class QuestionsIdDomainToModelMapperDefaultTest {

    private val idMapper = QuestionsIdDomainToModelMapperDefault()

    @Test
    fun `GIVEN domainIdDrugs, WHEN mapIdToDrugsModel, THEN return QuestionIdModelEnum_value`() {
        // GIVEN
        val id = listOf(
            QuestionIdDomainEnum.DRUGS_JAIL,
            QuestionIdDomainEnum.DRUGS_QUANTITY,
            QuestionIdDomainEnum.DRUGS_SMOKE,
            QuestionIdDomainEnum.DRUGS_USAGE,
            QuestionIdDomainEnum.SEX_SAME,
            QuestionIdDomainEnum.RELIGION_ANTI
        )
        val expected = listOf(
            QuestionIdModelEnum.DRUGS_JAIL,
            QuestionIdModelEnum.DRUGS_QUANTITY,
            QuestionIdModelEnum.DRUGS_SMOKE,
            QuestionIdModelEnum.DRUGS_USAGE,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID
        )

        // WHEN
        val result = id.map { idMapper.mapIdToDrugsModel(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN domainIdSex, WHEN mapIdToSexModel, THEN return QuestionIdModelEnum_value`() {
        // GIVEN
        val id = listOf(
            QuestionIdDomainEnum.SEX_SAME,
            QuestionIdDomainEnum.DRUGS_JAIL,
            QuestionIdDomainEnum.DRUGS_QUANTITY,
            QuestionIdDomainEnum.DRUGS_SMOKE,
            QuestionIdDomainEnum.DRUGS_USAGE,
            QuestionIdDomainEnum.RELIGION_ANTI
        )
        val expected = listOf(
            QuestionIdModelEnum.SEX_SAME,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID
        )

        // WHEN
        val result = id.map { idMapper.mapIdToSexModel(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN domainIdReligion, WHEN mapIdToReligionModel, THEN return QuestionIdModelEnum_value`() {
        // GIVEN
        val id = listOf(
            QuestionIdDomainEnum.RELIGION_ANTI,
            QuestionIdDomainEnum.DRUGS_JAIL,
            QuestionIdDomainEnum.DRUGS_QUANTITY,
            QuestionIdDomainEnum.DRUGS_SMOKE,
            QuestionIdDomainEnum.DRUGS_USAGE,
            QuestionIdDomainEnum.SEX_SAME
        )
        val expected = listOf(
            QuestionIdModelEnum.RELIGION_ANTI,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID
        )

        // WHEN
        val result = id.map { idMapper.mapIdToReligionModel(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
