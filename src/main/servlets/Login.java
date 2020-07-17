package main.servlets;

import main.lsea.LSEA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int age=0;
        float money =0;
        PrintWriter out = response.getWriter();
        String nick = request.getParameter("user");
        String pass = request.getParameter("pass");
        String name = request.getParameter("nameP");
        String surname = request.getParameter("surnameP");
        if(!request.getParameter("age").isEmpty())age = Integer.parseInt(request.getParameter("age"));
        if(!request.getParameter("money").isEmpty())money = Float.parseFloat(request.getParameter("money"));
        if(!nick.isEmpty()&& !pass.isEmpty()&&!name.isEmpty()&&!surname.isEmpty()){
            LSEA profile = new LSEA(nick,pass,name,surname,age,money);
            HttpSession session =request.getSession();
           // session.setAttribute("profile",profile);
            request.setAttribute("profile",profile);
            //request.getRequestDispatcher("welcome.jsp").forward(request,response);

            response.sendRedirect("welcome.jsp");

        } else{
            request.setAttribute("errorMessage","Invalid login or password! Try again");
//            response.sendRedirect("index.jsp");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hello, it's me");
        int age=0;
        float money =0;

        String nick = request.getParameter("user");
        String pass = request.getParameter("pass");
        String name = request.getParameter("nameP");
        String surname = request.getParameter("surnameP");
        if(!request.getParameter("age").isEmpty())age = Integer.parseInt(request.getParameter("age"));
        if(!request.getParameter("money").isEmpty())money = Float.parseFloat(request.getParameter("money"));
        LSEA profile = new LSEA(nick,pass,name,surname,age,money);
        out.print(profile.toString());
    }
}
