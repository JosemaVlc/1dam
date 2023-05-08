/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package prog.ud.pkg13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConexionBBDD1;
import utils.Productos;

/**
 *
 * @author jmore
 */
public class ejercicio07{
    public static void main(String[] args){
        
        ArrayList<Productos>listaProductos = new ArrayList<Productos>();
        
             
        
        String query = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        double nuevoPrecio = 0;
        
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
            
            if (value1 != "" && value2 != ""){            
                System.out.println("Quieres cambiar el precio de los productos? (s/n)");
                String opc = entrada.next();

                if ("s".equals(opc)){
                    System.out.println("Que precio quieres ponerle?");
                    if (entrada.hasNextDouble()){
                        nuevoPrecio = entrada.nextDouble();                         
                    }
                    if (nuevoPrecio != 0){                        
                        query  = "UPDATE productos2 SET PRECIO = ? WHERE SECCION = ? AND PAIS = ?";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setDouble(1, nuevoPrecio);
                        preparedStatement.setString(2, value1);
                        preparedStatement.setString(3, value2);
                        int filasAfectadas = preparedStatement.executeUpdate();
                        System.out.println(filasAfectadas + " filas afectadas.");
                    }else{
                        System.out.println("No ha sido posible cambiar el precio por un formato de precio incorrecto");
                    }                
                }
            }
            
            statement = connection.createStatement();
            resultSet = preparedStatement.executeQuery("SELECT * FROM productos2");
            
            while (resultSet.next()){             
                listaProductos.add(new Productos(resultSet.getString("CODIGO_ARTICULO"), resultSet.getString("SECCION"), resultSet.getString("NOMBRE"), resultSet.getDouble("PRECIO"), resultSet.getString("PAIS"), resultSet.getDate("FECHA")));
            }
            
            System.out.println("\nCon for:each");
            for(Productos i : listaProductos){
                System.out.print(i.getCODIGO_ARTICULO()+" | ");
                System.out.print(i.getSECCION()+" | ");
                System.out.print(i.getNOMBRE()+" | ");
                System.out.print(i.getPRECIO()+" | ");
                System.out.print(i.getPAIS()+" | ");
                System.out.print(i.getFECHA()+" | "+"\n");
            }
            File f = new File ("./lista.txt");
            FileWriter escritor = new FileWriter(f);
            
            System.out.println("\nCon iterator"); 
            Iterator <Productos> it = listaProductos.iterator();
                       
            while(it.hasNext()){
                Productos productoInspeccionado = it.next();
                System.out.print(productoInspeccionado.getCODIGO_ARTICULO()+" | ");
                System.out.print(productoInspeccionado.getSECCION()+" | ");
                System.out.print(productoInspeccionado.getNOMBRE()+" | ");
                System.out.print(productoInspeccionado.getPRECIO()+" | ");
                System.out.print(productoInspeccionado.getPAIS()+" | ");
                System.out.print(productoInspeccionado.getFECHA()+" | "+"\n");
                escritor.write(productoInspeccionado.getCODIGO_ARTICULO()+" | "+productoInspeccionado.getSECCION()+" | "+productoInspeccionado.getNOMBRE()+" | "+productoInspeccionado.getPRECIO()+" | "+productoInspeccionado.getPAIS()+" | "+productoInspeccionado.getFECHA()+" | "+"\n");
            }
            
            escritor.close();
            
            
            
            resultSet.close();
            preparedStatement.close();
            statement.close();
            
        }catch (SQLException e){
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ejercicio07.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}

