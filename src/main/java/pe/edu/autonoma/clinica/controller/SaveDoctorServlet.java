package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.*;
import pe.edu.autonoma.clinica.entity.Doctor;
import pe.edu.autonoma.clinica.entity.Especialidad;
import pe.edu.autonoma.clinica.entity.Paciente;
import pe.edu.autonoma.clinica.entity.Turno;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "SaveDoctorServlet",urlPatterns = "/savedoctor")
public class SaveDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ValidSession.validAdmin(request,response);
        String nombreApellido=request.getParameter("nombreApellido");
        String email=request.getParameter("email");
        String telefono=request.getParameter("telefono");
        String colegiatura=request.getParameter("colegiatura");
        Integer especialidadId=Integer.parseInt(request.getParameter("especialidadId"));
        Integer turnoId=Integer.parseInt(request.getParameter("turnoId"));

        EspecialidadDao clienteDao=new EspecialidadDao();
        TurnoDao productoDao=new TurnoDao();
        Optional<Especialidad> optionalEspecialidad = clienteDao.findId( especialidadId );
        Optional<Turno> optionalTurno= productoDao.findId( turnoId );
        Doctor doctor=new Doctor(nombreApellido ,email,telefono,colegiatura,optionalEspecialidad.get(),optionalTurno.get());

        try {
            DoctorDao dao2 = new DoctorDao();
            dao2.insert(doctor);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showdoctores");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
