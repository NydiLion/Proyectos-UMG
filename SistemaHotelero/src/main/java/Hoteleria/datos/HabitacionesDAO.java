/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoteleria.datos;

import Hoteleria.dominio.Habitaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author gegmo
 */
public class HabitacionesDAO {
    private static final String SQL_INSERT = "INSERT INTO tbl_mantenimiento_habitaciones(PK_id_habitacion,descripcion_habitacion,precio_habitacion,piso_habitaciones,estado_habitacion,tipo_de_habitacion) VALUES(?,?,?,?,?,?)";
    
    public int insert(Habitaciones mantenimiento_habitaciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConexionHoteleria.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, mantenimiento_habitaciones.getId_Habitaciones());
            stmt.setString(2,mantenimiento_habitaciones.getDescripcion());
            stmt.setInt(3,mantenimiento_habitaciones.getPrecio());
            stmt.setInt(4,mantenimiento_habitaciones.getPiso());
            stmt.setString(5,mantenimiento_habitaciones.getEstado_Habitacion());
            stmt.setString(6,mantenimiento_habitaciones.getTipo_Habitacion());
           

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionHoteleria.close(stmt);
            ConexionHoteleria.close(conn);
        }

        return rows;
    }

}
