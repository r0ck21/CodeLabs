package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var boxOneText : TextView
    lateinit var boxTwoText : TextView
    lateinit var boxThreeText : TextView
    lateinit var boxFourText : TextView
    lateinit var boxFiveText : TextView
    lateinit var rootConstraintLayout : View
    lateinit var redButton : Button
    lateinit var greenButton : Button
    lateinit var yellowButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

    }

    private fun setListeners() {

        boxOneText = findViewById<TextView>(R.id.box_one_text)
        boxTwoText = findViewById<TextView>(R.id.box_two_text)
        boxThreeText = findViewById<TextView>(R.id.box_three_text)
        boxFourText = findViewById<TextView>(R.id.box_four_text)
        boxFiveText = findViewById<TextView>(R.id.box_five_text)
        rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        redButton = findViewById<Button>(R.id.red_button)
        greenButton = findViewById<Button>(R.id.green_button)
        yellowButton = findViewById<Button>(R.id.yellow_button)


        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout, redButton, greenButton, yellowButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }

    }


    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for the background
            boxOneText.id -> view.setBackgroundColor(Color.DKGRAY)
            boxTwoText.id -> view.setBackgroundColor(Color.GRAY)
            boxThreeText.id -> view.setBackgroundColor(Color.BLUE)
            boxFourText.id -> view.setBackgroundColor(Color.MAGENTA)
            boxFiveText.id -> view.setBackgroundColor(Color.BLUE)
            redButton.id -> boxThreeText.setBackgroundResource(R.color.my_red)
            yellowButton.id -> boxFourText.setBackgroundResource(R.color.my_yellow)
            greenButton.id -> boxFiveText.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)

        }


    }

}