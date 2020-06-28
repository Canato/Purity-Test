package com.can_apps.questions.data.questions_data_source

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.core.*
import com.can_apps.questions.core.QuestionDetailsDomain
import com.can_apps.questions.core.QuestionDomain
import com.can_apps.questions.core.QuestionIdDomain
import com.can_apps.questions.core.QuestionWeightDomain
import com.can_apps.questions.core.QuestionsDomain


internal interface QuestionsDtoMapper {
    fun dtoToDomain(dto: QuestionsDto): QuestionsDomain
}

internal class QuestionsDtoMapperDefault(
    private val stringResource: CommonStringResourceWrapper
) :
    QuestionsDtoMapper {

    override fun dtoToDomain(dto: QuestionsDto): QuestionsDomain =
        when (dto) {
            is QuestionsDto.Invalid -> QuestionsDomain.Error(stringResource.getString(R.string.questions_dto_error))
            is QuestionsDto.Valid -> mapDomain(dto)
        }


    private fun mapDomain(dto: QuestionsDto.Valid): QuestionsDomain.Valid {
        val set = mutableSetOf<QuestionDetailsDomain>()
        dto.questions.forEach { questionsDataSourceDto ->
            questionsDataSourceDto.questions.forEach { question ->
            set.add(
                QuestionDetailsDomain(
                QuestionIdDomain(0u),
                    QuestionDomain(question.id.toString()),
                   false,
                    QuestionWeightDomain(question.weight),
                    QuestionCategoryDomain(questionsDataSourceDto.categoryName)
                ))
                }
        }

        return QuestionsDomain.Valid(set.toSet())
    }
}
