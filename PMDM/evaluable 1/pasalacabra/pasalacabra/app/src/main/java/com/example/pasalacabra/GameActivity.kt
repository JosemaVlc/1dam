package com.example.pasalacabra

import android.content.Intent
import android.content.pm.ActivityInfo
import java.text.Normalizer
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private lateinit var dbHelper: SQLiteOpenHelper
    private lateinit var mediaPlayerCorrect: MediaPlayer
    private lateinit var mediaPlayerIncorrect: MediaPlayer
    private lateinit var respuestaTexto: EditText
    private lateinit var marcador: TextView
    private var correctas: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        dbHelper = SQLiteOpenHelper(this)

        // Bloqueo de la vista en vertical
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Seteo la vista activity_game
        setContentView(R.layout.activity_game)

        // Enlazo el editText donde el usuario respondera a la pregunta
        respuestaTexto = findViewById(R.id.editTextRespuesta)

        // Instancia del Array de botones que mas tarde se inicializarán
        val arrayButton = arrayOf(
            R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD, R.id.btnE, R.id.btnF, R.id.btnG, R.id.btnH,
            R.id.btnI, R.id.btnJ, R.id.btnK, R.id.btnL, R.id.btnM, R.id.btnN, R.id.btnNY, R.id.btnO,
            R.id.btnP, R.id.btnQ, R.id.btnR, R.id.btnS, R.id.btnT, R.id.btnU, R.id.btnV, R.id.btnW,
            R.id.btnX, R.id.btnY, R.id.btnZ)

        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED)
        setContentView(R.layout.activity_game)

        var codboda: String? = ""
        val intent = intent
        if (intent.hasExtra("boda")){
            codboda = intent.getStringExtra("boda")
        }
        correctas = dbHelper.obtenerCorrectas(codboda)
        marcador = findViewById(R.id.marcador)
        marcador.text = correctas.toString()

        // bucle for que genera los botones mediante un iterador con el nombre de cada botón
        for (buttonId in arrayButton){
            val btn = findViewById<Button>(buttonId)
            // Si estan respondidas como verdaderas
            if (dbHelper.obtenerRespuesta(btn.text.toString(), codboda.toString()) == "1"){
                // Cambia el color de fondo del boton a verde
                btn.setBackgroundColor(Color.parseColor("#00FF00"))
                // Cambia el color de texto a negro
                btn.setTextColor(Color.parseColor("#000000"))
            }
            // Si estan respondidas como erroneas
            if (dbHelper.obtenerRespuesta(btn.text.toString(), codboda.toString()) == "2"){
                // fondo del boton a rojo
                btn.setBackgroundColor(Color.parseColor("#FF0000"))
                // letra color negra
                btn.setTextColor(Color.parseColor("#000000"))
            }
            btn.setOnClickListener {
                it.hidekeyboard()
                pregunta(btn.text.toString(), codboda.toString(), btn)
            }
        }

        /* boton de codigo secreto que si el numero de respuestas correctas no es 27 lanzara un toast
         * y si lo es pasará a la vista FinalActivity.
         */
        val btnCodigoSecreto = findViewById<Button>(R.id.btnCodigo)
        btnCodigoSecreto.setOnClickListener {
            if (correctas != 27){
                val mensaje = "AUN NO DESBLOQUEASTES LAS 27 PREGUNTAS."
                val duracion = Toast.LENGTH_SHORT  // Puedes usar 'Toast.LENGTH_LONG' para que dure más tiempo
                val toast = Toast.makeText(this, mensaje, duracion)
                toast.show()
            } else {
                val intent1 = Intent(this, FinalActivity::class.java)
                intent1.putExtra("boda",codboda)
                startActivity(intent1)
            }
        }
    }

    // función pregunta
    private fun pregunta(letra: String,codboda: String, btn: Button) {
        // setea el textPregunta mostrando la pregunta correspondiente
        val textPregunta = findViewById<TextView>(R.id.textPregunta)
        textPregunta.text = dbHelper.obtenerPregunta(letra,codboda).toString()

        // muestra el campo de texto en el que responder.
        val respuestaTexto = findViewById<EditText>(R.id.editTextRespuesta)
        respuestaTexto.isVisible = true

        // enlaza el boton check a layout
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        // setea el mensaje toast que aparecerá si la respuesta es erronea
        val mensaje = "RESPUESTA ERRONEA"
        val duracion = Toast.LENGTH_SHORT  // Puedes usar 'Toast.LENGTH_LONG' para que dure más tiempo
        val toast = Toast.makeText(applicationContext, mensaje, duracion)

        val imagenPregunta = findViewById<ImageView>(R.id.imageView)

        // pone la imagen en invisible de forma predeterminada.
        imagenPregunta.isVisible = false

        // si existe la imagen la pone visible
        if (dbHelper.obtenerImagen(letra,codboda) != null){
            imagenPregunta.isVisible = true
            imagenPregunta.setImageResource(dbHelper.obtenerImagen(letra,codboda)!!)
        }

        /* si el usuario no la ha respondido pone visible y en Enable el btnCheck, ademas setea a
         * vacio el valor del EditText, si ya esta respondida correctamente recupera la respuesta
         * del arrayRespuestas y la posición del iterable.
         */
        if (dbHelper.obtenerRespuesta(letra,codboda) == "0" || dbHelper.obtenerRespuesta(letra,codboda) == "2"){
            btnCheck.isVisible = true
            btnCheck.isEnabled = true
            respuestaTexto.isEnabled = true
            val texto = ""
            respuestaTexto.text = Editable.Factory.getInstance().newEditable(texto)
        }else{
            respuestaTexto.text = Editable.Factory.getInstance().newEditable(dbHelper.obtenerSolucion(letra,codboda))
            respuestaTexto.isEnabled = false
            btnCheck.isEnabled = false
        }

        // evento click sobre btnCheck,
        btnCheck.setOnClickListener{

            val respuesta = respuestaTexto.text

            // quita el foco del textEdit ocultando el teclado
            it.hidekeyboard()

            // comparativa entre la respuesta y la solucion en mayusculas, sin espacios y sin acentos
            if (removeAccents(respuesta.toString().uppercase().replace(" ", ""))==removeAccents(dbHelper.obtenerSolucion(letra,codboda).toString())){
                // crea el media player del sonido correcto e inicia la reproduccion
                mediaPlayerCorrect = MediaPlayer.create(this, R.raw.correct)
                mediaPlayerCorrect.start()
                // Cambia el color de fondo del boton a verde
                btn.setBackgroundColor(Color.parseColor("#00FF00"))
                // Cambia el color de texto a negro
                btn.setTextColor(Color.parseColor("#000000"))
                // Almacena en respuesta que es correcta
                dbHelper.actualizarRespuesta(letra, codboda,1)
                // Muestra la solucción en la editText
                respuestaTexto.text =  Editable.Factory.getInstance().newEditable(dbHelper.obtenerSolucion(letra,codboda).toString())
                // Suma una correcta y actualiza el marcador
                correctas++
                marcador = findViewById(R.id.marcador)
                marcador.text = correctas.toString()

                // Bloquea el editText y el btnCheck
                respuestaTexto.isEnabled = false
                btnCheck.isEnabled = false

                // espera a que se termine de reproducir
                mediaPlayerCorrect.setOnCompletionListener { mp ->
                    // El audio ha terminado de reproducirse, ahora puedes liberar el objeto MediaPlayer
                    mp.release()
                }
            } else{
                // crea el media player del sonido negativo e inicia la reproduccion
                mediaPlayerIncorrect = MediaPlayer.create(this, R.raw.negative)
                mediaPlayerIncorrect.start()
                // setea el editText a vacio
                val texto = ""
                respuestaTexto.text = Editable.Factory.getInstance().newEditable(texto)
                // Muestra el mensaje de respuesta incorrecta
                toast.show()
                // Almacena en respuesta que es incorrecta
                dbHelper.actualizarRespuesta(letra, codboda,2)
                // fondo del boton a rojo
                btn.setBackgroundColor(Color.parseColor("#FF0000"))
                // letra color negra
                btn.setTextColor(Color.parseColor("#000000"))
                // espera que el audio termine para poder cerrar el media player
                mediaPlayerIncorrect.setOnCompletionListener { mp ->
                    // El audio ha terminado de reproducirse, ahora puedes liberar el objeto MediaPlayer
                    mp.release()
                }
            }
        }
    }

    // Función para esconder el teclado.
    private fun View.hidekeyboard(){
        // instancia desde el contexto actual el metodo servicio de entrada y lo convierte a InputMethodManager
        val imm = this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        // oculta el teclado
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    companion object{
        // Revisa y devuelve un string sin acentos
        fun removeAccents(input: String): String {
            val normalized = Normalizer.normalize(input, Normalizer.Form.NFD) // Clase que separa en caracteres individuales separando los acentos de su caracter base
            val pattern = "\\p{InCombiningDiacriticalMarks}+".toRegex() // Crea un patter de diacriticos, el + significa que busque mas de uno y el toRegex() que lo convierta en expresión regular1
            return pattern.replace(normalized, "") // aplíca el pattern sobre el input normalizado y lo devuelve.
        }
    }
}
