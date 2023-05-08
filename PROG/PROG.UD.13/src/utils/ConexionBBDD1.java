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
public class ConexionBBDD1 { 
        private static String url = "jdbc:mysql://localhost:3306/uf13";
        private static String user = "root";
        private static String pass = "admin";
        private static Connection connection = null;
        

    public static Connection getConexionBBDD() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
    
    public static boolean existeTabla(String tabla) throws SQLException{
        boolean exist = false;
        
            String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tabla);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next() == true && resultSet.getInt(1) > 0 ){
                exist = true;
            }
            
            preparedStatement.close();
            resultSet.close();
            
        return exist;
    }
    
    public static void crearTablaProductos() throws SQLException{
        String sql = """
                     CREATE TABLE IF NOT EXISTS productos2 (
                     CODIGO_ARTICULO VARCHAR(10) PRIMARY KEY,
                     SECCION VARCHAR(50) NOT NULL,
                     NOMBRE VARCHAR(50) NOT NULL,
                     PRECIO DOUBLE NOT NULL,
                     PAIS VARCHAR(50) NOT NULL,
                     FECHA DATE NOT NULL
                     );""";
        
        connection.createStatement().execute(sql);
        
        // Insertar 5 productos aleatorios
        String[] codigos = {"P001", "P002", "P003", "P004", "P005"};
        String[] secciones = {"Ropa", "Electrónica", "Deportes", "Juguetes", "Hogar"};
        String[] nombres = {"Camiseta", "Smartphone", "Raqueta", "Peluche", "Lámpara"};
        double[] precios = {9.99, 599.99, 29.99, 14.99, 39.99};
        String[] paises = {"España", "Francia", "Alemania", "Italia", "Reino Unido"};
        java.sql.Date[] fechas = {new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis()), 
                          new Date(System.currentTimeMillis())};

        for (int i = 0; i < codigos.length; i++) {
            String insert = "INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement poblartabla = connection.prepareStatement(insert);
            poblartabla.setString(1, codigos[i]);
            poblartabla.setString(2, secciones[i]);
            poblartabla.setString(3, nombres[i]);
            poblartabla.setDouble(4, precios[i]);
            poblartabla.setString(5, paises[i]);
            poblartabla.setDate(6, fechas[i]);
            poblartabla.executeUpdate();
        }
        System.out.println("Tabla productos creada y productos aleatorios insertados.");
    }
}
