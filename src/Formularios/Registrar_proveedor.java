package Formularios;

import Controlador.operaciones_proveedor;
import Entidades.proveedores;
import Validaciones.Validaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author JASON LOZADA
 */
public class Registrar_proveedor extends javax.swing.JInternalFrame {

    operaciones_proveedor opve = new operaciones_proveedor();
    proveedores p = new proveedores();

    public Registrar_proveedor() {
        initComponents();
        bloquearCampos();
        opve.mostrardatos_Provedores("");
        bloquearBtn();
    }

    public void pinta_text() {
        Validaciones.pinta_text(txtCedpro);
        Validaciones.pinta_text(nom_pro);
        Validaciones.pinta_text(direc_pro);
        Validaciones.pinta_text(correo_pro);
        Validaciones.pinta_text(telf_pro);
        mensaje.setText("");
    }

    public boolean form_validado() {//txtCodPro
        boolean ok = true;
        String men = "Campos requeridos o con errores: ";
        //validar requerido
        if (!Validaciones.esCedula(txtCedpro)) {
            ok = false;
            men += "Ruc-Ci ";
        }
        if (!Validaciones.esRequerido(nom_pro)) {
            ok = false;
            men += ", Nombre ";
        }
        if (!Validaciones.esRequerido(direc_pro)) {
            ok = false;
            men += ", Direccion ";
        }
        if (!Validaciones.esEmail(correo_pro)) {
            ok = false;
            men += ", Email ";
        }
        if (!Validaciones.esTelefono(telf_pro)) {
            ok = false;
            men += ", Telefono ";
        }
        mensaje.setText(men);
        //validar más controles
        return ok;
    }

    public void bloquearCampos() {
        txtCedpro.setEnabled(false);
        nom_pro.setEnabled(false);
        direc_pro.setEnabled(false);
        correo_pro.setEnabled(false);
        telf_pro.setEnabled(false);
    }

    public void desbloquearCampos() {
        txtCedpro.setEnabled(true);
        nom_pro.setEnabled(true);
        direc_pro.setEnabled(true);
        correo_pro.setEnabled(true);
        telf_pro.setEnabled(true);
    }

    public void bloquearBtn() {
        btnGuardar.setEnabled(false);
        btnAct.setEnabled(false);
        btnEli.setEnabled(false);

    }
    public void limpiar(){
        txtCedpro.setText("");
        nom_pro.setText("");
        direc_pro.setText("");
        correo_pro.setText("");
        telf_pro.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCedpro = new javax.swing.JTextField();
        txtCodPro = new javax.swing.JTextField();
        nom_pro = new javax.swing.JTextField();
        telf_pro = new javax.swing.JTextField();
        direc_pro = new javax.swing.JTextField();
        correo_pro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        btnBus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAct = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro de Proveedores");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cod:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Direccion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cedula/RUC:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        txtCedpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedproActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, -1));

        txtCodPro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodPro.setEnabled(false);
        getContentPane().add(txtCodPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 70, -1));
        getContentPane().add(nom_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));
        getContentPane().add(telf_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, -1));
        getContentPane().add(direc_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 150, -1));
        getContentPane().add(correo_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Correo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 540, 150));

        btnBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnBusKeyReleased(evt);
            }
        });
        getContentPane().add(btnBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Buscar  cedula/RUC:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/document_edit.png"))); // NOI18N
        btnAct.setText("Actualizar");
        btnAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAct);

        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEli.setText("Eliminar");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEli);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensaje.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 560, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Guardar
        if (form_validado() && Validaciones.validadorDeCedula(txtCedpro.getText())) {
            pinta_text();
            p.setCod_prove(Integer.parseInt(txtCodPro.getText()));
            p.setCed(txtCedpro.getText());
            p.setNom(nom_pro.getText());
            p.setDireccion(direc_pro.getText());
            p.setCorreo_cedula(correo_pro.getText());
            p.setTelf(telf_pro.getText());
            opve.Registrar(p);
            bloquearCampos();
            opve.mostrardatos_Provedores("");
            limpiar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCedproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedproActionPerformed

    private void btnActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActActionPerformed
        // TODO add your handling code here:
        if (form_validado() && Validaciones.validadorDeCedula(txtCedpro.getText())) {
            pinta_text();
            p.setCod_prove(Integer.parseInt(txtCodPro.getText()));
            p.setCed(txtCedpro.getText());
            p.setNom(nom_pro.getText());
            p.setDireccion(direc_pro.getText());
            p.setCorreo_cedula(correo_pro.getText());
            p.setTelf(telf_pro.getText());
            opve.Modificar(p);
            bloquearCampos();
            opve.mostrardatos_Provedores("");
             limpiar();
        }
    }//GEN-LAST:event_btnActActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        // TODO add your handling code here:
        if (form_validado() && Validaciones.validadorDeCedula(txtCedpro.getText())) {
            pinta_text();
            p.setCod_prove(Integer.parseInt(txtCodPro.getText()));
            p.setCed(txtCedpro.getText());
            p.setNom(nom_pro.getText());
            p.setDireccion(direc_pro.getText());
            p.setCorreo_cedula(correo_pro.getText());
            p.setTelf(telf_pro.getText());
            opve.Eliminar(p);
            bloquearCampos();
            opve.mostrardatos_Provedores("");
             limpiar();
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtCodPro.setText(opve.codigo_Proveedor() + "");// btnNuevo
        desbloquearCampos();
        btnGuardar.setEnabled(true);
        btnAct.setEnabled(false);
        btnEli.setEnabled(false);
        limpiar();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBusKeyReleased
        opve.mostrardatos_Provedores(btnBus.getText());
    }//GEN-LAST:event_btnBusKeyReleased

    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        // TODO add your handling code here:
        try{
        int fila = tblProveedores.getSelectedRow();
        if (fila >= 0) {
            txtCodPro.setText(tblProveedores.getValueAt(fila, 0).toString());
            txtCedpro.setText(tblProveedores.getValueAt(fila, 1).toString());
            nom_pro.setText(tblProveedores.getValueAt(fila, 2).toString());
            direc_pro.setText(tblProveedores.getValueAt(fila, 3).toString());
            telf_pro.setText(tblProveedores.getValueAt(fila, 4).toString());
            correo_pro.setText(tblProveedores.getValueAt(fila, 5).toString());
            btnGuardar.setEnabled(false);
            btnAct.setEnabled(true);
            btnEli.setEnabled(true);
            desbloquearCampos();
            pinta_text();
        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
                System.out.println(e);
                
                }
        
    }//GEN-LAST:event_tblProveedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAct;
    private javax.swing.JTextField btnBus;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField correo_pro;
    private javax.swing.JTextField direc_pro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextField nom_pro;
    public static javax.swing.JTable tblProveedores;
    private javax.swing.JTextField telf_pro;
    private javax.swing.JTextField txtCedpro;
    private javax.swing.JTextField txtCodPro;
    // End of variables declaration//GEN-END:variables
}
