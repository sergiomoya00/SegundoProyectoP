/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Appointment;
import bean.Pacient;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author samoy
 */
public class AppointmentDAO {

    /**
     *
     * Atributos necesarios para la implementación de los métodos de la clase
     */
    private Conexion conexion = new Conexion();
    private Connection cin = conexion.getConnection();
    private PreparedStatement ps;
    private CallableStatement cs;
    private List<Appointment> listAppointment = new ArrayList<Appointment>();

    /**
     *
     * Constructor de clase vacío
     */
    public AppointmentDAO() {
    }

    /**
     * Método para insertar un usuario en la base de datos
     *
     * @param name Atributo que guarda el nombre del centro de atencion a
     * insertar en la base de datos
     * @param ubication Atributo que guarda la ubicacion del centro de atencion
     * en la base de datos
     * @param capacity Atributo que guarda la capacidad del centro de atencion
     * en la base de datos
     * @param type Atributo que guarda el tipo de centro de atencion en la base
     * de datos
     */
    public boolean createAppontment(Appointment appointment) {

        String insertar = "insert into citas (codigoCita,cedulaPaciente,cedulaFuncionario,area,fecha,hora,observation,estado) values(?,?,?,?,?,?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setInt(1, appointment.getIdAppointment());
            ps.setObject(2, appointment.getIdPacient());
            ps.setInt(3, appointment.getId());
            ps.setString(4, appointment.getArea());
            ps.setString(5, appointment.getDate());
            ps.setString(6, appointment.getHour());
            ps.setString(7, appointment.getObservation());
            ps.setString(8, appointment.getCondition());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método para eliminar las citas
     *
     * @param idAppointment Parametro de entrada para obtener la contraseña
     * desencriptada apartir del nombre de usuario
     */
    public void deleteAppointment(int idAppointment) {
        String delete = "delete  from citas where codigoCita=" + idAppointment;

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    /**
     * Método para actualizar las citas
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
    public void updateAppointment(int idAppointment, Object idPacient, int idWorker, String area, String date, String hour, String observation, String condition) {
        String update = "UPDATE citas SET codigoCita=" + idAppointment + ", cedulaPaciente=" + idPacient + ", cedulaFuncionario=" + idWorker + ", area='" + area + "', fecha='" + date + "', hora='" + hour + "', observacion='" + observation + "', estado='" + condition + "  WHERE codigoCita=" + idAppointment;
        try {

            ps = cin.prepareStatement(update);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    
    /**
     * Método para eliminar los usuarios
     *
     * @return
     */
    public List<Appointment> getAllAppointment() {
        List<Appointment> listAppointment = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM citas WHERE cedulaPaciente=";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setIdAppointment(rs.getInt("codigoCita"));
                appointment.setIdPacient((Pacient) rs.getObject("codigoCita"));
                appointment.setId(rs.getInt("cedulaFuncionario"));
                appointment.setArea(rs.getString("area"));
                appointment.setDate(rs.getString("fecha"));
                appointment.setHour(rs.getString("hora"));
                appointment.setObservation(rs.getString("observation"));
                appointment.setCondition(rs.getString("estado"));
                listAppointment.add(appointment);
            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listAppointment;

    }

    /**
     * Método para eliminar los usuarios
     *
     * @return
     */
    public List<Appointment> getAllAppointment(int id) {
        List<Appointment> listAppointment = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM citas WHERE cedulaPaciente=" + id;
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setIdAppointment(rs.getInt("codigoCita"));
                appointment.setIdPacient((Pacient) rs.getObject("codigoCita"));
                appointment.setId(rs.getInt("cedulaFuncionario"));
                appointment.setArea(rs.getString("area"));
                appointment.setDate(rs.getString("fecha"));
                appointment.setHour(rs.getString("hora"));
                appointment.setObservation(rs.getString("observation"));
                appointment.setCondition(rs.getString("estado"));
                listAppointment.add(appointment);
            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listAppointment;

    }

    /**
     * Método para obtener las citas mediante el paciente
     *
     * @param combo Atributo que hace referencia al combobox donde se mostrará
     * todos los usuarios de la base de datos
     */
    public void getComboAppointmentByWorker(JComboBox combo, int idWorker) {
        String poi = "SELECT codigoCita FROM citas WHERE cedulaFuncionario=" + idWorker;
        try {

            ps = cin.prepareCall(poi);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                combo.addItem(result.getString("nombreUsuario"));
            }

        } catch (Exception e) {

        }
    }

    /**
     * Método para obtener las citas mediante el paciente
     *
     * @param combo Atributo que hace referencia al combobox donde se mostrará
     * todos los usuarios de la base de datos
     */
    public void getComboAppointmentByPacient(JComboBox combo, int idPacient) {
        String poi = "SELECT codigoCita FROM citas WHERE cedulaPaciente=" + idPacient;
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
