package com.example.kotlin.calcolatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private  var calcLed:TextView? = null;

    var lastNumeric: Boolean = true
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inizializzo i componenti della calcolatrice
        calcLed=findViewById(R.id.calcLed)
    }

    fun onDigit(view: View){
        calcLed?.append((view as Button).text)
        lastNumeric = true
    }

    fun onOperator(view: View) {
        calcLed?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                calcLed?.append((view as Button).text)
                lastNumeric = false // Update the flag
                lastDot = false    // Reset the DOT flag
            }
        }
    }

    fun onPunto(view: View) {
        if (lastNumeric && !lastDot) {
            calcLed?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onClear(view: View) {
        calcLed?.text=""
        lastNumeric = true
        lastDot = false
    }

    fun onEqual(view: View) {

        if (lastNumeric) {
            var tvValue = calcLed?.text.toString()
            var prefix = ""
            try {


                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1);
                }

                when {
                    tvValue.contains("/") -> {

                        val splitedValue = tvValue.split("/")

                        var one = splitedValue[0]
                        val two = splitedValue[1]

                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }


                        calcLed?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                    }
                    tvValue.contains("*") -> {

                        val splitedValue = tvValue.split("*")

                        var one = splitedValue[0]
                        val two = splitedValue[1]

                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }

                        calcLed?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                    }
                    tvValue.contains("-") -> {


                        val splitedValue = tvValue.split("-")

                        var one = splitedValue[0] // Value One
                        val two = splitedValue[1] // Value Two

                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }


                        calcLed?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                    }
                    tvValue.contains("+") -> {

                        val splitedValue = tvValue.split("+")

                        var one = splitedValue[0]
                        val two = splitedValue[1]

                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }


                        calcLed?.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                    }
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }
    private fun removeZeroAfterDot(result: String): String {

        var value = result

        if (result.contains(".0")) {
            value = result.substring(0, result.length - 2)
        }

        return value
    }


    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            (value.contains("/")
                    || value.contains("*")
                    || value.contains("-")
                    || value.contains("+"))
        }
    }
}