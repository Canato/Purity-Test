package com.can_apps.questions.bresenter

import com.can_apps.questions.bresenter.mappers.QuestionsModelMapperDefault
import com.can_apps.questions.core.*
import org.junit.Assert.assertEquals
import org.junit.Test

internal class QuestionsModelMapperTest {

//    private val mapper =
//        QuestionsModelMapperDefault()
//
//    @Test
//    fun `GIVEN domain, WHEN map, THEN return model`() {
//        //GIVEN
//        val questionId = 0
//        val questionCategory = "sexlife"
//        val questionWeight = 0
//        val questionIsSelected = false
//
//        val domain = QuestionsDomain.Valid(
//            setOf(
//                QuestionDetailsDomain(
//                    QuestionWeightDomain(questionWeight),
//                    QuestionSelectedDomain(questionIsSelected)
//                )
//            )
//        )
//
//        val expected = listOf(
//            QuestionsModel(
//                QuestionCategoryModel(questionCategory),
//                QuestionIdModel(questionId),
//                QuestionWeightModel(questionWeight),
//                QuestionSelectedModel(questionIsSelected)
//            )
//        )
//
//        //WHEN
//        val result = mapper.toModel(domain)
//
//        //THEN
//        assertEquals(expected, result)
//    }
}