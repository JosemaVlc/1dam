package com.example.pasalacabra


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
        }
    }
}
