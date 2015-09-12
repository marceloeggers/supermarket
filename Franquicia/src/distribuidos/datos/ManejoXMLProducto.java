/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import javax.swing.JLabel;
import distribuidos.gui.*;
import webservice.Pedido;
/**
 *
 * @author marianasalcedo
 */
public class ManejoXMLProducto {
    private Element root;
    public static String ruta;

    private boolean actualizarXML() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(Util.RUTA_PRODUCTO);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }
   
   
   public boolean borrarProducto(String id) {
       
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        boolean resultado = false;
        Element aux = new Element("producto");
        List Productos = this.root.getChildren("producto");
        aux = this.buscarPorId(Productos, id);
       if (!"0".equals(aux.getChild("idSuper").getText())) {
       
                aux.getChild("estado").setText("inactivo");
					resultado = actualizarXML();
     
          
       } else {
        while (aux != null) {
            aux = this.buscarPorNombre(Productos, aux.getChildText("nombre"));
            if (aux != null) {
             
                aux.getChild("estado").setText("inactivo");
                resultado = actualizarXML();
            }
        }
       
       }
        return resultado;
    }

   
    public void cargarListaProductoEnCombo(JComboBox combo,Object posicion ,boolean borrarCombo)
    {
        int tamLista, i;
        String cadenaAMostrar, id;

        if (borrarCombo)
        combo.removeAllItems();
        
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        Element aux = new Element("producto");
        List Productos = this.root.getChildren("producto");
        String[] idproducto = posicion.toString().split(" ");
        tamLista = Productos.size();
       // Element aux = new Element("producto");
        for (i=1 ; i<tamLista+1 ; i++)
            
        {  
           
            aux = this.buscarPorId(Productos, Integer.toString(i));
            //System.out.println(distribuidos.Distribuidos.idAux.getId());
            
            if(aux.getChildText("idSuper").equals(idproducto[0])){
                
                cadenaAMostrar =aux.getChildText("id")+" "+ aux.getChildText("nombre");
                combo.addItem(cadenaAMostrar);
            }

        }
    }
    
     public void cargarListaPedidoEnCombo(JComboBox combo,Object posicion ,boolean borrarCombo)
    {
        int tamLista, i;
        String cadenaAMostrar, id;

        if (borrarCombo)
        combo.removeAllItems();
        
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PEDIDO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        Element aux = new Element("pedido");
        List<Element> Productos = this.root.getChildren("pedido");
       String[] idproducto = posicion.toString().split(" ");
        tamLista = Productos.size();
       // Element aux = new Element("producto");
        for (i=0 ; i<tamLista ; i++)
            
        {  
           
           
            aux = this.buscarPorNombreCantidad(Productos, idproducto[0], Productos.get(i).getChildText("idProducto"), Productos.get(i).getChildText("cantidad"));
            
            
//            if(aux.getChildText("idSuper").equals(idproducto[0])){
                
            
            try{
            
                cadenaAMostrar =aux.getChildText("nombreProducto")+" "+ aux.getChildText("cantidad");
                combo.addItem(cadenaAMostrar);
            }
            catch(Exception e){
                System.out.println("No tienes pedido aca bro");
            }
//            }

        }
    }
    
    
    
    public void cargarListaProductoEnComboFran(JComboBox combo, boolean borrarCombo)
    {
        int tamLista, i;
        String cadenaAMostrar, id;

        if (borrarCombo)
            combo.removeAllItems();
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        Element aux = new Element("producto");
        List Productos = this.root.getChildren("producto");
        
        tamLista = Productos.size();
       // Element aux = new Element("producto");
        for (i=1 ; i<tamLista+1 ; i++)    
        {  
            aux = this.buscarPorId(Productos, Integer.toString(i));
            if(aux.getChildText("idSuper").equals("0") && aux.getChildText("estado").equals("activo")){
                
                cadenaAMostrar =aux.getChildText("id")+" "+ aux.getChildText("nombre");
                combo.addItem(cadenaAMostrar);
            }

        }
    }
    
     public boolean updateProductoSucursal(String id,String cantidad) {
       
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        boolean resultado = false;
        Element aux = new Element("producto");
        List Productos = this.root.getChildren("producto");
        aux = this.buscarPorId(Productos, id);
        System.out.println();
        aux.getChild("cantidad").setText(cantidad);
        resultado = actualizarXML();
        return resultado;
    }
   
    
    
    public boolean updateProductoFranquicia(String idSuc,String nombreViejo,String id,String nuevoNombre, String nuevoDescripcion,String nuevaCantidad, String nuevaImagen, String nuevoCosto, String nuevoEstado) {
       
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        boolean resultado = false;
        Element aux = new Element("producto");
        List Productos = this.root.getChildren("producto");
        if(!idSuc.equals("0")){
            aux = this.buscarPorId(Productos, id);
            aux.getChild("nombre").setText(nuevoNombre);
            aux.getChild("descripcion").setText(nuevoDescripcion);
            aux.getChild("estado").setText(nuevoEstado);
            aux.getChild("cantidad").setText(nuevaCantidad);
            aux.getChild("costo").setText(nuevoCosto);
            resultado = actualizarXML();
        
        }
        else{
            for (int i = 0; i < Productos.size() ; i++) {
                aux = this.buscarPorNombreModif(Productos, nombreViejo);
                if (aux != null) {
                    aux.getChild("nombre").setText(nuevoNombre);
                    aux.getChild("descripcion").setText(nuevoDescripcion);
                    aux.getChild("estado").setText(nuevoEstado);
                    if(aux.getChildText("id").equals(id)){
                         aux.getChild("cantidad").setText(nuevaCantidad);
                    }
                    aux.getChild("costo").setText(nuevoCosto);
                    resultado = actualizarXML();
                }
            }   
      
        }
            
        System.out.println();
        return resultado;
    }
	
    
    

	
	public boolean activarProducto(String id) {
       
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        boolean resultado = false;
        Element aux = new Element("producto");
        List Productos = this.root.getChildren("producto");
        aux = this.buscarPorId(Productos, id);
       if (!"0".equals(aux.getChild("idSuper").getText())) {
       
                aux.getChild("estado").setText("activo");
                  resultado = actualizarXML();
          
       }
                else {
                    while (aux != null) {
                        aux = this.buscarPorNombreI(Productos, aux.getChildText("nombre"));
                        if (aux != null) {
                        // Productos.remove(aux);
                            aux.getChild("estado").setText("activo");
                            resultado = actualizarXML();
            }
        }
       
       }
        return resultado;
    }
	

  public static String getRuta(List raiz) {
       System.out.println( buscarPorId(raiz, Integer.toString(raiz.size())).getChildText("imagen"));
        return buscarPorId(raiz, Integer.toString(raiz.size())).getChildText("imagen");
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
   
    public static Element buscarPorNombreCantidad(List raiz,String idSuper, String idProducto, String cantidad) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element elemento = (Element) i.next();
            if (idSuper.equals(elemento.getChild("idSuper").getText()) && idProducto.equals(elemento.getChild("idProducto").getText()) && cantidad.equals(elemento.getChild("cantidad").getText())  ) {
                return elemento;
            }
        }
        return null;
    }
    
        public static Element buscarPorNombreCantidad2(List raiz,String idSuper, String idProducto, String cantidad) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element elemento = (Element) i.next();
            if (idSuper.equals(elemento.getChild("idSuper").getText()) && idProducto.equals(elemento.getChild("nombreProducto").getText()) && cantidad.equals(elemento.getChild("cantidad").getText())  ) {
                return elemento;
            }
        }
        return null;
    }
    

   
       public static Element buscarPorNombreModif(List raiz, String nombre) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element elemento = (Element) i.next();
            if ((nombre.equals(elemento.getChild("nombre").getText()))) {
                return elemento;
            }
        }
        return null;
    }

      public static Element buscarPorNombre(List raiz, String nombre) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element elemento = (Element) i.next();
            if ((nombre.equals(elemento.getChild("nombre").getText()))&& ("activo".equals(elemento.getChild("estado").getText()))) {
                return elemento;
            }
        }
        return null;
    }
      
         public static Element buscarPorNombreI(List raiz, String nombre) {


        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element elemento = (Element) i.next();
            if ((nombre.equals(elemento.getChild("nombre").getText()))&& ("inactivo".equals(elemento.getChild("estado").getText()))) {
                return elemento;
            }
        }
        return null;
    }
         
  public void actualizarNodo(){
       
       SAXBuilder builder = new SAXBuilder(false);
       //SAXBuilder builderE = new SAXBuilder(false);
       Document doc = null;
       //Document docExterno = null;
       Element rootExterno, auxExterno;
       List productosLocal = null, productosExternos = null;
      
       try {
           doc = builder.build(Util.RUTA_PRODUCTO);
           root = doc.getRootElement();
           productosLocal = this.root.getChildren("producto");

           rootExterno = doc.getRootElement();
           productosExternos = rootExterno.getChildren("producto");
           
       } catch (JDOMException ex) {
           Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
       
       Element aux = new Element("producto");
       auxExterno = new Element("producto");

        for (int i = 1; i <=  productosExternos.size(); i++) {
            for (int j = 1; j <= productosLocal.size(); j++) {

                auxExterno = this.buscarPorId(productosExternos, Integer.toString(i));
                aux = this.buscarPorId(productosLocal, Integer.toString(j));

                if(auxExterno.getChildText("id").equals(aux.getChildText("id"))){

                    if((!auxExterno.getChildText("nombre").equals(aux.getChildText("nombre")))){

                        aux.getChild("nombre").setText(auxExterno.getChildText("nombre"));

                    }if ((!auxExterno.getChildText("descripcion").equals(aux.getChildText("descripcion")))){
                        aux.getChild("descripcion").setText(auxExterno.getChildText("descripcion"));

                    }if ((!auxExterno.getChildText("imagen").equals(aux.getChildText("imagen")))){
                        aux.getChild("imagen").setText(auxExterno.getChildText("imagen"));

                    }if ((!auxExterno.getChildText("costo").equals(aux.getChildText("costo")))){
                        aux.getChild("costo").setText(auxExterno.getChildText("costo"));

                    }if ((!auxExterno.getChildText("cantidad").equals(aux.getChildText("cantidad")))){
                        aux.getChild("cantidad").setText(auxExterno.getChildText("cantidad"));
                        System.out.println(aux.getChildText("cantidad"));
                    }
                    if ((!auxExterno.getChildText("estado").equals(aux.getChildText("estado")))){
                        aux.getChild("estado").setText(auxExterno.getChildText("estado"));
                    } 
                   if ((!auxExterno.getChildText("idSuper").equals(aux.getChildText("idSuper")))){
                        aux.getChild("idSuper").setText(auxExterno.getChildText("idSuper"));
                    } 
                    actualizarXML();
                }else if ((productosExternos.size()> productosLocal.size())&& 
                         ((j == productosLocal.size()) && (i >=productosLocal.size()))){
                        escribirProducto(auxExterno.getChildText("nombre"),auxExterno.getChildText("descripcion"),
                                         auxExterno.getChildText("cantidad"),auxExterno.getChildText("imagen"),
                                         auxExterno.getChildText("costo"), auxExterno.getChildText("estado"), auxExterno.getChildText("idSuper") );
                }


            }
        }
        
   }    
    
    /**
     * Metodo que carga la lista de archivos leyendo del archivo XML
     *
     * @param ventanita COLOCAR LA VENTANA DONDE VOY A CARGAR LOS PRODUCTOS
     * 
     */
    public void cargaProductos() {
        try {
            
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build(Util.RUTA_PRODUCTO);
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("producto");
            Iterator k = listaarchivos.iterator();
            
            while (k.hasNext()) {
                int i = 0, j = 0;
                Element e = (Element) k.next();
                Element id = e.getChild("id");   
                Element nombre = e.getChild("nombre");
                Element descripcion = e.getChild("descripcion");                
                Element imagen = e.getChild("imagen");
                Element costo = e.getChild("costo");
                Element estado = e.getChild("estado");
                Element idSuper = e.getChild("idSuper");
                
                
                /*ver como cargar la imagen del carrizo o pasarle a la ventana el path y ahi buscarlo, xs.
                *DESCOMENTAR ACA Y COLOCAR DONDE VOY A CARGAR LOS PRODUCTOS!
                * ventanita.agregarfila(id.getText(), nombre.getText(), descripcion.getText(), costo.getText(), estado.getText());
                * 
                */
                System.out.println(id.getText());
                System.out.println(nombre.getText());
                System.out.println(descripcion.getText());
                System.out.println(imagen.getText());
                System.out.println(costo.getText());
                System.out.println(estado.getText());
                System.out.println(idSuper.getText());

            }
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return Varchivo;
    }


    /**
     * Metodo que genera un nodo de elemento archivo en el archivo xml
     */
  

    /**
     * metodo que escribe la lista de archivos en el XML
     *
     * @param ventanita
     */
    public static void archivoNuevo(String nombre) {

        try {

            Element company = new Element("archivos");
            Document doc = new Document(company);
            doc.setRootElement(company);
            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();
            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("../ditribuidos.datos/" + nombre));
            System.out.println("Producto Creado Satisfactoriamente");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    
    /**
     * 
     *esta funcion agrega un nuevo producto al XML 
     * 
     */
    public static boolean escribirProducto(String nuevoNombre, String nuevoDescripcion,String nuevaCantidad, String nuevaImagen, String nuevoCosto, String nuevoEstado, String idSucursal) {
        {
            Document doc;
            Element root,id, nombre, descripcion, imagen, costo, estado, producto, idSuper,cantidad;
            SAXBuilder builder = new SAXBuilder();
           
            try {
                doc = builder.build(Util.RUTA_PRODUCTO);
                root = doc.getRootElement();
                // Creamos una nueva etiqueta
                Element aux = new Element("producto");
                List Productos = root.getChildren("producto");
                int tamLista = Productos.size();
                
                producto = new Element("producto");
                id = new Element("id");
                nombre = new Element("nombre");
                descripcion = new Element("descripcion");
                imagen = new Element("imagen");
                costo = new Element("costo");
                cantidad = new Element("cantidad");
                estado = new Element("estado");
                idSuper = new Element("idSuper");

                root.addContent(producto);
  
                producto.addContent(id);
                id.addContent(Integer.toString(tamLista+1));
                
                producto.addContent(nombre);
                nombre.addContent(nuevoNombre);

                producto.addContent(descripcion);
                descripcion.addContent(nuevoDescripcion);

                producto.addContent(imagen);
                imagen.addContent(nuevaImagen);

                producto.addContent(costo);
                costo.addContent(nuevoCosto);

                producto.addContent(cantidad);
                cantidad.addContent(nuevaCantidad);
                
                producto.addContent(estado);
                estado.addContent(nuevoEstado);

                producto.addContent(idSuper);
                idSuper.addContent(idSucursal);

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
                    FileOutputStream file = new FileOutputStream(Util.RUTA_PRODUCTO);
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
    
      public List getListaProducto() {
       
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = null;
        
        try {
            doc = builder.build(Util.RUTA_PRODUCTO);
        } catch (JDOMException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        root = doc.getRootElement(); 
        List Productos = this.root.getChildren("producto");
        return Productos;
      }
    
  public  void cargarInformacionProducto(Object posicion, JTextField codi, JTextField nombre, JTextField descripcion, JTextField cantidad, JTextField pvp,JLabel imagen, JTextField estado){
//                                (jCBSupermercado.getSelectedIndex()-1, jCBSucursal.getSelectedIndex()-1,jCBProducto.getSelectedIndex()-1,jCBAlmacenaje, jTFCodigo, jTFNombre, jTFDescripcion, jDCFechaIngreso, jTFRubros, jTFCantidad, jTFUnidad, jTFPvp, jDCFechaVencimiento, jCBMP, jLImagenPro, jCBControlPrecio, jTFStockMin)
    
     
        
        nombre.setText("");
        codi.setText("");
        descripcion.setText("");
        cantidad.setText("");
        pvp.setText("");
        imagen.setText("");
        estado.setText("");

          SAXBuilder builder = new SAXBuilder(false);
          Document doc = null;
          String[] idProducto = posicion.toString().split(" ");
        System.out.println();
            try {
                doc = builder.build(Util.RUTA_PRODUCTO);
            } catch (JDOMException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

            root = doc.getRootElement(); 
            Element aux = new Element("producto");
            List Productos = this.root.getChildren("producto");
            aux = this.buscarPorId(Productos, idProducto[0]);
            
            nombre.setText(aux.getChildText("nombre"));
            codi.setText(aux.getChildText("id"));
            descripcion.setText(aux.getChildText("descripcion"));
            cantidad.setText(aux.getChildText("cantidad"));
            pvp.setText(aux.getChildText("costo"));
            imagen.setIcon(new ImageIcon(aux.getChildText("imagen")));
            imagen.setText(aux.getChildText("imagen"));
            estado.setText(aux.getChildText("estado"));
            


//            Almacenaje.setSelectedItem(productoActual.getAlmacenaje().getCondicionesAdicionales());
        
    }
  
   public  void cargarInformacionPedido(Object pedido, JTextField nombre, JTextField observacion, JTextField cantidad, JComboBox estatus, Object sucursal){
//                                (jCBSupermercado.getSelectedIndex()-1, jCBSucursal.getSelectedIndex()-1,jCBProducto.getSelectedIndex()-1,jCBAlmacenaje, jTFCodigo, jTFNombre, jTFDescripcion, jDCFechaIngreso, jTFRubros, jTFCantidad, jTFUnidad, jTFPvp, jDCFechaVencimiento, jCBMP, jLImagenPro, jCBControlPrecio, jTFStockMin)
    
     
        
        nombre.setText("");
        observacion.setText("");
        estatus.setName("");
        cantidad.setText("");
       

          SAXBuilder builder = new SAXBuilder(false);
          Document doc = null;
          String[] idProducto = pedido.toString().split(" ");
          String[] idSucursal = sucursal.toString().split(" ");
        System.out.println();
            try {
                doc = builder.build(Util.RUTA_PEDIDO);
            } catch (JDOMException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

            root = doc.getRootElement(); 
            Element aux = new Element("pedido");
            List Productos = this.root.getChildren("pedido");
            aux = this.buscarPorNombreCantidad2(Productos, idSucursal[0],idProducto[0],idProducto[1] );
            
//            System.out.println("IDSUPER:   "  + idSucursal[0]);
//                
//            System.out.println("IDPRODUCTO:   "  + idProducto[0]);
//                
//            System.out.println("CANTIDAD:   "  + idProducto[1]);
            
           System.out.println("estatus:   "  + aux.getChildText("estatus"));
            
            nombre.setText(aux.getChildText("nombreProducto"));
            observacion.setText(aux.getChildText("observacion"));
            cantidad.setText(aux.getChildText("cantidad"));
            estatus.setSelectedItem(aux.getChildText("estatus"));
            

//            Almacenaje.setSelectedItem(productoActual.getAlmacenaje().getCondicionesAdicionales());
        
    }
   
        public static boolean escribirPedido(String idSuper1, String idProducto1, String nombreProducto1, String cantidad1, String estatus1, String observacion1)  {
        {
            Document doc;
            Element root, pedido, idProducto, nombreProducto, idPedido, idSuper,cantidad,producto,estatus,observacion;
            SAXBuilder builder = new SAXBuilder();
          
            try {
                doc = builder.build(Util.RUTA_PEDIDO);
                root = doc.getRootElement();
            
                  pedido = new Element("pedido");
                  idSuper = new Element("idSuper");
                  idProducto = new Element("idProducto");
                  nombreProducto = new Element("nombreProducto");
                  cantidad = new Element("cantidad");
                  estatus = new Element("estatus");
                  observacion = new Element("observacion");
                  
              root.addContent(pedido);
                
        
                pedido.addContent(idSuper);
                idSuper.addContent(idSuper1);
                
                pedido.addContent(idProducto);
                idProducto.addContent(idProducto1);
                
                 pedido.addContent(nombreProducto);
                nombreProducto.addContent(nombreProducto1);
                
                 pedido.addContent(cantidad);
                cantidad.addContent(cantidad1);
                
                 pedido.addContent(estatus);
                estatus.addContent(estatus1);
                
                 pedido.addContent(observacion);
                observacion.addContent(observacion1);
                 
           
               

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
                    FileOutputStream file = new FileOutputStream(Util.RUTA_PEDIDO);
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
 
public void logralo (List<Pedido> venta1){
      SAXBuilder builder = new SAXBuilder(false);
      Document doc = null;
        
            try {
                doc = builder.build(Util.RUTA_PEDIDO);
            } catch (JDOMException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

            root = doc.getRootElement(); 
            Element aux = new Element("pedido");
            List Productos = this.root.getChildren("pedido");
           
            
     for (int i = 0; i < venta1.size() ; i++) {
          aux = this.buscarPorNombreCantidad(Productos,venta1.get(i).getIdSuper(),venta1.get(i).getIdProducto(),venta1.get(i).getCantidad() );
         if(aux==null)
          escribirPedido(venta1.get(i).getIdSuper(), venta1.get(i).getIdProducto(), venta1.get(i).getNombreProducto(), venta1.get(i).getCantidad(), venta1.get(i).getEstatus(), venta1.get(i).getObservacion());
     
     }
    
}

 private boolean actualizarXML2() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(Util.RUTA_PEDIDO);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

public boolean updatePedidoFranquicia(Object sucursal, Object pedido, String cantidad, String estatus, String  observacion) {
      
       SAXBuilder builder = new SAXBuilder(false);
       Document doc = null;
         String[] idProducto = pedido.toString().split(" ");
         String[] idSucursal = sucursal.toString().split(" ");
         
        
       try {
           doc = builder.build(Util.RUTA_PEDIDO);
       } catch (JDOMException ex) {
           Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(ManejoXMLProducto.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       root = doc.getRootElement(); 
       boolean resultado = false;
       Element aux = new Element("pedido");
       List Productos = this.root.getChildren("pedido");
        aux = this.buscarPorNombreCantidad2(Productos, idSucursal[0],idProducto[0],idProducto[1] );
    
           
           aux.getChild("cantidad").setText(cantidad);
           aux.getChild("estatus").setText(estatus);
           aux.getChild("observacion").setText(observacion);
           resultado = actualizarXML2();
       

              
       
           
    
       return resultado;
   

}

        public static java.util.List<distribuidos.datos.Pedido> llenarPedidos(){
            
        String entrada = Util.RUTA_PEDIDO;
        List<distribuidos.datos.Pedido> lista = new ArrayList();
        Element root = new Element("pedidos");
        
        
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        
        try {
            doc = builder.build(entrada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if (doc != null){
            
            List<Element> contenido = doc.getRootElement().getChildren();
            for (Element e : contenido) {
                                 
               
                distribuidos.datos.Pedido ve= new  distribuidos.datos.Pedido(e.getChild("idSuper").getText(),e.getChild("idProducto").getText() ,e.getChild("nombreProducto").getText(),e.getChild("cantidad").getText(),e.getChild("estatus").getText(), e.getChild("observacion").getText() );

                lista.add(ve); 
                                    
                    
                                      
            }
        }
        else
        {
            System.out.println("Problemas cargando el xml de Estudiantes");             
        }
        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        
        return lista;
    }

public static boolean borrarXMLPedido() {
        {

            Document doc;
            Element root;
            SAXBuilder builder = new SAXBuilder();

            try {
                doc = builder.build(Util.RUTA_PEDIDO);
                root = doc.getRootElement();
               List <Element> lista = root.getChildren("pedido");
             //   System.out.println("tamanoooo: " +lista.size());
               for (int i =0; i<=lista.size()+1; i++){
                 //  if(root.getChild("pedido").getChildText("idSuper").equals((Integer.toString(distribuidos.Distribuidos.idAux.getId()))))
                   //(Integer.toString(distribuidos.Distribuidos.idAux.getId()))       
                   root.removeChild("pedido");
               }
         
             
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
                    FileOutputStream file = new FileOutputStream(Util.RUTA_PEDIDO);
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

}

