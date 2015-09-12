/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

/**
 *
 * @author Marcelo
 */
public class Venta {

    String idSuper;
    String idProducto;
    String nombreProducto;
    String cantidad;
    String costo;

    public Venta(String idSuper, String idProducto, String nombreProducto, String cantidad, String costo) {
       
        this.idSuper = idSuper;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdSuper() {
        return idSuper;
    }

    public void setIdSuper(String idSuper) {
        this.idSuper = idSuper;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
   
    
    
}
