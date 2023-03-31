/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name="Login",urlPatterns = {"/Login"})
public class IniciarSesion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        
        RequestDispatcher dispatcher = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root","n0m3l0");
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM sesion WHERE Correo = ? and Contrasena = md5(?)");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                session.setAttribute("name", rs.getString("Nombre"));
                dispatcher = request.getRequestDispatcher("PaginaPrincipal.jsp");
            }else{
                request.setAttribute("estado2", "fallido");
                dispatcher = request.getRequestDispatcher("IncioSesion.jsp");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //processRequest(request, response);
    }

}
