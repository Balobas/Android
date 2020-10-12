package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    enum class Operations {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener     {calculate(Operations.PLUS) }
        btn_minus.setOnClickListener    { calculate(Operations.MINUS) }
        btn_multiply.setOnClickListener { calculate(Operations.MULTIPLY) }
        btn_divide.setOnClickListener   { calculate(Operations.DIVIDE) }
        btn_clear.setOnClickListener    { first_view.setText(""); second_view.setText("")}
    }

    private fun validateInput(view: TextView): Boolean {
        if (view.text.isNotEmpty()) {
            return true
        }
        Snackbar.make(mainLayout, "Input is empty", Snackbar.LENGTH_LONG).show()
        return false
    }

    private fun calculate(operation :Operations) {
        if (validateInput(first_view) && validateInput(second_view)) {
            val cs : CharSequence
            when (operation) {
                Operations.PLUS -> {
                    cs = (first_view.text.toString().toFloat() + second_view.text.toString().toFloat()).toString()
                }
                Operations.MINUS -> {
                    cs = (first_view.text.toString().toFloat() - second_view.text.toString().toFloat()).toString()
                }
                Operations.MULTIPLY -> {
                    cs = (first_view.text.toString().toFloat() * second_view.text.toString().toFloat()).toString()
                }
                Operations.DIVIDE -> {
                    if (second_view.text.toString().toFloat() == 0.toFloat() ) {
                        Snackbar.make(mainLayout, "You cant divide by zero", Snackbar.LENGTH_LONG).show()
                        return
                    }
                    cs = (first_view.text.toString().toFloat() / second_view.text.toString().toFloat()).toString()
                }
            }
            first_view.setText(cs, TextView.BufferType.EDITABLE)
            second_view.setText("", TextView.BufferType.EDITABLE)
        }
    }
}