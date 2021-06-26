/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Controlador.operaciones_usuarios;
import Entidades.Usuarios;
import Listas.ListaUsuario;
import Validaciones.Validaciones;
import static Validaciones.Validaciones.validadorDeCedula;
import javax.swing.JOptionPane;

/**
 *
 * @author JASON LOZADA
 */
public class Registrar_Usuario extends javax.swing.JInternalFrame {

    operaciones_usuarios ous = new operaciones_usuarios();
    Usuarios usua = new Usuarios();
    ListaUsuario luarios = new ListaUsuario();

    public Registrar_Usuario() {
        initComponents();
        luarios.Cargar();
        tablaUsu.setModel(ous.mostrardatos(""));

        // ous.mostrardatos("");
        bloquearC();
        bloquearBtnes();
    }

    public void limpiar() {
        cedUs.setText("");
        nomUs.setText("");
        apeUs.setText("");
        telfUs.setText("");
        direUs.setText("");
        paswUs.setText("");

    }

    public void bloquearBtnes() {
        btnGuardar.setEnabled(false);
        btnActua.setEnabled(false);
        btnEli.setEnabled(false);

    }

    public void desbloquearC() {
        cedUs.setEnabled(true);
        nomUs.setEnabled(true);
        apeUs.setEnabled(true);
        direUs.setEnabled(true);
        comboUs.setEnabled(true);
        paswUs.setEnabled(true);

    }

    public void bloquearC() {
        cedUs.setEnabled(false);
        nomUs.setEnabled(false);
        apeUs.setEnabled(false);
        direUs.setEnabled(false);
        comboUs.setEnabled(false);
        paswUs.setEnabled(false);

    }

    public void pinta_text() {
        Validaciones.pinta_text(cedUs);
        Validaciones.pinta_text(nomUs);
        Validaciones.pinta_text(apeUs);
        Validaciones.pinta_text(direUs);
        Validaciones.pinta_text(telfUs);
        Validaciones.pinta_text(paswUs);
        txtMensaje.setText("");
    }

