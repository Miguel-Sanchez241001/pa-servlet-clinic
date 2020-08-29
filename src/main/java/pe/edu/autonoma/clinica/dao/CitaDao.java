package pe.edu.autonoma.clinica.dao;

import pe.edu.autonoma.clinica.conexion.Conexion;
import pe.edu.autonoma.clinica.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitaDao {
    private Connection conn;
    private PreparedStatement ps;
     private PacienteDao pacientedao;
     private DoctorDao doctorDao;

    public CitaDao() {
        doctorDao = new DoctorDao();
        pacientedao = new PacienteDao();
        conn = Conexion.openConnection();
    }
    public void insert(Cita cita ) {

        try {
            java.lang.String sql = "INSERT INTO cita (ASUNTO,PACIENTE_ID,DOCTOR_ID,FECHA) " +
                    "VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cita.getAsunto());
            ps.setString(2, cita.getPacienteId().getDni());
            ps.setInt(3, cita.getDoctorId().getId());
            ps.setString(4, cita.getFecha());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
    public List<Cita> list() {
        List<Cita> ventaList = new ArrayList<>();
        try {
            java.lang.String sql = "SELECT * FROM  cita";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                String idPaciente = rs.getString("PACIENTE_ID");
                int idDoctor = rs.getInt("DOCTOR_ID");
                Optional<Doctor> optionalClientes = doctorDao.findId( idDoctor );
                Optional<Paciente> optionalProductos = pacientedao.findDni( idPaciente );
                Cita venta1 = new Cita( rs.getInt("ID"), rs.getString("ASUNTO") ,optionalProductos.get(),
                        optionalClientes.get(),rs.getString("FECHA"));
                ventaList.add(venta1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return ventaList;
    }
    public Optional<Cita> findId(Integer id) {

        Optional<Cita> optional = Optional.empty();
        try {
            java.lang.String sql = "SELECT * FROM  doctor WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                String idPaciente = rs.getString("PACIENTE_ID");
                int idDoctor = rs.getInt("DOCTOR_ID");
                Optional<Doctor> optionalClientes = doctorDao.findId( idDoctor );
                Optional<Paciente> optionalProductos = pacientedao.findDni( idPaciente );
                Cita venta12 = new Cita( rs.getInt("ID"), rs.getString("ASUNTO") ,optionalProductos.get(),
                        optionalClientes.get(),rs.getString("FECHA"));
                optional = Optional.of(venta12);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update( Cita cita ) {
        try {
            String sql = "UPDATE cita SET ASUNTO = ?, PACIENTE_ID = ?,DOCTOR_ID = ?,FECHA = ?" +

                    "WHERE ID = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, cita.getAsunto());
            ps.setString(2, cita.getPacienteId().getDni());
            ps.setInt(3, cita.getDoctorId().getId());
            ps.setString(4, cita.getFecha());
            ps.setInt(5, cita.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer ID ) {
        try {
            String sql = "DELETE FROM cita WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }























}
