package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName : MyName = MyName(("Alexis H"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname()
        }
    }

    private fun addNickname(view: View) {

        /*val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE*/
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        binding. apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname () {
       // val editText = findViewById<EditText>(R.id.nickname_edit)
        //val doneButton = findViewById<Button>(R.id.done_button)

        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.GONE

        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}