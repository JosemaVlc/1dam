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
public class PROGUD13{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/uf13";
        String user = "root";
        String pass = "admin";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try{
            connection = DriveManager.getConnection(url, user, pass);
            String query = "SELECT * FORM productos WHERE column1 = ? AND column2 = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "value1");
            preparedStatement.setString(2, "value2");
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                System.out.println(resultSet.getString("column1") + " " + resultSet.getString("column2"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            // cerramos manualmente los objetos en orden inverso a como se han recreado
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}