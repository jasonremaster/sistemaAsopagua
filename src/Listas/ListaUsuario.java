
package Listas;

import Conexion.Conexion;
import Entidades.Usuarios;
import static Formularios.Registrar_Usuario.tablaUsu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JASON LOZADA
 */
public class ListaUsuario {
    DefaultTableModel campos;
    public static Usuarios cab;
     Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();
    

    //Nodo<Cliente> cab;
    private PreparedStatement ps = null;
    //Consulta de base de datos
    private String consulta = "SELECT cod_usu, ced_us, nom_us, ape_usu, dire_usu, telf_usu, tipo_usuario, \n" +
"       contra_usu\n" +
"  FROM public.usuario";

    public ListaUsuario() {
        cab = null;
    }

    public boolean estaVacia() {
        boolean vacia = false;
        if (cab == null) {
            vacia = true;
        }
        return vacia;
    }

    public ListaUsuario InsertarFin(Usuarios ultimo, Usuarios nuevo) {
        if (estaVacia()) {
            cab = nuevo;
        } else {
            ultimo.sgte = nuevo;
            ultimo = ultimo.sgte;
        }
        return this;
    }

    public Usuarios BuscarUltimo() {
        Usuarios indice;
        for (indice = cab; indice != null; indice = indice.sgte) {
            if (indice.sgte == null) {
                return indice;
            }
        }
        return null;
    }
     public int CodUsuario() {//Codigo del producto 

        int cont = 0;
        int aux = 0;
        for (Usuarios indice = cab; indice != null; indice = indice.sgte) {
            cont = indice.getCod_usu();
            if (aux < cont) {
                aux = cont;
            }
        }
        return aux;
    }

    public void Cargar() {//Se carga la lista de datos
        int con = 1;
        if (con == 1) {
            try {
                bd.ConectarBDPostgres();
                ps = cn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Usuarios i = new Usuarios();
                    i.setCod_usu(rs.getInt(1));
                    i.setCed(rs.getString(2));
                    i.setNom(rs.getString(3));
                    i.setApe(rs.getString(4));
                    i.setDireccion(rs.getString(5));
                    i.setTelf(rs.getString(6));
                    i.setTip_usuario(rs.getString(7));
                    i.setPossward(rs.getString(8));
                    
                    //insertar(i);//se cargan a la lista desde la base de datos
                    InsertarFin(BuscarUltimo(), i);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
                //Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            con++;
        } else {
            System.out.println("Cargadoo.....");
        }
    }

    public String CantidadClientes() {//Contar la cantidad de clientes
        Usuarios indice;
        int cont = 0;
        for (indice = cab; indice != null; indice = indice.sgte) {
            cont++;
        }
        return cont + "";
    }
    
}
