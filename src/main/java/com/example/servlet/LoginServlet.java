package com.example.servlet;

import com.example.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getAttribute("user")!=null)resp.sendRedirect("/login.jsp");
        else resp.sendRedirect("/user/hello.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean fr = false;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/hello.jsp");
        RequestDispatcher dispatcher1 = req.getRequestDispatcher("/login.jsp");
        List<String> list= Users.getInstance().getUsers();
        for (String str: list) {if(req.getParameter("login").equals(str)&&
                req.getParameter("password")!=null){  fr = true;
        }
        }
        if(fr){session.setAttribute("user", true);
            req.setAttribute("user",true);
            dispatcher.forward(req,resp);}
        else dispatcher1.forward(req,resp);
    }
}
