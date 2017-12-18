/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Gabriel
 */
public class Pelicula {
    private Integer codigo;
    private Integer precio;
    private String categoria;
    private String cuatroK;
    private String nombre;

    public Pelicula(Integer codigo, Integer precio, String categoria, String cuatroK, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.cuatroK = cuatroK;
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the cuatroK
     */
    public String getCuatroK() {
        return cuatroK;
    }

    /**
     * @param cuatroK the cuatroK to set
     */
    public void setCuatroK(String cuatroK) {
        this.cuatroK = cuatroK;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
