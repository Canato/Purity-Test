package com.can_apps.questions.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModel
import com.can_apps.questions.bresenter.QuestionsModel

internal class QuestionsRecyclerViewAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Listener {
        fun onItemSelected(questionId: QuestionIdModel)
    }

    private var questions = emptyList<QuestionsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        QuestionItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_question_item,
                parent,
                false
            ),
            listener
        )

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        questions[position].let { (holder as QuestionItemViewHolder).bindView(it) }
    }

    fun updateList(model: List<QuestionsModel>) {
        questions = model
    }
}
