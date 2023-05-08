/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package prog.ud.pkg13;

import java.sql.*;
import java.util.*;
import utils.ConexionBBDD1;

/**
 *
 * @author jmore
 */
public class ejercicio04{
    public static void main(String[] args){
        try (Connection connection = ConexionBBDD1.getConexionBBDD()){
            if (!ConexionBBDD1.existeTabla("productos2")){
                ConexionBBDD1.crearTablaProductos();
            }
            
            String query = "SELECT * FROM productos2";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                System.out.print(resultSet.getString("CODIGO_ARTICULO")+ " | ");
                System.out.print(resultSet.getString("SECCION")+" | ");
                System.out.print(resultSet.getString("NOMBRE")+" | ");
                System.out.print(resultSet.getDouble("PRECIO")+" | ");
                System.out.print(resultSet.getString("PAIS")+" | ");
                System.out.print(resultSet.getDate("FECHA")+"\n");
            }
            
            resultSet.close();
            preparedStatement.close();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        
    }
}