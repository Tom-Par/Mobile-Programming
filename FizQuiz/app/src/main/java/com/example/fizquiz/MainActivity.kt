package com.example.fizquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

object ListQuestions{
    val questions: List<Question>
        get() = listOf(
            Question("Czy Programowanie urządzeń moblilnych to najlepszy przedmiot?",true),
            Question("Czy słońce to planeta?",false),
            Question("Czy astronauci skakali po Księżycu?",true),
            Question("Czy amper to jednostka natężenia prądu?",true),
            Question("Czy atom jest mniejszy od protonu?",false),
            Question("Czy wszystkie kąty w kwadracie są proste?",true),
            Question("Czy Zero absolutne to najniższa z osiągniętych dotąd temperatur?",false),
            Question("Czy metr w układzie SI jest oznaczony literą 'm'?",true),
            Question("Czy kilogram ma 1000 gram?",true),
            Question("Czy Księżyc to satelita Ziemi?",true)
        )
}

class Question(
    val question: String,
    val correctAnswer: Boolean
)

class MainActivity : AppCompatActivity(){

    private var position = 0
    private var answerCount = 0
    private var points = 0
    private var cheatCount = 0

    private val questions: List<Question> = ListQuestions.questions
    private var question = questions[position]

    private val urlGoogle = "https://www.google.com/search?q="
    private val questionText: TextView by lazy { findViewById(R.id.textQuestion) }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
        {
            position = savedInstanceState.getInt("position")
            points = savedInstanceState.getInt("points")
            cheatCount = savedInstanceState.getInt("cheatCount")
            answerCount = savedInstanceState.getInt("answerCount")

        }
        setQuestion()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putInt("points", points)
        outState.putInt("currentPosition", position)
        outState.putInt("cheats", cheatCount)
        outState.putInt("rightAns", answerCount)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    private fun setQuestion(){
        if(position < questions.size)
        {
            question = questions[position]
            questionText.text = question.question
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showResults(){
        val trueBut: Button by lazy { findViewById(R.id.button)}
        trueBut.isVisible = false
        val falseBut: Button by lazy { findViewById(R.id.button1)}
        falseBut.isVisible = false
        val cheatBut: Button by lazy { findViewById(R.id.button2)}
        cheatBut.isVisible = false
        questionText.text = "Wynik: $points\n Poprawne odpowiedzi: $answerCount\n Oszustwa: $cheatCount"
    }

    fun buttonClickAnswer(view: android.view.View) {
        if(question.correctAnswer == (view as Button).text.toString().toBoolean())
        {
            points += 10
            println(points)
            answerCount++
        }
        position++
        if(position < questions.size) {

            setQuestion()
        }
        else showResults()
    }

    fun buttonClickCheat(view: android.view.View) {
        val intent = Intent(this, CheatActivity::class.java).apply {}
        startActivity(intent)
        points -= 15
        cheatCount++
        if(position < questions.size)
        {
            position++
            setQuestion()
        }
        else showResults()
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun clickQuestion(view: android.view.View) {
        val urlSearch = urlGoogle + question.question.replace(" ", "+")
        val intentSearch = Intent(Intent.ACTION_VIEW, Uri.parse(urlSearch)).apply {
            addCategory(CATEGORY_BROWSABLE)
        }

        if (intent.resolveActivity(packageManager) != null)
        {
            startActivity(intentSearch)
        }
    }

}