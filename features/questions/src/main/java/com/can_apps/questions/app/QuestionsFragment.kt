package com.can_apps.questions.app

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.bresenter.QuestionsModelDetails
import com.can_apps.questions.core.QuestionsContract
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_questions.*

internal class QuestionsFragment :
    Fragment(R.layout.fragment_questions),
    QuestionsRecyclerViewAdapter.Listener,
    QuestionsContract.View {

    companion object {
        fun newInstance(): Fragment = QuestionsFragment()
    }

    private lateinit var presenter: QuestionsContract.Presenter
    private lateinit var recyclerViewAdapter: QuestionsRecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val serviceLocator = QuestionsServiceLocator(context)
        presenter = serviceLocator.getPresenter()
        recyclerViewAdapter = serviceLocator.getRecyclerViewAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.bind(this)
        setOnBackPressedCallback()
        presenter.onViewCreated()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            recyclerView.adapter = recyclerViewAdapter
        }
        actionButton.setOnClickListener {
            presenter.fetchNextCategoryList()
        }
    }

    private fun setOnBackPressedCallback() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                presenter.onBackPressed()
            }
        })
    }

    override fun onItemSelected(questionId: QuestionIdModelEnum) {
        Toast.makeText(requireContext(), questionId.name, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressView.visibility = View.GONE
    }

    override fun showList(model: List<QuestionsModelDetails>) {
        recyclerViewAdapter.updateList(model)
    }

    override fun showError(message: String) {
        view?.let {
            val snackbar = Snackbar.make(it, message, Snackbar.LENGTH_LONG)

            snackbar.setActionTextColor(
                ContextCompat.getColor(
                    context!!,
                    R.color.design_default_color_primary
                )
            )

            val snackbarView = snackbar.view
            val textView = snackbarView.findViewById<TextView>(R.id.snackbar_text)

            textView?.setTextColor(
                ContextCompat.getColor(
                    context!!,
                    R.color.design_default_color_error
                )
            )
            snackbarView.setBackgroundColor(Color.BLACK)

            snackbar.show()
        }
    }

    override fun close() {
        activity?.finish()
    }

    override fun showCategory(category: String) {
        categoryView.text = category
    }

    override fun updateActionButtonFunction() {
        actionButton.text = getString(R.string.action_button_finish)
        actionButton.setOnClickListener {
            presenter.onBackPressed()
        }
    }
}
