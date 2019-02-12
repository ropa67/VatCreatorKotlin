package com.example.vatcreatorkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val vatValues = arrayOf(23, 8, 0)
    private val dochValues = arrayOf(18, 19, 32)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nextActivity.setOnClickListener {
            startActivity(
                Intent(this, Main2Activity::class.java).apply {
                putExtras(
                    Bundle().apply {
                        putString("price_key", price_et.text.toString())
                        putInt("vat",vatValues[vat_spinner.selectedItemPosition])
                        putInt("doch", dochValues[dochodowySpinner.selectedItemPosition])
                    }
                )
            }
            )
        }


//        val spinerVAT = arrayOf("-Wybierz-", "23%", "8%", "0% - Rachunek bez VAT")
//        val spinerDoch = arrayOf("-Wybierz-", "18% - zasady ogólne", "19% - liniowy", "32% - drugi próg")
//        val tak_nieVatSpinner = arrayOf("-Wybierz-", "Tak", "Nie")
//        val tak_nieVatSam = arrayOf("-Wybierz-", "Tak", "Nie")
//

        val tak_nieVatSpinner = arrayOf("-Wybierz-", "Tak", "Nie")
        val tak_nieVatSam = arrayOf("-Wybierz-", "Tak", "Nie")


        vat_spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vatValues.map {"$it%"})
        dochodowySpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dochValues.map { "$it%" })
        tak_nieVat.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tak_nieVatSpinner)
        SamochódTak_Nie.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tak_nieVatSam)




        dochodowySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    }

                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    }
                }

        vat_spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    }

                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    }
                }
    }


}
