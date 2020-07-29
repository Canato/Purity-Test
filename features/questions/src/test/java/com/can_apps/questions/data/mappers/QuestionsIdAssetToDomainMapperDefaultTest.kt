package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetToDomainMapperDefault
import org.junit.Assert
import org.junit.Test

internal class QuestionsIdAssetToDomainMapperDefaultTest {

    private val idDomainMapper = QuestionsIdAssetToDomainMapperDefault()

    @Test
    fun `GIVEN id, WHEN mapIdToDrugsDomain, THEN return QuestionIdDomainEnum_DRUGS_JAIL`() {
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
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_SEX_SAME`() {
        // GIVEN
        val id = listOf(1, 666)
        val expected = listOf(QuestionIdDomainEnum.SEX_SAME, QuestionIdDomainEnum.INVALID)

        // WHEN
        val result = id.map { idDomainMapper.mapIdToSexDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_RELIGION_ANTI`() {
        // GIVEN
        val id = listOf(1, 666)
        val expected = listOf(QuestionIdDomainEnum.RELIGION_ANTI, QuestionIdDomainEnum.INVALID)

        // WHEN
        val result = id.map { idDomainMapper.mapIdToReligionDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
