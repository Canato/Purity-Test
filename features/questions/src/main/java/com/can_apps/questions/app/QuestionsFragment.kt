package com.can_apps.questions.app

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            recyclerView.adapter = recyclerViewAdapter
        }

        actionButton.setOnClickListener {
            presenter.fetchNextCategoryQuestions()
        }

        presenter.onViewCreated()
    }

    private fun setOnBackPressedCallback() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, true) {
            findNavController().navigateUp()
        }
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

    // todo put in common module
    override fun showError(message: String) {
        view?.let {
            val snackbar = Snackbar.make(it, message, Snackbar.LENGTH_LONG)

            snackbar.setActionTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.design_default_color_primary
                )
            )

            val snackbarView = snackbar.view
            val textView = snackbarView.findViewById<TextView>(R.id.snackbar_text)

            textView?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
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

    // show = visible/invisible/gone. Change to set/setup
    override fun showCategory(category: String) {
        categoryView.text = category
    }

    override fun setNewActionButtonFunction() {
        actionButton.text = getString(R.string.action_button_finish)
    }

    override fun goToResultScreen(score: List<QuestionsModelDetails>) {
        TODO("fun will start new fragment and send score in bundle of models")
    }
}
