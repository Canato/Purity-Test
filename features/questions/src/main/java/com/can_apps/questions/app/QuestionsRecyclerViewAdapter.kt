package com.can_apps.questions.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModel
import com.can_apps.questions.bresenter.QuestionsModel

internal class QuestionsRecyclerViewAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<QuestionItemViewHolder>() {

    interface Listener {
        fun onItemSelected(questionId: QuestionIdModel)
    }

    private var questions = emptyList<QuestionsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionItemViewHolder =
        QuestionItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_question_item,
                parent,
                false
            ),
            listener,
            CommonStringResourceWrapper(parent.context)
        )

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: QuestionItemViewHolder, position: Int) {
        holder.bindView(questions[position])
    }

    fun updateList(model: List<QuestionsModel>) {
        questions = model
        notifyDataSetChanged()
    }
}
