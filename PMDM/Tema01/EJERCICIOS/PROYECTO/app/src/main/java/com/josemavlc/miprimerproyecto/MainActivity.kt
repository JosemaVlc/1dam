package com.josemavlc.miprimerproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.josemavlc.miprimerproyecto.ui.theme.MiPrimerProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiPrimerProyectoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Josema")
                }
            }
        }
        imprimir()
        oplogicos()
        sumVariables()
        sentenciaWhen()
    }
    private fun variables() {

        //constantes
        val numPi: Double = 3.141592653589793
        val velLuz: Int = 299792458

        //variables
        val edad: Int = 38
        val nombre: String="Josema"
    }

    private fun imprimir(){

        val edad: Int = 38
        val nombre: String="Josema"

        println("Mi nombre completo es $nombre y tengo $edad años")
    }

    private fun oplogicos(){

        val x: Int = 5
        val y: Int = 8
        val z: Int = 14

        if ((z > y) && (z > x)){
            println("Z es el mayor")
        }
        else if((y > x) && (y > z)){
            println("Y es el mayor")
        }
        else if((x > y) && (x > z)){
            println("X es el mayor")
        }
        else if((x == y) && (x > z)){
            println("X e Y son los mayores")
        }
        else if((x == z) && (x > y)){
            println("X y Z son los mayores")
        }
        else{
            println("Y y Z son los mayores")
        }
    }

    private fun sumVariables(){
        val a: Int = 6
        val b: Int = 8

        if (a > 0 && a < 10 && b > 0 && b < 10){
            println(a+b)
        }else{
            println("Fuera de rango")
        }
    }

    private fun sentenciaWhen(){
        val pais: String = "Canada"

        when(pais){
            "España", "Peru", "Guatemala", "Venezuela", "Argentina", "Cuba", "Uruguay" -> {
                println("El idioma es Español")
            } "USA", "Inglaterra", "Gales", "Irlanda", "Australia" -> {
                println("El idioma es Inglés")
            } "Francia", "Canada" -> {
                println("El idioma es Frances")
            } "Portugal", "Brasil" -> {
                println("El idioma es Portugues")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiPrimerProyectoTheme {
        Greeting("Android")
    }
}