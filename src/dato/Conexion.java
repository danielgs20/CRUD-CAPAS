/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dato;

/**
 *
 * @author jeferson.agudelo
 */
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jeferson.agudelo
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/datos";
        String user="root";
        String pass="1234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch(Exception e){
            
        }
        return con;
    }
}