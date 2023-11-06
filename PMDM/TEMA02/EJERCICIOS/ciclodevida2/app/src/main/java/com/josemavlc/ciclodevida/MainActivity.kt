package com.josemavlc.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("CiclodeVida", "Ingresa a onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.i("CiclodeVida", "Ingresa a onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("CiclodeVida", "Ingresa a onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i("CiclodeVida", "Ingresa a OnPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("CiclodeVida", "Ingresa a onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("CiclodeVida", "Ingresa a onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("CiclodeVida", "Ingresa a onDestroy")
    }
}