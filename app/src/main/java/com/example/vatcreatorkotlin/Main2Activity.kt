package com.example.vatcreatorkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    lateinit var podanaCena: TextView
    lateinit var doObliczeniaDochodo: String
    var podanacena3: Double = 0.0



    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val actionbar = supportActionBar
        actionbar!!.title = "New Activity"
        actionbar.setDisplayShowHomeEnabled(true)
        actionbar.setDisplayShowHomeEnabled(true)


        val price = intent.extras?.getString("price_key") ?: "Brak ceny"
        podanaCenaTV.text = price


        zaoszczedzonaNaVAT.text = when(intent.extras?.getInt("vat")){
            23 -> ((price.toDouble()/1.23) - price.toDouble()).toString()
            8 -> ((price.toDouble()/1.08) - price.toDouble()).toString()
            0 -> (price.toDouble()*0).toString()
            else -> "Error"
        }


       doObliczeniaDochodo = (price.toDouble() - zaoszczedzonaNaVAT.text.toString().toDouble()).toString()

        zaoszczędzonaNaDochodo.text = when(intent.extras?.getInt("doch")){
            18 -> (price.toDouble() - (doObliczeniaDochodo.toString().toDouble()*0.18)).toString()
            19 -> (doObliczeniaDochodo.toDouble()*0.19).toString()
            32 -> (doObliczeniaDochodo.toDouble()*0.32).toString()
            else -> "Error"

        }







    }
    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()

        return true
    }
}
