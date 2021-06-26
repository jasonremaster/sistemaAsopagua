package Controlador;

import Conexion.Conexion;
import Conexion.Modelo;
import Entidades.Usuarios;
import static Formularios.Registrar_Usuario.tablaUsu;
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
public class operaciones_usuarios implements Modelo<Usuarios> {

    DefaultTableModel campos;
     Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();
    

    private String insertar = "INSERT INTO public.usuario(\n"
            + "            cod_usu, ced_us, nom_us, ape_usu, dire_usu, telf_usu, tipo_usuario, \n"
            + "            contra_usu)\n"
            + "    VALUES (?, ?, ?, ?, ?, ?, ?, \n"
            + "            ?)";
    private String update = "UPDATE public.usuario\n"
            + "   SET  ced_us=?, nom_us=?, ape_usu=?, dire_usu=?, telf_usu=?, \n"
            + "       tipo_usuario=?, contra_usu=?\n"
            + " WHERE cod_usu=?";
    private String delete = "DELETE FROM public.usuario\n"
            + " WHERE cod_usu=?";
    private PreparedStatement ps = null;

    @Override
    public void Registrar(Usuarios dato) {
        try {
           
            ps = cn.prepareStatement(insertar);
            ps.setInt(1, dato.getCod_usu());
            ps.setString(2, dato.getCed());
            ps.setString(3, dato.getNom());
            ps.setString(4, dato.getApe());
            ps.setString(5, dato.getDireccion());
            ps.setString(6, dato.getTelf());
            ps.setString(7, dato.getTip_usuario());
            ps.setString(8, dato.getPossward());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Usuario ya existe");
        }
    }
    @Override
    public void Modificar(Usuarios dato) {
        try {
            ps = cn.prepareStatement(update);
          
            ps.setString(1, dato.getCed());
            ps.setString(2, dato.getNom());
            ps.setString(3, dato.getApe());
            ps.setString(4, dato.getDireccion());
            ps.setString(5, dato.getTelf());
            ps.setString(6, dato.getTip_usuario());
            ps.setString(7, dato.getPossward());
              ps.setInt(8, dato.getCod_usu());

            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void Eliminar(Usuarios dato) {
        try {
            ps = cn.prepareStatement(delete);
            ps.setInt(1, dato.getCod_usu());//identificacin unica
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (SQLException ex) {
            System.out.println(ex);
        }   
    }
  
    public DefaultTableModel mostrardatos(String valor) {//Modificar
        String[] titulos = {"Cod", "Ced", "Nombre", "Apellido", "Direccion", "Telef", "Cargo","Passward"};
        String[] Registros = new String[8];//Numero de columnas
        campos = new DefaultTableModel(null, titulos);
        String mostrar = " SELECT * FROM  public.usuario WHERE CONCAT(cod_usu, ced_us, nom_us, ape_usu) LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_usu");
                Registros[1] = rs.getString("ced_us");
                Registros[2] = rs.getString("nom_us");
                Registros[3] = rs.getString("ape_usu");
                Registros[4] = rs.getString("dire_usu");
                Registros[5] = rs.getString("telf_usu");
                Registros[6] = rs.getString("tipo_usuario");
                Registros[7] = rs.getString("contra_usu");
                campos.addRow(Registros);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return campos;
    }

}
