package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBtn1 = findViewById<Button>(R.id.idBtn1)
        btnBtn1.setOnClickListener {
            btnBtn1.text="Ciao !!!!!"
        }
    }
}