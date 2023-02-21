package com.example.kotlin.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var txtSelectedDate:TextView? = null;
    private var txtYourAgeInMinutes:TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSelectDate:Button = findViewById(R.id.btnSelectDate)
        txtSelectedDate = findViewById(R.id.txtSelectedDate)
        txtYourAgeInMinutes = findViewById(R.id.txtYourAgeInMinutes)

        btnSelectDate.setOnClickListener{
            clickSelectDate()
        }
    }

    private fun clickSelectDate() {


        val myCalendar:Calendar=Calendar.getInstance()
        val anno=myCalendar.get(Calendar.YEAR)
        val mese=myCalendar.get(Calendar.MONTH)
        val giorno=myCalendar.get(Calendar.DAY_OF_MONTH)



        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{_,selectedAnno,selectedMese,selectedGiorno ->
            val strData=String.format("%02d/%02d/%04d", selectedGiorno,selectedMese+1,selectedAnno)
            Toast.makeText(this,"${strData}",Toast.LENGTH_LONG).show()

            txtSelectedDate?.text=strData

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(strData)

            theDate?.let{
                val selectedDateInMinutes=theDate.time/60000
                val currentTime=sdf.parse(sdf.format(System.currentTimeMillis()))
                currentTime?.let{
                    val currentTimeInMinutes=currentTime.time/60000
                    val differenzaInMinuti:Long=currentTimeInMinutes-selectedDateInMinutes;

                    Log.i("RAFFO","theDate=${theDate}")
                    Log.i("RAFFO","currentTime=${currentTime}")


                    Log.i("RAFFO","selectedDateInMinutes  = ${selectedDateInMinutes}")
                    Log.i("RAFFO","currentTimeInMinutes   = ${currentTimeInMinutes}")
                    Log.i("RAFFO","differenzaInMinuti     = ${differenzaInMinuti}")

                    txtYourAgeInMinutes?.text=differenzaInMinuti.toString()
                }

            }

        },anno, mese, giorno);

        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()
    }
}