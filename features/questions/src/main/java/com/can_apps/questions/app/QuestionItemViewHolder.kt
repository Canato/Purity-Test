package com.can_apps.questions.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.bresenter.QuestionsModel

internal class QuestionItemViewHolder(
    val containerView: View,
    val listener: QuestionsRecyclerViewAdapter.Listener
) : RecyclerView.ViewHolder(containerView) {

    fun bindView(model: QuestionsModel) {
//        containerView.question.text = "stringResourceWrapper.getString(${QuestionIdModelEnum.value})"
//        questionItem.setOnClickListener {
//            listener.onItemSelected(model.questionId)
//        }
    }
}
