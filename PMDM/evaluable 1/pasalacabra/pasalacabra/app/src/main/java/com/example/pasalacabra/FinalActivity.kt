package com.example.pasalacabra

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    private lateinit var mediaPlayerFinal: MediaPlayer

    private lateinit var dbHelper: SQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        mediaPlayerFinal = MediaPlayer.create(this, R.raw.win)
        mediaPlayerFinal.start()
        mediaPlayerFinal.setOnCompletionListener { mp ->
            // El audio ha terminado de reproducirse, ahora puedes liberar el objeto MediaPlayer
            mp.release()
        }

        dbHelper = SQLiteOpenHelper(this)

        var codboda: String? = ""
        val intent = intent
        if (intent.hasExtra("boda")){
            codboda = intent.getStringExtra("boda")
        }

        val textocliente = findViewById<TextView>(R.id.textoCliente)
        textocliente.text = dbHelper.obtenerMensaje(codboda.toString())
    }
}