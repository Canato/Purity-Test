package com.can_apps.questions.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionsModelDetails

internal class QuestionsRecyclerViewAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<QuestionItemViewHolder>() {

    interface Listener {
        fun onItemSelected(questionId: QuestionIdModelEnum)
    }

    private var questions = emptyList<QuestionsModelDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionItemViewHolder =
        QuestionItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_question_item, parent, false),
            listener
        )

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: QuestionItemViewHolder, position: Int) {
        holder.bindView(questions[position])
    }

    fun updateList(model: List<QuestionsModelDetails>) {
        questions = model
        notifyDataSetChanged()
    }
}
