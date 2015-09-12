/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;


import distribuidos.datos.DatosNodos;
import distribuidos.datos.Hilo;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Marcelo
 */
public class RecibirPuerto implements Runnable {

     
    int puerto;
    boolean cerrar;
    
    public RecibirPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    public RecibirPuerto() {
        
    }
    
    public void run() {
        
        this.recibiendo();
     
    }
    

    
    
    public void recibiendo() {
         XMLnodos xmlnodo = new XMLnodos();    
          int var=0;
          for (int i = 0; i < xmlnodo.cantNodos(); i++) {
           
              var=xmlnodo.cargaArchivos(i);
              Hilo Hilo;
              // OJO EL 1200 ES EL PUERTO DE ENVIAR, EL DE ESCUCHA SE ESTA USANDO POR ARGUMENTO
            if(var==1){
               Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_salida(),DatosNodos.getPuerto_entrada(),"actualizarNuevo");
               Hilo.start();
                }
     
       } 
        
        while (1 == 1) {
                
       
        
            try {
                
                ServerSocket servicio = new ServerSocket(puerto);
                Socket socket = servicio.accept();
                DataInputStream entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                
                
                String opcion = "";
                
                opcion = entrada.readUTF();
                
                if (opcion.equals("crear")) {
                    
                    //File archivo = new File(entrada.readUTF());
                    
                   // int n = 0;
                   // byte[] buf = new byte[1000000];
                  //  File folder = new File("../Distribuidos/" + entrada.readUTF() + "/");
                   // System.out.println("Receiving file: " + archivo.getName());
                    //create a new fileoutputstream for each new file
                   // folder.mkdir();
                   // FileOutputStream fos = new FileOutputStream(folder.getName() + "/" + archivo.getName());
                    
                    
                    String nombreProducto =entrada.readUTF();
                    String descripProducto =entrada.readUTF();
                    String cantidadProducto =entrada.readUTF();
                    String imagenProducto =entrada.readUTF();
                    String precioProducto =entrada.readUTF();
                    String estadoProducto =entrada.readUTF();
                    String idSucursal =entrada.readUTF();
                    ManejoXMLProducto xml = new ManejoXMLProducto();
                    xml.escribirProducto(nombreProducto, descripProducto, cantidadProducto, imagenProducto, precioProducto, estadoProducto, idSucursal);
                            //escribirArchivos(archivo.getName(), "10KB", "16-11-2012", "16-11-2012", folder.getName());
                    System.out.println("Se agrego un producto en la franquicia");
                    System.out.println("Actualiza para mandar a las demas sucursales");
                     
                    xml.actualizarfoto();
                    xml.actualizarXML();
                    
             
                    
                    
                    //while ((n = entrada.read(buf)) != -1) {
                       // fos.write(buf, 0, n);
                     //   fos.flush();
                        
                   // }
                    //fos.close();
                    
                    servicio.close();
                    
                }
                
                else if (opcion.equals("modificar")) {
                   String idProducto =entrada.readUTF();
                   String cantidadProducto1 =entrada.readUTF();
                  
                   
                   ManejoXMLProducto xml = new ManejoXMLProducto();
                   xml.updateProductoSucursal(idProducto, cantidadProducto1);
                  
                 
                   
                   servicio.close();
                    
                   }
                
      
                else if (opcion.equals("modificarEstado")) {
                   String idProducto =entrada.readUTF();
                   ManejoXMLProducto xml = new ManejoXMLProducto();
                   xml.borrarProducto(idProducto);
                   servicio.close();
                   }
                
               else if (opcion.equals("modificarFranquicia")) {
                   
                        String nombreProducto =entrada.readUTF();
                        String descripProducto =entrada.readUTF();
                        String cantidadProducto =entrada.readUTF();
                        String imagenProducto =entrada.readUTF();
                        String precioProducto =entrada.readUTF();
                        String estadoProducto =entrada.readUTF();
                        String idSuc =entrada.readUTF();
                        String nombreViejo =entrada.readUTF();
                        String idProducto =entrada.readUTF();
                        
     
                      
     //updateProductoFranquicia(String idSuc,String nombreViejo,String id,String nuevoNombre, String nuevoDescripcion,String nuevaCantidad, String nuevaImagen, String nuevoCosto, String nuevoEstado)
                       ManejoXMLProducto xml = new ManejoXMLProducto();
                       xml.updateProductoFranquicia(idSuc, nombreViejo, idProducto, nombreProducto,descripProducto,cantidadProducto,imagenProducto,precioProducto,estadoProducto);
                        servicio.close();
                        
          
                   
               }
 
                
                
                else if (opcion.equals("replicar")) {
                   
                    File archivo = new File(entrada.readUTF());
                    int n = 0;
                    byte[] buf = new byte[1000000];
                    FileOutputStream fos = new FileOutputStream(archivo.getName());
                    
                    while ((n = entrada.read(buf)) != -1) {
                        fos.write(buf, 0, n);
                        fos.flush();
                        
                    }
                    fos.close();
                    
                    ManejoXMLProducto xml = new ManejoXMLProducto();
                    xml.actualizarNodo();
                    
                                       
          
          for (int i = 0; i < xmlnodo.cantNodos(); i++) {
           
              var=xmlnodo.cargaArchivos(i);
              Hilo Hilo;
            
            if(var==1){
             
               Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_salida(),DatosNodos.getPuerto_entrada(),"replicar");
               Hilo.start();
               
            }
       }
          servicio.close();
                    
                }
                
                 else if (opcion.equals("enviarImagen")) {
                   
                    File archivo = new File(entrada.readUTF());
                    int n = 0;
                    byte[] buf = new byte[1000000];
                    FileOutputStream fos = new FileOutputStream(archivo.getName());
                    
                    while ((n = entrada.read(buf)) != -1) {
                        fos.write(buf, 0, n);
                        fos.flush();
                  
                    }
                    fos.close();
                    servicio.close();
                    
                }
                
                 else if (opcion.equals("actualizarNuevo")) {
                   
          for (int i = 0; i < xmlnodo.cantNodos(); i++) {
           
              var=xmlnodo.cargaArchivos(i);
              Hilo Hilo;
            
            if(var==1){
             
               Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_salida(),DatosNodos.getPuerto_entrada(),"replicar");
               Hilo.start();
               
            }
       }
                  servicio.close();
                 
                 }
               
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
            
        }
        
        
    }
    
    
    
    public int cantArchivos(String usuario) {
        int cant = 0;
        
        try {
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build("ListaArchivos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("archivo");
            Iterator k = listaarchivos.iterator();
            int contador = 0;
            
            while (k.hasNext()) {
                Element elemento = (Element) k.next();
                if (usuario.equals(elemento.getChild("user").getText())) {
                    contador++;
                    cant = cant++;
                }
                
                
                
            }
            //   System.out.println(contador);
            return contador;
            
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado cantArchivos clase RecibirPuerto");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cant;
        
    }
    /*
    public void modooffline(String usuario) {
        
        File carpeta = new File("../Distribuidos/" + usuario);
        
        File[] listadearchivos = new File[carpeta.listFiles().length];
        File[] listaaux = new File[this.cantArchivos(usuario)];
   //     System.out.println("tamano de capeta" + this.cantArchivos(usuario));
   //     System.out.println("tamano de capeta" + carpeta.listFiles().length);
        
        listaaux = cargaArchivosparacarpeta(usuario);
        int numero = 0;
        if (carpeta.isDirectory()) {
            
            listadearchivos = carpeta.listFiles();
            
            for (int i = 0; i < listadearchivos.length; i++) {
                
                if (listadearchivos[i].equals(
                        listaaux[i])) {
                    numero++;
                }
                
                
            }
            if (numero != listadearchivos.length) {
                
                XMLCliente xml = new XMLCliente();
                
                for (int i = 0; i < this.cantArchivos(usuario); i++) {
                    System.out.println(listaaux[i].getName());
                  //  System.out.println("tamano de aux" + listaaux.length);
                    xml.borrarCliente(listaaux[i].getName(), usuario);
                }
                
                for (int i = 0; i < listadearchivos.length; i++) {
                    
                    XMLCliente.escribirArchivos(listadearchivos[i].getName(), "10Kb", "21-11-12", "21-11-12", usuario);
                    XMLnodos xmlnodo = new XMLnodos();
                    int var = 0;
                    for (int j = 0; j < xmlnodo.cantNodos(); j++) {
                        File archivo = new File(listadearchivos[i].getName());
                        var = xmlnodo.cargaArchivos(j);
                        Hilo Hilo;
                        
                        if (var == 1) {
                            Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_entrada(), DatosNodos.getPuerto_salida(), archivo, usuario, "crear");
                            Hilo.start();
                        }
                        
                    }
                }
            }
            
        }
                 
               this.enviarxmlarchivo();         
                  listaaux =null;
                  listadearchivos=null;
        
        
        
    }*/
    
    public File[] cargaArchivosparacarpeta(String usuario) {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            File[] listadearchivos = new File[50];
            Document doc = builder.build("ListaArchivos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("archivo");
            Iterator k = listaarchivos.iterator();
            int i = 0, j = 0;
            while (k.hasNext()) {
                Element e = (Element) k.next();
                Element nombre = e.getChild("nombre");
                Element tamano = e.getChild("tamano");
                Element diacreado = e.getChild("diacreado");
                Element diamodificado = e.getChild("diamodificado");
                Element user = e.getChild("user");
                if (usuario.equals(user.getText())) {
                    File aux = new File("../Distribuidos/" + usuario + "/" + nombre.getText());
                    listadearchivos[i] = aux;
                    i++;
                }
            }
            return listadearchivos;
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado cargaArchivosparacarpeta clase RecibirPuerto");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return Varchivo;
        return null;
    }
    
    /*
    public void enviarxmlarchivo(){
  
            File archivo = new File("../Distribuidos/ListaArchivos.xml");
            XMLnodos xmlnodo = new XMLnodos();
            int var=0;
            for (int i = 0; i < xmlnodo.cantNodos(); i++) {
             
                var=xmlnodo.cargaArchivos(i);
                Hilo Hilo;
                // OJO EL 1200 ES EL PUERTO DE ENVIAR, EL DE ESCUCHA SE ESTA USANDO POR ARGUMENTO
              if(var==1){
              Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_entrada(),DatosNodos.getPuerto_salida(),archivo,"","replicar");
               Hilo.start();
              }

            }
        
           
        }*/
    
}
