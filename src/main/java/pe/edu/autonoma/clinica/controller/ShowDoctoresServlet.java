package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.DoctorDao;
import pe.edu.autonoma.clinica.entity.Doctor;

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

@WebServlet(name = "ShowDoctoresServlet",urlPatterns = "/showdoctores")
public class ShowDoctoresServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String key = (String) session.getAttribute("key");
        String username = (String) session.getAttribute("username");
        if (!key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + username)){
            ValidSession.valid(request, response);
        }else{
            ValidSession.validAdmin(request, response);

        }
        List<Doctor> doctores = new ArrayList<>();
        try{
            DoctorDao dao = new DoctorDao();
            doctores = dao.list();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        request.setAttribute("doctores", doctores);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-doctores.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);

    }
}
