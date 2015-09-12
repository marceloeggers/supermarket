/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import sucursal.servicio.Venta;
import sucursal.servicio.Pedido;
/**
 *
 * @author Marcelo
 */
public class Comunicacion {

    public Comunicacion() {
    }
   
    public static String ventas(String idSuper, Object idProducto, String nombreProducto, String cantidad, String costo) {
       try{
         //   System.out.println(" entra en el try....");
        String[] idProducto1 = idProducto.toString().split(" ");
        sucursal.servicio.SupermercadoWS_Service service = new  sucursal.servicio.SupermercadoWS_Service();
        sucursal.servicio.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.registrarVenta(idSuper,idProducto1[0],nombreProducto,cantidad,costo);
        } catch(Exception ex){
    //      System.out.println("si en el catch entra....");
          String[] idProducto1 = idProducto.toString().split(" ");
          distribuidos.datos.Venta registrar = new  distribuidos.datos.Venta(idSuper,idProducto1[0],nombreProducto,cantidad,costo); 
          ManejoXMLProducto.escribirventa(registrar);
          return "se inserto localmente";
       }
    }
    
           public static java.util.List<Venta> devolverVenta(String idSuper, String idProducto) {
        sucursal.servicio.SupermercadoWS_Service service = new  sucursal.servicio.SupermercadoWS_Service();
        sucursal.servicio.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.devolverVenta(idSuper, idProducto);
    }
           
        public static String nuevoPedido(String idSuper, String idProducto,String nombreProducto,String cantidad,String estatus,String observacion) {
 
        sucursal.servicio.SupermercadoWS_Service service = new  sucursal.servicio.SupermercadoWS_Service();
        sucursal.servicio.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.nuevoPedido(idSuper, idProducto, nombreProducto, cantidad, estatus, observacion);
      
    }
        
        public static java.util.List<Pedido> devolverPedido() {
       sucursal.servicio.SupermercadoWS_Service service = new   sucursal.servicio.SupermercadoWS_Service();
         sucursal.servicio.SupermercadoWS port = service.getSupermercadoWSPort();
        return port.devolverPedido();
    }
        
      public static void borrarXMLPedido(){
 
        sucursal.servicio.SupermercadoWS_Service service = new   sucursal.servicio.SupermercadoWS_Service();
         sucursal.servicio.SupermercadoWS port = service.getSupermercadoWSPort();
         port.borrarXMLPedido();
      
    }
                 
       public static void actualizarEstatus(String idSucursal, String idProducto){
 
        sucursal.servicio.SupermercadoWS_Service service = new   sucursal.servicio.SupermercadoWS_Service();
         sucursal.servicio.SupermercadoWS port = service.getSupermercadoWSPort();
         port.actualizarPedido(idSucursal, idProducto);
      
    }
    
    
}
