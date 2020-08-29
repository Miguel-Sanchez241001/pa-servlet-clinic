package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.PacienteDao;
import pe.edu.autonoma.clinica.entity.Paciente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowPacientesServlet",urlPatterns = "/showpacientes")
public class ShowPacientesServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ValidSession.validAdmin(request, response);

        List<Paciente> pacientes = new ArrayList<>();
        try{
            PacienteDao dao = new PacienteDao();
            pacientes = dao.list();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        request.setAttribute("pacientes", pacientes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-pacientes.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);

    }
}
