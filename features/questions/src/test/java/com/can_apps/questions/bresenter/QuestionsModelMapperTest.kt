package com.can_apps.questions.bresenter

import com.can_apps.questions.core.QuestionDomain
import com.can_apps.questions.core.QuestionIdDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain
import org.junit.Assert.assertEquals
import org.junit.Test

internal class QuestionsModelMapperTest {

    private val mapper = QuestionsModelMapperDefault()

    @Test
    fun `GIVEN domain, WHEN map, THEN return model`() {
        //GIVEN
        val questionId = 42UL
        val question = "Nice question to answer"

        val domain = QuestionsDomain.Valid(
            QuestionIdDomain(questionId),
            QuestionDomain(question),
            false,
            QuestionWeightDomain(9)
        )

        val expected = QuestionsModel(
            QuestionModel(question),
            QuestionIdModel(questionId)
        )

        //WHEN
        val result = mapper.toModel(domain)

        //THEN
        assertEquals(expected, result)
    }
}