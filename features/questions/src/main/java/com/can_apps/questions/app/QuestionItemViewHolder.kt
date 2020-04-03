package com.can_apps.questions.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionsModel
import kotlinx.android.extensions.LayoutContainer

internal class QuestionItemViewHolder(
    override val containerView: View,
    val listener: QuestionsRecyclerViewAdapter.Listener
) : RecyclerView.ViewHolder(containerView), LayoutContainer {


    fun bindView(model: QuestionsModel) {
        question.text = model.question.value

        questionItem.setOnClickListener {
            listener.onItemSelected(model.questionId)
        }
    }
}



