package app_proyecto;


import Consultas.Reportes;
import Formularios.Facturar;
import Formularios.Registrar_Usuario;
import Formularios.Registrar_proveedor;
import Formularios.Registro_Clientes;
import Formularios.Registro_productos;
import controlador.*;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);//Centrar la ventan
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/lgsmall.png")).getImage());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(143, 240, 90));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(388, 75));

        jMenu1.setBackground(new java.awt.Color(0, 0, 204));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro2.png"))); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setPreferredSize(new java.awt.Dimension(90, 62));
        jMenu1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroanim.png"))); // NOI18N
        jMenu1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroanim.png"))); // NOI18N
        jMenu1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroanim.png"))); // NOI18N
        jMenu1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroanim.png"))); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(143, 240, 90));
        jMenuItem1.setText("OPCION 1 ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setBackground(new java.awt.Color(143, 240, 90));
        jMenuItem5.setText("OPCION 2");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setBackground(new java.awt.Color(143, 240, 90));
        jMenuItem6.setText("OPCION 3");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida.png"))); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setPreferredSize(new java.awt.Dimension(90, 62));

        jMenuItem4.setBackground(new java.awt.Color(143, 240, 90));
        jMenuItem4.setText("OPCION 1");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario.png"))); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setPreferredSize(new java.awt.Dimension(90, 62));

        jMenuItem8.setBackground(new java.awt.Color(143, 240, 90));
        jMenuItem8.setText("OPCION 1");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte2.png"))); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMenuItem9.setBackground(new java.awt.Color(143, 240, 90));
        jMenuItem9.setText("OPCION 1");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // llamar a la venta registro clientes
        Registro_Clientes rc = new Registro_Clientes();
        int x = (jDesktopPane1.getWidth() / 2) - (rc.getWidth() / 2);
        int y = (jDesktopPane1.getHeight() / 2) - (rc.getHeight() / 2);
        if (rc.isShowing()) {
            rc.setLocation(x, y);
        } else {
            jDesktopPane1.add(rc);
            rc.setLocation(x, y);
            rc.show();
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // 
        try {
            Facturar rc = new Facturar();
            int x = (jDesktopPane1.getWidth() / 2) - (rc.getWidth() / 2);
            int y = (jDesktopPane1.getHeight() / 2) - (rc.getHeight() / 2);
            if (rc.isShowing()) {
                rc.setLocation(x, y);
            } else {
                jDesktopPane1.add(rc);
                rc.setLocation(x, y);
                rc.show();
            }
        } catch (Exception ex) {
            System.out.println(ex+"");
        }


    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       
         try {
            Registrar_Usuario rc = new Registrar_Usuario();
            int x = (jDesktopPane1.getWidth() / 2) - (rc.getWidth() / 2);
            int y = (jDesktopPane1.getHeight() / 2) - (rc.getHeight() / 2);
            if (rc.isShowing()) {
                rc.setLocation(x, y);
            } else {
                jDesktopPane1.add(rc);
                rc.setLocation(x, y);
                rc.show();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    
         try {
            Registrar_proveedor rc = new Registrar_proveedor();
            int x = (jDesktopPane1.getWidth() / 2) - (rc.getWidth() / 2);
            int y = (jDesktopPane1.getHeight() / 2) - (rc.getHeight() / 2);
            if (rc.isShowing()) {
                rc.setLocation(x, y);
            } else {
                jDesktopPane1.add(rc);
                rc.setLocation(x, y);
                rc.show();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }  
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
         Registro_productos rc = new Registro_productos();
        int x = (jDesktopPane1.getWidth() / 2) - (rc.getWidth() / 2);
        int y = (jDesktopPane1.getHeight() / 2) - (rc.getHeight() / 2);
        if (rc.isShowing()) {
            rc.setLocation(x, y);
        } else {
            jDesktopPane1.add(rc);
            rc.setLocation(x, y);
            rc.show();
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
           try {
            Reportes rc = new Reportes();
            int x = (jDesktopPane1.getWidth() / 2) - (rc.getWidth() / 2);
            int y = (jDesktopPane1.getHeight() / 2) - (rc.getHeight() / 2);
            if (rc.isShowing()) {
                rc.setLocation(x, y);
            } else {
                jDesktopPane1.add(rc);
                rc.setLocation(x, y);
                rc.show();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
