package pe.edu.autonoma.clinica.dao;

import pe.edu.autonoma.clinica.conexion.Conexion;
import pe.edu.autonoma.clinica.entity.Doctor;
import pe.edu.autonoma.clinica.entity.Especialidad;
import pe.edu.autonoma.clinica.entity.Turno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDao {
    private Connection conn;
    private PreparedStatement ps;
    private EspecialidadDao especialidadDao;
    private TurnoDao turnoDao;

    public DoctorDao() {
especialidadDao = new EspecialidadDao();
turnoDao = new TurnoDao();
        conn = Conexion.openConnection();
    }
    public void insert( Doctor doctor ) {
        try {
            String sql = "INSERT INTO doctor (NOMBREAPELLIDO,EMAIL,TELEFONO,NCOLEGIATURA, " +
                    "IDESPECIALIDAD,IDTURNO) " +
                    "VALUES (?, ?, ?, ?, ?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getNombreApellido());
            ps.setString(2, doctor.getEmail());
            ps.setString(3, doctor.getTelefono());
            ps.setString(4, doctor.getNumeroColegiatura());
            ps.setInt(5, doctor.getEspecialidad().getId());
            ps.setInt(6, doctor.getTurno().getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
   
    public List<Doctor> list() {
        List<Doctor> ventaList = new ArrayList<>();
        try {
            java.lang.String sql = "SELECT * FROM  doctor";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                int idEspecialidad = rs.getInt("IDESPECIALIDAD");
                int idTurno = rs.getInt("IDTURNO");
                Optional<Especialidad> optionalClientes = especialidadDao.findId( idEspecialidad );
                Optional<Turno> optionalProductos = turnoDao.findId( idTurno );

                Doctor venta1 = new Doctor( rs.getInt("ID"), rs.getString("NOMBREAPELLIDO"), rs.getString("EMAIL"),
                        rs.getString("TELEFONO"),rs.getString("NCOLEGIATURA"),optionalClientes.get(),
                                optionalProductos.get()
                );
                ventaList.add(venta1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return ventaList;
    }

    public Optional<Doctor> findId(Integer id) {

        Optional<Doctor> optional = Optional.empty();
        try {
            java.lang.String sql = "SELECT * FROM  doctor WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                int idEspecialidad = rs.getInt("IDESPECIALIDAD");
                int idTurno = rs.getInt("IDTURNO");
                Optional<Especialidad> optionalClientes = especialidadDao.findId( idEspecialidad );
                Optional<Turno> optionalProductos = turnoDao.findId( idTurno );

                Doctor venta1 = new Doctor( rs.getInt("ID"), rs.getString("NOMBREAPELLIDO"), rs.getString("EMAIL"),
                        rs.getString("TELEFONO"),rs.getString("NCOLEGIATURA"),optionalClientes.get(),
                        optionalProductos.get()
                );
                optional = Optional.of(venta1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update( Doctor doctor ) {
        try {
            java.lang.String sql = "UPDATE doctor SET  NOMBREAPELLIDO = ?,EMAIL = ?,TELEFONO = ?,NCOLEGIATURA = ? " +
                    "IDESPECIALIDAD= ? ,IDTURNO= ? " +
                    "WHERE ID = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getNombreApellido());
            ps.setString(2, doctor.getEmail());
            ps.setString(3, doctor.getTelefono());
            ps.setString(4, doctor.getNumeroColegiatura());
            ps.setInt(5, doctor.getEspecialidad().getId());
            ps.setInt(6, doctor.getTurno().getId());
            ps.setInt(7, doctor.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer ID ) {
        try {
            java.lang.String sql = "DELETE FROM doctor WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }


















}
