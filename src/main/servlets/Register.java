package main.servlets;

import main.database.DB_Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("DataBaseP");
        EntityManager eM = eMF.createEntityManager();

        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        float money = Float.parseFloat(request.getParameter("money"));

        DB_Profile prof = new DB_Profile(nick, password, name, surname, age, money);

        EntityTransaction eT = eM.getTransaction();
        eT.begin();
        eM.persist(prof);
        eT.commit();

        request.setAttribute("prof", prof);
        request.getRequestDispatcher("register-success.jsp").forward(request, response);
    }
}
