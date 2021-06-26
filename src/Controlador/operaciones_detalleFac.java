
package Controlador;

import Conexion.Conexion;
import Conexion.Modelo;
import Entidades.detFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JASON LOZADA
 */
public class operaciones_detalleFac implements Modelo<detFactura>{
     private String insertar ="INSERT INTO public.detalle_factura( id_factura, cod_prod, nom_prod, "
             + "cantidad, precio, total) VALUES (?, ?, ?, ?, ?, ?)";
     
     private PreparedStatement ps = null;
     Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();

   

    @Override
    public void Registrar(detFactura dato) {
        try {
            ps = cn.prepareStatement(insertar);
            ps.setString(1, dato.getId_fac());
            ps.setInt(2, dato.getCod_prod());
            ps.setString(3, dato.getNom_Prod());
            ps.setInt(4, dato.getCant());
            ps.setDouble(5, dato.getPrecio());
            ps.setDouble(6, dato.getTotal());
            ps.executeUpdate();
            System.out.println("Detalle guardado");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    }

    @Override
    public void Eliminar(detFactura dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(detFactura dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
