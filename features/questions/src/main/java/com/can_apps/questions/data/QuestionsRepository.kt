package com.can_apps.questions.data

import com.can_apps.questions.core.QuestionsContract
import com.can_apps.questions.core.QuestionsDomain

internal class QuestionsRepository : QuestionsContract.Repository {

    override suspend fun retrieveList(): QuestionsDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}