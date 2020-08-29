package pe.edu.autonoma.clinica.controller;

import pe.edu.autonoma.clinica.dao.CitaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCitaServlet",urlPatterns = "/deletecita")
public class DeleteCitaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ValidSession.validAdmin(request,response);
        Integer id = Integer.parseInt( request.getParameter("id") );
        RequestDispatcher requestDispatcher = null;
        try {
            CitaDao dao = new CitaDao();
            dao.deleteId(id);
            requestDispatcher = request.getRequestDispatcher("/showcitas");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
