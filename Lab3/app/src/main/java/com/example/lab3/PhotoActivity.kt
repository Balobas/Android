package com.example.lab3

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val imageBitmap = this.intent?.extras?.get("data") as Bitmap
        image_view.setImageBitmap(imageBitmap)

        val name = this.intent?.extras?.get("name") as String
        name_output.text = name
    }
}