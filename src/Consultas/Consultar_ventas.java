/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Controlador.operaciones_factura;
import Formularios.Global;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author JASON LOZADA
 */
public class Consultar_ventas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consultar_ventas
     */
    operaciones_factura of = new operaciones_factura();

    public Consultar_ventas() {
        initComponents();
        tabla_ventas.setModel(of.mostrardatosFacturas(""));
        modelo_tabla();

    }

    public void modelo_tabla() {

        tabla_ventas.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabla_ventas.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla_ventas.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla_ventas.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabla_ventas.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabla_ventas.getColumnModel().getColumn(5).setPreferredWidth(50);

        // define color de fonto y del texto del encabezado de la tabla
        tabla_ventas.getTableHeader().setBackground(new Color(100, 200, 200));
        tabla_ventas.getTableHeader().setForeground(Color.BLACK);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarFac = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        ced_client = new javax.swing.JTextField();
        cod_fac = new javax.swing.JTextField();
        fecha_fac = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("IMPRIMIR FACTURAS");

        tabla_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_ventasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_ventas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por codigo , fecha y cedula:");

        txtBuscarFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarFacKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprmir Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        ced_client.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        ced_client.setEnabled(false);

        cod_fac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cod_fac.setEnabled(false);

        fecha_fac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fecha_fac.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PrinterSettings.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Cedula/Cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ced_client, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cod_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod_fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ced_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Mostrar todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarFac, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarFacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarFacKeyReleased
        tabla_ventas.setModel(of.mostrardatosFacturas(txtBuscarFac.getText()));
        modelo_tabla();


    }//GEN-LAST:event_txtBuscarFacKeyReleased

    private void tabla_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ventasMouseClicked
        int fila = tabla_ventas.getSelectedRow();
        if (fila >= 0) {
            cod_fac.setText(tabla_ventas.getValueAt(fila, 0).toString());
            ced_client.setText(tabla_ventas.getValueAt(fila, 1).toString());
            fecha_fac.setText(tabla_ventas.getValueAt(fila, 2).toString());

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_tabla_ventasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tabla_ventas.setModel(of.mostrardatosFacturas(""));
        modelo_tabla();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
            String cad=cod_fac.getText();
            //agregar parametros al reporte
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id_factura", cad);
            //params.put("SUBREPORT_DIR", Global.getPathReport());
            Global.generarReporte("factura_venta",params);
        } catch (Exception ex) {
        System.out.println(ex);}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ced_client;
    private javax.swing.JTextField cod_fac;
    private javax.swing.JTextField fecha_fac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_ventas;
    private javax.swing.JTextField txtBuscarFac;
    // End of variables declaration//GEN-END:variables
}
