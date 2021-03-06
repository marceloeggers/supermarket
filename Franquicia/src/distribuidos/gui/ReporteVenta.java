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
import distribuidos.datos.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import webservice.Venta;
/**
 *
 * @author Administrador
 */
public class ReporteVenta extends javax.swing.JFrame {

  //  private ManejoXMLProducto.agregarArchivo archi = new ManejoXMLProducto.;
    private ManejoXMLProducto xmlproducto = new ManejoXMLProducto();
     private ManejoXMLSupermercado xmlsuper = new ManejoXMLSupermercado();
    private Util util = new Util();
    private String nombrePro;
    /** Creates new form CrearProducto */
    public ReporteVenta() {
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
        jLSupermercado = new javax.swing.JLabel();
        jCBSupermercado = new javax.swing.JComboBox();
        jBAtras = new javax.swing.JButton();
        jLProducto = new javax.swing.JLabel();
        jCBProducto = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Producto");
        setResizable(false);

        jLPFondo.setBackground(new java.awt.Color(255, 255, 255));

        jLSupermercado.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLSupermercado.setForeground(new java.awt.Color(255, 255, 255));
        jLSupermercado.setText("Supermercado:");
        jLSupermercado.setBounds(20, 30, 110, 14);
        jLPFondo.add(jLSupermercado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jCBSupermercado.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jCBSupermercado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        jCBSupermercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSupermercadoActionPerformed(evt);
            }
        });
        jCBSupermercado.setBounds(120, 30, 130, 20);
        jLPFondo.add(jCBSupermercado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jBAtras.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jBAtras.setText("Aceptar");
        jBAtras.setVerifyInputWhenFocusTarget(false);
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });
        jBAtras.setBounds(210, 310, 80, 20);
        jLPFondo.add(jBAtras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLProducto.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLProducto.setForeground(new java.awt.Color(255, 255, 255));
        jLProducto.setText("Producto:");
        jLProducto.setBounds(20, 60, 110, 14);
        jLPFondo.add(jLProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jCBProducto.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jCBProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        jCBProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProductoActionPerformed(evt);
            }
        });
        jCBProducto.setBounds(120, 60, 130, 20);
        jLPFondo.add(jCBProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setBounds(50, 120, 452, 140);
        jLPFondo.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/561x571.jpg"))); // NOI18N
        jLFondo.setBounds(0, -230, 560, 570);
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
  
    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
                    
         this.dispose();
       
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jCBProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProductoActionPerformed
         String[] idSuper = this.jCBSupermercado.getSelectedItem().toString().split(" ");
          String[] idProducto = this.jCBProducto.getSelectedItem().toString().split(" ");
     if (jCBProducto.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una opcion en Supermercado","Error", JOptionPane.ERROR_MESSAGE);
     }
     else{  
                Comunicacion com = new Comunicacion();
      int i;
  
        List <Venta> lista =  com.devolverVenta(idSuper[0],idProducto[0]);
       for (i=0; i<lista.size(); i++){
            
                ((DefaultTableModel) this.jTable1.getModel()).addRow(new Object[]{lista.get(i).getNombreProducto(),lista.get(i).getCantidad(),lista.get(i).getCosto()});

            }
     }
    }//GEN-LAST:event_jCBProductoActionPerformed

    private void jCBSupermercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSupermercadoActionPerformed
        String[] idSuper = this.jCBSupermercado.getSelectedItem().toString().split(" ");
       
//        if (!idSuper[0].equals("0")){
//          jTFNombre.setEditable(false);
//          jTFDescripcion.setEditable(false);
//          jTFPvp.setEditable(false);
//          jTFEstado.setEditable(false);
//        }

        xmlproducto.cargarListaProductoEnCombo(this.jCBProducto, jCBSupermercado.getSelectedItem(),false);
    }//GEN-LAST:event_jCBSupermercadoActionPerformed
                   
    /**
     * @param args the command line arguments
     */
   private void initMyOwnComponents()
    {
           xmlsuper.cargarListaSuperEnCombo(jCBSupermercado,false);
//              Utilitaria.cargarListaAlmacenajeEnCombo(jCBAlmacenaje, false);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReporteVenta().setVisible(true);
            }
        });
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtras;
    private javax.swing.JComboBox jCBProducto;
    private javax.swing.JComboBox jCBSupermercado;
    private javax.swing.JLabel jLFondo;
    private javax.swing.JLayeredPane jLPFondo;
    private javax.swing.JLabel jLProducto;
    private javax.swing.JLabel jLSupermercado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
