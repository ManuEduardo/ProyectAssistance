/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.proyect.Vistas.VentanasRegistrar;
import org.proyect.Vistas.Ventana;

/**
 *
 * @author manue
 */
public class VentanaCrearEmpleado extends javax.swing.JFrame implements Ventana {

    /**
     * Creates new form VentanaCrearEmpleado
     */
    @Override
    public void iniciar() {
        this.setVisible(true);
        this.setTitle("Crear Empleado");// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public VentanaCrearEmpleado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBusqueda = new javax.swing.JTable();
        jComboBoxParametro = new javax.swing.JComboBox<>();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        jComboBoxDepartamento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(240, 242, 242));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 62, 89));
        jLabel1.setText("REGISTRAR EMPLEADO");
        jLabel1.setPreferredSize(new java.awt.Dimension(524, 62));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 14, 560, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel2.setText("DNI:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 171, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel5.setText("Departamento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel6.setText("Contraseña:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel7.setText("Repite Contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jTextFieldDni.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jTextFieldDni.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDniActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 170, 29));

        jTextFieldNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 170, 29));

        jPasswordField1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 170, 29));

        jPasswordField2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 170, 29));

        jPanel2.setBackground(new java.awt.Color(57, 62, 89));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Parametro");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar por:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ingrese:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jTextFieldBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jTextFieldBuscar.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 170, 29));

        jButtonBuscar.setBackground(new java.awt.Color(111, 191, 191));
        jButtonBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(57, 62, 89));
        jButtonBuscar.setText("Buscar");
        jPanel2.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 40));

        jTableBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dni", "Nombre", "Email", "Departamento"
            }
        ));
        jScrollPane1.setViewportView(jTableBusqueda);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 310, 51));

        jComboBoxParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dni", "Nombre" }));
        jPanel2.add(jComboBoxParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, 29));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 176, 346, 270));

        jTextFieldEmail.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 170, 29));

        jButtonRegistrar.setBackground(new java.awt.Color(57, 62, 89));
        jButtonRegistrar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(111, 191, 191));
        jButtonRegistrar.setText("Registrar");
        jPanel1.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 160, 40));

        jComboBoxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marketing", "Ventas", "Logistica", "Tic", "Control Interno", "RR.HH", "Contabilidad" }));
        jPanel1.add(jComboBoxDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 170, 29));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextFieldDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCrearEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonBuscar;
    public javax.swing.JButton jButtonRegistrar;
    public javax.swing.JComboBox<String> jComboBoxDepartamento;
    public javax.swing.JComboBox<String> jComboBoxParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableBusqueda;
    public javax.swing.JTextField jTextFieldBuscar;
    public javax.swing.JTextField jTextFieldDni;
    public javax.swing.JTextField jTextFieldEmail;
    public javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}