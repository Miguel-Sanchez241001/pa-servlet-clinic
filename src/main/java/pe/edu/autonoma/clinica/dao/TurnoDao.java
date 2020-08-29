package pe.edu.autonoma.clinica.dao;

import pe.edu.autonoma.clinica.conexion.Conexion;
import pe.edu.autonoma.clinica.entity.Turno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurnoDao {
    private Connection conn;
    private PreparedStatement ps;

    public TurnoDao() {
        conn = Conexion.openConnection();
    }
    public void insert( Turno Turno) {
        try {
            java.lang.String sql = "INSERT INTO turno (TANDA) " +
                    "VALUES (?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, Turno.getTanda());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public List<Turno> list() {
        List<Turno> clientetb = new ArrayList<>();
        try {
            java.lang.String sql = "SELECT * FROM  turno";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Turno Turno =new Turno(rs.getInt("ID"),rs.getString("TANDA")
                );
                clientetb.add(Turno);
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return clientetb;
    }
    public Optional<Turno> findId(Integer ID) {
        Optional<Turno> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  turno WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Turno Turno =new Turno(rs.getInt("ID"),rs.getString("TANDA")
                );

                optional = Optional.of(Turno);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }
    public void update( Turno Turno) {
        try {
            String sql = "UPDATE turno SET TANDA = ? " +
                    "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, Turno.getTanda());
            ps.setInt(2, Turno.getId());

            ps.executeUpdate();
            ps.close();
            System.out.println("se actualizo");
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }
    public void deleteId( Integer ID ) {
        try {
        String sql = "DELETE FROM turno WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

}
