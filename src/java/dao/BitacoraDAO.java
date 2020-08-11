/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Bitacora;
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
public class BitacoraDAO {

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
    public BitacoraDAO() {

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
    public boolean bitacoraRegister(Bitacora bitacora) {
        String insertar = "insert into bitacora (idBitacora, fecha,hora,usuario,codigoCita,estado) values (?,?,?,?,?,?)";
        try {

            ps = cin.prepareCall(insertar);
            ps.setInt(1, bitacora.getIdBitacora());
            ps.setString(2, bitacora.getDate());
            ps.setString(3, bitacora.getHour());
            ps.setString(4, bitacora.getUser());
            ps.setInt(5, bitacora.getAppointmentCode());
            ps.setString(6, bitacora.getCondition());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Bitacora> getAllBitacora() {
        List<Bitacora> listBitacora = new ArrayList<>();
        try {

            ResultSet rs = null;
            String login = "SELECT * FROM bitacora ";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                Bitacora bitacora = new Bitacora();
                bitacora.setIdBitacora(rs.getInt("idBitacora"));
                bitacora.setDate(rs.getString("fecha"));
                bitacora.setHour(rs.getString("hora"));
                bitacora.setUser(rs.getString("usuario"));
                bitacora.setAppointmentCode(rs.getInt("codigoCita"));
                bitacora.setCondition(rs.getString("estado"));
                listBitacora.add(bitacora);

            }
            ps.close();

        } catch (SQLException ex) {

        }
        return listBitacora;

    }

    public void deleteBitacora(Bitacora bitacora) {
        String delete = "delete  from bitacora where idBitacora=" + bitacora.getIdBitacora();

        try {
            ps = cin.prepareCall(delete);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
