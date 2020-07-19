package com.can_apps.questions.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionsModel
import kotlinx.android.synthetic.main.item_question_item.view.*

internal class QuestionItemViewHolder(
    val containerView: View,
    val listener: QuestionsRecyclerViewAdapter.Listener,
    val stringResourceWrapper: CommonStringResourceWrapper
) : RecyclerView.ViewHolder(containerView) {

    fun bindView(model: QuestionsModel) {
//        containerView.question.text = "stringResourceWrapper.getString(${QuestionIdModelEnum.value})"
//        questionItem.setOnClickListener {
//            listener.onItemSelected(model.questionId)
//        }
    }
}



