package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.DoctorDao;
import pe.edu.autonoma.clinica.dao.PacienteDao;
import pe.edu.autonoma.clinica.entity.Doctor;
import pe.edu.autonoma.clinica.entity.Paciente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewCitaServlet",urlPatterns = "/newcita")
public class NewCitaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String key = (String) session.getAttribute("key");
        String username = (String) session.getAttribute("username");
        if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + username)){
            ValidSession.validAdmin(request, response);
        }else{
            ValidSession.valid(request, response);
        }
        List<Doctor> doctor = new ArrayList<>();
        try {

            DoctorDao dao1 = new DoctorDao();
            doctor = dao1.list();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        request.setAttribute("doctores", doctor);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register-cita.jsp");
        requestDispatcher.forward(request, response);
    }
}
