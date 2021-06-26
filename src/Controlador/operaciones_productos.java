package Controlador;

import Conexion.Conexion;
import Conexion.Modelo;
import Entidades.Producto;
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
public class operaciones_productos implements Modelo<Producto> {

    private String insertar = "INSERT INTO public.productos(\n"
            + "            cod_prod, desc_prod, precio_prod, cant_prod, iva, categoria)\n"
            + "    VALUES (?, ?, ?, ?, ?, ?)";
    private String update = "UPDATE public.productos\n"
            + "   SET  desc_prod=?, precio_prod=?, cant_prod=?, iva=?, categoria=?\n"
            + " WHERE cod_prod=?";
    private String delete = "DELETE FROM public.productos\n"
            + " WHERE cod_prod=?";

    private PreparedStatement ps = null;
    Conexion bd = new Conexion();
    DefaultTableModel campos;

    Connection cn = bd.ConectarBDPostgres();

    @Override
    public void Registrar(Producto dato) {
        try {
            bd.ConectarBDPostgres();
            ps = cn.prepareStatement(insertar);

            ps.setInt(1, dato.getCodigo());
            ps.setString(2, dato.getDescripcion());
            ps.setString(3, dato.getPrecio());
            ps.setString(4, dato.getCosto());
            ps.setString(5, dato.getIva());
            ps.setString(6, dato.getCategoria());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");

        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Modificar(Producto dato) {
        try {
            ps = cn.prepareStatement(update);

            ps.setString(1, dato.getDescripcion());
            ps.setString(2, dato.getPrecio());
            ps.setString(3, dato.getCosto());
            ps.setString(4, dato.getIva());
            ps.setString(5, dato.getCategoria());
            ps.setInt(6, dato.getCodigo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException ex) {
            Logger.getLogger(operaciones_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Eliminar(Producto dato) {
        try {
            ps = cn.prepareStatement(delete);
            ps.setInt(1, dato.getCodigo());//identificacin unica
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public DefaultTableModel mostrardatos(String valor) {
        String[] titulos = {"Cod", "Nombre", "Precio", "Cantidad", "Iva", "Categoria"};
        String[] Registros = new String[6];//Numero de columnas
        campos = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String mostrar = " SELECT * FROM  public.productos WHERE CONCAT(cod_prod, desc_prod) LIKE '%" + valor + "%'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("cod_prod");
                Registros[1] = rs.getString("desc_prod");
                Registros[2] = rs.getString("precio_prod");
                Registros[3] = rs.getString("cant_prod");
                Registros[4] = rs.getString("iva");
                Registros[5] = rs.getString("categoria");
                campos.addRow(Registros);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return campos;
    }

    public void descontarProd(String cod, String cant) {//Descontar cantidades
        System.out.println("Estubo aqui");
        int desct = Integer.parseInt(cant);//cantidad se convierte en entero
        String canProd = "";
        int desfinal;
        String consul = "SELECT * FROM productos WHERE  cod_prod ='" + cod + "'";//llamo la base de datos 
        try {//la cual aparecen los datos segun el codigo
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                canProd = rs.getString("cant_prod");//cantidad de productos
            }
            System.out.println("Este es el codigo:" + canProd);
        } catch (Exception e) {
            System.out.println(e);
        }
        desfinal = Integer.parseInt(canProd) - desct;
        String modif = "UPDATE productos SET cant_prod='" + desfinal + "' WHERE cod_prod = '" + cod + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modif);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
