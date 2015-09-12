/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

/**
 *
 * @author caro
 */
public class Supermercado {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String telefono;

    public Supermercado(int id, String nombre, String ubicacion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
}
