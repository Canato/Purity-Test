package com.can_apps.questions.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.bresenter.QuestionsModelDetails
import kotlinx.android.synthetic.main.fragment_questions.view.*
import kotlinx.android.synthetic.main.item_question_item.view.*

internal class QuestionItemViewHolder(
    private val containerView: View,
    private val listener: QuestionsRecyclerViewAdapter.Listener
) : RecyclerView.ViewHolder(containerView) {

    fun bindView(model: QuestionsModelDetails) {

        containerView.question.text = model.questionText.value
        containerView.questionItem.setOnClickListener {
            listener.onItemSelected(model.questionId)
        }
    }
}
