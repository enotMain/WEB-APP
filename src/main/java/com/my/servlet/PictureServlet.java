package com.my.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "SendPictureServlet", urlPatterns = {"/picture"})
public class PictureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        try (InputStream inputStream = servletContext.getResourceAsStream("/Picture/picture.jpg")) {
            OutputStream outputStream = response.getOutputStream();

            if (inputStream == null) {
                response.setContentType("text/plain");
                outputStream.write("Failed to send picture".getBytes());
            } else {
                byte[] buffer = new byte[1024];
                int bytesRead;

                response.setContentType("image/png");
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}
