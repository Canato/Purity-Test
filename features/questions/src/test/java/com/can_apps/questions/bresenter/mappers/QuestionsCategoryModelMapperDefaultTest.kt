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
            QuestionCategoryDomainEnum.INVALID,
            QuestionCategoryDomainEnum.BANDITRY,
            QuestionCategoryDomainEnum.MAKE_OUT,
            QuestionCategoryDomainEnum.NERVOUS_MOUTH,
            QuestionCategoryDomainEnum.MASTURBATION,
            QuestionCategoryDomainEnum.SINS,
            QuestionCategoryDomainEnum.EXHIBITIONISM,
            QuestionCategoryDomainEnum.CRAZY_LIFE,
            QuestionCategoryDomainEnum.LEGAL_DRUGS,
            QuestionCategoryDomainEnum.ILLEGAL_DRUGS,
            QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS,
            QuestionCategoryDomainEnum.SEX,
            QuestionCategoryDomainEnum.PURITY_SEEKER
        )
        val expected = listOf(
            QuestionCategoryModelEnum.INVALID,
            QuestionCategoryModelEnum.BANDITRY,
            QuestionCategoryModelEnum.MAKE_OUT,
            QuestionCategoryModelEnum.NERVOUS_MOUTH,
            QuestionCategoryModelEnum.MASTURBATION,
            QuestionCategoryModelEnum.SINS,
            QuestionCategoryModelEnum.EXHIBITIONISM,
            QuestionCategoryModelEnum.CRAZY_LIFE,
            QuestionCategoryModelEnum.LEGAL_DRUGS,
            QuestionCategoryModelEnum.ILLEGAL_DRUGS,
            QuestionCategoryModelEnum.UNIVERSITY_FEELINGS,
            QuestionCategoryModelEnum.SEX,
            QuestionCategoryModelEnum.PURITY_SEEKER
        )

        // WHEN
        val result = category.map { categoryMapper.mapCategoryToModel(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
