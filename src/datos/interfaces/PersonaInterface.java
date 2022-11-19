/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.interfaces;

import entidades.Persona;
import java.util.List;

/**
 *
 * @author jeferson.agudelo
 */
public interface PersonaInterface {
    
    public int insertar(Persona obj);
    public List listar();
    public int actualizar(Persona obj);
    public int eliminar(int id);
    
    
}
