/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

/**
 *
 * @author caro
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Float costo;
    private String estatus;
    private int cantidad;
    private int idSuper;

    public Producto(int id, String nombre, String descripcion, String imagen, Float costo, String estatus, int cantidad, int idSuper) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.costo = costo;
        this.estatus = estatus;
        this.cantidad = cantidad;
        this.idSuper = idSuper;
    }

    public int getIdSuper() {
        return idSuper;
    }

    public void setIdSuper(int idSuper) {
        this.idSuper = idSuper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", estatus=" + estatus + '}';
    }
    
    
    
}
