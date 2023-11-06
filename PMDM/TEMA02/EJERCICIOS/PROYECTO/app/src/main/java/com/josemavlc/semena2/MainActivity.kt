package com.josemavlc.semena2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFirstApp = findViewById<Button>(R.id.btn_firstApp)

        btnFirstApp.setOnClickListener {
            val intent = Intent(this, firstApp::class.java)
            startActivity(intent)
        }

        val btnClickerApp = findViewById<Button>(R.id.btn_clickerApp)

        btnClickerApp.setOnClickListener {
            val intent = Intent(this, clickerApp::class.java)
            startActivity(intent)
        }


    }
}