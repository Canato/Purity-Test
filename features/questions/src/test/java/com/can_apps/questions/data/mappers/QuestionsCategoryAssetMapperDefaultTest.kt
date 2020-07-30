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
        val category = listOf(
            "pterodactyl", "banditry", "make_out", "NERVOUS MOUTH",
            "masturbation", "Sins", "Exhibitionism", "Crazy Life", "Legal Drugs",
            "Illegal Drugs", "University Feelings", "Sex", "purity_seeker"
        )
        val expected = listOf(
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

        // WHEN
        val result = category.map { assetCategoryMapper.mapCategoryToDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
