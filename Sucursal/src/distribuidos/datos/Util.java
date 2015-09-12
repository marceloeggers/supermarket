/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.datos;

//import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import org.jdom.Element;

/**
 *
 * @author marianasalcedo
 */
public class Util {
    
  public static final String RUTA_IMAGEN = "src//images//";
  public static final String RUTA_PRODUCTO = "src//distribuidos//datos//productoXML.xml";
  public static final String RUTA_SUPERMERCADO = "src/distribuidos.datos/supermercados.xml";
  public static final String RUTA_VENTA = "src/distribuidos/datos/VentaProducto.xml";
    public static final String RUTA_PEDIDO = "src/distribuidos/datos/PedidoProducto.xml";
  public static boolean sinConexion = true;
  private ManejoXMLProducto xmlproducto = new ManejoXMLProducto();
  public static int  id;
  private List ruta = xmlproducto.getListaProducto();
  //C:\Users\caro\Desktop\EN EL Q HAY Q TRABAJAR\Distribuidos\src\distribuidos\datos

    public static int getId() {
        return id;
    }

    public  void setId(int id) {
        
        this.id = id;
    }
        
  
  public static int ValidarEntero (String numero, String mensaje){

	try{
		int numero1 = Integer.parseInt(numero); return numero1;
		}

	catch (NumberFormatException ex){
	JOptionPane.showMessageDialog(null,mensaje,"Introdujo Tipo De Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
		return 0;

		}
        }
  
   public String getRuta(){
     ruta = xmlproducto.getListaProducto();
     return xmlproducto.getRuta(ruta);
 
 }
        
     public void cargarListaProductoEnCombo(JComboBox combo, boolean borrarCombo)
    {
        int tamLista, i;
        Supermercado superActual;
        String cadenaAMostrar, id;

        if (borrarCombo)
            combo.removeAllItems();
        List lista = xmlproducto.getListaProducto();
        tamLista = lista.size();
       // Element aux = new Element("producto");
        for (i=0 ; i<tamLista ; i++)
            
        {   System.out.println("ENTRAAA");
            //System.out.println(xmlproducto.buscarPorId(lista, Integer.toString(i)).getChildText("nombre"));
            cadenaAMostrar = ManejoXMLProducto.buscarPorId(lista, Integer.toString(i)).getChildText("nombre");

            combo.addItem(cadenaAMostrar);
        }
    }
                //Util.cargarInformacionProducto(jCBProducto.getSelectedIndex()-1, jTFCodigo, jTFNombre, jTFDescripcion,jTFCantidad,  jTFPvp,   jLImagenPro,  jTFStockMin);
    /*  public static void cargarInformacionProducto(int posicion, JTextField codi, JTextField nombre, JTextField descripcion, JTextField cantidad, JTextField pvp, JTextField estado){
//                                (jCBSupermercado.getSelectedIndex()-1, jCBSucursal.getSelectedIndex()-1,jCBProducto.getSelectedIndex()-1,jCBAlmacenaje, jTFCodigo, jTFNombre, jTFDescripcion, jDCFechaIngreso, jTFRubros, jTFCantidad, jTFUnidad, jTFPvp, jDCFechaVencimiento, jCBMP, jLImagenPro, jCBControlPrecio, jTFStockMin)
        Producto productoActual;

        nombre.setText("");
        codi.setText("");
        descripcion.setText("");
        rubros.setText("");
        cantidad.setText("");
        unidad.setText("");
        pvp.setText("");
        imagen.setText("");
        estado.setText("");


        if (posicion >= 0)
        {

            productoActual = funcion.ObtenerSucursal(indexsup, indexsuc).obtenerProducto(posicion);
            if(productoActual.isMateriaPrima()==true){
                materiaPrima.setSelectedItem("Si");
            } else{
                materiaPrima.setSelectedItem("No");
            }
            if(productoActual.isRegimenControlPRecio()==true){
                controlPrecio.setSelectedItem("Si");
            } else{
                controlPrecio.setSelectedItem("No");
            }


            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFechaIng = productoActual.getFechaIngreso();
            java.util.Date fechaing = null;
            String strFechaVenc = productoActual.getFechaVence();
            java.util.Date fechavenc = null;
            try {

            fechaing = formatoDelTexto.parse(strFechaIng);
            fechavenc= formatoDelTexto.parse(strFechaVenc);

} catch (ParseException ex) {

    ex.printStackTrace();

}

            nombre.setText(productoActual.getNombre());
            codi.setText(Integer.toString(productoActual.getCodigo()));
            descripcion.setText(productoActual.getDescripcion());
            fechaIng.setDate(fechaing);
            rubros.setText(productoActual.getRubros());
            cantidad.setText(Integer.toString(productoActual.getCantidad()));
            unidad.setText(productoActual.getUnidad());
            pvp.setText(Float.toString(productoActual.getPvp()));
            fechaVenc.setDate(fechavenc);
            imagen.setIcon(new ImageIcon(productoActual.getImagen()));
            imagen.setText(productoActual.getImagen());
            estado.setText(Integer.toString(productoActual.estado()));
//            Almacenaje.setSelectedItem(productoActual.getAlmacenaje().getCondicionesAdicionales());
        }
    }
     */
     
}