    public boolean form_validado() {
        boolean ok = true;
        String men = "Campos requeridos o con errores: ";
        //validar requerido
        if (!Validaciones.esCedula(cedUs)) {
            ok = false;
            men += "Cedula ";
        }
        if (!Validaciones.esRequerido(nomUs)) {
            ok = false;
            men += ", Nombre ";
        }
        if (!Validaciones.esRequerido(apeUs)) {
            ok = false;
            men += ", Apellido ";
        }
        if (!Validaciones.esRequerido(direUs)) {
            ok = false;
            men += ", Direccion ";
        }

        if (!Validaciones.esTelefono(telfUs)) {
            ok = false;
            men += ", Telefono ";
        }
        if (!Validaciones.esRequerido(paswUs)) {
            ok = false;
            men += ", Pasward ";
        }
        txtMensaje.setText(men);
        //validar más controles
        return ok;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsu = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        paswUs = new javax.swing.JTextField();
        nomUs = new javax.swing.JTextField();
        apeUs = new javax.swing.JTextField();
        cedUs = new javax.swing.JTextField();
        codUs = new javax.swing.JTextField();
        telfUs = new javax.swing.JTextField();
        direUs = new javax.swing.JTextField();
        comboUs = new javax.swing.JComboBox();
        busUs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActua = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtMensaje = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro de Usuarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cod:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Teléfono:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Cedula:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Buscar por cedula:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        tablaUsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 550, 150));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tipo Usuario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Dirección:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, 20));
        getContentPane().add(paswUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 130, -1));
        getContentPane().add(nomUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 120, -1));
        getContentPane().add(apeUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, -1));
        getContentPane().add(cedUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, -1));

        codUs.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codUs.setEnabled(false);
        getContentPane().add(codUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 120, -1));
        getContentPane().add(telfUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 130, -1));
        getContentPane().add(direUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 130, -1));

        comboUs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Empleado" }));
        getContentPane().add(comboUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 130, -1));

        busUs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                busUsKeyReleased(evt);
            }
        });
        getContentPane().add(busUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Apellido:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnActua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/document_edit.png"))); // NOI18N
        btnActua.setText("Editar");
        btnActua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActua);

        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEli.setText("Eliminar");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEli);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMensaje.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 540, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 560, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Guardar datos
        if (form_validado() && validadorDeCedula(cedUs.getText())) {
            pinta_text();
             
            usua.setCod_usu(Integer.parseInt(codUs.getText()));
            usua.setCed(cedUs.getText());
            usua.setNom(nomUs.getText());
            usua.setApe(apeUs.getText());
            usua.setTelf(telfUs.getText());
            usua.setDireccion(direUs.getText());
            usua.setTip_usuario(comboUs.getSelectedItem().toString());
            usua.setPossward(paswUs.getText());
            ous.Registrar(usua);
            tablaUsu.setModel(ous.mostrardatos(""));
            bloquearC();
            limpiar();

        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuaActionPerformed
        // 
        if (form_validado() && validadorDeCedula(cedUs.getText())) {
            pinta_text();
            usua.setCod_usu(Integer.parseInt(codUs.getText()));
            usua.setCed(cedUs.getText());
            usua.setNom(nomUs.getText());
            usua.setApe(apeUs.getText());
            usua.setTelf(telfUs.getText());
            usua.setDireccion(direUs.getText());
            usua.setTip_usuario(comboUs.getSelectedItem().toString());
            usua.setPossward(paswUs.getText());
            ous.Modificar(usua);
            tablaUsu.setModel(ous.mostrardatos(""));
            bloquearC();
            limpiar();

        }
    }//GEN-LAST:event_btnActuaActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        // TODO add your handling code here:
        if (form_validado() && validadorDeCedula(cedUs.getText())) {
            pinta_text();
            usua.setCod_usu(Integer.parseInt(codUs.getText()));
            usua.setCed(cedUs.getText());
            usua.setNom(nomUs.getText());
            usua.setApe(apeUs.getText());
            usua.setTelf(telfUs.getText());
            usua.setDireccion(direUs.getText());
            usua.setTip_usuario(comboUs.getSelectedItem().toString());
            usua.setPossward(paswUs.getText());
            ous.Eliminar(usua);
            tablaUsu.setModel(ous.mostrardatos(""));

            bloquearC();
            limpiar();

        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        codUs.setText(luarios.CodUsuario() + 1 + "");
        desbloquearC();
        limpiar();
        btnGuardar.setEnabled(true);
        btnActua.setEnabled(false);
        btnEli.setEnabled(false);
        pinta_text();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaUsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuMouseClicked
        // TODO add your handling code here:
        int fila = tablaUsu.getSelectedRow();
        if (fila >= 0) {
            codUs.setText(tablaUsu.getValueAt(fila, 0).toString());
            cedUs.setText(tablaUsu.getValueAt(fila, 1).toString());
            nomUs.setText(tablaUsu.getValueAt(fila, 2).toString());
            apeUs.setText(tablaUsu.getValueAt(fila, 3).toString());
            direUs.setText(tablaUsu.getValueAt(fila, 4).toString());
            telfUs.setText(tablaUsu.getValueAt(fila, 5).toString());
            comboUs.setSelectedItem(tablaUsu.getValueAt(fila, 6).toString());
            paswUs.setText(tablaUsu.getValueAt(fila, 7).toString());

            btnGuardar.setEnabled(false);
            btnActua.setEnabled(true);
            btnEli.setEnabled(true);
            desbloquearC();
            pinta_text();

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tablaUsuMouseClicked

    private void busUsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busUsKeyReleased
        tablaUsu.setModel(ous.mostrardatos(busUs.getText()));

    }//GEN-LAST:event_busUsKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apeUs;
    private javax.swing.JButton btnActua;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField busUs;
    private javax.swing.JTextField cedUs;
    private javax.swing.JTextField codUs;
    private javax.swing.JComboBox comboUs;
    private javax.swing.JTextField direUs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nomUs;
    private javax.swing.JTextField paswUs;
    public static javax.swing.JTable tablaUsu;
    private javax.swing.JTextField telfUs;
    private javax.swing.JLabel txtMensaje;
    // End of variables declaration//GEN-END:variables
}
