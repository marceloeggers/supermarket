/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Pedido {
    String idSuper;
    String idProducto;
    String nombreProducto;
    String cantidad;
    String estatus;
    String observacion;
    static List<Pedido> lista;

    public Pedido() {
    }

    
    
    public Pedido(String idSuper, String idProducto, String nombreProducto, String cantidad, String estatus, String observacion) {
        this.idSuper = idSuper;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.observacion = observacion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public static List<Pedido> getLista() {
        return lista;
    }

    public  void setLista(List<Pedido> lista) {
        this.lista = lista;
    }



    
    
    
}
