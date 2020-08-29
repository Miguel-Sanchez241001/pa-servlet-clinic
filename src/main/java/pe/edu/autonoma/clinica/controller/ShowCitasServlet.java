package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.CitaDao;
import pe.edu.autonoma.clinica.entity.Cita;

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

@WebServlet(name = "ShowCitasServlet",urlPatterns = "/showcitas")
public class ShowCitasServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String key = (String) session.getAttribute("key");
        String username = (String) session.getAttribute("username");
        if (key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + username)){
            ValidSession.validAdmin(request, response);
        }else{
            ValidSession.valid(request, response);
        }
    List<Cita> citas = new ArrayList<>();
        try{
            CitaDao dao = new CitaDao();
        citas = dao.list();

    }catch (Exception e){
        System.err.println(e.getMessage());
    }
        request.setAttribute("citas", citas);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-citas.jsp");
        requestDispatcher.forward(request, response);
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
