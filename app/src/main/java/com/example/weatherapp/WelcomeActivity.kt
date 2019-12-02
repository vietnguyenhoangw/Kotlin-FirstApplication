package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {

    var btnSetName : Button ?= null
    var tvUserName : TextView ?= null
    var edtUserName : EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        createWidget()
        tvUserName?.visibility = INVISIBLE

        btnSetName?.setOnClickListener(View.OnClickListener { setName() })
    }

    private fun createWidget() {
        btnSetName = findViewById(R.id.btnSetName)
        tvUserName = findViewById(R.id.tvUserName)
        edtUserName = findViewById(R.id.edtUserName)
    }

    private fun setName() {
        if (edtUserName?.length() == 0) {
            tvUserName?.visibility = INVISIBLE
            Toast.makeText(this, "Please enter ur name", Toast.LENGTH_SHORT).show()
        }
        else {
            tvUserName?.visibility = VISIBLE

            val str: String = edtUserName?.text.toString()
            tvUserName?.setText("Hello $str")
        }

    }

    fun openMain(view : View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
