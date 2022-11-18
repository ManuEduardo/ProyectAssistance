/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.proyect.Vistas.VentanasPrincipales;

import org.proyect.Vistas.Ventana;

/**
 *
 * @author manue
 */
public class VentanaLogin extends javax.swing.JFrame implements Ventana {

    /**
     * Creates new form VentanaLogin
     */
    @Override
    public void iniciar() {
        this.setVisible(true);
        this.setTitle("Registrar Asistencia");
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public VentanaLogin() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        jPasswordFieldContrasenia = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 242, 242));
        setMinimumSize(new java.awt.Dimension(420, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(420, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(111, 191, 191));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(57, 62, 89));
        jLabel8.setText("Contraseña");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(57, 62, 89));
        jLabel10.setText("DNI:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jTextFieldDni.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jTextFieldDni.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDniActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 170, 29));

        jButtonIngresar.setBackground(new java.awt.Color(57, 62, 89));
        jButtonIngresar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jButtonIngresar.setForeground(new java.awt.Color(111, 191, 191));
        jButtonIngresar.setText("Iniciar Sesión");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, 40));

        jPasswordFieldContrasenia.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jPasswordFieldContrasenia.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordFieldContrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldContraseniaActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordFieldContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, 29));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 104, 346, 232));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 62, 89));
        jLabel1.setText("LOGIN");
        jLabel1.setPreferredSize(new java.awt.Dimension(524, 62));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 24, 152, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Solo Administradores (RR.HH)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 354, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldContraseniaActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPasswordField jPasswordFieldContrasenia;
    public javax.swing.JTextField jTextFieldDni;
    // End of variables declaration//GEN-END:variables
}
