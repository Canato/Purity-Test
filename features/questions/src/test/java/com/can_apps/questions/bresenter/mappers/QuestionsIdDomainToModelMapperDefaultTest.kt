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

    @Test
    fun `GIVEN domainIdBanditry, WHEN mapIdToBanditryModel, THEN return QuestionIdModelEnum_value`() {
        // GIVEN
        val id = listOf(
            QuestionIdDomainEnum.BANDITRY_POLICE,
            QuestionIdDomainEnum.BANDITRY_DRIVE_DRUNK,
            QuestionIdDomainEnum.BANDITRY_LOST_LICENCE,
            QuestionIdDomainEnum.BANDITRY_ACCUSED,
            QuestionIdDomainEnum.BANDITRY_JUVENILE,
            QuestionIdDomainEnum.BANDITRY_STEALING,
            QuestionIdDomainEnum.BANDITRY_SOLD_STOLEN,
            QuestionIdDomainEnum.BANDITRY_BOUGHT_STOLEN,
            QuestionIdDomainEnum.BANDITRY_NOTION,
            QuestionIdDomainEnum.BANDITRY_PREGNANT,
            QuestionIdDomainEnum.BANDITRY_ABORTION,
            QuestionIdDomainEnum.RELIGION_ANTI,
            QuestionIdDomainEnum.DRUGS_JAIL,
            QuestionIdDomainEnum.SEX_SAME
        )
        val expected = listOf(
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
            QuestionIdModelEnum.BANDITRY_ABORTION,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.INVALID
        )

        // WHEN
        val result = id.map { idMapper.mapIdToBanditryModel(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
