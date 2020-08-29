package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.PacienteDao;
import pe.edu.autonoma.clinica.dao.UsuarioDao;
import pe.edu.autonoma.clinica.entity.Paciente;
import pe.edu.autonoma.clinica.entity.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet",urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni=request.getParameter("dni");
        String nombreApellido=request.getParameter("nombreApellido");
        String email=request.getParameter("email");
        String telefono=request.getParameter("telefono");
        Integer edad=Integer.parseInt(request.getParameter("edad"));
        String name="user";
        String password=request.getParameter("password");
        boolean status=true;
        Usuario usuario=new Usuario(dni,password,status,name);
        Paciente paciente=new Paciente(dni,nombreApellido,email,telefono,edad);

        try {
            UsuarioDao dao = new UsuarioDao();
            dao.insert(usuario);
            PacienteDao dao2 = new PacienteDao();
            dao2.insert(paciente);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
