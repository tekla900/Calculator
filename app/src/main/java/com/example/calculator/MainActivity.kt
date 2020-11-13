package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)


    }

    fun numberClick(view: View){

        if (view is TextView){

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result+number

        }


    }
    fun operationClick(view: View) {

        if (view is TextView) {

            if(TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }

            this.operation = view.text.toString()

            resultTextView.text = ""
        }

    }
    fun equalsClick(view: View){

        val secOpeadnText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secOpeadnText)) {

            secOperand = secOpeadnText.toDouble()

        }

       when (operation) {
           "+" -> resultTextView.text = (operand + secOperand).toString()
           "-" -> resultTextView.text = (operand - secOperand).toString()
           "*" -> resultTextView.text = (operand * secOperand).toString()
           "/" -> resultTextView.text = (operand / secOperand).toString()


       }

    }

    fun deleteClick(view: View) {

        resultTextView.text = (resultTextView.text).toString().dropLast(1)

    }

    fun clearClick(view: View) {

        resultTextView.text = ""

    }

    fun dotClick(view: View) {

        resultTextView = resultTextView.text.toString() + "." + view.toString()

    }



}