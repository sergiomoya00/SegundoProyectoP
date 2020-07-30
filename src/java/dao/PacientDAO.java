/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pacient;
import bean.center;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samoy
 */
public class PacientDAO {

    /**
     *
     * Atributos necesarios para la implementación de los métodos de la clase
     */
    private Conexion conexion = new Conexion();
    private Connection cin = conexion.getConnection();
    private PreparedStatement ps;
    private CallableStatement cs;
    private List<Pacient> listPacient = new ArrayList<Pacient>();

    /**
     *
     * Constructor de clase vacío
     */
    public PacientDAO() {
    }

    /**
     * Método para insertar un paciente en la base de datos
     *
     * @param id Atributo que guarda la cedula del paciente a insertar en la
     * base de datos
     * @param name Atributo que guarda el nombre del paciente a insertar en la
     * base de datos
     * @param birthDay Atributo que guarda la fecha de nacimiento del paciente
     * en la base de datos
     * @param bloodType Atributo que guarda el tipo de sangre del paciente en la
     * base de datos
     * @param nationality Atributo que guarda la nacionalidad del paciente en la
     * base de datos
     * @param province Atributo que guarda la provincia en la que reside el
     * paciente en la base de datos
     * @param canton Atributo que guarda el canton en el que reside el paciente
     * en la base de datos
     * @param phone Atributo que guarda el numero del telefono del paciente en
     * la base de datos
     */
    public boolean pacientRegister(Pacient pacient) {

        String insertar = "insert into paciente (cedula,nombre,fechaNacimiento,tipoSangre,nacionalidad,provincia,canton,telefono) values(?,?,?,?,?,?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setInt(1, pacient.getId());
            ps.setString(2, pacient.getName());
            ps.setString(3, pacient.getBirthDay());
            ps.setString(4, pacient.getBloodType());
            ps.setString(5, pacient.getNationality());
            ps.setString(6, pacient.getProvince());
            ps.setString(7, pacient.getCanton());
            ps.setInt(8, pacient.getPhone());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método para eliminar los usuarios
     *
     * @param id Parametro de entrada para obtener el paciente y eliminarlo
     */
    public void deletePacient(int id) {
        String delete = "delete from paciente where cedula=" + id;

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    /**
     * Método para actualizar los pacientes
     *
     * @param id Parametro de entrada para obtener la contraseña desencriptada
     * apartir del nombre de usuario
     * @param name Parametro de entrada para obtener la contraseña desencriptada
     * apartir del nombre de usuario
     * @param birthDay Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     * @param bloodType Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     * @param nationality Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     * @param province Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     * @param canton Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     * @param phone Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     */
    public void updatePacient(int id, String name, String birthDay, String bloodType, String nationality, String province, String canton, int phone) {
        String update = "UPDATE paciente SET cedula=" + id + ", nombre='" + name + "', fechaNacimiento='" + birthDay + "', tipoSangre='" + bloodType + "', nacionalidad='" + nationality + "', provincia='" + province + "', canton='" + canton + "', telefono=" + phone + "  WHERE cedula=" + id;
        try {

            ps = cin.prepareStatement(update);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    /**
     * Método para obtener todos los pacientes de la base de datos
     *
     * @return
     */
    public List<Pacient> getAllPacients() {
        List<Pacient> pacientList = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM paciente";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pacient pacient = new Pacient();
                pacient.setId(rs.getInt("cedula"));
                pacient.setName(rs.getString("nombre"));
                pacient.setBirthDay(rs.getString("fechaNacimiento"));
                pacient.setBloodType(rs.getString("tipoSangre"));
                pacient.setNationality(rs.getString("nacionalidad"));
                pacient.setProvince(rs.getString("provincia"));
                pacient.setCanton(rs.getString("canton"));
                pacient.setPhone(rs.getInt("telefono"));
                pacientList.add(pacient);
            }
            ps.close();

        } catch (SQLException ex) {

        }
        return pacientList;

    }
}
