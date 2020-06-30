package com.can_apps.questions.data

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.core.*
import com.can_apps.questions.data.questions_data_source.QuestionsDto
import com.can_apps.questions.data.questions_data_source.QuestionsDtoMapperDefault
import com.can_apps.questions_data_source.data.Question
import com.can_apps.questions_data_source.data.QuestionsDataSourceDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class QuestionsDtoMapperDefaultTest {

    @MockK
    private lateinit var stringResource: CommonStringResourceWrapper

    @InjectMockKs
    private lateinit var dto: QuestionsDtoMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN questions_dto_valid, WHEN dto_toDomain, THEN return questionsdomain_valid`() {
        //GIVEN
        val questionId = mockk<Int>(relaxed = true)
        val questionWeight = mockk<Int>(relaxed = true)
        val questionSelected =  mockk<Boolean>(relaxed = true)
        val questionSet = setOf(Question(questionId,questionWeight))
        val questionCategoryName = "some fancy category"
        val questionDataSourceSet = setOf(QuestionsDataSourceDto(questionCategoryName, questionSet))
        val questionsDto = QuestionsDto.Valid(questionDataSourceSet)

        val questionDetailsDomain = QuestionDetailsDomain(
            QuestionCategoryDomain(questionCategoryName),
            QuestionIdDomain(questionId),
            QuestionWeightDomain(questionWeight),
            QuestionSelectedDomain(questionSelected)
        )

        val questionDomainSet = setOf(questionDetailsDomain)
        val expected = QuestionsDomain.Valid(questionDomainSet)


        //WHEN
        val result = dto.dtoToDomain(questionsDto)

        //THEN
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN questions_dto_invalid, WHEN dto_toDomain, THEN return questionsdomain_error`() {
        //GIVEN
        val message = "iOS sucks"
        val questionsDto = QuestionsDto.Invalid
        val questionErrorDomain = QuestionErrorDomain(message)
        val expected = QuestionsDomain.Error(questionErrorDomain)

        coEvery { stringResource.getString(R.string.questions_dto_error) } returns message

        //WHEN
        val result = dto.dtoToDomain(questionsDto)

        //THEN
        assertEquals(expected, result)
    }
}