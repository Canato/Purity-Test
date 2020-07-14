package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapperDefault
import org.junit.Assert
import org.junit.Test

internal class QuestionsCategoryAssetMapperDefaultTest {

    private val assetCategoryMapper = QuestionsCategoryAssetMapperDefault()

    @Test
    fun `GIVEN category, WHEN asset_mapCategoryToDomain, THEN return QuestionIdDomainEnum`() {
        //GIVEN
        val category = listOf("drugs", "sex", "religion")
        val expected = listOf(
            QuestionCategoryDomainEnum.DRUGS,
            QuestionCategoryDomainEnum.SEX,
            QuestionCategoryDomainEnum.RELIGION
        )

        //WHEN
        val result = category.map { assetCategoryMapper.mapCategoryToDomain(it) }

        //THEN
        Assert.assertEquals(expected, result)
    }

}