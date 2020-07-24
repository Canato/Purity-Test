package com.can_apps.questions.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.bresenter.QuestionsModelDetails

internal class QuestionItemViewHolder(
    val containerView: View,
    val listener: QuestionsRecyclerViewAdapter.Listener
) : RecyclerView.ViewHolder(containerView) {

    fun bindView(model: QuestionsModelDetails) {

//        containerView.question.text = "stringResourceWrapper.getString(${QuestionIdModelEnum.value})"
//        questionItem.setOnClickListener {
//            listener.onItemSelected(model.questionId)
//        }
    }
}
