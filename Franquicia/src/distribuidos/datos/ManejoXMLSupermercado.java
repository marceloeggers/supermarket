/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

import distribuidos.gui.MainWindow;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author caro
 */
public class ManejoXMLSupermercado {
    
    private Element root;
    
    public ManejoXMLSupermercado() {
    }
    
    
       public static Element buscarPorId(List raiz, String id) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element elemento = (Element) i.next();
            if (id.equals(elemento.getChild("id").getText())) {
                return elemento;
            }
        }
        return null;
    }
    
    
     public void cargarListaSuperEnCombo(JComboBox combo,boolean borrarCombo)
    {
        int tamLista, i;
        String cadenaAMostrar;

        if (borrarCombo)
            combo.removeAllItems();
        
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_SUPERMERCADO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        Element aux = new Element("supermercado");
        List Super = this.root.getChildren("supermercado");
        tamLista = Super.size();
       // Element aux = new Element("producto");
        for (i=0 ; i<tamLista ; i++)   
        {  
            aux = this.buscarPorId(Super, Integer.toString(i));
            //System.out.println(distribuidos.Distribuidos.idAux.getId());
 
            cadenaAMostrar = aux.getChildText("id")+" "+ aux.getChildText("nombre");
            combo.addItem(cadenaAMostrar);
        }
    }
     
      public static boolean escribirSucursal( String nuevoNombre, String nuevaUbicacion, String nuevoTlf ) {
        {
            Document doc;
            Element root,nombre, ubicacion, tlf, supermercado,id,franquicia;
            SAXBuilder builder = new SAXBuilder();



            try {
                doc = builder.build(Util.RUTA_SUPERMERCADO);
                root = doc.getRootElement();
                // Creamos una nueva etiqueta
                Element aux = new Element("supermercado");
                List Productos = root.getChildren("supermercado");
                int tamLista = Productos.size();
                
                supermercado = new Element("supermercado");
                id = new Element("id");
                nombre = new Element("nombre");
                ubicacion = new Element("ubicacion");
                tlf = new Element("telefono");
                franquicia = new Element("franquicia");

                root.addContent(supermercado);
  
                supermercado.addContent(id);
                id.addContent(Integer.toString(tamLista));
                
                supermercado.addContent(nombre);
                nombre.addContent(nuevoNombre);

                supermercado.addContent(ubicacion);
                ubicacion.addContent(nuevaUbicacion);

                supermercado.addContent(tlf);
                tlf.addContent(nuevoTlf);

                supermercado.addContent(franquicia);
                franquicia.addContent("false");

                try {
                    Format format = Format.getPrettyFormat();
                    /*
                     * Se genera un flujo de salida de datos XML
                     */
                    XMLOutputter out = new XMLOutputter(format);
                    /*
                     * Se asocia el flujo de salida con el archivo donde se
                     * guardaran los datos
                     */
                    FileOutputStream file = new FileOutputStream(Util.RUTA_SUPERMERCADO);
                    /*
                     * Se manda el documento generado hacia el archivo XML
                     */
                    out.output(doc, file);
                    /*
                     * Se limpia el buffer ocupado por el objeto file y se manda
                     * a cerrar el archivo
                     */
                    file.flush();
                    file.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (JDOMParseException e) {
                System.out.println("Error loading XML file - The file is empty");
                e.printStackTrace();
            } catch (JDOMException e) {
                System.out.println("Error loading XML file - The file is empty");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error loading XML file - The file is empty");
                e.printStackTrace();
            }

            return true;
        }


    }


    
    public  void cargarInformacionSucursal(Object posicion, JTextField nombre, JTextField ubicacion, JTextField tlf){
//                                (jCBSupermercado.getSelectedIndex()-1, jCBSucursal.getSelectedIndex()-1,jCBProducto.getSelectedIndex()-1,jCBAlmacenaje, jTFCodigo, jTFNombre, jTFDescripcion, jDCFechaIngreso, jTFRubros, jTFCantidad, jTFUnidad, jTFPvp, jDCFechaVencimiento, jCBMP, jLImagenPro, jCBControlPrecio, jTFStockMin)
    
     
        
        nombre.setText("");
        ubicacion.setText("");
        tlf.setText("");

          SAXBuilder builder = new SAXBuilder(false);
          Document doc = null;
          String[] idProducto = posicion.toString().split(" ");
        System.out.println();
            try {
                doc = builder.build(Util.RUTA_SUPERMERCADO);
            } catch (JDOMException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

            root = doc.getRootElement(); 
            Element aux = new Element("supermercado");
            List Productos = this.root.getChildren("supermercado");
            aux = this.buscarPorId(Productos, idProducto[0]);
            
            nombre.setText(aux.getChildText("nombre"));
            ubicacion.setText(aux.getChildText("ubicacion"));
            tlf.setText(aux.getChildText("telefono"));
            


//            Almacenaje.setSelectedItem(productoActual.getAlmacenaje().getCondicionesAdicionales());
        
    }
}
