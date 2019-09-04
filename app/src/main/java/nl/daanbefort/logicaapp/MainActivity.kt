package nl.daanbefort.logicaapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val allAnswers : Array<String> = arrayOf("T","F","F","F")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConfirm.setOnClickListener{
            updateUI()
        }
    }

    private fun updateUI(){
        checkAnswer(0, inpQuestionOne)
        checkAnswer(1, inpQuestionTwo)
        checkAnswer(2, inpQuestionThree)
        checkAnswer(3, inpQuestionFour)
    }

    private fun checkAnswer(questionNumber: Int, inputFromUser: EditText){
        val answer = inputFromUser.text.toString()

        if (!isInputCorrect(answer)){
            Toast.makeText(this, getString(R.string.input_not_correct), Toast.LENGTH_SHORT).show()
        }

        if(allAnswers[questionNumber] != answer) {
            inputFromUser.setTextColor(Color.RED)
        } else {
            inputFromUser.setTextColor(Color.GREEN)
        }
    }

    private fun isInputCorrect(input :String): Boolean {
        return !input.isNullOrEmpty() && input.isDigitsOnly()
    }
}
