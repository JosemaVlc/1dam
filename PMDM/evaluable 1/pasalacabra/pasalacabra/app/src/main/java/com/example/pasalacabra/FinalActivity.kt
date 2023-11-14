package com.example.pasalacabra

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FinalActivity : AppCompatActivity() {
    private lateinit var mediaPlayerFinal: MediaPlayer
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
    }
}