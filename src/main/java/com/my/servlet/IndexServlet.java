package com.my.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.my.servlet.User;
import com.my.servlet.UserDB;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher = null;
        HttpSession session = null;
        ArrayList<User> users = UserDB.select();
        if (login != "" && password != "" && login != null && login != null &&
            UserCheck.isUserCorrect(users, login, password)) {
            session = request.getSession(true);
            session.setAttribute("login", login);
            dispatcher = request.getRequestDispatcher("hello.jsp");
        } else {
            throw new IllegalStateException("Неверный логин или пароль!");
        }

        dispatcher.forward(request, response);
    }
}