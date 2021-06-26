/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import Conexion.Modelo;
import Entidades.Cliente;
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
public class operaciones_clientes implements Modelo<Cliente> {

    DefaultTableModel campos;

    Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();

    private String insertar = "INSERT INTO public.cliente(\n"
            + "            id_client, ced_cliente, nom_client, ape_client, telf_client, \n"
            + "            direc_client, correo_client)\n"
            + "    VALUES (?, ?, ?, ?, ?, \n"
            + "            ?, ?)";
    private String update = "UPDATE public.cliente\n"
            + "   SET ced_cliente=?, nom_client=?, ape_client=?, telf_client=?, \n"
            + "       direc_client=?, correo_client=?\n"
            + " WHERE id_client=?";
    private String delete = "DELETE FROM public.cliente\n"
            + " WHERE id_client=?";
    private PreparedStatement ps = null;

    @Override
    public void Registrar(Cliente dato) {
        try {
            ps = cn.prepareStatement(insertar);
            ps.setInt(1, dato.getCod_clie());
            ps.setString(2, dato.getCed());
            ps.setString(3, dato.getNom());
            ps.setString(4, dato.getApe());
            ps.setString(5, dato.getTelf());
            ps.setString(6, dato.getDireccion());
            ps.setString(7, dato.getCorreo_cedula());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente ya existe");
        }
    }

    @Override
    public void Modificar(Cliente dato) {
        try {
            ps = cn.prepareStatement(update);
            ps.setString(1, dato.getCed());
            ps.setString(2, dato.getNom());
            ps.setString(3, dato.getApe());
            ps.setString(4, dato.getTelf());
            ps.setString(5, dato.getDireccion());
            ps.setString(6, dato.getCorreo_cedula());
            ps.setInt(7, dato.getCod_clie());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Eliminar(Cliente dato) {
        try {
            ps = cn.prepareStatement(delete);
            ps.setInt(1, dato.getCod_clie());//identificacin unica
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "No se puede eliminar cliente");
        }
    }
  
    public DefaultTableModel mostrardatos(String valor) {
        
        String[] titulos = {"Cod", "Cedula", "Nombre", "Apellido", "Telefono", "Direccion", "Correo"};
        String[] Registros = new String[7];//Numero de columnas
        campos = new DefaultTableModel(null, titulos){
         public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String mostrar = " SELECT * FROM  public.cliente WHERE CONCAT(id_client, ced_cliente, nom_client, ape_client) LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("id_client");
                Registros[1] = rs.getString("ced_cliente");
                Registros[2] = rs.getString("nom_client");
                Registros[3] = rs.getString("ape_client");
                Registros[4] = rs.getString("telf_client");
                Registros[5] = rs.getString("direc_client");
                Registros[6] = rs.getString("correo_client");
                campos.addRow(Registros);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return campos;
    }

}
