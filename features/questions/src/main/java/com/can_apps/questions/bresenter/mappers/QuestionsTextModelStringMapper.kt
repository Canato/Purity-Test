package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionTextModel

internal interface QuestionsTextModelStringMapper {

    fun mapDrugsEnumToString(id: QuestionIdModelEnum): QuestionTextModel
    fun mapSexEnumToString(id: QuestionIdModelEnum): QuestionTextModel
    fun mapReligionEnumToString(id: QuestionIdModelEnum): QuestionTextModel
}

internal class QuestionsTextModelStringMapperDefault(private val stringResource: CommonStringResourceWrapper) :
    QuestionsTextModelStringMapper {
    override fun mapDrugsEnumToString(id: QuestionIdModelEnum): QuestionTextModel {
        TODO("Not yet implemented")
    }

    override fun mapSexEnumToString(id: QuestionIdModelEnum): QuestionTextModel {
        TODO("Not yet implemented")
    }

    override fun mapReligionEnumToString(id: QuestionIdModelEnum): QuestionTextModel {
        TODO("Not yet implemented")
    }
}
