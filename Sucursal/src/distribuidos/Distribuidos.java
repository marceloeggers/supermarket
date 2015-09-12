/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos;

import distribuidos.datos.*;
import distribuidos.gui.MainWindow;

/**
 *
 * @author caro
 */
public class Distribuidos {
 public static Util idAux = new Util();
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // TODO code application logic here
       idAux.setId(Integer.parseInt(args[0]));
       MainWindow iniciarSesion = new MainWindow();
        iniciarSesion.setVisible(true);
       /*COMIENZA A SETEAR EL NODO QUE MI MAQUINA ESTA ESTABLECIDA */
                 DatosNodos.setId_nodo(Integer.valueOf(args[0]));
                 XMLnodos xmlnodo = new XMLnodos();    
                 xmlnodo.setpuertoescucha(DatosNodos.getId_nodo());
             
        
                 RecibirPuerto recibePuerto = new RecibirPuerto(DatosNodos.getPuerto_entrada());
                 recibePuerto.run();
                 
              
                 
        
    }
}
