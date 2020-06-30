package com.can_apps.questions.data.questions_data_source

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.core.*


internal interface QuestionsDtoMapper {
    fun dtoToDomain(dto: QuestionsDto): QuestionsDomain
}

internal class QuestionsDtoMapperDefault(
    private val stringResource: CommonStringResourceWrapper
) :
    QuestionsDtoMapper {

    override fun dtoToDomain(dto: QuestionsDto): QuestionsDomain =
        when (dto) {
            is QuestionsDto.Invalid -> QuestionsDomain.Error(QuestionErrorDomain(stringResource.getString(R.string.questions_dto_error)))
            is QuestionsDto.Valid -> mapDomain(dto)
        }


    private fun mapDomain(dto: QuestionsDto.Valid): QuestionsDomain.Valid {
        val set = mutableSetOf<QuestionDetailsDomain>()
        dto.questions.forEach { questionsDataSourceDto ->
            questionsDataSourceDto.questions.forEach { question ->
                set.add(
                    QuestionDetailsDomain(
                        QuestionCategoryDomain(questionsDataSourceDto.categoryName),
                        QuestionIdDomain(question.id),
                        QuestionWeightDomain(question.weight),
                        QuestionSelectedDomain(false)
                    )
                )
            }
        }

        return QuestionsDomain.Valid(set.toSet())
    }
}
