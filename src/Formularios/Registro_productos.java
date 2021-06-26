/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Controlador.operaciones_productos;
import Entidades.Producto;
import Listas.ListaProductos;
import Validaciones.Validaciones;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JASON LOZADA
 */
public class Registro_productos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Registro_productos
     */
    operaciones_productos opp = new operaciones_productos();
    Producto prod = new Producto();
    ListaProductos lp = new ListaProductos();
    double iva = 0;

    public Registro_productos() {
        initComponents();
        lp.Cargar();
        bloquear();
        tabla_prod.setModel(opp.mostrardatos(""));
        bloqCamp();
        modelo_tabla() ;
    }
      public void modelo_tabla() {
        
        tabla_prod.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabla_prod.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabla_prod.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabla_prod.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabla_prod.getColumnModel().getColumn(4).setPreferredWidth(40);
        tabla_prod.getColumnModel().getColumn(5).setPreferredWidth(40);
        // define color de fonto y del texto del encabezado de la tabla
        tabla_prod.getTableHeader().setBackground(new Color(100, 200, 200));
        tabla_prod.getTableHeader().setForeground(Color.BLACK);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tabla_prod.getColumnModel().getColumn(0).setCellRenderer(tcr);
    }

    public double Iva() {
        double iva = 0;
        if (txtIva.isSelected()) {
            iva = 0.14;
            return iva;
        } else {
            return iva;
        }
    }

    public void limpiar() {
        descr_prec.setText("");
        descr_prec.setText("");
        txt_precio.setText("");
        cant_prec.setText("");
        txtIva.setSelected(false);
        siIva.setText("");
    }

    public void bloqCamp() {
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEli.setEnabled(false);
    }

    public void bloquear() {
        descr_prec.setEnabled(false);
        descr_prec.setEnabled(false);
        txt_precio.setEnabled(false);
        cant_prec.setEnabled(false);
        txtIva.setEnabled(false);
        comCat.setEnabled(false);

    }

    public void desbloquear() {
        descr_prec.setEnabled(true);
        descr_prec.setEnabled(true);
        txt_precio.setEnabled(true);
        cant_prec.setEnabled(true);
        txtIva.setEnabled(true);
        comCat.setEnabled(true);

    }

    public void pinta_text() {
        Validaciones.pinta_text(txtCod);
        Validaciones.pinta_text(descr_prec);
        Validaciones.pinta_text(txt_precio);
        Validaciones.pinta_text(cant_prec);
        label.setText("");
    }

    public boolean form_validado() {
        boolean ok = true;
        String men = "Campos requeridos o con errores: ";
        //validar requerido

        if (!Validaciones.esRequerido(descr_prec)) {
            ok = false;
            men += ", Descripcion ";
        }
        if (!Validaciones.esFlotante(txt_precio)) {
            ok = false;
            men += ", precio ";
        }

        if (!Validaciones.esFlotante(cant_prec)) {
            ok = false;
            men += ", cantidad ";
        }

        label.setText(men);
        //validar más controles
        return ok;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_precio = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        descr_prec = new javax.swing.JTextField();
        cant_prec = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_prod = new javax.swing.JTable();
        txtBuscarP = new javax.swing.JTextField();
        comCat = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtIva = new javax.swing.JCheckBox();
        siIva = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro de Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 136, -1));

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        getContentPane().add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 40, -1));
        getContentPane().add(descr_prec, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 136, -1));
        getContentPane().add(cant_prec, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 136, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cod:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Precio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Descripcion:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        tabla_prod.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_prodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_prod);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 530, 150));

        txtBuscarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 220, -1));

        comCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Leche", "Queso", "Yogurt" }));
        comCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCatActionPerformed(evt);
            }
        });
        getContentPane().add(comCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 120, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Categoria:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Buscar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

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

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

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

        txtIva.setText("IVA");
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        siIva.setEnabled(false);
        jPanel1.add(siIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 150, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 530, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 530, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (form_validado()) {
            pinta_text();
            
            prod.setCodigo(Integer.parseInt(txtCod.getText()));
            prod.setDescripcion(descr_prec.getText());
            prod.setPrecio(txt_precio.getText());
            prod.setCosto(cant_prec.getText());
            prod.setIva(Iva() + "");//Guarda el iva 
            prod.setCategoria(comCat.getSelectedItem().toString());
            opp.Registrar(prod);
            btnGuardar.setEnabled(false);
            tabla_prod.setModel(opp.mostrardatos(""));
             modelo_tabla() ;
            lp.Cargar();
            //cantProd.setText(lp.CantidadProductos());
            limpiar();

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        if (form_validado()) {
            pinta_text();
             
            prod.setCodigo(Integer.parseInt(txtCod.getText()));
            prod.setDescripcion(descr_prec.getText());
            prod.setPrecio(txt_precio.getText());
            prod.setCosto(cant_prec.getText());
            prod.setIva(Iva() + "");//Guarda el iva 
            prod.setCategoria(comCat.getSelectedItem().toString());
            opp.Modificar(prod);
            btnGuardar.setEnabled(false);
            tabla_prod.setModel(opp.mostrardatos(""));
            modelo_tabla() ;
            // pinta_text();
            limpiar();

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        // TODO add your handling code here:
        if (form_validado()) {
            pinta_text();         
            prod.setCodigo(Integer.parseInt(txtCod.getText()));        
            opp.Eliminar(prod);
            txtCod.setText("");
            tabla_prod.setModel(opp.mostrardatos(""));
             modelo_tabla() ;
            //cantProd.setText(lp.CantidadProductos());
            limpiar();
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Codigo      
        txtCod.setText(lp.CodProducto() + 1 + "");
        desbloquear();
        limpiar();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEli.setEnabled(false);
        pinta_text();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_prodMouseClicked
        // TODO add your handling code here:

        int fila = tabla_prod.getSelectedRow();
        if (fila >= 0) {
            txtCod.setText(tabla_prod.getValueAt(fila, 0).toString());
            descr_prec.setText(tabla_prod.getValueAt(fila, 1).toString());
            txt_precio.setText(tabla_prod.getValueAt(fila, 2).toString());
            cant_prec.setText(tabla_prod.getValueAt(fila, 3).toString());
            comCat.setSelectedItem(tabla_prod.getValueAt(fila, 5).toString());
            siIva.setText(tabla_prod.getValueAt(fila, 4).toString());
            desbloquear();
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(true);
            btnEli.setEnabled(true);
            pinta_text();

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_tabla_prodMouseClicked

    private void comCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comCatActionPerformed

    private void txtBuscarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPKeyReleased

        tabla_prod.setModel(opp.mostrardatos(txtBuscarP.getText()));
        modelo_tabla();

    }//GEN-LAST:event_txtBuscarPKeyReleased

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        int temp=Integer.parseInt(txtCod.getText());
    }//GEN-LAST:event_txtCodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField cant_prec;
    private javax.swing.JComboBox comCat;
    private javax.swing.JTextField descr_prec;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField siIva;
    public static javax.swing.JTable tabla_prod;
    private javax.swing.JTextField txtBuscarP;
    private javax.swing.JTextField txtCod;
    private javax.swing.JCheckBox txtIva;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
