package com.carlos.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    lateinit var boton: Button
    lateinit var boton2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton = findViewById(R.id.boton)
        boton.setOnClickListener() {


            //asignando valores
            val builder = AlertDialog.Builder(this@MainActivity)
            val view = layoutInflater.inflate(R.layout.dialog, null)

            builder.setView(view)

            val dialog = builder.create()
            dialog.show()


            }


        }
    }


