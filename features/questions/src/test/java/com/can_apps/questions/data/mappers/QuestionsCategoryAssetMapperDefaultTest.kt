package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapperDefault
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsCategoryAssetMapperDefaultTest {

    @InjectMockKs
    private lateinit var assetCategoryMapper: QuestionsCategoryAssetMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN drugs category, WHEN asset_mapCategoryToDomain, THEN return QuestionIdDomainEnum_Drugs`() {
        //GIVEN
        val category = "drugs"
        val expected = QuestionCategoryDomainEnum.DRUGS

        //WHEN
        val result = assetCategoryMapper.mapCategoryToDomain(category)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN sex category, WHEN asset_mapCategoryToDomain, THEN return QuestionIdDomainEnum_Sex`() {
        //GIVEN
        val category = "sex"
        val expected = QuestionCategoryDomainEnum.SEX

        //WHEN
        val result = assetCategoryMapper.mapCategoryToDomain(category)

        //THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN religion category, WHEN asset_mapCategoryToDomain, THEN return QuestionIdDomainEnum_Religion`() {
        //GIVEN
        val category = "religion"
        val expected = QuestionCategoryDomainEnum.RELIGION

        //WHEN
        val result = assetCategoryMapper.mapCategoryToDomain(category)

        //THEN
        Assert.assertEquals(expected, result)
    }
}
