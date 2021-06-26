package Formularios;

import Controlador.operaciones_clientes;
import Entidades.Cliente;
import Listas.ListaCliente;
import Validaciones.Validaciones;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Registro_Clientes extends javax.swing.JInternalFrame {

    Cliente cli = new Cliente();
    operaciones_clientes ocl = new operaciones_clientes();
    ListaCliente lc = new ListaCliente();

    public Registro_Clientes() {
        initComponents();
        lc.Cargar();
        tbl_cliente.setModel(ocl.mostrardatos(""));

        bloquearCampos();
        bloquearBotones();
        modelo_tabla();

    }
      public void modelo_tabla() {
        
        tbl_cliente.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbl_cliente.getColumnModel().getColumn(1).setPreferredWidth(60);
        tbl_cliente.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_cliente.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbl_cliente.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbl_cliente.getColumnModel().getColumn(5).setPreferredWidth(50);
            tbl_cliente.getColumnModel().getColumn(6).setPreferredWidth(80);

        // define color de fonto y del texto del encabezado de la tabla
        tbl_cliente.getTableHeader().setBackground(new Color(100, 200, 200));
        tbl_cliente.getTableHeader().setForeground(Color.BLACK);

        
    }

    public void pinta_text() {
        Validaciones.pinta_text(txtCed);
        Validaciones.pinta_text(nom_clien);
        Validaciones.pinta_text(ape_client);
        Validaciones.pinta_text(direc_client);
        Validaciones.pinta_text(correo_client);
        Validaciones.pinta_text(telf_client);
        txtLabel.setText("");
    }

    public void bloquearBotones() {
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEli.setEnabled(false);
    }

    public boolean form_validado() {
        boolean ok = true;
        String men = "Campos requeridos o con errores: ";
        //validar requerido
        if (!Validaciones.esCedula(txtCed)) {
            ok = false;
            men += "Ruc-Ci ";
        }
        if (!Validaciones.esRequerido(nom_clien)) {
            ok = false;
            men += ", Nombre ";
        }
        if (!Validaciones.esRequerido(ape_client)) {
            ok = false;
            men += ", Apellido ";
        }
        if (!Validaciones.esRequerido(direc_client)) {
            ok = false;
            men += ", Direccion ";
        }
        if (!Validaciones.esEmail(correo_client)) {
         ok = false;
         men += ", Email ";
         }
        if (!Validaciones.esTelefono(telf_client)) {
            ok = false;
            men += ", Telefono ";
        }
        txtLabel.setText(men);
        //validar más controles
        return ok;
    }

    public void limpiar() {
        //txtCodClient.setText("");
        txtCed.setText("");
        nom_clien.setText("");
        ape_client.setText("");
        telf_client.setText("");
        direc_client.setText("");
        correo_client.setText("");
    }

    public void bloquearCampos() {
       // txtCodClient.setEnabled(false);
        txtCed.setEnabled(false);
        nom_clien.setEnabled(false);
        ape_client.setEnabled(false);
        telf_client.setEnabled(false);
        direc_client.setEnabled(false);
        correo_client.setEnabled(false);

    }

    public void desbloquearCampos() {
        //txtCodClient.setEnabled(true);
        txtCed.setEnabled(true);
        nom_clien.setEnabled(true);
        ape_client.setEnabled(true);
        telf_client.setEnabled(true);
        direc_client.setEnabled(true);
        correo_client.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCed = new javax.swing.JTextField();
        nom_clien = new javax.swing.JTextField();
        ape_client = new javax.swing.JTextField();
        txtCodClient = new javax.swing.JTextField();
        telf_client = new javax.swing.JTextField();
        direc_client = new javax.swing.JTextField();
        correo_client = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cliente = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtLabel = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro de Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cod:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Direccion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Identificacion:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        getContentPane().add(txtCed, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, -1));
        getContentPane().add(nom_clien, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));
        getContentPane().add(ape_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, -1));

        txtCodClient.setBorder(null);
        txtCodClient.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodClient.setEnabled(false);
        getContentPane().add(txtCodClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 20, -1));
        getContentPane().add(telf_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 150, 20));
        getContentPane().add(direc_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 150, 20));
        getContentPane().add(correo_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 150, 20));

        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 580, 130));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 220, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Correo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Buscar por cedula:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jToolBar1.setRollover(true);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        jButton6.setText("Refrescar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnEli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEli.setText("Eliminar");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEli);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/document_edit.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLabel.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(txtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 550, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 580, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        limpiar();
        pinta_text();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // codigo del cliente

        
        desbloquearCampos();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEli.setEnabled(false);
        limpiar();
        pinta_text();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Guardar registros del cliente

        if (form_validado() && Validaciones.validadorDeCedula(txtCed.getText())) {
            pinta_text();
             modelo_tabla() ;
            cli.setCod_clie(Integer.parseInt(txtCodClient.getText()));
            cli.setCed(txtCed.getText());
            cli.setNom(nom_clien.getText());
            cli.setApe(ape_client.getText());
            cli.setTelf(telf_client.getText());
            cli.setDireccion(direc_client.getText());
            cli.setCorreo_cedula(correo_client.getText());
            ocl.Registrar(cli);
            tbl_cliente.setModel(ocl.mostrardatos(""));
            limpiar();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        // Empleado
        int fila = tbl_cliente.getSelectedRow();
        if (fila >= 0) {
            txtCodClient.setText(tbl_cliente.getValueAt(fila, 0).toString());
            txtCed.setText(tbl_cliente.getValueAt(fila, 1).toString());
            nom_clien.setText(tbl_cliente.getValueAt(fila, 2).toString());
            ape_client.setText(tbl_cliente.getValueAt(fila, 3).toString());
            telf_client.setText(tbl_cliente.getValueAt(fila, 4).toString());
            direc_client.setText(tbl_cliente.getValueAt(fila, 5).toString());
            correo_client.setText(tbl_cliente.getValueAt(fila, 6).toString());
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(true);
            btnEli.setEnabled(true);
            desbloquearCampos();
            pinta_text();

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        if (form_validado() && Validaciones.validadorDeCedula(txtCed.getText())) {
            pinta_text();
            cli.setCod_clie(Integer.parseInt(txtCodClient.getText()));
            cli.setCed(txtCed.getText());
            cli.setNom(nom_clien.getText());
            cli.setApe(ape_client.getText());
            cli.setTelf(telf_client.getText());
            cli.setDireccion(direc_client.getText());

            cli.setCorreo_cedula(correo_client.getText());
            ocl.Modificar(cli);
             tbl_cliente.setModel(ocl.mostrardatos(""));
              modelo_tabla() ;
            limpiar();
            // pinta_text();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        // TODO add your handling code here:
        if (form_validado() && Validaciones.validadorDeCedula(txtCed.getText())) {
            pinta_text();
            
            cli.setCod_clie(Integer.parseInt(txtCodClient.getText()));
            cli.setCed(txtCed.getText());
            cli.setNom(nom_clien.getText());
            cli.setApe(ape_client.getText());
            cli.setTelf(telf_client.getText());
            cli.setDireccion(direc_client.getText());
            cli.setCorreo_cedula(correo_client.getText());
            ocl.Eliminar(cli);
            limpiar();
             tbl_cliente.setModel(ocl.mostrardatos(""));
              modelo_tabla() ;
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tbl_cliente.setModel(ocl.mostrardatos(txtBuscar.getText()));
         modelo_tabla() ;
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ape_client;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField correo_client;
    private javax.swing.JTextField direc_client;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nom_clien;
    public static javax.swing.JTable tbl_cliente;
    private javax.swing.JTextField telf_client;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCed;
    private javax.swing.JTextField txtCodClient;
    private javax.swing.JLabel txtLabel;
    // End of variables declaration//GEN-END:variables
}
