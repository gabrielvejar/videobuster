/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import db.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Gabriel
 */
public class ComboCategoria {
    public ResultSet listaCategoria(){
        return Conexion.listaCategorias();
    }
}
