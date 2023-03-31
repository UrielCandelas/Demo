/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javap;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author UrielC
 */
@WebServlet(name="Logout",urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession(false); // obtiene la sesión actual sin crear una nueva sesión si no existe
    if (session != null) {
        session.invalidate(); // invalida la sesión actual
    }
    
    response.sendRedirect("IncioSesion.jsp"); // redirige al usuario a la página de inicio de sesión
}
}
