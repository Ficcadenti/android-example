package com.example.kotlin.calcolatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        Toast.makeText(this,"Numero premuto", Toast.LENGTH_LONG).show();
    }

    fun onOperator(view: View) {
        Toast.makeText(this,"Operazione premuta", Toast.LENGTH_LONG).show();
    }

    fun onPunto(view: View) {
        Toast.makeText(this,"Punto premut0", Toast.LENGTH_LONG).show();
    }

    fun onClear(view: View) {
        Toast.makeText(this,"Clear premuto", Toast.LENGTH_LONG).show();
    }
}