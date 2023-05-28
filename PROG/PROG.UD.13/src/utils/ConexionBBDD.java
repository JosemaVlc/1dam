/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.*;

/**
 *
 * @author jmore
 */
public class ConexionBBDD { 
        private static String url = "jdbc:mysql://localhost:3306/uf13";
        private static String user = "root";
        private static String pass = "admin";
        private static Connection connection = null;
        
    //metodo de classe que retorna la conexio a la base de dades
    public static Connection getConexionBBDD() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
    
    //metode de classe que comprova si la taula existeis en la base de dades utilitzant una consulta
    public static boolean existeTabla(String taula) throws SQLException {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = '" + taula + "'";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            existe = true;
        }
        rs.close();
        pstmt.close();
        return existe;
    }
    
    //metode de clase que crea una taula a la base de dades si no existeis.
    public static void crearTablaProductos() throws SQLException {
        String sql = """
                     CREATE TABLE IF NOT EXISTS t_vehicles (
                     T_MATRICULA VARCHAR(7) PRIMARY KEY,
                     T_MARCA VARCHAR(50) DEFAULT,
                     T_PLACES INT(5) DEFAULT 0,
                     T_CAPACITAT VARCHAR(15) DEFAULT,
                     T_TIPUS VARCHAR(10) DEFAULT,
                     );""";
        connection.createStatement().execute(sql);

        System.out.println("Tabla productos creada");
    }
}

