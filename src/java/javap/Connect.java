/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author UrielC
 */
public class Connect {
    private final String db = "usuarios";
    private final String url = "jdbc:mysql://localhost:3306/" + db;
    private final String user = "root";
    private final String pass = "n0m3l0";
    public Connect(){
    }
    public Connection conect(){
        Connection dbconn = null;
        try {
            Class.forName("com.mysql.jdbc.cj.Driver");
            dbconn=DriverManager.getConnection(this.url,this.user,this.pass);
                    
        } catch (SQLException e) {
            System.out.println(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbconn;
    }
}
