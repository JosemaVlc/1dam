/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package prog.ud.pkg13;

import java.sql.*;
import java.util.*;

/**
 *
 * @author jmore
 */
public class ejercicio02{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/uf13";
        String user = "root";
        String pass = "admin";
        
        try (Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos");){
            
            while (resultSet.next()){
                System.out.print(resultSet.getString("CODIGO_ARTICULO")+ " | ");
                System.out.print(resultSet.getString("SECCION")+" | ");
                System.out.print(resultSet.getString("NOMBRE")+" | ");
                System.out.print(resultSet.getDouble("PRECIO")+" | ");
                System.out.print(resultSet.getString("PAIS")+" | ");
                System.out.print(resultSet.getDate("FECHA")+"\n");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}