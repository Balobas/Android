package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        make_photo_btn.setOnClickListener { if (validateName()) openCamera()}
    }

    private fun validateName(): Boolean {
        return name_input.text.isNotEmpty()
    }

    private fun openCamera() {

    }
}