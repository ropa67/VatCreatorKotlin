package com.example.vatcreatorkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        const val CALC_RESULT = 1234
    }

    private val vatValues = arrayOf(23, 8, 0) ////23 , 8 , 0 - > 0 , 1, 2
    private val incomeValues = arrayOf(18, 19, 32)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vat_spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vatValues.map { "$it%" })
        incomeSpinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, incomeValues.map { "$it%" })





        switchVat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) vat_spinner.setSelection(2)
            else vat_spinner.setSelection(0)
        }


        nextActivity.setOnClickListener {
            when {
                price_et.text.isEmpty() -> {
                    price_et.text.toString().replace(" ", "")
                    price_et.error = getString(R.string.price_error_text)
                }
                price_et.text.toString().startsWith(".") -> price_et.error = getString(R.string.price_error_text)
                else -> startActivityForResult(
                    Intent(this, Main2Activity::class.java).apply {
                        putExtras(
                            Bundle().apply {
                                putDouble("price_key", price_et.text.toString().toDouble())
                                putInt("vat", vatValues[vat_spinner.selectedItemPosition])
                                putBoolean("tax", switchVat.isChecked)
                                putInt("doch", incomeValues[incomeSpinner.selectedItemPosition])
                            }
                        )

                    }, CALC_RESULT
                )


            }
        }


    }





    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CALC_RESULT) {
            if (resultCode == Activity.RESULT_OK) {
                clearAllData()
            }
        }
    }

    private fun clearAllData() {
        price_et.setText("")
        vat_spinner.setSelection(0)
        incomeSpinner.setSelection(0)
        switchVat.isChecked = false
        switchCar.isChecked = false
    }
}




