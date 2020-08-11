/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Area;
import bean.Treatments;
import bean.Worker;
import bean.center;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jabre
 */
public class WorkerDAO {

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
    public WorkerDAO() {

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
    public boolean workerRegister(Worker worker) {
        long time = System.currentTimeMillis();
        java.sql.Date d = new java.sql.Date(time);
        long now = System.currentTimeMillis();
        java.sql.Time a = new java.sql.Time(now);
        String datetime = d + " " + a;
        String insertar = "insert into funcionario (cedula,nombre,tipo,fechaEntrega,area) values(?,?,?,?,?)";
        try {
            
            ps = cin.prepareCall(insertar);
            ps.setInt(1, worker.getId());
            ps.setString(2, worker.getName());
            ps.setString(3, worker.getType());
            ps.setString(4, datetime);
            ps.setString(5, worker.getArea());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Worker> getAllWorkers() {
        List<Worker> listWorker = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM funcionario ";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId(rs.getInt("cedula"));
                worker.setName(rs.getString("nombre"));
                worker.setType(rs.getString("tipo"));
                worker.setFechaDeEntrega(rs.getString("fechaEntrega"));
                worker.setArea(rs.getString("area"));
                listWorker.add(worker);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listWorker;

    }
    
    public boolean areaRegister(Area area) {
        long time = System.currentTimeMillis();
        java.sql.Date d = new java.sql.Date(time);
        long now = System.currentTimeMillis();
        java.sql.Time a = new java.sql.Time(now);
        String datetime = d + " " + a;
        String insertar = "insert into area (nombre) values(?)";
        try {
            
            ps = cin.prepareCall(insertar);
            ps.setString(1, area.getName());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    public void deleteWorker(Worker worker) {
        String delete = "delete  from funcionario where nombre='" + worker.getName() + "'";

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

}
