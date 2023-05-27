package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var addnickname : Button
    lateinit var nicknameedittext : EditText
    lateinit var showtext : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addnickname = findViewById(R.id.addtext)
        addnickname.setOnClickListener {
            addNickName(it)  // it is context to pass the reference
        }
    }

    private fun addNickName(view : View) {
        nicknameedittext = findViewById(R.id.enternickname)
        showtext = findViewById(R.id.ShowText)


        showtext.text = nicknameedittext.text
        nicknameedittext.visibility = View.GONE
        view.visibility = View.GONE
        showtext.visibility = View.VISIBLE

        // hide Input using System Service
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}