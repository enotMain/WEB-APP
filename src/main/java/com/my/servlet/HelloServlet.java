package com.my.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // Очищение сессии
        Cookie cookie = new Cookie("password",""); // Создание куки
        cookie.setMaxAge(0); // Максимальная длительность существования 0 сек
        response.addCookie(cookie); // Добавляем в ответ
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
