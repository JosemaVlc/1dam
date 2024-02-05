package com.example.pasalacabra

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SQLiteOpenHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "pasalacabra.db"
    }

    // Crea las tablas y pobla la base de datos con datos iniciales.
    override fun onCreate(db: SQLiteDatabase) {
        // Crea las tablas aquí:
        db.execSQL("CREATE TABLE cliente(" +
                        "codigo VARCHAR(8) PRIMARY KEY," +
                        "novio VARCHAR(50)," +
                        "novia VARCHAR(50)," +
                        "mensaje VARCHAR(280)" +
                        ")"
        )
        db.execSQL("CREATE TABLE pregunta(" +
                "letra CHAR," +
                "codcliente VARCHAR(8)," +
                "texto VARCHAR(500) NOT NULL," +
                "solucion VARCHAR(20) NOT NULL," +
                "respuesta INTEGER," + // 0 SERÁ NULO, 1 SERÁ INCORRECTA, 2 SERÁ CORRECTA
                "imagen INTEGER," +
                "PRIMARY KEY (letra, codcliente)," +
                "FOREIGN KEY (codcliente) REFERENCES cliente(codigo) ON DELETE CASCADE" +
                ")"
        )

        // Pobla la base de datos
        poblarCliente(db)
        poblarPregunta(db)
    }

    // Maneja las actualizaciones de la base de datos eliminando las tablas existentes y llamando a onCreate.
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Maneja las actualizaciones de la base de datos aquí
        db.execSQL("DROP TABLE IF EXISTS cliente")
        db.execSQL("DROP TABLE IF EXISTS pregunta")
        onCreate(db)
    }

    // Pobla la tabla cliente con datos iniciales
    fun poblarCliente(db: SQLiteDatabase){
        // Informacion del cliente
        val codigo = 1
        val novio = "Paco Llorens"
        val novia = "Alba Correcher"
        val mensaje = "Enhorabuena os deseamos que seais muy felices juntos"

        // Almacena la info en valuesCodigo
        val valuesCodigo = ContentValues().apply {
            put("codigo", codigo)
            put("novio", novio)
            put("novia", novia)
            put("mensaje", mensaje)
        }
        // Introduce la info en la base de datos
        db.insert("cliente", null, valuesCodigo)
    }

    // Pobla la tabla pregunta con datos iniciales.
    fun poblarPregunta(db: SQLiteDatabase){
        // Letras
        val letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"

        // Array de soluciones
        val soluciones = arrayOf(
            "ALBA","BOLÍVAR","CARMEN","DESAPARECIDOS","EMBARAZO","FALLAS","GODELLA","HOSPITAL",
            "INYECCIÓN","JESY","KIKO","LUCÍA","MARTA","NOVIEMBRE","CASTAÑA","OROPESA","PACO",
            "SÍQUIERO","RUTA","SANTI","TURÍSMO","UBER","VALENCIA","WILLY","XAVI","CONYUGES","ALZIRA"
        )

        // Array de preguntas
        val preguntas = arrayOf(
            "A: Primera luz del día antes de salir el sol",
            "B: Líder en la independencia de varios países de América. También segundo apellido de este mendrugo.",
            "C: Ópera escrita por el compositor francés Georges Bizet. También el segundo nombre de esta señora y el de su hija.",
            "D: Serie del 2020 en la que Juan Echanove encarna a Santiago Abad. También cómo se encuentran estos individuos.",
            "E: Periodo que transcurre entre la concepción y el parto, que Jesy siempre os pide.",
            "F: Mayor festividad Valenciana.",
            "G: Municipio en el que ha vivido el novio durante su infancia.",
            "H: Centro en el que trabaja la novia.",
            "I: Medicación a la que fue sometido el novio en su despedida de soltero.",
            "J: Nombre abreviado de la mejor compañera para irse de peceras y pillar una buena merla.",
            "K: Este tipo te anima con el senderismo, pero tiene nombre de fruto seco, ¿quién es?",
            "L: Personaje de película encarnada por Paz Vega en el 2001 y nombre de esta mendruga.",
            "M: Pequeño mamífero carnívoro familiar de visones, hurones y la garduña. También es su nombre propio.",
            "N: Mes en el que se celebró vuestra boda.",
            "Contiene la Ñ: Coloquialmente, ¿cómo se pusieron los invitados en la barra libre?",
            "O: Municipio donde se ubica el nidito de amor.",
            "P: Deriva de Francisco y veranea en Cullera todos los veranos.",
            "Contiene la Q: Aceptación de los votos matrimoniales (dos palabras).",
            "R: Camino que se puede recorrer a pie por la naturaleza, disfrutando de diversos paisajes.",
            "S: Nombre del señor que inventó la piña con explosión de sabores.",
            "T: Carrera universitaria en la que un integrante de la pareja ha estudiado.",
            "U: Servicio de movilidad que han tenido que pedir algunos de los invitados por su estado de embriaguez.",
            "V: Capital del Turia.",
            "W: Orca de una famosa película y el nombre del señor de la foto ¡Que la suerte te acompañe!",
            "X:¿Quién es este melón? (Sí, el de la derecha!)",
            "Contiene la Y: Aquellos que se encuentra relacionados a través del matrimonio.",
            "Contiene la Z: Municipio donde viven estos dos y donde se encuentra la marca de las pipas Tijuana, que tantas hemos comido!"
        )

        // Codigo del cliente
        val codigoCliente = 1 // Supongamos que el código del cliente es 1

        // Bucle que introduce la información de cada pregunta respecto a los arrays anteriores y constantes anteriores.
        for (i in preguntas.indices) {
            val pregunta = preguntas[i]
            val solucion = soluciones[i]
            val letra: Char = letras[i]

            // mirara en la carpeta drawable si existe una imagen con el mismo nombre que la solucion (en minuscula)
            val resourceName = GameActivity.removeAccents(solucion.lowercase()) // devuelve la string de la solucion en minuscula y sin acentos
            val resourceId = context.resources.getIdentifier(resourceName, "drawable", context.packageName) // devuelve un id de la imagen si existe, si no existe devuelve 0

            // Introduce la información de la pregunta en valuesPregunta
            val valuesPregunta = ContentValues().apply {
                put("letra", letra.toString()) // Extrae la letra de la pregunta
                put("codcliente", codigoCliente)
                put("texto", pregunta)
                put("solucion", solucion)
                put("respuesta", 0)
                put("imagen", resourceId)
            }

            // Introduce la info en la base de datos
            db.insert("pregunta", null, valuesPregunta)
        }
    }

    // Obtiene los nombres de los novios asociados a un cliente.
    fun obtenerNovios(clienteId: String): Pair<String?, String?> {
        // Abre la base de datos en modo de lectura.
        val db = readableDatabase
        // Realizo la query
        val query = "SELECT novio, novia FROM cliente WHERE codigo = ?"
        // Paso los argumentos que estan en ? de la query
        val selectionArgs = arrayOf(clienteId)

        // genera el cursor
        val cursor = db.rawQuery(query, selectionArgs)

        // inicializo valores en nulo
        var novio: String? = null
        var novia: String? = null

        // Muevo el cursor al primer registro
        if (cursor.moveToFirst()) {
            // Almacena el registro
            val columnIndexNovio = cursor.getColumnIndex("novio")
            val columnIndexNovia = cursor.getColumnIndex("novia")

            // Recupera y lo pasa a String
            novio = cursor.getString(columnIndexNovio)
            novia = cursor.getString(columnIndexNovia)
        }

        // Cierra el cursor
        cursor.close()

        // retorna el nombre del novio y de la novia
        return Pair(novio, novia)
    }

    // Se utiliza para obtener el estado de la respuesta donde 0 es no respondida, 1 es correcta y 2 incorrecta.
    fun obtenerSolucion(letra: String, cliente: String): String? {
        // Abre la base de datos en modo de solo lectura.
        val db = readableDatabase

        // Define la consulta SQL para obtener la solución de la pregunta específica.
        val query = "SELECT solucion FROM pregunta WHERE letra = ? AND codcliente = ?"
        // Prepara los argumentos que se insertarán en la consulta SQL.
        val selectionArgs = arrayOf(letra, cliente)
        // Ejecuta la consulta y obtiene un cursor.
        val cursor = db.rawQuery(query, selectionArgs)

        // Inicializa la variable que almacenará la solución.
        var texto: String? = null

        // Mueve el cursor al primer registro si existe.
        if (cursor.moveToFirst()) {
            // Obtiene el índice de la columna "solucion" en el cursor.
            val columnIndex = cursor.getColumnIndex("solucion")

            // Verifica si la columna existe en el cursor.
            if (columnIndex != -1) {
                // Obtiene el valor de la columna y lo asigna a la variable texto.
                texto = cursor.getString(columnIndex)
            }
        }

        // Cierra el cursor para liberar recursos.
        cursor.close()

        // Retorna la solución obtenida.
        return texto
    }

    // Se utiliza para obtener el mensaje que se mostrara en activity_end de cada cliente.
    fun obtenerMensaje(codigo: String): String? {

        // Abre la base de datos en modo de solo lectura.
        val db = readableDatabase
        // Define la consulta SQL para obtener el mensaje asociado al código del cliente
        val query = "SELECT mensaje FROM cliente WHERE codigo = ?"
        // Prepara los argumentos que se insertarán en la consulta SQL.
        val selectionArgs = arrayOf(codigo)
        // Ejecuta la consulta y obtiene un cursor.
        val cursor = db.rawQuery(query, selectionArgs)

        // Inicializa la variable que almacenará el mensaje.
        var texto: String? = null

        // Mueve el cursor al primer registro si existe.
        if (cursor.moveToFirst()) {
            // Obtiene el índice de la columna "mensaje" en el cursor.
            val columnIndex = cursor.getColumnIndex("mensaje")

            // Verifica si la columna existe en el cursor.
            if (columnIndex != -1) {
                // Obtiene el valor de la columna y lo asigna a la variable texto.
                texto = cursor.getString(columnIndex)
            }
        }

        // Cierra el cursor para liberar recursos.
        cursor.close()

        // Retorna el mensaje obtenido.
        return texto
    }

    // Se utiliza para obtener el estado de la respuesta donde 0 es no respondida, 1 es correcta y 2 incorrecta.
    fun obtenerRespuesta(letra: String, cliente: String): String? {
        // Abre la base de datos en modo de solo lectura.
        val db = readableDatabase
        // Define la consulta SQL para obtener la respuesta asociada a la letra y código del cliente.
        val query = "SELECT respuesta FROM pregunta WHERE letra = ? AND codcliente = ?"
        // Prepara los argumentos que se insertarán en la consulta SQL.
        val selectionArgs = arrayOf(letra, cliente)
        // Ejecuta la consulta y obtiene un cursor.
        val cursor = db.rawQuery(query, selectionArgs)

        // Inicializa la variable que almacenará la respuesta.
        var texto: String? = null

        // Mueve el cursor al primer registro si existe.
        if (cursor.moveToFirst()) {
            // Obtiene el índice de la columna "respuesta" en el cursor.
            val columnIndex = cursor.getColumnIndex("respuesta")

            // Verifica si la columna existe en el cursor.
            if (columnIndex != -1) {
                // Obtiene el valor de la columna y lo asigna a la variable texto.
                texto = cursor.getString(columnIndex)
            }
        }

        // Cierra el cursor para liberar recursos.
        cursor.close()

        // Retorna el mensaje obtenido.
        return texto
    }

    // Se utiliza para obtener la pregunta de una letra y un cliente especifico.
    fun obtenerPregunta(letra: String, cliente: String): String? {
        val db = readableDatabase
        val query = "SELECT texto FROM pregunta WHERE letra = ? AND codcliente = ?"
        val selectionArgs = arrayOf(letra, cliente)

        val cursor = db.rawQuery(query, selectionArgs)

        var texto: String? = null

        if(cursor.moveToFirst()){
            val columnIndex = cursor.getColumnIndex("texto")
            if (columnIndex != -1) {
                texto = cursor.getString(columnIndex)
            }
        }

        cursor.close()

        return texto
    }

    // Obtiene el número de respuestas correctas de un cliente.
    fun obtenerCorrectas(cliente: String?): Int {
        val db = readableDatabase
        val query = "SELECT COUNT(*) AS count FROM pregunta WHERE respuesta = 1 AND codcliente = ?"
        val selectionArgs = arrayOf(cliente.toString())

        val cursor = db.rawQuery(query, selectionArgs)

        var count = 0

        if (cursor.moveToFirst()) {
            // Mueve el cursor a la primera fila si existe
            val columnIndex = cursor.getColumnIndex("count")
            if (columnIndex != -1) {
                count = cursor.getInt(columnIndex)
            }
        }

        cursor.close()

        return count
    }

    // Actualiza el estado de la respuesta (0: no respondida, 1: correcta, 2: incorrecta) para una letra y cliente específicos.
    fun actualizarRespuesta(letra: String, cliente: String, estado: Int) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("respuesta", estado)
        }

        // Define la cláusula WHERE para actualizar solo la fila específica
        val whereClause = "letra = ? AND codcliente = ?"
        val whereArgs = arrayOf(letra, cliente)

        // Realiza la actualización
        db.update("pregunta", values, whereClause, whereArgs)
    }

    // Obtiene la ID de recurso de la imagen asociada a una letra y cliente específicos.
    fun obtenerImagen(letra: String, cliente: String): Int? {
        val db = readableDatabase
        val query = "SELECT imagen FROM pregunta WHERE letra = ? AND codcliente = ?"
        val selectionArgs = arrayOf(letra, cliente)

        val cursor = db.rawQuery(query, selectionArgs)

        var imagen: Int? = null

        if(cursor.moveToFirst()){
            val columnIndex = cursor.getColumnIndex("imagen")
            if (columnIndex != -1) {
                imagen = cursor.getInt(columnIndex)
            }
        }

        cursor.close()

        return imagen
    }

    // Elimina la base de datos existente y la vuelve a crear.
    fun eliminarBaseDeDatos() {
        val db = writableDatabase
        db.execSQL("DROP TABLE IF EXISTS cliente")
        db.execSQL("DROP TABLE IF EXISTS pregunta")
        onCreate(db)
    }
}

