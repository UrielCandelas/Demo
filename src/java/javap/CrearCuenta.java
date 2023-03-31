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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author UrielC
 */
@WebServlet(name="Register",urlPatterns = {"/Register"})
public class CrearCuenta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("nombre");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        RequestDispatcher dispatcher = null;
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root","n0m3l0");
            PreparedStatement ps = cn.prepareStatement("INSERT INTO sesion(Nombre,Contrasena,Correo) VALUES(?,md5(?),?)");
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, email);
            int rowCount = ps.executeUpdate();
            dispatcher = request.getRequestDispatcher("CrearCuenta.jsp");
            if (rowCount > 0) {
                request.setAttribute("estado", "exito");
            }else{
                request.setAttribute("estado", "sin_exito");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CrearCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //processRequest(request, response);
    }

    
    
    
    

}
