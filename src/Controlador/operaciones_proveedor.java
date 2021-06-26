
package Controlador;

import Conexion.Conexion;
import Conexion.Modelo;
import Entidades.proveedores;
import static Formularios.Registrar_proveedor.tblProveedores;
import static Formularios.Registro_Clientes.tbl_cliente;
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
 * @author alm
 */
public class operaciones_proveedor implements Modelo<proveedores> {
    
     Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();

    DefaultTableModel campos;
    private String insertar = "INSERT INTO public.proveedores(\n"
            + "            id_pro, ced_pro, nom_pro, direc_pro, telf_pro, correo_pro)\n"
            + "    VALUES (?, ?, ?, ?, ?, ?)";
    private String update = "UPDATE public.proveedores\n"
            + "   SET  ced_pro=?, nom_pro=?, direc_pro=?, telf_pro=?, correo_pro=?\n"
            + " WHERE id_pro=?";
    private String delete = "DELETE FROM public.proveedores\n"
            + " WHERE id_pro=?";
    private PreparedStatement ps = null;
   

    @Override
    public void Registrar(proveedores dato) {
        try {
            ps = cn.prepareStatement(insertar);
            ps.setInt(1, dato.getCod_prove());
            ps.setString(2, dato.getCed());
            ps.setString(3, dato.getNom());
            ps.setString(4, dato.getDireccion());
            ps.setString(5, dato.getTelf());
            ps.setString(6, dato.getCorreo_cedula());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Proveedor ya existe");
        }
    }
    @Override
    public void Modificar(proveedores dato) {
          try {
            ps = cn.prepareStatement(update);           
            ps.setString(1, dato.getCed());
            ps.setString(2, dato.getNom());
            ps.setString(3, dato.getDireccion());
            ps.setString(4, dato.getTelf());
            ps.setString(5, dato.getCorreo_cedula());
            ps.setInt(6, dato.getCod_prove());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Eliminar(proveedores dato) {
        try {
            ps = cn.prepareStatement(delete);
            ps.setInt(1, dato.getCod_prove());//identificacin unica
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (SQLException ex) {
            System.out.println(ex);
        }       
    }
    public int codigo_Proveedor() {
        int c = 0;
        String SQL = "select max(id_pro) from public.proveedores";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
            }
            if (c == 0) {
                return 1;
            } else {

                return c + 1;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
    }
    //VISTAS
  /*  id_pro, ced_pro, nom_pro, direc_pro, telf_pro, correo_p*/
     public void mostrardatos_Provedores(String valor) {//Modificar
        String[] titulos = {"Cod","Cedula","Nombre","Direccion", "Telefono","Correo"};
        String[] Registros = new String[6];//Numero de columnas
        campos = new DefaultTableModel(null, titulos);
        String mostrar = " SELECT * FROM  public.proveedores WHERE CONCAT(id_pro, ced_pro, nom_pro) LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("id_pro");
                Registros[1] = rs.getString("ced_pro");
                Registros[2] = rs.getString("nom_pro");
                Registros[3] = rs.getString("direc_pro");
                Registros[4] = rs.getString("telf_pro");
                Registros[5] = rs.getString("correo_pro");              
                campos.addRow(Registros);
            }
            tblProveedores.setModel(campos);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
