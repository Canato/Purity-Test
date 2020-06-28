package com.can_apps.questions.bresenter

import com.can_apps.questions.core.*
import org.junit.Assert.assertEquals
import org.junit.Test

internal class QuestionsModelMapperTest {

    private val mapper = QuestionsModelMapperDefault()

    @Test
    fun `GIVEN domain, WHEN map, THEN return model`() {
        //GIVEN
        val questionId = 42UL
        val question = "Nice question to answer"
        val questionCategory = "sexlife"

        val domain = QuestionsDomain.Valid(
            setOf(QuestionDetailsDomain(
                QuestionIdDomain(questionId),
                QuestionDomain(question),
                false,
                QuestionWeightDomain(9),
                QuestionCategoryDomain(questionCategory)
            ))
        )

        val expected = listOf(QuestionsModel(
            QuestionModel(question),
            QuestionIdModel(questionId)
        ))

        //WHEN
        val result = mapper.toModel(domain)

        //THEN
        assertEquals(expected, result)
    }
}