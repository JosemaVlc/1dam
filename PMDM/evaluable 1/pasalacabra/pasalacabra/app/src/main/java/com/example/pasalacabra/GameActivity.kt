package com.example.pasalacabra

import android.content.Intent
import android.content.pm.ActivityInfo
import java.text.Normalizer
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.provider.AlarmClock
import android.text.Editable
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class GameActivity : AppCompatActivity() {
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer
    private lateinit var respuestaTexto: EditText
    private lateinit var marcador: TextView
    private val arrayPreguntas: Array<String> = arrayOf(
        "Con la A: Primera luz del día antes de salir el sol",
        "Con la B: Líder en la independencia de varios países de América. También segundo apellido de este mendrugo.",
        "Con la C: Ópera escrita por el compositor francés Georges Bizet. Tambien Segundo nombre de esta señora y el de su hija.",
        "Con la D: Serie del 2020 en la que Juan Echanove encarna a Santiago Abad. También como se encuentran estos individuos",
        "Con la E: Periodo que transcurre entre la concepción y el parto, que Jesy siempre os pide",
        "Con la F: Mayor festividad Valenciana",
        "Con la G: Municipio en el que ha vivido el novio durante su infancia",
        "Con la H: Centro en el que trabaja la novia",
        "Con la I: Medicación a la que fue sometido el novio en su despedida de soltero",
        "Con la J: Nombre abreviado de la mejor compañera para irse de peceras y pillar una buena merla",
        "Con la K: Este tipo te anima con el senderismo, pero tiene nombre de fruto seco, quien es?",
        "Con la L: Personaje de pelicula encarnada por Paz Vega en el 2001 y nombre de esta mendruga",
        "Con la M: Pequeño mamífero carnívoro familiar de visones, hurones y la garduña. Tambien es su nombre propio.",
        "Con la N: Mes en la que se celebró vuestra boda",
        "Contiene la Ñ: Coloquialmente, cómo se pusieron los invitados en la barra libre",
        "Con la O: Municipio donde se ubica el nidito de amor",
        "Con la P: Deriva de Francisco y veranea en Cullera todos los veranos.",
        "Contiene la Q: Aceptación de los votos matrimoniales (dos palabras)",
        "Con la R: Camino que se puede recorrer a pie por la naturaleza, disfrutando de diversos paisajes",
        "Con la S: Nombre del señor que inventó la piña con explosion de sabores",
        "Con la T: Carrera universitaria en la que un integrante de la pareja ha estudiado",
        "Con la U: Servicio de movilidad que han tenido que pedir algunos de los invitados por su estado de embriaguez",
        "Con la V: Capital del Turia",
        "Con la W: Orca de una famosa pelicula y el nombre del señor de la foto ¡Que la suerte te acompañe!",
        "Con la X: Quién es este melón? (Si, el de la derecha!)",
        "Contiene la Y: Aquellos que se encuentra relacionados a través del matrimonio",
        "Contiene la Z: Município donde viven estos dos y donde se encuentra la marca de las pipas Tijuana, que tantas hemos comido!"
    )
    private val arrayRespuesta = mutableListOf(
        "","","","","","","","",
        "","","","","","","","","",
        "","","","","","","","","",""
    )
    private val arraySolucion: Array<String> = arrayOf(
        "ALBA","BOLÍVAR","CARMEN","DESAPARECIDOS","EMBARAZO","FALLAS","GODELLA","HOSPITAL",
        "INYECCIÓN","JESY","KIKO","LUCÍA","MARTA","NOVIEMBRE","CASTAÑA","OROPESA","PACO",
        "SÍQUIERO","RUTA","SANTI","TURÍSMO","UBER","VALENCIA","WILLY","XAVI","CONYUGES","ALZIRA"
    )
    private var correctas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_game)

        respuestaTexto = findViewById(R.id.editTextRespuesta)

        val arrayButton = arrayOf(
            R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD, R.id.btnE, R.id.btnF, R.id.btnG, R.id.btnH,
            R.id.btnI, R.id.btnJ, R.id.btnK, R.id.btnL, R.id.btnM, R.id.btnN, R.id.btnNY, R.id.btnO,
            R.id.btnP, R.id.btnQ, R.id.btnR, R.id.btnS, R.id.btnT, R.id.btnU, R.id.btnV, R.id.btnW,
            R.id.btnX, R.id.btnY, R.id.btnZ)

        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED)
        setContentView(R.layout.activity_game)
        for ((i, buttonId) in arrayButton.withIndex()){
            val btn = findViewById<Button>(buttonId)
            btn.setOnClickListener {
                it.hidekeyboard()
                pregunta(i, btn)
            }
        }

        val btnCodigoSecreto = findViewById<Button>(R.id.btnCodigo)
        btnCodigoSecreto.setOnClickListener {
            if (correctas != 27){
                val mensaje = "AUN NO DESBLOQUEASTES LAS 27 PREGUNTAS."
                val duracion = Toast.LENGTH_SHORT  // Puedes usar 'Toast.LENGTH_LONG' para que dure más tiempo
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            } else {
                val intent = Intent(this, FinalActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun pregunta(opc: Int, btn: Button) {

        val textPregunta = findViewById<TextView>(R.id.textPregunta)
        textPregunta.text = arrayPreguntas[opc]

        val respuestaTexto = findViewById<EditText>(R.id.editTextRespuesta)
        respuestaTexto.isVisible = true

        val btnCheck = findViewById<Button>(R.id.btnCheck)

        val mensaje = "RESPUESTA ERRONEA"
        val duracion = Toast.LENGTH_SHORT  // Puedes usar 'Toast.LENGTH_LONG' para que dure más tiempo
        val toast = Toast.makeText(applicationContext, mensaje, duracion)

        /*
        mirara en la carpeta drawable si existe una imagen con el mismo nombre que la solucion (en minuscula),
        y si es así la mostrara en el ImageView.
        */
        val resourceName = removeAccents(arraySolucion[opc].lowercase())
        val resourceId = resources.getIdentifier(resourceName, "drawable", packageName)
        val imagenPregunta = findViewById<ImageView>(R.id.imageView)

        imagenPregunta.isVisible = false
        if (resourceId != 0){
            imagenPregunta.isVisible = true
            imagenPregunta.setImageResource(resourceId)
        }

        if (arrayRespuesta[opc] == ""){
            btnCheck.isVisible = true
            btnCheck.isEnabled = true
            respuestaTexto.isEnabled = true
            val texto = ""
            respuestaTexto.text = Editable.Factory.getInstance().newEditable(texto)
        }else{
            respuestaTexto.text = Editable.Factory.getInstance().newEditable(arrayRespuesta[opc])
            respuestaTexto.isEnabled = false
            btnCheck.isEnabled = false
        }

        btnCheck.setOnClickListener{
            val respuesta = respuestaTexto.text
            it.hidekeyboard()
            if (removeAccents(respuesta.toString().uppercase().replace(" ", ""))==removeAccents(arraySolucion[opc])){
                mediaPlayerCorrect = MediaPlayer.create(this, R.raw.correct)
                mediaPlayerCorrect.start()
                btn.setBackgroundColor(Color.parseColor("#00FF00"))
                btn.setTextColor(Color.parseColor("#000000"))
                arrayRespuesta[opc] = respuesta.toString().uppercase()
                textPregunta.text = arrayPreguntas[opc]
                respuestaTexto.text = Editable.Factory.getInstance().newEditable(arraySolucion[opc])
                correctas++
                marcador = findViewById(R.id.marcador)
                marcador.text = correctas.toString()
                respuestaTexto.isEnabled = false
                btnCheck.isEnabled = false
                mediaPlayerCorrect.setOnCompletionListener { mp ->
                    // El audio ha terminado de reproducirse, ahora puedes liberar el objeto MediaPlayer
                    mp.release()
                }
            } else{
                mediaPlayerIncorrect = MediaPlayer.create(this, R.raw.negative)
                mediaPlayerIncorrect.start()
                val texto = ""
                respuestaTexto.text = Editable.Factory.getInstance().newEditable(texto)
                toast.show()
                btn.setBackgroundColor(Color.parseColor("#FF0000"))
                btn.setTextColor(Color.parseColor("#000000"))
                mediaPlayerIncorrect.setOnCompletionListener { mp ->
                    // El audio ha terminado de reproducirse, ahora puedes liberar el objeto MediaPlayer
                    mp.release()
                }
            }
        }
    }

    // Funcion para esconder el teclado.
    private fun View.hidekeyboard(){
        val imm = this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    // Revisa y devuelve un string sin acentos
    private fun removeAccents(input: String): String {
        val normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
        val pattern = "\\p{InCombiningDiacriticalMarks}+".toRegex()
        return pattern.replace(normalized, "")
    }
}
