/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dato;

import datos.interfaces.PersonaInterface;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import presentacion.Vista;

/**
 *
 * @author jeferson.agudelo
 */
public class PersonaDao implements PersonaInterface{
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vista vista = new Vista();

    @Override
    public int insertar(Persona obj){
        int r=0;
        String sql="insert into persona(Nombres,Correo,Telefono)values(?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,obj.getNombres());
            ps.setString(2,obj.getCorreo());
            ps.setString(3,obj.getTelefono());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        }catch (Exception e) {
        }  
        return r;
    }

    @Override
    public List listar(){
        List<Persona>datos=new ArrayList<>();
        String sql=("select * from Persona");
        try{
            con=conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                datos.add(p);
            }
            
        } catch(Exception e){
            
        }
            
        return datos;
    }


    @Override
    public int actualizar(Persona obj) {
        int r=0;
        String sql="update persona set Nombres=?,Correo=?,Telefono=? where Id=?";        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,obj.getNombres());
            ps.setString(2,obj.getCorreo());
            ps.setString(3,obj.getTelefono());
            ps.setInt(4,obj.getId());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }

    @Override
    public int eliminar(int id) {
        int r=0;
        String sql="delete from persona where Id="+id;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
