package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "On create", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on create")
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "On start", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on start")
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "On resume", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on resume")
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "On restart", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on restart")
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "On pause", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on pause")
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "On stop", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on stop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "On destroy", Toast.LENGTH_LONG).show()
        Log.d("LIFE_CIRCLE", "on destroy")
    }
}