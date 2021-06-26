package Formularios;

import Consultas.Consulta_Productos;
import Consultas.Consulta_clientes;
import Consultas.Consultar_ventas;
import Controlador.operaciones_detalleFac;
import Controlador.operaciones_factura;
import Controlador.operaciones_productos;
import Validaciones.Validaciones;
import static app_proyecto.Menu.jDesktopPane1;
import Entidades.Factura;
import Entidades.detFactura;
import Validaciones.Recurso;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Facturar extends javax.swing.JInternalFrame {

    Factura fac = new Factura();
    operaciones_factura of = new operaciones_factura();
    operaciones_productos opp = new operaciones_productos();
    Recurso r = new Recurso();
    operaciones_detalleFac odf = new operaciones_detalleFac();
    detFactura df = new detFactura();
    DefaultTableModel campos;

    public Facturar() {
        initComponents();
        lblFecha.setText(r.fechaactual());
        bloquearBot();
        diseTabla();

    }

    public void imprimirFacturaDisponible() {
        JOptionPane.showMessageDialog(this, "Cargando factura.......Espere un momento");
        try {
            String cad = codFac.getText();
            //agregar parametros al reporte
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id_factura", cad);
            //params.put("SUBREPORT_DIR", Global.getPathReport());
            Global.generarReporte("factura_venta", params);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //Tabla titulos
    public void diseTabla() {
        String[] titulos = {"Cod", "Detalle", "Precio", "Cantidad", "Iva", "Total iva", "Total"};
        String[] Registros = new String[7];//Numero de columnas
        campos = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblFactura.getTableHeader().setBackground(new Color(100, 200, 200));
        tblFactura.getTableHeader().setForeground(Color.BLACK);
        tblFactura.setModel(campos);
        tblFactura.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblFactura.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblFactura.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblFactura.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblFactura.getColumnModel().getColumn(4).setPreferredWidth(40);
        tblFactura.getColumnModel().getColumn(5).setPreferredWidth(40);
        tblFactura.getColumnModel().getColumn(6).setPreferredWidth(40);
    }
    /*
     public static String getPathFacturas() {
     return getPath() + "Facturas\\";
     }*/

    public void descontarDatosFac() {//Descuenta la cantidad de productos
        String datoFac = " ";
        String codProd = "", cantP = "";
        for (int i = 0; i < Facturar.tblFactura.getRowCount(); i++) {//Recorre toda la tabla
            codProd = Facturar.tblFactura.getValueAt(i, 0).toString();
            cantP = Facturar.tblFactura.getValueAt(i, 3).toString();
            System.out.println("codigo:" + codProd);
            System.out.println("cantidad:" + cantP);
            opp.descontarProd(codProd, cantP);//Descuenta la cantidad

        }//Limpia la tabla
        LimpiarTabla();
    }

    public void guardarDetalle() {
        try {
            for (int i = 0; i < tblFactura.getRowCount(); i++) {
                df.setId_fac(codFac.getText());//String codio factura
                df.setCod_prod(Integer.parseInt(tblFactura.getValueAt(i, 0).toString()));
                df.setNom_Prod(tblFactura.getValueAt(i, 1).toString());
                df.setPrecio(Double.parseDouble(tblFactura.getValueAt(i, 2).toString()));
                df.setCant(Integer.parseInt(tblFactura.getValueAt(i, 3).toString()));
                df.setTotal(Double.parseDouble(tblFactura.getValueAt(i, 5).toString()));
                odf.Registrar(df);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void LimpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblFactura.getModel();
        int a = tblFactura.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void limpiar() {
        lblIva.setText("");
        lblSubtotal.setText("");
        lblTotal.setText("");
        lblSubtotal.setText("");
        lblIva.setText("");
        ced_cli.setText("");
        lblNombre.setText("");
        lblDireccion.setText("");
        lblTelefono.setText("");
        LimpiarTabla();

    }

    public void bloquearBot() {
        jButton1.setEnabled(false);
        btnBusCl.setEnabled(false);
        btnAdici.setEnabled(false);
        btnQuitar.setEnabled(false);

    }

    public void pinta_text() {
        Validaciones.pinta_text(codFac);
        Validaciones.pinta_text(lblIva);
        Validaciones.pinta_text(lblSubtotal);
        Validaciones.pinta_text(lblFecha);
        Validaciones.pinta_text(lblNombre);
        Validaciones.pinta_text(ced_cli);
        Validaciones.pinta_text(lblDireccion);
        Validaciones.pinta_text(lblTotal);
        Validaciones.pinta_text(lblTelefono);

        label.setText("");
    }

    public boolean form_validado() {
        boolean ok = true;
        String men = "Campos requeridos o con errores: ";
        //validar requerido

        if (!Validaciones.esRequerido(codFac)) {
            ok = false;
            men += ", Cod Factura ";
        }
        if (!Validaciones.esRequerido(lblIva)) {
            ok = false;
            men += ", Iva ";
        }
        if (!Validaciones.esRequerido(lblSubtotal)) {
            ok = false;
            men += ", Subtotal ";
        }
        if (!Validaciones.esRequerido(lblFecha)) {
            ok = false;
            men += ", Fecha ";
        }
        if (!Validaciones.esRequerido(lblNombre)) {
            ok = false;
            men += ", nombre ";
        }
        if (!Validaciones.esRequerido(ced_cli)) {
            ok = false;
            men += ", cedula ";
        }
        if (!Validaciones.esRequerido(lblDireccion)) {
            ok = false;
            men += ",direccion ";
        }
        if (!Validaciones.esRequerido(lblTelefono)) {
            ok = false;
            men += ", Telefono ";
        }
        if (!Validaciones.esRequerido(lblTotal)) {
            ok = false;
            men += ",Total ";
        }

        label.setText(men);
        return ok;
    }

    public void guardar() {
        if (form_validado()) {
            pinta_text();
            fac.setCod_fac(codFac.getText());
            fac.setTotal(Double.parseDouble(lblTotal.getText()));
            fac.setSubtotal(Double.parseDouble(lblSubtotal.getText()));
            fac.setIva(Double.parseDouble(lblIva.getText()));
            fac.setFecha(lblFecha.getText());
            fac.setId_cliente(ced_cli.getText());
            of.Registrar(fac);
            guardarDetalle();
            descontarDatosFac();    //Descontar datos 
            imprimirFacturaDisponible();
            limpiar();
            jButton1.setEnabled(false);
            btnBusCl.setEnabled(false);
            btnAdici.setEnabled(false);
            btnQuitar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codFac = new javax.swing.JTextField();
        btnBusCl = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        lblNombre = new javax.swing.JTextField();
        ced_cli = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JTextField();
        lblSubtotal = new javax.swing.JTextField();
        lblIva = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdici = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        lblTotal = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JTextField();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Fecha:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 18));

        jLabel12.setText("SUBTOTAL");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jLabel13.setText("I.V.A");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFactura);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 590, 150));

        jLabel14.setText("TOTAL");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cedula/RUC:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Teléfono:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 22));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel5.setText("Num_fact");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        codFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codFac.setEnabled(false);
        getContentPane().add(codFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 90, -1));

        btnBusCl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBusCl.setText("Bucar Cliente");
        btnBusCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusClActionPerformed(evt);
            }
        });
        getContentPane().add(btnBusCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PrinterSettings.png"))); // NOI18N
        jButton3.setText("Imprimir Facturas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        label.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 570, 20));

        lblNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblNombre.setEnabled(false);
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, -1));

        ced_cli.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ced_cli.setEnabled(false);
        getContentPane().add(ced_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, -1));

        lblDireccion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblDireccion.setEnabled(false);
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 140, -1));

        lblFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblFecha.setEnabled(false);
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 100, -1));

        lblSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblSubtotal.setEnabled(false);
        lblSubtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblSubtotalKeyTyped(evt);
            }
        });
        getContentPane().add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 80, -1));

        lblIva.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblIva.setEnabled(false);
        lblIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblIvaKeyTyped(evt);
            }
        });
        getContentPane().add(lblIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 60, -1));

        jButton1.setText("Realizar Ventas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, 30));

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jToolBar1.setRollover(true);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        jButton6.setText("Limpiar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 40));

        jToolBar2.setRollover(true);

        btnAdici.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnAdici.setText("Añadir");
        btnAdici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdiciActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdici);

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnQuitar);

        getContentPane().add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 220, 50));

        lblTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotal.setEnabled(false);
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 60, -1));

        lblTelefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTelefono.setEnabled(false);
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusClActionPerformed

        try {
            Consulta_clientes rc = new Consulta_clientes();
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

    }//GEN-LAST:event_btnBusClActionPerformed

    private void btnAdiciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdiciActionPerformed
        btnQuitar.setEnabled(true);
        try {
            Consulta_Productos rc = new Consulta_Productos();
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
    }//GEN-LAST:event_btnAdiciActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            Consultar_ventas rc = new Consultar_ventas();
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


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed

        try {
            DefaultTableModel modelo = (DefaultTableModel) tblFactura.getModel();
            int fila = tblFactura.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
                Consulta_Productos pro = new Consulta_Productos();
                pro.calcular();
            } else {
                JOptionPane.showMessageDialog(null, "No Selecciono ninguna fila");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        limpiar();
        pinta_text();
        //codFac.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        codFac.setText(of.codigo_Fact());
        jButton1.setEnabled(true);
        btnBusCl.setEnabled(true);
        btnAdici.setEnabled(true);
        limpiar();
        pinta_text();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!lblTotal.getText().equals("0.0")) {
            guardar();//Guarda la factura
           

        } else {
            JOptionPane.showMessageDialog(this, "Debe "
                    + "ingresar almenos un producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    private void lblSubtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSubtotalKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if (lblSubtotal.getText().length() >= 4) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_lblSubtotalKeyTyped

    private void lblIvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblIvaKeyTyped
        char car = evt.getKeyChar();
        if (lblIva.getText().length() >= 4) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_lblIvaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdici;
    private javax.swing.JButton btnBusCl;
    private javax.swing.JButton btnQuitar;
    public static javax.swing.JTextField ced_cli;
    public static javax.swing.JTextField codFac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel label;
    public static javax.swing.JTextField lblDireccion;
    public static javax.swing.JTextField lblFecha;
    public static javax.swing.JTextField lblIva;
    public static javax.swing.JTextField lblNombre;
    public static javax.swing.JTextField lblSubtotal;
    public static javax.swing.JTextField lblTelefono;
    public static javax.swing.JTextField lblTotal;
    public static javax.swing.JTable tblFactura;
    // End of variables declaration//GEN-END:variables

}
