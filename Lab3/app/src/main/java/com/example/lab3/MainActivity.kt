package com.example.lab3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var Name: String = ""
    private var REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        make_photo_btn.setOnClickListener {
            if (validateName()) {
                Name = name_input.text.toString()
                openCamera()
            } else
                Snackbar.make(main_layout, R.string.invalid_name_message, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun validateName(): Boolean {
        return name_input.text.isNotEmpty()
    }



    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            Snackbar.make(main_layout, R.string.camera_error_message, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            val intent : Intent = Intent(this, PhotoActivity::class.java)
            intent.putExtra("data", data?.extras?.get("data") as Bitmap)
            intent.putExtra("name", Name)
            startActivity(intent)
        }
    }
}
