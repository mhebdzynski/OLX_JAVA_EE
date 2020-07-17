package main.servlets;

import main.database.DB_Profile;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainDashboard")
public class MainDashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("DataBaseP");
        EntityManager eM = eMF.createEntityManager();
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertUser(request, response, eM);
                break;
            case "/delete":
                deleteUser(request, response, eM);
                break;
            case "/edit":
                showEditForm(request, response, eM);
                break;
            case "/update":
                updateUser(request, response, eM);
                break;
            default:
                listUser(request, response, eM);
                break;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response, EntityManager eM) throws IOException, ServletException {
        String queryString = "SELECT p FROM DB_Profile p";
        Query query = eM.createQuery(queryString);
        List<DB_Profile> listProf = query.getResultList();

        request.setAttribute("listProf", listProf);
        request.getRequestDispatcher("register-success.jsp").forward(request, response);
    }


    private void insertUser(HttpServletRequest request, HttpServletResponse response, EntityManager eM) throws IOException {
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
        response.sendRedirect("register-success.jsp");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response, EntityManager eM)  throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        DB_Profile prof = eM.find(DB_Profile.class, id);
        EntityTransaction eT = eM.getTransaction();

        eT.begin();
        if(prof != null){
            eM.remove(prof);
            System.out.println("Profile is deleted");
        }
        eT.commit();
        response.sendRedirect("register-success.jsp");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response, EntityManager eM) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        float money = Float.parseFloat(request.getParameter("money"));

        DB_Profile prof = eM.find(DB_Profile.class, id);
        EntityTransaction eT = eM.getTransaction();

        eT.begin();
        prof.setNick(nick);
        prof.setPassword(password);
        prof.setName(name);
        prof.setSurname(surname);
        prof.setAge(age);
        prof.setMoney(money);
        eM.persist(prof);
        eT.commit();
        response.sendRedirect("register-success.jsp");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response, EntityManager eM) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DB_Profile prof = eM.find(DB_Profile.class, id);
        request.setAttribute("prof", prof);

        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }
}
