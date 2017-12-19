/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Registro {
    
    public ArrayList listar(){
        ArrayList <Pelicula> list = new ArrayList<>();
        Integer codigo;
        Integer precio;
        String categoria;
        String cuatroK;
        String nombre;
        
        
        try {
            String sql = "SELECT VB_PELICULA.CODIGO ,VB_PELICULA.PRECIO ,VB_CATEGORIA.DESCRIPCION ,VB_PELICULA.FORMATO4K ,VB_PELICULA.NOMBRE  FROM VB_PELICULA JOIN VB_CATEGORIA ON VB_PELICULA.ID_CATEGORIA=VB_CATEGORIA.ID";
            ResultSet resultSet = Conexion.select(sql);
            while (resultSet.next()) {
                codigo=resultSet.getInt(1);
                precio=resultSet.getInt(2);
                categoria=resultSet.getString(3);
                cuatroK=resultSet.getString(4);
                nombre=resultSet.getString(5);

                
                Pelicula peli = new Pelicula(codigo, precio, categoria, cuatroK, nombre);
                list.add(peli);
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
        }
        
        
        
        return list;
    }

    public ArrayList listar(Integer cod){
        ArrayList <Pelicula> list = new ArrayList<>();
        Integer codigo;
        Integer precio;
        String categoria;
        String cuatroK;
        String nombre;
        
        
        try {
            String sql = "SELECT VB_PELICULA.CODIGO ,VB_PELICULA.PRECIO ,VB_CATEGORIA.DESCRIPCION ,VB_PELICULA.FORMATO4K ,VB_PELICULA.NOMBRE  FROM VB_PELICULA JOIN VB_CATEGORIA ON VB_PELICULA.ID_CATEGORIA=VB_CATEGORIA.ID WHERE VB_PELICULA.CODIGO="+cod;
            ResultSet resultSet = Conexion.select(sql);
            while (resultSet.next()) {
                codigo=resultSet.getInt(1);
                precio=resultSet.getInt(2);
                categoria=resultSet.getString(3);
                cuatroK=resultSet.getString(4);
                nombre=resultSet.getString(5);

                
                Pelicula peli = new Pelicula(codigo, precio, categoria, cuatroK, nombre);
                list.add(peli);
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
        }
        
        
        
        return list;
    }    
    
    
    
    public boolean buscar(Integer cod){
        boolean retorno=false;
        String sql = "SELECT * FROM VB_PELICULA";
        ResultSet resultSet = Conexion.select(sql);
        Integer codigors;
        try {
            while (resultSet.next()) {
                codigors = resultSet.getInt(1);
                if (codigors.equals(cod)) {
                    retorno = true;
                }                
            }
        } catch (SQLException sQLException) {
        }
        return retorno;
    }
    
    public boolean agregar(Pelicula pelicula){   
        Integer codigo=pelicula.getCodigo();
        Integer precio=pelicula.getPrecio();
        String categoria=pelicula.getCategoria();
        String cuatroK=pelicula.getCuatroK();
        String nombre=pelicula.getNombre();
        
        
        
        String sql = "insert into VB_PELICULA (CODIGO, PRECIO, ID_CATEGORIA, FORMATO4K, NOMBRE) VALUES ('"+codigo+"', '"+precio+"', (SELECT ID FROM VB_CATEGORIA WHERE DESCRIPCION='"+categoria+"'), '"+cuatroK+"', '"+nombre+"')";        
        return Conexion.insert(sql);
    }

    public boolean modificar(Pelicula pelicula){        
        Integer codigo=pelicula.getCodigo();
        Integer precio=pelicula.getPrecio();
        String categoria=pelicula.getCategoria();
        String cuatroK=pelicula.getCuatroK();
        String nombre=pelicula.getNombre();
        
        
        
        String sql = "UPDATE VB_PELICULA SET PRECIO = '"+precio+"', ID_CATEGORIA = (SELECT ID FROM VB_CATEGORIA WHERE DESCRIPCION='"+categoria+"'), FORMATO4K = '"+cuatroK+"', NOMBRE = '"+nombre+"' WHERE CODIGO="+codigo;
        return Conexion.insert(sql);
    }    
    public boolean borrar(Integer codigo){        

        String sql = "DELETE FROM VB_PELICULA WHERE CODIGO="+codigo;
        return Conexion.delete(sql);
    }      
    


    public ResultSet listarCategoria(){
        ResultSet resultSet=null;
        
        try {
            String sql = "SELECT * FROM VB_CATEGORIA";
            PreparedStatement preparedStatement = Conexion.conectar().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sQLException) {
        }


        return resultSet;
    }

    
}
