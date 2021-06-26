package Consultas;

import Controlador.operaciones_productos;
import Formularios.Facturar;
import Formularios.Registro_productos;
import Listas.ListaProductos;
import Validaciones.Recurso;
import static app_proyecto.Menu.jDesktopPane1;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Consulta_Productos extends javax.swing.JInternalFrame {

    operaciones_productos op = new operaciones_productos();
    ListaProductos lp = new ListaProductos();
    Recurso re = new Recurso();
    

    String cod = "", nomP = "", precio = "", cant = "", iva;

    public Consulta_Productos() {
        initComponents();
        lp.Cargar();
        tbl_prod.setModel(op.mostrardatos(""));
        txtcantProd.setText(lp.CantidadProductos());
        modelo_tabla();
    }

    public void modelo_tabla() {

        tbl_prod.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbl_prod.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_prod.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl_prod.getColumnModel().getColumn(3).setPreferredWidth(40);
        tbl_prod.getColumnModel().getColumn(4).setPreferredWidth(40);
        tbl_prod.getColumnModel().getColumn(5).setPreferredWidth(40);

        // define color de fonto y del texto del encabezado de la tabla
        tbl_prod.getTableHeader().setBackground(new Color(100, 200, 200));
        tbl_prod.getTableHeader().setForeground(Color.BLACK);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tbl_prod.getColumnModel().getColumn(0).setCellRenderer(tcr);
    }

    public void calcular() {
        double totalIva=0;
        double subtotal = 0, iva = 0;
        double precio;
        int cantidad;
        double imp = 0;
        for (int i = 0; i < Facturar.tblFactura.getRowCount(); i++) {
            precio = Double.parseDouble(Facturar.tblFactura.getValueAt(i, 2).toString());
            cantidad = Integer.parseInt(Facturar.tblFactura.getValueAt(i, 3).toString());
            iva = Double.parseDouble(Facturar.tblFactura.getValueAt(i, 4).toString());
            imp = precio * cantidad;
            totalIva = totalIva + (iva * imp);
            subtotal = subtotal + imp;//Acumula el subtotal  
            Facturar.tblFactura.setValueAt(Math.rint((iva * imp) * 100) / 100, i, 5);//total iva
            Facturar.tblFactura.setValueAt(Math.rint(imp * 100) / 100, i, 6);//muestra el total
        }
        Facturar.lblSubtotal.setText(subtotal + "");
        Facturar.lblIva.setText("" + Math.rint((totalIva) * 100) / 100);//iva
        Facturar.lblTotal.setText("" + Math.rint((subtotal + totalIva) * 100) / 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        buscarProd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcantProd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbMensaje1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setTitle(" CONSULTAR PRODUCTOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        tbl_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_prodKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 570, 209));
        getContentPane().add(buscarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad de Productos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar por codiogo o nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 20));

        txtcantProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcantProd.setEnabled(false);
        getContentPane().add(txtcantProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 90, -1));

        jButton1.setText("Mostrar Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 100, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lbMensaje1.setText("Hacer doble clic en una fila de la tabla para seleccionar un producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMensaje1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMensaje1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 590, -1));

        jButton3.setText("Registrar Producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        //Elegir producto        
        if (evt.getClickCount() == 2) {
            try {
                DefaultTableModel tabladet = (DefaultTableModel) Facturar.tblFactura.getModel();//tabla qeu se llena
                String[] dato = new String[6];
                int fila = tbl_prod.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    cod = (String) tbl_prod.getValueAt(fila, 0);
                    nomP = (String) tbl_prod.getValueAt(fila, 1);
                    precio = (String) tbl_prod.getValueAt(fila, 2);
                    cant = (String) tbl_prod.getValueAt(fila, 3);
                    iva = (String) tbl_prod.getValueAt(fila, 4);
                    System.out.println(iva);
                    int c = 0;
                    boolean volver = false;
                    do {
                        String can = JOptionPane.showInputDialog("Ingrese la Cantidad ");
                        try {
                            if ((can.equals("")) || (can.equals("0"))) {
                                JOptionPane.showMessageDialog(this, "Debe ingresar un valor mayor que 0", "ERROR", JOptionPane.ERROR_MESSAGE);
                                volver = true;
                            } else {
                                int canti = Integer.parseInt(can);//cantidad ingresada
                                int cantidad = Integer.parseInt(cant);  //cantidad de productos          
                                if (canti > cantidad) {
                                    JOptionPane.showMessageDialog(this, " no disponible");
                                    volver = true;
                                } else {
                                    if (c == 0) {
                                        dato[0] = cod;
                                        dato[1] = nomP;
                                        dato[2] = precio;
                                        dato[3] = can;
                                        dato[4] = iva;
                                        tabladet.addRow(dato);
                                        Facturar.tblFactura.setModel(tabladet);
                                        //metodo del iva
                                        calcular();
                                    }
                                    volver = false;
                                }
                            }
                        } catch (HeadlessException | NumberFormatException e) {
                            System.out.println(e);
                        }
                    } while (volver == true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tbl_prodMouseClicked


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tbl_prod.setModel(op.mostrardatos(""));//carga con las litas enlazadas
        modelo_tabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        tbl_prod.setModel(lp.Buscar_prod(buscarProd.getText()));
        modelo_tabla();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_prodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_prodKeyReleased
        int row = tbl_prod.getSelectedRow();
    }//GEN-LAST:event_tbl_prodKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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


    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMensaje1;
    public static javax.swing.JTable tbl_prod;
    private javax.swing.JTextField txtcantProd;
    // End of variables declaration//GEN-END:variables
}
