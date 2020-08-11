/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Hospitalized;
import bean.Treatments;
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
public class HospitalizedDAO {

    /**
     *
     * Atributos necesarios para la implementación de los métodos de la clase
     */
    private Conexion conexion = new Conexion();
    private Connection cin = conexion.getConnection();
    private PreparedStatement ps;

    /**
     *
     * Constructor de clase vacío
     */
    public HospitalizedDAO() {

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
    public boolean hospitalizationRegister(Hospitalized hospi) {
        String insertar = "insert into pacienteHospitalizado (centroAtencion,cedulaPaciente,nombrePaciente,diagnostico,fechaInicio,fechaSalida,area,cedulaFuncionario) values (?,?,?,?,?,?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setInt(1, hospi.getCenter());
            ps.setInt(2, hospi.getPacientID());
            ps.setString(3, hospi.getPacientName());
            ps.setString(4, hospi.getDiagnostic());
            ps.setString(5, hospi.getStartDate());
            ps.setString(6, hospi.getDepartureDate());
            ps.setString(7, hospi.getArea());
            ps.setInt(8, hospi.getWorker());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Hospitalized> getAllHospitalizedPacient() {
        List<Hospitalized> listHospitalized = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM pacienteHospitalizado ";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Hospitalized hospi = new Hospitalized();
                hospi.setCenter(rs.getInt("centroAtencion"));
                hospi.setPacientID(rs.getInt("cedulaPaciente"));
                hospi.setPacientName(rs.getString("nombrePaciente"));
                hospi.setDiagnostic(rs.getString("diagnostico"));
                hospi.setStartDate(rs.getString("fechaInicio"));
                hospi.setDepartureDate(rs.getString("fechaSalida"));
                hospi.setArea(rs.getString("area"));
                hospi.setWorker(rs.getInt("cedulaFuncionario"));
                listHospitalized.add(hospi);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listHospitalized;

    }

    public void deleteDiagnostic(Hospitalized hospi) {
        String delete = "delete  from pacienteHospitalizado where cedulaPaciente=" + hospi.getPacientID() + " and diagnostico='" + hospi.getDiagnostic() + "'";

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
