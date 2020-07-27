package com.can_apps.questions.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.can_apps.questions.R

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_questions, QuestionsFragment()).commit()
    }
}
