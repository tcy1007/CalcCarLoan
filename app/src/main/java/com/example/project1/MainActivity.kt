package com.example.project1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.submit).setOnClickListener {
            calcCarLoan(it)
        }



    }

    private fun calcCarLoan(view : View){
        val carPrice = findViewById<EditText>(R.id.carPrice_price)
        val downPayment = findViewById<EditText>(R.id.downPayment_price)
        val loanPayment = findViewById<EditText>(R.id.loan_price)
        val interestPayment = findViewById<EditText>(R.id.interest_price)

        val carPriceStr = carPrice.text.toString()
        val downPaymentStr = downPayment.text.toString()
        val loanPaymentStr = loanPayment.text.toString()
        val interestRateStr = interestPayment.text.toString()

        val carLoan:Double = carPriceStr.toDouble() - downPaymentStr.toDouble()
        val interest:Double = loanPaymentStr.toDouble() * (interestRateStr.toDouble() /100) * 10
        val monthly:Double = (carLoan+interest)/10/12

        val carLoanStr = findViewById<TextView>(R.id.carLoan_price)
        carLoanStr.text = carLoan.toString()

        val carInterest = findViewById<TextView>(R.id.carInterest_price)
        carInterest.text = interest.toString()

        val carPayment = findViewById<TextView>(R.id.carMonthly_price)
        carPayment.text = monthly.toString()

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}

