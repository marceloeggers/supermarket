/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

import distribuidos.gui.RegistroProducto;
import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Hilo extends Thread {
    private Util aux = new Util();
     private String ip_nodo_siguiente;
    private int puerto_salida;
    private int puerto_entrada;
    private File archivo;
    private String opcion;
    private Integer opcion2;
    private String username;
    private String password;
    private String usuario;
                  
        //*******************PARTE NUEVA SUCURSAL DISTRIBUIDOS            
    private String nombreProducto;
    private String descripProducto;
    private String cantidadProducto;
    private String imagenProducto;
    private String precioProducto;
    private String estadoProducto;
    
    private String idProducto;
    private String cantidadProducto1;
   
     
    private String idSuc;
    private String nombreViejo;
    
    private List Productos;
    
    
    private String idSucursal;
    //*******************PARTE NUEVA SUCURSAL DISTRIBUIDOS

    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String hola, String chao, String mamalo) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.opcion = opcion;
    }


    
    
    
    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String nombreProducto, String descripProducto, String cantidadProducto, String imagenProducto, String precioProducto, String estadoProducto, String idSucursal) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.opcion = opcion;
        this.nombreProducto = nombreProducto;
        this.descripProducto = descripProducto;
        this.cantidadProducto = cantidadProducto;
        this.imagenProducto = imagenProducto;
        this.precioProducto = precioProducto;
        this.estadoProducto = estadoProducto;
        this.idSucursal = idSucursal;
    }

    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String nombreProducto, String descripProducto, String cantidadProducto, String imagenProducto, String precioProducto, String estadoProducto, String idSuc, String nombreViejo,  String idProducto) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.opcion = opcion;
        this.nombreProducto = nombreProducto;
        this.descripProducto = descripProducto;
        this.cantidadProducto = cantidadProducto;
        this.imagenProducto = imagenProducto;
        this.precioProducto = precioProducto;
        this.estadoProducto = estadoProducto;
        this.idSuc = idSuc;
        this.nombreViejo = nombreViejo;
        this.idProducto = idProducto;
    }
        
        

    public Hilo(String ip_nodo_siguiente, int puerto_entrada, int puerto_salida, File archivo, String user, String opciones) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.archivo = archivo;
        this.usuario = user;
        this.opcion = opciones;

    }



    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String idProducto, String cantidadProducto1) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.opcion = opcion;
        this.idProducto = idProducto;
        this.cantidadProducto1 = cantidadProducto1;
    }
    
    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String idProducto) {
       this.ip_nodo_siguiente = ip_nodo_siguiente;
       this.puerto_salida = puerto_salida;
       this.puerto_entrada = puerto_entrada;
       this.opcion = opcion;
       this.idProducto = idProducto;
   }

    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, List Productos) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.opcion = opcion;
        this.Productos = Productos;
    }

    public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.opcion = opcion;
    }

 
   
    
    

    @Override
    public void run() {

        if (this.opcion.equals("crear")) {
            this.crearArchivo();
        } else if (this.opcion.equals("modificar")) {
           this.modificarCantidad();
        } else if (this.opcion.equals("modificarFranquicia")) {
            this.modificarFranquicia();
        } else if (this.opcion.equals("replicar")) {
            this.replicarXML();
        }
        else if (this.opcion.equals("modificarEstado")) {
           this.modificarEstado();
        }
        else if (this.opcion.equals("enviarImagen")) {
           this.replicarImagen();
        }
        else if (this.opcion.equals("actualizarNuevo")) {
           this.actualizarNuevo();
        }
        else if (this.opcion.equals("webservice")) {
           this.webService();
        }
        
        

    }

    public void replicarArchivo() {
        try {


            Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);
            DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
            servicioSocket.writeUTF(archivo.getName());
            servicioSocket.writeUTF(this.usuario);
            servicioSocket.flush();
            FileInputStream archivo2 = new FileInputStream("../Distribuidos/" + this.usuario + "/" + archivo.getName());

            byte[] buffer = new byte[1000000];

            System.out.println(archivo.getName());
            int len;

            while ((len = archivo2.read(buffer)) != -1) {
                servicioSocket.write(buffer, 0, len);

                servicioSocket.flush();

            }

            servicioSocket.close();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error al replicarArchivo clase Hilo ");
        }
    }

      
    
    private void crearArchivo() {

        try {
         //   System.out.println("Ip vecino: "+ ip_nodo_siguiente+" "+puerto_salida);
            Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);
            
            DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
            servicioSocket.writeUTF(this.nombreProducto);
            servicioSocket.writeUTF(this.descripProducto);
            servicioSocket.writeUTF(this.cantidadProducto);
            servicioSocket.writeUTF(this.imagenProducto);
            servicioSocket.writeUTF(this.precioProducto);
            servicioSocket.writeUTF(this.estadoProducto);
            servicioSocket.writeUTF(this.idSucursal);
            servicioSocket.flush();

            servicioSocket.close();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error al Registrar clase Hilo");
        }



    }
    
    
    
    private void modificarCantidad() {

       try {
           Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

           DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

           servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
           servicioSocket.writeUTF(this.idProducto);
           servicioSocket.writeUTF(this.cantidadProducto1);
           
           servicioSocket.flush();

           servicioSocket.close();


       } catch (Exception e) {
           // TODO Auto-generated catch block
           System.out.println("Error al modificarCantidad clase Hilo");
       }



   }
    //boolean updateProductoFranquicia(String idSuc,String nombreViejo,String id,String nuevoNombre, String nuevoDescripcion,String nuevaCantidad, String nuevaImagen, String nuevoCosto, String nuevoEstado) {
    
        private void modificarFranquicia() {

       try {
           Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

           DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

           servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
           servicioSocket.writeUTF(this.nombreProducto);
           servicioSocket.writeUTF(this.descripProducto);
           servicioSocket.writeUTF(this.cantidadProducto);
           servicioSocket.writeUTF(this.imagenProducto);
           servicioSocket.writeUTF(this.precioProducto);
           servicioSocket.writeUTF(this.estadoProducto);
           servicioSocket.writeUTF(this.idSuc);
           servicioSocket.writeUTF(this.nombreViejo);
           servicioSocket.writeUTF(this.idProducto);
           
           servicioSocket.flush();

           servicioSocket.close();


       } catch (Exception e) {
           // TODO Auto-generated catch block
           System.out.println("Error al modificarFranquicia clase Hilo");
       }



   }
    
    private void modificarEstado() {

       try {
           Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

           DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

           servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
           servicioSocket.writeUTF(this.idProducto);
           
           servicioSocket.flush();

           servicioSocket.close();


       } catch (Exception e) {
           // TODO Auto-generated catch block
           System.out.println("Error al modificarEstado clase Hilo");
       }



   }
    
    private void registrar() {

        try {


            Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

            DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
            servicioSocket.writeUTF(this.username);
            servicioSocket.writeUTF(this.password);
            servicioSocket.flush();

            servicioSocket.close();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error al Registrar clase Hilo");
        }



    }

    private void replicarXML() {

        try {


            Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

            DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            servicioSocket.writeUTF("replicar");
            servicioSocket.writeUTF("src//distribuidos//datos//productoXML.xml");// opcion hay que poner variable
            servicioSocket.flush();
              FileInputStream archivo2 = new FileInputStream("src//distribuidos//datos//productoXML.xml");

            byte[] buffer = new byte[1000000];

           // System.out.println(archivo.getName());
            int len;

            while ((len = archivo2.read(buffer)) != -1) {
                servicioSocket.write(buffer, 0, len);

                servicioSocket.flush();

            }

            servicioSocket.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error al replicarXML clase Hilo");
        }
    }
    
    
        private void replicarImagen() {

        try {
     
            
            Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

            DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            
            servicioSocket.writeUTF("enviarImagen");
            servicioSocket.writeUTF(aux.getRuta());// opcion hay que poner variable
            servicioSocket.flush();
              FileInputStream archivo2 = new FileInputStream(aux.getRuta());

            byte[] buffer = new byte[1000000];

           // System.out.println(archivo.getName());
            int len;

            while ((len = archivo2.read(buffer)) != -1) {
                servicioSocket.write(buffer, 0, len);

                servicioSocket.flush();

            }

            servicioSocket.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error al replicarImagen clase Hilo");
        }
    }
        private void actualizarNuevo() {

       try {
           Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

           DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

           servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable

           servicioSocket.flush();

           servicioSocket.close();


       } catch (Exception e) {
           // TODO Auto-generated catch block
           System.out.println("Error al ActualizarNuevo clase Hilo");
       }
        }
        
              private void webService() {

       try {
           Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);

           DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

           servicioSocket.writeUTF(this.opcion);// opcion hay que poner variable
           
           
           servicioSocket.flush();

           servicioSocket.close();


       } catch (Exception e) {
           // TODO Auto-generated catch block
           System.out.println("Error al modificarFranquicia clase Hilo");
       }



   }
}
