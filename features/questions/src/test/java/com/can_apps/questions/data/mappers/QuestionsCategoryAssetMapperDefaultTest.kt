package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsCategoryAssetMapperDefault
import org.junit.Assert
import org.junit.Test

internal class QuestionsCategoryAssetMapperDefaultTest {

    private val assetCategoryMapper = QuestionsCategoryAssetMapperDefault()

    @Test
    fun `GIVEN category, WHEN asset_mapCategoryToDomain, THEN return QuestionCategoryDomainEnum`() {
        // GIVEN
        val category = listOf("drugs", "sex", "religion", "pterodactyl")
        val expected = listOf(
            QuestionCategoryDomainEnum.DRUGS,
            QuestionCategoryDomainEnum.SEX,
            QuestionCategoryDomainEnum.RELIGION,
            QuestionCategoryDomainEnum.INVALID
        )

        // WHEN
        val result = category.map { assetCategoryMapper.mapCategoryToDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
