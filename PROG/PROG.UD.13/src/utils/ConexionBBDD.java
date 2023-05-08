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
        

    public static Connection getConexionBBDD() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
}

