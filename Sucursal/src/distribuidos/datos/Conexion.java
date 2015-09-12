/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CZHiller
 */
public class Conexion implements Runnable{
       
    @Override
    public void run() {
        
         while (true) {
            try {
                Thread.sleep(10000);
                chequearConexion();
            } catch (InterruptedException ex) {
                Logger.getLogger(RecibirPuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        
        
             public boolean chequearConexion() {

        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            // trying to retrieve data from the source. If offline, this line will fail:
            Object objData = urlConnect.getContent();
            
            if (Util.sinConexion = true) {
                new ManejoXMLProducto().mandarVentasPendientes();
            //  new XMLPedido().borrarPedidos();
                Util.sinConexion = false;
            }

        } 
        catch (MalformedURLException ex) {
           // Logger.getLogger(Replicador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO TENGO INTERNET");
          //  sucursalapp.SucursalApp.tengoInternet = false;
        } 
        
        catch (java.net.UnknownHostException r){
            System.out.println("NO HAY INTERNET");
        }
        
        catch (java.net.NoRouteToHostException nr) {
            System.out.println("NO HAY INTERNET");
        }
        
        catch (IOException ex) {
             System.out.println("NO HAY INTERNET");
         //   Logger.getLogger(Replicador.class.getName()).log(Level.SEVERE, null, ex);
        } 

        
        
        
        //sucursalapp.SucursalApp.tengoInternet = true;
       // enviarSignal();
        return true;

    }

//    public void enviarSignal() {
//        try {
//
//            Socket cliente = new Socket(this.ip, this.puerto);
//
//            OutputStream os = cliente.getOutputStream();
//
//            DataOutputStream dos = new DataOutputStream(os);
//            dos.writeUTF("Estoy arriba");
//            dos.writeUTF("sucursal");
//            dos.flush();
//
//            cliente.close();
//
//
//        } catch (NoRouteToHostException nr) {
//            System.out.println("No se encuentra el HOST ");
//
//        } catch (ConnectException ce) {
//            System.out.println("No se encuentra el HOST ");
//        } catch (java.net.SocketException nr) {
//            System.out.println("No se encuentra el HOST ");
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
//
//    }

    
    
    
}
