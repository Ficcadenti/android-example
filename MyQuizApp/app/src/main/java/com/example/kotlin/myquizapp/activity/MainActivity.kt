package com.example.kotlin.myquizapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.kotlin.myquizapp.R

class MainActivity : AppCompatActivity() {
    private var btnStart: Button?=null;
    private var etName: AppCompatEditText?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)
        etName  = findViewById(R.id.et_name)

        btnStart?.setOnClickListener {
            if (etName?.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
            }

        }
    }
}