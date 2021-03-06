/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CrearProducto.java
 *
 * Created on 24/04/2011, 12:32:08 PM
 */
package distribuidos.gui;
import distribuidos.datos.ManejoXMLProducto;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import distribuidos.datos.*;
import java.net.ConnectException;

/**
 *
 * @author Administrador
 */
public class VentaProducto extends javax.swing.JFrame {

    
    private ManejoXMLProducto xmlproducto = new ManejoXMLProducto();
    private Util util = new Util();
    /** Creates new form CrearProducto */
    public VentaProducto() {
        initComponents();
        initMyOwnComponents();
        this.setIconImage(new ImageIcon("src/Images/Icon.jpg").getImage());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLPFondo = new javax.swing.JLayeredPane();
        jLDescripcion = new javax.swing.JLabel();
        jTFDescripcion = new javax.swing.JTextField();
        jLPvp = new javax.swing.JLabel();
        jTFPvp = new javax.swing.JTextField();
        jLImagen = new javax.swing.JLabel();
        jBAtras = new javax.swing.JButton();
        jLNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLImagenPro = new javax.swing.JLabel();
        jLProducto = new javax.swing.JLabel();
        jCBProducto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTFCantidadV = new javax.swing.JTextField();
        jLCantidad = new javax.swing.JLabel();
        jTFCantidad = new javax.swing.JTextField();
        jLFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Producto");
        setResizable(false);

        jLPFondo.setBackground(new java.awt.Color(255, 255, 255));

        jLDescripcion.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jLDescripcion.setText("Descripcion:");
        jLDescripcion.setBounds(10, 100, 70, 20);
        jLPFondo.add(jLDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFDescripcion.setEditable(false);
        jTFDescripcion.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDescripcionActionPerformed(evt);
            }
        });
        jTFDescripcion.setBounds(140, 100, 150, 20);
        jLPFondo.add(jTFDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLPvp.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLPvp.setForeground(new java.awt.Color(255, 255, 255));
        jLPvp.setText("Precio:");
        jLPvp.setBounds(10, 130, 70, 20);
        jLPFondo.add(jLPvp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFPvp.setEditable(false);
        jTFPvp.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFPvp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPvpActionPerformed(evt);
            }
        });
        jTFPvp.setBounds(140, 130, 150, 20);
        jLPFondo.add(jTFPvp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLImagen.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLImagen.setForeground(new java.awt.Color(255, 255, 255));
        jLImagen.setText("Imagen:");
        jLImagen.setBounds(380, 30, 70, 14);
        jLPFondo.add(jLImagen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jBAtras.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jBAtras.setText("Vender");
        jBAtras.setVerifyInputWhenFocusTarget(false);
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });
        jBAtras.setBounds(240, 300, 80, 20);
        jLPFondo.add(jBAtras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLNombre.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLNombre.setText("Nombre:");
        jLNombre.setBounds(10, 70, 60, 14);
        jLPFondo.add(jLNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFNombre.setEditable(false);
        jTFNombre.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jTFNombre.setBounds(140, 70, 150, 20);
        jLPFondo.add(jTFNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLImagenPro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLImagenPro.setBounds(370, 60, 110, 130);
        jLPFondo.add(jLImagenPro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLProducto.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLProducto.setForeground(new java.awt.Color(255, 255, 255));
        jLProducto.setText("Producto:");
        jLProducto.setBounds(10, 40, 110, 14);
        jLPFondo.add(jLProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jCBProducto.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jCBProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        jCBProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProductoActionPerformed(evt);
            }
        });
        jCBProducto.setBounds(140, 40, 150, 20);
        jLPFondo.add(jCBProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad a Vender:");
        jLabel1.setBounds(10, 220, 120, 14);
        jLPFondo.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTFCantidadV.setBounds(140, 210, 50, 20);
        jLPFondo.add(jTFCantidadV, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLCantidad.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLCantidad.setText("Cantidad Disponible:");
        jLCantidad.setBounds(10, 160, 130, 20);
        jLPFondo.add(jLCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFCantidad.setEditable(false);
        jTFCantidad.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCantidadActionPerformed(evt);
            }
        });
        jTFCantidad.setBounds(140, 160, 50, 20);
        jLPFondo.add(jTFCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/561x571.jpg"))); // NOI18N
        jLFondo.setBounds(0, -170, 560, 570);
        jLPFondo.add(jLFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-554)/2, (screenSize.height-377)/2, 554, 377);
    }// </editor-fold>//GEN-END:initComponents
  
    private void jTFDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDescripcionActionPerformed

    private void jTFPvpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPvpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPvpActionPerformed

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
       Comunicacion com = new Comunicacion();
       int sucursal = Util.getId();
       float costo = Float.parseFloat(jTFPvp.getText()) * Float.parseFloat(jTFCantidadV.getText());
       String[] idProducto1 = jCBProducto.getSelectedItem().toString().split(" ");
       int cantidad =  Integer.parseInt(jTFCantidad.getText()) - Integer.parseInt(jTFCantidadV.getText());
       
       if(cantidad < 0 ){
         JOptionPane.showMessageDialog(null, "VALOR INCORRECTO EN LA CANTIDAD A VENDER");  
           this.dispose();
       }
       else
      if(cantidad < 10){
           JOptionPane.showMessageDialog(null, "SOLICITAR PRODUCTO YA QUE EXISTE BAJO INVENTARIO");
            int num =0;
            num=Util.ValidarEntero(jTFCantidadV.getText(), "Cantidad debe ser un numero");
            if (jCBProducto.getSelectedIndex()==0||num==0){
            JOptionPane.showMessageDialog(null,"Indique opcion correcta","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
           XMLnodos xmlnodo = new XMLnodos();
           int var=0;
           for (int i = 0; i < xmlnodo.cantNodos(); i++) {
            
               var=xmlnodo.cargaArchivos(i);
               Hilo Hilo;
               // OJO EL 1200 ES EL PUERTO DE ENVIAR, EL DE ESCUCHA SE ESTA USANDO POR ARGUMENTO
             if(var==1){
                
                //  public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String idProducto, String cantidadProducto1)
                 
                Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_salida(),DatosNodos.getPuerto_entrada(),"modificar", idProducto1[0],Integer.toString(cantidad));
                Hilo.start();
             }
            xmlproducto.updateProductoSucursal(idProducto1[0],Integer.toString(cantidad));

       // TODO add your handling code here:
        }
            }
        
            //CODIGO PARA GUARDAR LA VENTA LOCALMENTE
            
           
        
           com.ventas(Integer.toString(sucursal), jCBProducto.getSelectedItem(), jTFNombre.getText() ,jTFCantidadV.getText(), Float.toString(costo));
           this.dispose();
           
      }else{ 
          
          if(cantidad >= 10 ){
            int num =0;
            num=Util.ValidarEntero(jTFCantidadV.getText(), "Cantidad debe ser un numero");
            if (jCBProducto.getSelectedIndex()==0||num==0){
            JOptionPane.showMessageDialog(null,"Indique opcion correcta","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
           XMLnodos xmlnodo = new XMLnodos();
           int var=0;
           for (int i = 0; i < xmlnodo.cantNodos(); i++) {
            
               var=xmlnodo.cargaArchivos(i);
               Hilo Hilo;
               // OJO EL 1200 ES EL PUERTO DE ENVIAR, EL DE ESCUCHA SE ESTA USANDO POR ARGUMENTO
             if(var==1){
                
                //  public Hilo(String ip_nodo_siguiente, int puerto_salida, int puerto_entrada, String opcion, String idProducto, String cantidadProducto1)
                 
                Hilo = new Hilo(DatosNodos.getIp_vecino(), DatosNodos.getPuerto_salida(),DatosNodos.getPuerto_entrada(),"modificar", idProducto1[0],Integer.toString(cantidad));
                Hilo.start();
             }
            xmlproducto.updateProductoSucursal(idProducto1[0],Integer.toString(cantidad));

       // TODO add your handling code here:
        }
            }
        
            //CODIGO PARA GUARDAR LA VENTA LOCALMENTE
            
           
        
           com.ventas(Integer.toString(sucursal), jCBProducto.getSelectedItem(), jTFNombre.getText() ,jTFCantidadV.getText(), Float.toString(costo));
           this.dispose();
      }
      }     
        
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jCBProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProductoActionPerformed
        // TODO add your handling code here:
     if (jCBProducto.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un Producto","Error", JOptionPane.ERROR_MESSAGE);
     }
     else{
         xmlproducto.cargarInformacionProducto2(jCBProducto.getSelectedItem(),jTFNombre, jTFDescripcion,jTFCantidad,  jTFPvp,jLImagenPro);

     }
    }//GEN-LAST:event_jCBProductoActionPerformed

    private void jTFCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCantidadActionPerformed
                   
    /**
     * @param args the command line arguments
     */
            private void initMyOwnComponents()
    {
            xmlproducto.cargarListaProductoVenta(this.jCBProducto, false);
//              Utilitaria.cargarListaAlmacenajeEnCombo(jCBAlmacenaje, false);
    }
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
        
            public void run() {
                new VentaProducto().setVisible(true);
            }
        });
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtras;
    private javax.swing.JComboBox jCBProducto;
    private javax.swing.JLabel jLCantidad;
    private javax.swing.JLabel jLDescripcion;
    private javax.swing.JLabel jLFondo;
    private javax.swing.JLabel jLImagen;
    private javax.swing.JLabel jLImagenPro;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLayeredPane jLPFondo;
    private javax.swing.JLabel jLProducto;
    private javax.swing.JLabel jLPvp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFCantidadV;
    private javax.swing.JTextField jTFDescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFPvp;
    // End of variables declaration//GEN-END:variables
}
