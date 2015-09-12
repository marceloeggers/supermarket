/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos;

import distribuidos.datos.DatosNodos;
import distribuidos.datos.RecibirPuerto;
import distribuidos.datos.Util;
import distribuidos.datos.XMLnodos;
import distribuidos.gui.MainWindow;

/**
 *
 * @author caro
 */
public class Distribuidos {

    /**
     * @param args the command line arguments
     */public static Util idAux = new Util();
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(idAux.getId());
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
