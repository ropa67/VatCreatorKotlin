package com.example.vatcreatorkotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import android.content.Intent







class Main2Activity : AppCompatActivity() {

    var realPrice: Double = 0.0
    var savedMoney: Double = 0.0
    private lateinit var toCalcuIncome2: String
    var savedOnVat: Double = 0.0
    lateinit var savedOnIncome2: String



    @SuppressLint("RestrictedApi", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val actionbar = supportActionBar
        actionbar!!.title = "New Activity"
        actionbar.setDisplayShowHomeEnabled(true)
        actionbar.setDisplayShowHomeEnabled(true)


        val price = intent.extras?.getDouble("price_key") ?: 0.0
        priceAddeded_tv.text =  getString(R.string.price_added_text,price)


        savedOnVat = when(intent.extras?.getInt("vat")){
            23 -> ( price - (price /1.23))
            8 -> (price - (price /1.08))
            0 -> (price *0)
            11,5 -> (( price - (price /1.23))/2)
            4 -> (( price - (price /1.08))/2)
            else -> -1.0
        }

        savedOn_vat.text = getString(R.string.saved_on_vat,savedOnVat)

        toCalcuIncome2 = (price-savedOnVat).toString()
        toCalcuIncome.text = getString(R.string.to_calcume_income,toCalcuIncome2.toDouble())


        savedOnIncome2 = when(intent.extras?.getInt("doch")){
            18 -> (toCalcuIncome2.toDouble()*0.18).toString()
            19 -> (toCalcuIncome2.toDouble()*0.19).toString()
            32 -> (toCalcuIncome2.toDouble()*0.32).toString()
            else -> "Error"
        }
        savedOnIncome.text = getString(R.string.saved_on_income,savedOnIncome2.toDouble())
        realPrice = price- savedOnIncome2.toDouble() - savedOnVat
        realPriceProduct.text = getString(R.string.real_price,realPrice)
        savedMoney = price - realPrice
        howMuch_tv.text = getString(R.string.saved_money,savedMoney)



        resetButton.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()

        }

    }




    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }


    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()


    }
}




