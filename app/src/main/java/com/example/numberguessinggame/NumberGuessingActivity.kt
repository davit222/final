package com.example.numberguessinggame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_number_guessing.*
import kotlin.random.Random


class NumberGuessingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var attempts: Int = 1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guessing)
        val randomNum = randomNumber()
        checkButton.setOnClickListener {
            val enteredNumber = numberGuessingEditText.text.toString()
            if (randomNum > Integer.parseInt(enteredNumber)){
                Toast.makeText(this, "Enter Higher Number", Toast.LENGTH_SHORT).show()
                attempts++
            }
            else if (randomNum < Integer.parseInt(enteredNumber)){
                Toast.makeText(this, "Enter The Lower Number", Toast.LENGTH_SHORT).show()
                attempts++
            }
            else if (enteredNumber.isEmpty()){
                Toast.makeText(this, "Please Fill Field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                Toast.makeText(
                    this,
                    "Great, You Found The Number In $attempts Attemps", Toast.LENGTH_SHORT).show()
                    Intent(this, NumberGuessingActivity::class.java)
                    startActivity(intent)

            }
        }
    }
    fun randomNumber() :Int{
        return Random.nextInt(1000)
    }
}
