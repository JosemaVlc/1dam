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
public class ejercicio05{
    public static void main(String[] args){
        String query = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("De que seccion es su producto que busca?:");
        String value1 = entrada.nextLine();
        System.out.println("De que pais es el producto que busca?");
        String value2 = entrada.nextLine();
       
        try (Connection connection = ConexionBBDD1.getConexionBBDD()){
            if (!ConexionBBDD1.existeTabla("productos2")){
                ConexionBBDD1.crearTablaProductos();
            }
            
            if (value1 == "" && value2 == ""){
                query = "SELECT * FROM productos2";
                preparedStatement = connection.prepareStatement(query);
            }else if (value1 != "" && value2 == ""){
                query = "SELECT * FROM productos2 WHERE SECCION = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, value1);
            }else if (value1 == "" && value2 != ""){
                query = "SELECT * FROM productos2 WHERE PAIS = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, value2);
            }else{
                query = "SELECT * FROM productos2 WHERE SECCION = ? AND PAIS = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, value1);
                preparedStatement.setString(2, value2);
            }
            
            resultSet = preparedStatement.executeQuery();
            
            
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