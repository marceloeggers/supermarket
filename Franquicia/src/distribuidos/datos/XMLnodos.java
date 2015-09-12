/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;


import distribuidos.datos.DatosNodos;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Marcelo
 */
public class XMLnodos {
    
     public XMLnodos() {
    }
    
    public void setpuertoescucha(int nodo){ 
    
          try {
            int cant =0;
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build("src//distribuidos//datos//ListaNodos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("nodo");
            Iterator k = listaarchivos.iterator();
            while (k.hasNext()) {
                
           
                Element e = (Element) k.next();
                Element idnodo = e.getChild("id");
                Element ip = e.getChild("ip");
                Element puerto_entrada = e.getChild("puerto_entrada");
              //  System.out.println(ip.getText());
                if(Integer.valueOf(idnodo.getText())==nodo){
                DatosNodos.setPuerto_entrada(Integer.valueOf(puerto_entrada.getText()));
                }
             
           
         
            }
           
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado setpuertoescucha clase XMLnodos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    public int cargaArchivos(int index) {
        
        try {
            int cant =0;
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build("src//distribuidos//datos//ListaNodos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("nodo");
            Iterator k = listaarchivos.iterator();
            while (k.hasNext()) {
                
           if(index== cant){
                Element e = (Element) k.next();
                Element idnodo = e.getChild("id");
                Element ip = e.getChild("ip");
                Element puerto_entrada = e.getChild("puerto_entrada");
                if(DatosNodos.getId_nodo()!=Integer.valueOf(idnodo.getText())){
                DatosNodos.setArgumentos(ip.getText(), Integer.valueOf(puerto_entrada.getText()),Integer.valueOf(idnodo.getText()));
                return 1;
                }
                break;
           }
           else{
               
           }
            k.next();
            cant++;
            }
         
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado cargaArchivos clase XMLnodos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return Varchivo;
        return 0;
    }

    public int cantNodos() {
        int cant = 0;

        try {
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            
            Document doc = builder.build("src//distribuidos//datos//ListaNodos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("nodo");
            Iterator k = listaarchivos.iterator();
            int contador=0;
            while (k.hasNext()) {
                contador++;
                cant = cant++;
                
                k.next();
                

            }
         //   System.out.println(contador);
            return contador;

        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado cantNodos clase XMLnodos");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cant;

    }
    
}
