/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;
import webservice.Pedido;
import webservice.Venta;
/**
 *
 * @author Marcelo
 */
public class Comunicacion {

    public Comunicacion() {
    }

    
       public static java.util.List<Venta> devolverVenta(String idSuper, String idProducto) {
       webservice.SupermercadoWS_Service service = new  webservice.SupermercadoWS_Service();
        webservice.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.devolverVenta(idSuper, idProducto);
    }
       
         public static java.util.List<Pedido> devolverPedido() {
       webservice.SupermercadoWS_Service service = new  webservice.SupermercadoWS_Service();
        webservice.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.devolverPedido();
    }
         
        public static String nuevoPedido2(String idSuper, String idProducto,String nombreProducto,String cantidad,String estatus,String observacion) {
 
        webservice.SupermercadoWS_Service service = new   webservice.SupermercadoWS_Service();
         webservice.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.nuevoPedido(idSuper, idProducto, nombreProducto, cantidad, estatus, observacion);
      
    }
         public static void borrarXMLPedido(){
 
        webservice.SupermercadoWS_Service service = new   webservice.SupermercadoWS_Service();
         webservice.SupermercadoWS port = service.getSupermercadoWSPort();
         port.borrarXMLPedido();
      
    }
    
}
