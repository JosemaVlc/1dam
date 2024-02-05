package com.josemavlc.myapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.AsyncTaskLoader
import androidx.loader.content.Loader
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.Properties

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<String> {

    private val LOADER_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Aquí se establece la ruta y la contraseña de la wallet
        val walletPath = "/sampledata/wallet" // Reemplaza con la ruta real a tu wallet
        val walletPassword = "Josema_4r4r8i1q" // Reemplaza con la contraseña de tu wallet

        // Inicializar el LoaderManager
        supportLoaderManager.initLoader(LOADER_ID, null, this)

        // Ejecutar la tarea asíncrona para la conexión a la base de datos
        val loader = ConnectSqlLoader(this, walletPath, walletPassword)
        loader.forceLoad()
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String> {
        // Devolver una instancia del AsyncTaskLoader
        val walletPath = "/sampledata/wallet" // Reemplaza con la ruta real a tu wallet
        val walletPassword = "Josema_4r4r8i1q" // Reemplaza con la contraseña de tu wallet
        return ConnectSqlLoader(this, walletPath, walletPassword)
    }

    override fun onLoadFinished(loader: Loader<String>, data: String?) {
        // Manejar el resultado aquí, por ejemplo, mostrarlo en un TextView
        // txtResult.text = data
    }

    override fun onLoaderReset(loader: Loader<String>) {
        // Opcionalmente manejar la reinicialización del Loader
    }

    private class ConnectSqlAsyncTask(private val walletPath: String, private val walletPassword: String) {

        fun doInBackground(): String {
            // Realizar operaciones de conexión a la base de datos en segundo plano
            val connection: Connection? = ConnectSql(walletPath, walletPassword).getConnection()

            // Realizar operaciones en la base de datos (por ejemplo, ejecutar una consulta)
            val sql = "SELECT * FROM cliente"
            val resultStringBuilder = StringBuilder()

            connection?.use { conn ->
                val preparedStatement: PreparedStatement = conn.prepareStatement(sql)
                val resultSet: ResultSet = preparedStatement.executeQuery()

                // Procesar resultados
                while (resultSet.next()) {
                    val columna1 = resultSet.getString("novio")
                    val columna2 = resultSet.getInt("codigo")
                    // ... Procesar otras columnas según tu esquema
                    resultStringBuilder.append("Resultado: $columna1, $columna2\n")
                }

                // Cerrar recursos
                resultSet.close()
                preparedStatement.close()
            }

            return resultStringBuilder.toString()
        }
    }

    private class ConnectSqlLoader(context: Context, private val walletPath: String, private val walletPassword: String) :
        AsyncTaskLoader<String>(context) {

        override fun loadInBackground(): String {
            return ConnectSqlAsyncTask(walletPath, walletPassword).doInBackground()
        }
    }

    class ConnectSql(private val walletPath: String, private val walletPassword: String) {
        init {
            // Registrar el controlador JDBC
            try {
                Class.forName("oracle.jdbc.OracleDriver")
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }

        fun getConnection(): Connection? {
            val connectionProperties = Properties()
            connectionProperties.setProperty("oracle.net.wallet_location", "(SOURCE=(METHOD=FILE)(METHOD_DATA=(DIRECTORY=$walletPath)))")
            val url = "jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.eu-madrid-1.oraclecloud.com))(connect_data=(service_name=g94d7614f3e6d0f_pasalacabra_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))"

            return DriverManager.getConnection(url, connectionProperties)
        }
    }

}
