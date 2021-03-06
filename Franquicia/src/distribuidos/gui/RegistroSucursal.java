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
import distribuidos.datos.ManejoXMLSupermercado;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import distribuidos.datos.Util;

/**
 *
 * @author Administrador
 */
public class RegistroSucursal extends javax.swing.JFrame {

    
    private ManejoXMLSupermercado xmlsucursal = new ManejoXMLSupermercado();
    private Util util = new Util();
    /** Creates new form CrearProducto */
    public RegistroSucursal() {
        initComponents();
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
        jTFUbicacion = new javax.swing.JTextField();
        jFCImagenProducto = new javax.swing.JFileChooser();
        jTFTelf = new javax.swing.JTextField();
        jLStrockMin = new javax.swing.JLabel();
        jBAtras = new javax.swing.JButton();
        jLNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Producto");
        setResizable(false);

        jLPFondo.setBackground(new java.awt.Color(255, 255, 255));

        jLDescripcion.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jLDescripcion.setText("ubicacion:");
        jLDescripcion.setBounds(90, 90, 70, 20);
        jLPFondo.add(jLDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFUbicacion.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUbicacionActionPerformed(evt);
            }
        });
        jTFUbicacion.setBounds(190, 90, 150, 20);
        jLPFondo.add(jTFUbicacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jFCImagenProducto.setBounds(220, 390, 10, 10);
        jLPFondo.add(jFCImagenProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFTelf.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFTelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelfActionPerformed(evt);
            }
        });
        jTFTelf.setBounds(190, 120, 150, 20);
        jLPFondo.add(jTFTelf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLStrockMin.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLStrockMin.setForeground(new java.awt.Color(255, 255, 255));
        jLStrockMin.setText("Telefono:");
        jLStrockMin.setBounds(90, 120, 90, 20);
        jLPFondo.add(jLStrockMin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jBAtras.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jBAtras.setText("Aceptar");
        jBAtras.setVerifyInputWhenFocusTarget(false);
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });
        jBAtras.setBounds(190, 260, 80, 20);
        jLPFondo.add(jBAtras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLNombre.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLNombre.setText("Nombre:");
        jLNombre.setBounds(90, 60, 60, 20);
        jLPFondo.add(jLNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTFNombre.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jTFNombre.setBounds(190, 60, 150, 20);
        jLPFondo.add(jTFNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/561x571.jpg"))); // NOI18N
        jLFondo.setBounds(-100, -270, 560, 570);
        jLPFondo.add(jLFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-473)/2, (screenSize.height-325)/2, 473, 325);
    }// </editor-fold>//GEN-END:initComponents
  
    private void jTFTelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTelfActionPerformed

    private void jTFUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUbicacionActionPerformed

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        // TODO add your handling code here:
        // public agregarArchivo(String nombre, String descrip, String cantidad, String imagen, String costo, String estado) {
        xmlsucursal.escribirSucursal(jTFNombre.getText(),jTFUbicacion.getText(),jTFTelf.getText());
        this.dispose();
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed
                   
    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RegistroSucursal().setVisible(true);
            }
        });
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtras;
    private javax.swing.JFileChooser jFCImagenProducto;
    private javax.swing.JLabel jLDescripcion;
    private javax.swing.JLabel jLFondo;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLayeredPane jLPFondo;
    private javax.swing.JLabel jLStrockMin;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTelf;
    private javax.swing.JTextField jTFUbicacion;
    // End of variables declaration//GEN-END:variables
}
