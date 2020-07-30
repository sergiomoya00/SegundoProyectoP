/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bean.center;

/**
 *
 * @author jabre
 */
public class CenterDAO {

    /**
     *
     * Atributos necesarios para la implementación de los métodos de la clase
     */
    private Conexion conexion = new Conexion();
    private Connection cin = conexion.getConnection();
    private PreparedStatement ps;
    private CallableStatement cs;
    private List<center> listCenter =new ArrayList<center>();

    /**
     *
     * Constructor de clase vacío
     */
    public CenterDAO() {

    }

    /**
     * Método para insertar un usuario en la base de datos
     *
     * @param name Atributo que guarda el nombre del centro de atencion a insertar en la base de datos
     * @param ubication Atributo que guarda la ubicacion del centro de atencion en la base de datos
     * @param capacity Atributo que guarda la capacidad del centro de atencion en la base de datos
     * @param type Atributo que guarda el tipo de centro de atencion en la base de datos
     */
    public boolean centerRegister(center center) {

        String insertar = "insert into centroDeAtencion (nombre,ubicacion,capacidad,tipo) values(?,?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setString(1, center.getName());
            ps.setString(2, center.getUbication());
            ps.setInt(3, center.getCapacity());
            ps.setString(4, center.getType());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
        return false;
        }
    }

    /**
     * Método para verificar las credenciales de los usuarios
     *
     * @param email Atributo que guarda el identificador del usuario en la base
     * de datos
     * @param password Atributo que la contraseña del usuario en la base de
     * datos
     * @return
     */
    public boolean logIn(String email, String password,String type) {
        try {

            String login = "select nombreUsuario,contraseña,tipo from usuario where nombreUsuario='" + email + "' AND contraseña='" + password + "' AND tipo='"+type+"'";
            ps = cin.prepareStatement(login);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                return true;
            }

        } catch (SQLException ex) {
        
        } catch (NullPointerException e) {
        
        }
        return false;
    }

    /**
     * Método para verificar las credenciales de los usuarios
     *
     * @param email Parametro de entrada para obtener el correo electronico
     * apartir del nombre de usuario
     * @return
     */
    public String getEmail(String email) {
        String user = "";
        try {
            ResultSet rs = null;
            String login = "select correoElectronico from usuarios where nombreUsuario='" + email + "'";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {

                user = rs.getString("correoElectronico");
                return user;
            }

        } catch (SQLException ex) {

        }
        return user;
    }

    /**
     * Método para verificar las credenciales de los usuarios
     *
     * @param pass Parametro de entrada para obtener la contraseña desencriptada
     * apartir del nombre de usuario
     * @return
     */
    public String getPassword(String pass) {
        String result = "";
        try {
            cs = cin.prepareCall("{?=call ENCRIPTA_PASS(?)}");
            cs.registerOutParameter(1, Types.VARBINARY);
            cs.setString(2, pass);
            cs.execute();
            result = cs.getString(1);

        } catch (SQLException ex) {

        }

        return result;
    }

    /**
     * Método para obtener el rol de los usuarios
     *
     * @param username Parametro de entrada para obtener el rol apartir del
     * nombre de usuario
     * @return
     */
    public String getRole(String username) {
        String user = "";
        try {
            ResultSet rs = null;
            String login = "select rol from usuarios where nombreUsuario='" + username + "'";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {

                user = rs.getString("rol");
                return user;
            }

        } catch (SQLException ex) {

        }
        return user;

    }

    /**
     * Método para eliminar los usuarios
     *
     * @param username Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     */
    public void deleteUser(String username) {
        String delete = "delete  from usuarios where nombreUsuario='" + username + "'";

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    /**
     * Método para eliminar los usuarios
     *
     * @param username Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     * @param email Parametro de entrada para actualizar el correo apartir del
     * nombre de usuario
     * @param password Parametro de entrada para actualizar la contraseña
     * desencriptada apartir del nombre de usuario
     * @param role Parametro de entrada para actualizar el rol apartir del
     * nombre de usuario
     */
    public void updateUser(String username, String email, String password, String role) {
        String update = "UPDATE usuarios SET  nombreUsuario='" + username + "', correoElectronico='" + email + "', contraseña=dbo.ENCRIPTA_PASS('" + password + "'), rol='" + role + "'  WHERE nombreUsuario='" + username + "'";
        try {

            ps = cin.prepareStatement(update);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    /**
     * Método para eliminar los usuarios
     * @return 
     */
    public List<center> getAllCenters() {
         List<center> listCenter =new ArrayList<>();
        try {
           
            ResultSet rs = null;
            String login = "SELECT * FROM centroDeAtencion ";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();
            
            while (rs.next()) {
               center center=new center();
               center.setName(rs.getString("nombre"));
               center.setUbication(rs.getString("ubicacion"));
               center.setCapacity(rs.getInt("capacidad"));
               center.setType(rs.getString("tipo"));
               center.setId(rs.getInt("codigo"));
               listCenter.add(center);
            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listCenter;

    }

    /**
     * Método para eliminar los usuarios
     *
     * @param combo Atributo que hace referencia al combobox donde se mostrará
     * todos los usuarios de la base de datos
     */
    public void getComboUserProviders(JComboBox combo) {
        String poi = "SELECT nombreUsuario FROM usuarios WHERE rol='Proveedor'";
        try {

            ps = cin.prepareCall(poi);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                combo.addItem(result.getString("nombreUsuario"));
            }

        } catch (Exception e) {

        }
    }
}
