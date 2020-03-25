package com.my.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.my.servlet.User;
import com.my.servlet.UserDB;


@WebServlet("/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(UserDB.select() == null){
            throw new IllegalStateException("BD connect error");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != "" && password != "" && login != null && login != null){
            ArrayList<User> users = UserDB.select();
            if (UserCheck.isUserCorrect(users, login, password)){
                HttpSession session = request.getSession(); // Создаём сессию
                session.setAttribute("login", login); // Добавляем ключ-значение в сессию
                response.addCookie(new Cookie("password", password)); // Добавляем новый куки в ответ
                request.getRequestDispatcher("/hello.jsp").forward(request, response);
            } else {
                throw new IllegalStateException("Wrong Login or Password");
            }
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}