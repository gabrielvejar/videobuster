package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Conexion {
    public static Connection conect;

    private Conexion() {
    }
    public static Connection conectar(){
        if (conect==null){
             String url= "jdbc:oracle:thin:@localhost:1521:xe";
             String user="HR";
             String pass="123456";
             System.out.println("Proceso de Conexión...");
             try {
                 conect= DriverManager.getConnection(url, user, pass);
                 System.out.println("Base de datos Conectada!!");
             }catch (SQLException e) {
                 System.out.println(e.getMessage());
                 e.printStackTrace();    
             }  
        }
        return conect;
    }
    


    public static ResultSet select(String sql){
        ResultSet resultSet = null;
        
        try {
            
            PreparedStatement preparedStatement = Conexion.conectar().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();        
           
            
            
        } catch (SQLException ex) {
            
        }        
        
        
        
        return resultSet;
    }

    public static boolean insert(String sql){
        boolean retorno=false;
        try {
            PreparedStatement prepareStatement = Conexion.conectar().prepareStatement(sql);

            prepareStatement.execute();
            
            retorno=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }        
        
        return retorno;
    }

    public static boolean update(String sql){
        boolean retorno=false;
        try {
            PreparedStatement prepareStatement = Conexion.conectar().prepareStatement(sql);

            prepareStatement.execute();
            
            retorno=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }        
        
        return retorno;
    }

    public static boolean delete(String sql){
        boolean retorno=false;
        try {
            PreparedStatement prepareStatement = Conexion.conectar().prepareStatement(sql);

            prepareStatement.execute();
            
            retorno=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }        
        
        return retorno;
    }
    
    
    /*    public static ResultSet listaCategorias(){
    ResultSet resultSet=null;
    
    try {
    String sql = "SELECT * FROM VB_CATEGORIA";
    PreparedStatement preparedStatement = Conexion.conectar().prepareStatement(sql);
    resultSet = preparedStatement.executeQuery();
    } catch (SQLException sQLException) {
    }
    
    
    return resultSet;
    }    */
}
