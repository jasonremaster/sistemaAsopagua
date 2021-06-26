/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Controlador.operaciones_clientes;
import static Formularios.Facturar.ced_cli;
import static Formularios.Facturar.lblDireccion;
import static Formularios.Facturar.lblNombre;
import static Formularios.Facturar.lblTelefono;
import Formularios.Registro_Clientes;
import Listas.ListaCliente;
import static app_proyecto.Menu.jDesktopPane1;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author alm
 */
public class Consulta_clientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consulta_clientes
     */
    ListaCliente lc = new ListaCliente();
    operaciones_clientes oc = new operaciones_clientes();

    public Consulta_clientes() {
        initComponents();
        lc.Cargar();
       
        tbl_clientes.setModel(oc.mostrardatos(""));
        cantidad.setText(lc.CantidadClientes());
        modelo_tabla();
         
    }

    //Diseño de la tabla

    public void modelo_tabla() {
        
        tbl_clientes.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbl_clientes.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl_clientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_clientes.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbl_clientes.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbl_clientes.getColumnModel().getColumn(5).setPreferredWidth(50);
        tbl_clientes.getColumnModel().getColumn(6).setPreferredWidth(90);

        // define color de fonto y del texto del encabezado de la tabla
        tbl_clientes.getTableHeader().setBackground(new Color(100, 200, 200));
        tbl_clientes.getTableHeader().setForeground(Color.BLACK);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tbl_clientes.getColumnModel().getColumn(0).setCellRenderer(tcr);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_clientes = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbMensaje1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setTitle("CONSULTAR CLIENTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_clientes.setToolTipText("");
        tbl_clientes.setDoubleBuffered(true);
        tbl_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientesMouseClicked(evt);
            }
        });
        tbl_clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_clientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 576, 220));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 180, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad de clientes Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Buscar Por Cedula:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        cantidad.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cantidad.setEnabled(false);
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 70, -1));

        jButton1.setText("Mostrar Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 110, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lbMensaje1.setText("Hacer doble clic en una fila de la tabla para seleccionar un cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMensaje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMensaje1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 610, -1));

        jButton3.setText("Registrar Cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientesMouseClicked
        // elegir datos
        if (evt.getClickCount() == 2) {

            String cod = "", ced = "", nom = "", ape = "", dir = "", telf = "";
       
            try {
          //  if (fila == -1) {
                //      JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato", "ERROR", JOptionPane.ERROR_MESSAGE);
                // } else {
                ced_cli.setText(tbl_clientes.getValueAt(tbl_clientes.getSelectedRow(), 1).toString());

                nom = tbl_clientes.getValueAt(tbl_clientes.getSelectedRow(), 2).toString();
                ape = tbl_clientes.getValueAt(tbl_clientes.getSelectedRow(), 3).toString();

                String nomCompleto = nom + "  " + ape;
                lblNombre.setText(nomCompleto);

                lblTelefono.setText(tbl_clientes.getValueAt(tbl_clientes.getSelectedRow(), 4).toString());
                lblDireccion.setText(tbl_clientes.getValueAt(tbl_clientes.getSelectedRow(), 5).toString());
                this.dispose();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_tbl_clientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        tbl_clientes.setModel(oc.mostrardatos(""));
        modelo_tabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        tbl_clientes.setModel(lc.Buscar_cli(txtBuscar.getText()));
        modelo_tabla();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_clientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clientesKeyReleased
        int row = tbl_clientes.getSelectedRow();
    }//GEN-LAST:event_tbl_clientesKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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

        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMensaje1;
    public static javax.swing.JTable tbl_clientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
