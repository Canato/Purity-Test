package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionCategoryModelEnum
import com.can_apps.questions.core.QuestionCategoryDomainEnum
import org.junit.Assert
import org.junit.Test

internal class QuestionsCategoryModelMapperDefaultTest {

    private val categoryMapper = QuestionsCategoryModelMapperDefault()

    @Test
    fun `GIVEN category, WHEN domain_mapCategoryToModel, THEN return QuestionsCategoryModelEnum`() {
        // GIVEN
        val category = listOf(
            QuestionCategoryDomainEnum.DRUGS,
            QuestionCategoryDomainEnum.SEX,
            QuestionCategoryDomainEnum.RELIGION
        )
        val expected = listOf(
            QuestionCategoryModelEnum.DRUGS,
            QuestionCategoryModelEnum.SEX,
            QuestionCategoryModelEnum.RELIGION
        )

        // WHEN
        val result = category.map { categoryMapper.mapCategoryToModel(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
