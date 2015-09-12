/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

/**
 *
 * @author Marcelo
 */
public class DatosNodos {
    
     private static String ip_vecino="";
    private static int puerto_salida;
    private static int puerto_entrada;
    private static int id_nodo;
    private static String ip;
  
    
    public DatosNodos() {
        
        
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        DatosNodos.ip = ip;
    }

    public static int getId_nodo() {
        return id_nodo;
    }

    public static void setId_nodo(int id_nodo) {
        DatosNodos.id_nodo = id_nodo;
    }
    
    public DatosNodos (String ip_vecino, int puerto_salida , int puerto_entrada) {
        
        DatosNodos.ip_vecino=ip_vecino;
        DatosNodos.puerto_salida=puerto_salida;
        DatosNodos.puerto_entrada=puerto_entrada;
        
    }
    
    public static void setArgumentos(String ip_vecinos, int puerto_salidas, int id_nodos)   
    {
         DatosNodos.ip_vecino=ip_vecinos;
         DatosNodos.puerto_salida=puerto_salidas;
       
    }

 
    

    public static String getIp_vecino() {
        return ip_vecino;
    }

    public static void setIp_vecino(String ip_vecino) {
        DatosNodos.ip_vecino = ip_vecino;
    }

    public static int getPuerto_salida() {
        return puerto_salida;
    }

    public static void setPuerto_salida(int puerto_salida) {
        DatosNodos.puerto_salida = puerto_salida;
    }

    public static int getPuerto_entrada() {
        return puerto_entrada;
    }

    public static void setPuerto_entrada(int puerto_entrada) {
        DatosNodos.puerto_entrada = puerto_entrada;
    }
    
}
