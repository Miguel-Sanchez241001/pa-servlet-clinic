package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.CitaDao;
import pe.edu.autonoma.clinica.dao.DoctorDao;
import pe.edu.autonoma.clinica.dao.PacienteDao;
import pe.edu.autonoma.clinica.entity.Cita;
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
import java.util.Optional;

@WebServlet(name = "SaveCitaServlet",urlPatterns = "/savecita")
public class SaveCitaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String key = (String) session.getAttribute("key");
        String username = (String) session.getAttribute("username");
        if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + username)){
            ValidSession.validAdmin(request, response);
        }else{
            ValidSession.valid(request, response);
        }
        String asunto = request.getParameter("asunto");
        String dni = (String) request.getSession().getAttribute("username");
        Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String fecha = request.getParameter("fecha");

        PacienteDao clienteDao=new PacienteDao();
        DoctorDao productoDao=new DoctorDao();

        String idPaciente = dni;
        Optional<Paciente> optionalPaciente = clienteDao.findDni( idPaciente );
        int idDoctor = doctorId;
        Optional<Doctor> optionalDoctor= productoDao.findId( idDoctor );

        Cita venta = new Cita(asunto,optionalPaciente.get(),optionalDoctor.get(),
                fecha);
        try {
            CitaDao dao = new CitaDao();
            dao.insert(venta);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showcitas");
        requestDispatcher.forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
