
package app_proyecto;


import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {
    
    Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();
    

    PreparedStatement pst = null;
    ResultSet rs = null;
    String usu;
 
    Menu mn = new Menu();
  
    public login() {
        initComponents();
        
        this.setLocationRelativeTo(null);
     setIconImage(new ImageIcon(getClass().getResource("/imagenes/lgsmall.png")).getImage());
        
    }
    /*
    almacenar en variable y realizar consulta
    */
   
     public void Validar_acceso() {
        usu = user.getText();
        char contrasena[] = password.getPassword();
        String contra = new String(contrasena);
        String consulta = "SELECT * FROM usuario WHERE ced_us=? and contra_usu=? ";
        try {
            pst = cn.prepareStatement(consulta);
            
            pst.setString(1, usu);
            pst.setString(2, contra);
           
            rs = pst.executeQuery();
            if (rs.next()) {
                mn.setVisible(true);
                this.setVisible(false);
                this.setVisible(false);
            } else {
                label.setText("Datos incorrectos");
                JOptionPane.showMessageDialog(null, "Acceso no autorizado....", "ERROR", JOptionPane.ERROR_MESSAGE);
                user.setText("");
                password.setText("");
                user.grabFocus();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        user = new principal.MaterialTextField();
        jButton1 = new principal.MaterialButtomRectangle();
        mBtnSalir = new principal.MaterialButtomRectangle();
        label = new principal.MaterialTextField();
        rSPanelMaterial2 = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial1.setBackground(new java.awt.Color(89, 191, 42));
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        rSPanelMaterial1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 190, 40));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 26)); // NOI18N
        jLabel8.setText("CONTRASEÑA:");
        rSPanelMaterial1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 26)); // NOI18N
        jLabel7.setText("USUARIO:");
        rSPanelMaterial1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        user.setFont(new java.awt.Font("Roboto Regular", 1, 16)); // NOI18N
        user.setSelectionColor(new java.awt.Color(255, 0, 0));
        rSPanelMaterial1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 190, 40));

        jButton1.setBackground(new java.awt.Color(0, 112, 192));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INGRESAR");
        jButton1.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 150, 50));

        mBtnSalir.setBackground(new java.awt.Color(0, 112, 192));
        mBtnSalir.setForeground(new java.awt.Color(255, 255, 255));
        mBtnSalir.setText("SALIR");
        mBtnSalir.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        mBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBtnSalirActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(mBtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 150, 50));

        label.setEditable(false);
        label.setBackground(new java.awt.Color(89, 191, 42));
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        label.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 20)); // NOI18N
        label.setSelectionColor(new java.awt.Color(255, 0, 0));
        rSPanelMaterial1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 240, 30));

        getContentPane().add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -1, 440, 480));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asologo.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelMaterial2Layout = new javax.swing.GroupLayout(rSPanelMaterial2);
        rSPanelMaterial2.setLayout(rSPanelMaterial2Layout);
        rSPanelMaterial2Layout.setHorizontalGroup(
            rSPanelMaterial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        rSPanelMaterial2Layout.setVerticalGroup(
            rSPanelMaterial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelMaterial2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(100, 100, 100))
        );

        getContentPane().add(rSPanelMaterial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBtnSalirActionPerformed
        // TODO add your handling code here:
         System.exit(0); 
    }//GEN-LAST:event_mBtnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Validar_acceso();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButtomRectangle jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private principal.MaterialTextField label;
    private principal.MaterialButtomRectangle mBtnSalir;
    private javax.swing.JPasswordField password;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial2;
    private principal.MaterialTextField user;
    // End of variables declaration//GEN-END:variables
}
