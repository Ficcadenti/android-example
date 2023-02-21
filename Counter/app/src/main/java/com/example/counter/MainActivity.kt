package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBtn1 = findViewById<Button>(R.id.idBtn1)
        val txtTxt1 = findViewById<TextView>(R.id.idTxt1)
        var counter :Int = 0;

        txtTxt1.text=counter.toString()

        btnBtn1.setOnClickListener {
            counter++
            txtTxt1.text="Persone: ${counter.toString()}"
            Toast.makeText(this,"Sono un toaST !!!",Toast.LENGTH_LONG).show()
        }
    }
}