package pe.edu.autonoma.clinica.dao;

import pe.edu.autonoma.clinica.conexion.Conexion;
import pe.edu.autonoma.clinica.entity.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteDao {
    private Connection conn;
    private PreparedStatement ps;

    public PacienteDao() {
        conn = Conexion.openConnection();
    }

    public void insert(Paciente paciente ) {

        try {
            String sql = "INSERT INTO paciente (DNI,NOMBREAPELLIDO,EMAIL,TELEFONO,EDAD) " +
                    "VALUES (?, ?, ?, ?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombreApellido());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getTelefono());
            ps.setInt(5, paciente.getEdad());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Paciente> list() {
        List<Paciente> clientetb = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  paciente";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Paciente cliente=new Paciente(rs.getString("DNI"),rs.getString("NOMBREAPELLIDO"),rs.getString("EMAIL") ,rs.getString("TELEFONO") ,rs.getInt("EDAD")
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

    public Optional<Paciente> findDni(String dni) {
        Optional<Paciente> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  paciente WHERE DNI = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Paciente cliente=new Paciente(rs.getString("DNI"),rs.getString("NOMBREAPELLIDO"),rs.getString("EMAIL") ,rs.getString("TELEFONO") ,rs.getInt("EDAD")
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

    public void update( Paciente paciente ) {
        try {
            String sql = "UPDATE paciente SET  NOMBREAPELLIDO = ?, EMAIL = ?, TELEFONO = ?, EDAD = ? " +
                    "WHERE DNI = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombreApellido());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getTelefono());
            ps.setInt(5, paciente.getEdad());


            ps.executeUpdate();
            ps.close();
            System.out.println("se actualizo");
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteDni( String dni ) {
        try {
            String sql = "DELETE FROM clientes WHERE DNI = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dni);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }










}
