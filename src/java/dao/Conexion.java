/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jabre
 */
public class Conexion {
    
     /**
     *
     * Atributos necesarios para la implementación de los métodos de la clase
     */

    private static Connection con=null;
    private static final String url = "jdbc:sqlserver://DESKTOP-VRFNBQA:1433;databaseName=TareaProgramada2";
    
      /**
     * Método para obtener la conexión con la base de datos
     * @return 
     */

    public Connection getConnection() {
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url,"userSQL","123");
            if (con != null) {
                System.out.print("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("Conexion fail");
        }  
        return con;
    }

}
