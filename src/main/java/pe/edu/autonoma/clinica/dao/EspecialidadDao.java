package pe.edu.autonoma.clinica.dao;

import pe.edu.autonoma.clinica.conexion.Conexion;
import pe.edu.autonoma.clinica.entity.Especialidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EspecialidadDao {
    private Connection conn;
    private PreparedStatement ps;

    public EspecialidadDao() {
        conn = Conexion.openConnection();
    }

    public void insert( Especialidad especialidad ) {

        try {
            String sql = "INSERT INTO especialidad (NOMBRE,COSTO) " +
                    "VALUES (?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, especialidad.getNombre());
            ps.setInt(2, especialidad.getCosto());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Especialidad> list() {
        List<Especialidad> clientetb = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  especialidad";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Especialidad cliente=new Especialidad(rs.getInt("ID"),rs.getString("NOMBRE"),rs.getInt("COSTO")
                );
                clientetb.add(cliente);
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return clientetb;
    }

    public Optional<Especialidad> findId(Integer ID) {
        Optional<Especialidad> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  especialidad WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Especialidad cliente=new Especialidad(rs.getInt("ID"),rs.getString("NOMBRE"),rs.getInt("COSTO")
                );
                optional = Optional.of(cliente);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update( Especialidad especialidad ) {
        try {
            String sql = "UPDATE especialidad SET NOMBRE = ?, COSTO = ? " +
                    "WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, especialidad.getNombre());
            ps.setInt(2, especialidad.getCosto());
            ps.setInt(3, especialidad.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("se actualizo");
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer ID ) {
        try {
            String sql = "DELETE FROM especialidad WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }










}
