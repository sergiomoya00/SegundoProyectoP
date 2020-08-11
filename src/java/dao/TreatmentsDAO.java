/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Diagnostics;
import bean.Treatments;
import bean.Worker;
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
public class TreatmentsDAO {

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
    public TreatmentsDAO() {
        
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
    public boolean treatmentRegister(Treatments treat) {
        String insertar = "insert into catalogoTratamientos (tratamiento,nombreDiagnostico,cantidadUnidades,tipo) values(?,?,?,?)";
        try {
            
            ps = cin.prepareCall(insertar);
            ps.setString(1, treat.getName());
            ps.setString(2, treat.getIdDiagnostic());
            ps.setInt(3, treat.getQuantity());
            ps.setString(4, treat.getType());
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Treatments> getAllTreatments() {
        List<Treatments> listTreatments = new ArrayList<>();
        try {
            
            ResultSet rs = null;
            String login = "SELECT * FROM catalogoTratamientos ";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Treatments treatments = new Treatments();
                treatments.setIdDiagnostic(rs.getString("nombreDiagnostico"));
                treatments.setName(rs.getString("tratamiento"));
                treatments.setQuantity(rs.getInt("cantidadUnidades"));
                treatments.setType(rs.getString("tipo"));
                listTreatments.add(treatments);
                
            }
            ps.close();
            
        } catch (SQLException ex) {
            
        }
        return listTreatments;
        
    }
    
        public void deleteDiagnostic(Treatments treatment) {
        String delete = "delete  from catalogoTratamientos where tratamiento='" + treatment.getName() + "'";

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
