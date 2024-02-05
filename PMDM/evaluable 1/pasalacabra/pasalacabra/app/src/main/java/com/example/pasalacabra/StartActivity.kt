package com.example.pasalacabra


import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class StartActivity : AppCompatActivity() {
    private lateinit var dbHelper: SQLiteOpenHelper
    private val prefsName = "MyPrefsFile"

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)// Obtén la instancia de ActionBar
        setContentView(R.layout.activity_start)

        dbHelper = SQLiteOpenHelper(this)
        mostrarMenu()

    }
    private fun mostrarMenu(){
        val btnStart = findViewById<Button>(R.id.btnStart)
        val editTextCliente = findViewById<EditText>(R.id.editTextCodigo)
        val textViewBoda = findViewById<TextView>(R.id.textBoda)
        val btnEnlazar = findViewById<Button>(R.id.btnEnlazar)
        val btnDesvincular = findViewById<Button>(R.id.btnVinculo)


        val sharedPreferences = getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        val connected = sharedPreferences.getBoolean("connected", false)

        if (connected) {
            val boda = sharedPreferences.getString("codigo", "")
            val (novio, novia) = dbHelper.obtenerNovios(boda.toString())
            if (novio != null && novia != null) {
                textViewBoda.text = "$novio\ny\n$novia"
                textViewBoda.isVisible = true
                editTextCliente.isVisible = false
                btnEnlazar.isVisible = false
                btnStart.isVisible = true
                btnStart.text = "CONTINUAR"
                btnDesvincular.isVisible = true
            }
        } else {
            btnEnlazar.setOnClickListener {
                val boda = editTextCliente.text
                val (novio, novia) = dbHelper.obtenerNovios(boda.toString())
                if (novio != null && novia != null) {
                    textViewBoda.text = "$novio\ny\n$novia"
                    textViewBoda.isVisible = true
                    editTextCliente.isVisible = false
                    btnEnlazar.isVisible = false
                    btnStart.isVisible = true
                    btnDesvincular.isVisible = true
                    it.hidekeyboard()
                    // Guarda el ID de usuario en las preferencias compartidas
                    with(sharedPreferences.edit()) {
                        putBoolean("connected", true)
                        putString("codigo", editTextCliente.text.toString())
                    }.apply()
                }
            }
        }

        btnStart.setOnClickListener {// Obtener conexión
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("boda",sharedPreferences.getString("codigo", "")) // Se pasa el argumento de la boda
            startActivity(intent)
        }

        btnDesvincular.setOnClickListener {// Obtener conexión
            with(sharedPreferences.edit()) {
                putBoolean("connected", false)
                putString("codigo", null)
            }.apply()

            dbHelper.eliminarBaseDeDatos()

            // Reinicio la aplicación, ya que volviendo a mostrar los otros botones se descuadran sin fallo aparente
            val intent = Intent(this, StartActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
    }
    private fun View.hidekeyboard() {
        // instancia desde el contexto actual el metodo servicio de entrada y lo convierte a InputMethodManager
        val imm = this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        // oculta el teclado
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

