package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //var diceImage : ImageView? = null
    //lateinit keyword promises the Kotlin compiler that the variable will be initialized before the code calls any operations on it
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener{ reset() }

        /*val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener{ countUp() }

        */

    }

    private fun rollDice() {
        //val randomInt = (1..6).random()
        /*Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()*/

        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())

    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun reset() {

        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)

    }

    /*private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text.toString() =="Hello World"){
            resultText.text = "1"
        }else {
            var textNumber = resultText.text.toString().toInt()

            if (textNumber < 6) {
                textNumber++
                resultText.text = textNumber.toString()
            }
        }
    }
    */

}