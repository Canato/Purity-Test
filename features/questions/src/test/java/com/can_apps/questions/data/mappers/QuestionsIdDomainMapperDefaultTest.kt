package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdDomainMapper
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdDomainMapperDefault
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsIdDomainMapperDefaultTest {

    @InjectMockKs
    private lateinit var idDomainMapper: QuestionsIdDomainMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN id, WHEN mapIdToDrugsDomain, THEN return QuestionIdDomainEnum_DRUGS_JAIL`() {
        //GIVEN
        val id = 1
        val expected = QuestionIdDomainEnum.DRUGS_JAIL

        //WHEN
        val result = idDomainMapper.mapIdToDrugsDomain(id)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToDrugsDomain, THEN return QuestionIdDomainEnum_DRUGS_QUANTITY`() {
        //GIVEN
        val id = 2
        val expected = QuestionIdDomainEnum.DRUGS_QUANTITY

        //WHEN
        val result = idDomainMapper.mapIdToDrugsDomain(id)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToDrugsDomain, THEN return QuestionIdDomainEnum_DRUGS_SMOKE`() {
        //GIVEN
        val id = 3
        val expected = QuestionIdDomainEnum.DRUGS_SMOKE

        //WHEN
        val result = idDomainMapper.mapIdToDrugsDomain(id)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToDrugsDomain, THEN return QuestionIdDomainEnum_DRUGS_USAGE`() {
        //GIVEN
        val id = 4
        val expected = QuestionIdDomainEnum.DRUGS_USAGE

        //WHEN
        val result = idDomainMapper.mapIdToDrugsDomain(id)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_SEX_SAME`() {
        //GIVEN
        val id = 1
        val expected = QuestionIdDomainEnum.SEX_SAME

        //WHEN
        val result = idDomainMapper.mapIdToSexDomain(id)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_RELIGION_ANTI`() {
        //GIVEN
        val id = 1
        val expected = QuestionIdDomainEnum.RELIGION_ANTI

        //WHEN
        val result = idDomainMapper.mapIdToReligionDomain(id)

        //THEN
        Assert.assertEquals(expected, result)
    }
}