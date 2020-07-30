package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetToDomainMapperDefault
import org.junit.Assert
import org.junit.Test

internal class QuestionsIdAssetToDomainMapperDefaultTest {

    private val idDomainMapper = QuestionsIdAssetToDomainMapperDefault()

    @Test
    fun `GIVEN id, WHEN mapIdToDrugsDomain, THEN return QuestionIdDomainEnum_DRUGS_id`() {
        // GIVEN
        val id = listOf(1, 2, 3, 4, 666)
        val expected = listOf(
            QuestionIdDomainEnum.DRUGS_JAIL,
            QuestionIdDomainEnum.DRUGS_QUANTITY,
            QuestionIdDomainEnum.DRUGS_SMOKE,
            QuestionIdDomainEnum.DRUGS_USAGE,
            QuestionIdDomainEnum.INVALID
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToDrugsDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_SEX_id`() {
        // GIVEN
        val id = listOf(1, 666)
        val expected = listOf(QuestionIdDomainEnum.SEX_SAME, QuestionIdDomainEnum.INVALID)

        // WHEN
        val result = id.map { idDomainMapper.mapIdToSexDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_RELIGION_id`() {
        // GIVEN
        val id = listOf(1, 666)
        val expected = listOf(QuestionIdDomainEnum.RELIGION_ANTI, QuestionIdDomainEnum.INVALID)

        // WHEN
        val result = id.map { idDomainMapper.mapIdToReligionDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToBanditryDomain, THEN return QuestionIdDomainEnum_BANDITRY_id`() {
        // GIVEN
        val id = listOf(1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1011, 1012, 666)
        val expected = listOf(
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
            QuestionIdDomainEnum.INVALID
        )

        // WHEN
        val result = id.map { idDomainMapper.mapBanditryToDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
