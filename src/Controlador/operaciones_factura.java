/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import Conexion.Modelo;
import Entidades.Factura;
import Validaciones.Recurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JASON LOZADA
 */
public class operaciones_factura implements Modelo<Factura> {
    Recurso re =new Recurso();
    DefaultTableModel campos;
     Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();
   
    private String insertar = "INSERT INTO public.factura(\n" +
"            id_factura, total_fac, subtotal_fac, iva, fecha, ced_cliente)\n" +
"    VALUES (?, ?, ?, ?, ?, ?)";
    private String update = "";
    private String delete = "";
    private PreparedStatement ps = null;
    

    @Override
    public void Registrar(Factura dato) {
        try {
         
            ps = cn.prepareStatement(insertar);
            ps.setString(1, dato.getCod_fac());
            ps.setDouble(2, dato.getTotal());
            ps.setDouble(3, dato.getSubtotal());
            ps.setDouble(4, dato.getIva());
            ps.setString(5, dato.getFecha());
            ps.setString(6, dato.getId_cliente());
            ps.executeUpdate();
            System.out.println("Registrado");
            JOptionPane.showMessageDialog(null, "Venta Realizada");

        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Modificar(Factura dato) {
        try {
        
            ps = cn.prepareStatement(update);

            ps.setInt(1, dato.getId_prod());
            ps.setDouble(2, dato.getTotal());
            ps.setDouble(3, dato.getSubtotal());
            ps.setDouble(4, dato.getIva());
            ps.setString(5, dato.getFecha());
            ps.setString(6, dato.getId_cliente());
            ps.setString(7, dato.getCod_fac());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Eliminar(Factura dato) {
        try {
           
            ps = cn.prepareStatement(delete);
            ps.setString(1, dato.getCod_fac());//identificacin unica
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
       public String codigo_Fact() {
        int j;
        String codPrimero = "F0001";
        String cod = "";
        String c = "";
        String SQL = "select max(id_factura) from public.factura";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                return codPrimero;
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                String r = "";
                r = "" + r1 + r2 + r3;
                j = Integer.parseInt(r);
                re.generar(j);
                cod = "F" + re.serie();
                return cod;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
       public DefaultTableModel mostrardatosFacturas(String valor) {
        
        String[] titulos = {"Cod", "ced_cliente", "fecha", "subtotal", "iva", "total"};
        String[] Registros = new String[6];//Numero de columnas
        campos = new DefaultTableModel(null, titulos){
         public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String mostrar = " SELECT * FROM  public.factura WHERE CONCAT(id_factura, fecha, ced_cliente) LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("id_factura");
                Registros[1] = rs.getString("ced_cliente");
                Registros[2] = rs.getString("fecha");
                Registros[3] = rs.getString("subtotal_fac");
                Registros[4] = rs.getString("iva");
                Registros[5] = rs.getString("total_fac");
                campos.addRow(Registros);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return campos;
    }

}
