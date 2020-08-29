package pe.edu.autonoma.clinica.dao;

import pe.edu.autonoma.clinica.conexion.Conexion;
import pe.edu.autonoma.clinica.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDao {
    private Connection conn;
    private PreparedStatement ps;

    public UsuarioDao() {
        conn = Conexion.openConnection();
    }

    public void insert( Usuario usuario ) {
        try {
            String sql = "INSERT INTO usuario (USERNAME,PASSWORD, ENABLE,NAME ) " +
                    "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            int tempEnable = (usuario.isEnable() ? 1 : 0 );
            ps.setInt(3, tempEnable);
            ps.setString(4, usuario.getName());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }

    public List<Usuario> list() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  usuario";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                boolean tempEnable = (rs.getInt("enable") == 1 ? true : false );
                Usuario usuario = new Usuario( rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), tempEnable,
                        rs.getString("name"));

                usuarios.add(usuario);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return usuarios;
    }

    public Optional<Usuario> findId(Integer id) {
        Optional<Usuario> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  usuario WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                boolean tempEnable = (rs.getInt("enable") == 1 ? true : false );
                Usuario usuario = new Usuario( rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), tempEnable,
                        rs.getString("name"));

                optional = Optional.of(usuario);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public Optional<Usuario> findByUsername(String username) {
        Optional<Usuario> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM usuario WHERE USERNAME = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                boolean tempEnable = (rs.getInt("enable") == 1 ? true : false );
                Usuario usuario = new Usuario( rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), tempEnable,
                        rs.getString("name"));

                optional = Optional.of(usuario);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }


    public void update( Usuario usuario ) {

        try {
            int tempEnable = (usuario.isEnable() ? 1 : 0 );
            String sql = "UPDATE usuario SET USERNAME = ?, PASSWORD = ?, ENABLE = ?, NAME = ? " +
                    "WHERE ID = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, tempEnable);
            ps.setString(4, usuario.getName());
            ps.setInt(5, usuario.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }


    public void deleteId( Integer id ) {
        try {
            String sql = "DELETE FROM usuario WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

}
