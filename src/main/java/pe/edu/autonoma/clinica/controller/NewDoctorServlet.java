package pe.edu.autonoma.clinica.controller;


import pe.edu.autonoma.clinica.dao.EspecialidadDao;
import pe.edu.autonoma.clinica.dao.TurnoDao;
import pe.edu.autonoma.clinica.entity.Especialidad;
import pe.edu.autonoma.clinica.entity.Turno;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewDoctorServlet",urlPatterns = "/newdoctor")
public class NewDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ValidSession.validAdmin(request,response);
        List<Especialidad> especialidads = new ArrayList<>();
        List<Turno> turnos = new ArrayList<>();

        try {

            EspecialidadDao dao1 = new EspecialidadDao();
            TurnoDao dao = new TurnoDao();
            turnos = dao.list();

            especialidads = dao1.list();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        request.setAttribute("especialidades", especialidads);
        request.setAttribute("turnos", turnos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register-doctor.jsp");
        requestDispatcher.forward(request, response);
    }
}
