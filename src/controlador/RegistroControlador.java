/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import db.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Pelicula;
import modelo.Registro;
/**
 *
 * @author Gabriel
 */
public class RegistroControlador {
    Registro registro = new Registro();
    public boolean agregar(Pelicula pelicula){
        return registro.agregar(pelicula);
    }    
    public boolean modificar(Pelicula pelicula){
        return registro.modificar(pelicula);
    }

    public ArrayList listar(){
        return registro.listar();
    }    
    public ArrayList listar(Integer cod){
        return registro.listar(cod);
    }
    public boolean borrar(Integer codigo){ 
        return registro.borrar(codigo);
    } 
    public ResultSet listaCategoria(){
        return registro.listarCategoria();
    }
    public boolean buscar(Integer cod){
        return registro.buscar(cod);
    }    
}