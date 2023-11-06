package com.josemavlc.semena2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class clickerApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicker_app)

        var cont:Int = 0

        var boton1 = findViewById<Button>(R.id.btn_clicker)

        boton1.setOnClickListener{

            var modString = getString(R.string.clicker, cont)
            cont++
            boton1.text = modString
        }

    }
}