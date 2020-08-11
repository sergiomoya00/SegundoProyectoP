/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Diagnostics;
import bean.Treatments;
import bean.center;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jabre
 */
public class DiagnosticsDAO {

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
    public DiagnosticsDAO() {

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
    public boolean diagnosticsRegister(Diagnostics diagnostic) {
        String insertar = "insert into catalogoDiagnosticos (nombreDiagnostico,nivel,observaciones) values(?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setString(1, diagnostic.getName());
            ps.setString(2, diagnostic.getLevel());
            ps.setString(3, diagnostic.getObservations());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean patientDiagnosticsRegister(Diagnostics diagnostic) {
        String insertar = "insert into diagnosticoPaciente (cedulaPaciente,nombreDiagnostico,fechaDiagnostico) values(?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setInt(1, diagnostic.getIdPatient());
            ps.setString(2, diagnostic.getName());
            ps.setString(3, diagnostic.getDate());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Diagnostics> getAllDiagnostics() {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM catalogoDiagnosticos ";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Diagnostics diagnostics = new Diagnostics();
                diagnostics.setLevel(rs.getString("nivel"));
                diagnostics.setObservations(rs.getString("observaciones"));
                diagnostics.setName(rs.getString("nombreDiagnostico"));
                diagnostics.setDate(rs.getString("fechaDiagnostico"));
                listDiagnostics.add(diagnostics);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsByName(String name) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT B.nivel,B.observaciones,B.nombreDiagnostico,A.fechaDiagnostico,A.cedulaPaciente FROM diagnosticoPaciente A, catalogoDiagnosticos B where A.nombreDiagnostico=B.nombreDiagnostico AND nombreDiagnostico='" + name + "'";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Diagnostics diagnostics = new Diagnostics();
                diagnostics.setLevel(rs.getString("nivel"));
                diagnostics.setObservations(rs.getString("observaciones"));
                diagnostics.setName(rs.getString("nombreDiagnostico"));
                diagnostics.setDate(rs.getString("fechaDiagnostico"));
                diagnostics.setIdPatient(rs.getInt("cedulaPaciente"));
                listDiagnostics.add(diagnostics);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsByLevel(String level) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT B.nivel,B.observaciones,B.nombreDiagnostico,A.fechaDiagnostico,A.cedulaPaciente FROM diagnosticoPaciente A, catalogoDiagnosticos B where A.nombreDiagnostico=B.nombreDiagnostico AND B.nivel='" + level + "'";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Diagnostics diagnostics = new Diagnostics();
                diagnostics.setLevel(rs.getString("nivel"));
                diagnostics.setObservations(rs.getString("observaciones"));
                diagnostics.setName(rs.getString("nombreDiagnostico"));
                diagnostics.setDate(rs.getString("fechaDiagnostico"));
                diagnostics.setIdPatient(rs.getInt("cedulaPaciente"));
                listDiagnostics.add(diagnostics);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsByPatient(int id) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT B.nivel,B.observaciones,B.nombreDiagnostico,A.fechaDiagnostico,A.cedulaPaciente FROM diagnosticoPaciente A, catalogoDiagnosticos B where A.nombreDiagnostico=B.nombreDiagnostico AND A.cedulaPaciente="+id;
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Diagnostics diagnostics = new Diagnostics();
                diagnostics.setLevel(rs.getString("nivel"));
                diagnostics.setObservations(rs.getString("observaciones"));
                diagnostics.setName(rs.getString("nombreDiagnostico"));
                diagnostics.setDate(rs.getString("fechaDiagnostico"));
                diagnostics.setIdPatient(rs.getInt("cedulaPaciente"));
                listDiagnostics.add(diagnostics);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsByDate(String date) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM diagnosticoPaciente where fechaDiagnostico='" + date + "'";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Diagnostics diagnostics = new Diagnostics();
                diagnostics.setLevel(rs.getString("nivel"));
                diagnostics.setObservations(rs.getString("observaciones"));
                diagnostics.setName(rs.getString("nombreDiagnostico"));
                diagnostics.setDate(rs.getString("fechaDiagnostico"));
                listDiagnostics.add(diagnostics);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsQuantity(String name) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        int quantity = 0;
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM diagnosticoPaciente";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                quantity++;

            }
            ps.close();

        } catch (SQLException ex) {

        }
        Diagnostics diagnostics = new Diagnostics();
        diagnostics.setQuantity(quantity);
        listDiagnostics.add(diagnostics);
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsQuantityByArea(String name) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        int quantity = 0;
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM diagnosticoPaciente where nombreArea='" + name + "'";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                quantity++;

            }
            ps.close();

        } catch (SQLException ex) {

        }
        Diagnostics diagnostics = new Diagnostics();
        diagnostics.setQuantity(quantity);
        listDiagnostics.add(diagnostics);
        return listDiagnostics;

    }

    public List<Diagnostics> getAllDiagnosticsQuantityByPatient(int id) {
        List<Diagnostics> listDiagnostics = new ArrayList<>();
        int quantity = 0;
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM diagnosticoPaciente where cedulaPaciente=" + id;
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {

                quantity++;
            }
            ps.close();

        } catch (SQLException ex) {

        }
        Diagnostics diagnostics = new Diagnostics();
        diagnostics.setQuantity(quantity);
        listDiagnostics.add(diagnostics);
        return listDiagnostics;

    }

    public void deleteDiagnostic(Diagnostics diagnostic) {
        String delete = "delete  from catalogoDiagnosticos where nombreDiagnostico='" + diagnostic.getName() + "'";

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
