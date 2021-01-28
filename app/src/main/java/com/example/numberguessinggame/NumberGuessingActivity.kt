package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number_guessing.*
import kotlin.random.Random


class NumberGuessingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guessing)
        var randomNum = randomNumber()
        checkButton.setOnClickListener {
            val enteredNumber = numberGuessingEditText.text.toString()
            if (randomNum > Integer.parseInt(enteredNumber)){
                Toast.makeText(this, "Enter Higher Number", Toast.LENGTH_SHORT).show()
            }
            else if (randomNum < Integer.parseInt(enteredNumber)){
                Toast.makeText(this, "Enter The Lower Number", Toast.LENGTH_SHORT).show()
            }
            else if (enteredNumber.isEmpty()){
                Toast.makeText(this, "Please Fill Field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                Toast.makeText(this, "Great, You Found The Number", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun randomNumber() :Int{
        return Random.nextInt(1000)
    }
}
