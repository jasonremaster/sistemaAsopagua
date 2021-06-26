package Listas;

import Conexion.Conexion;
import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ListaProductos {

    Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();

    DefaultTableModel campos;

    Producto cab;
    private PreparedStatement ps = null;
    private String consulta = "SELECT cod_prod, desc_prod, precio_prod, cant_prod, iva, categoria\n"
            + "  FROM public.productos";

    public ListaProductos() {
        cab = null;
    }

    public boolean estaVacia() {
        boolean vacia = false;
        if (cab == null) {
            vacia = true;
        }
        return vacia;
    }

    public ListaProductos InsertarFin(Producto ultimo, Producto nuevo) {
        if (estaVacia()) {
            cab = nuevo;
        } else {
            ultimo.sgte = nuevo;
            ultimo = ultimo.sgte;
        }
        return this;
    }

    public Producto BuscarUltimo() {
        Producto indice;
        for (indice = cab; indice != null; indice = indice.sgte) {
            if (indice.sgte == null) {
                return indice;
            }
        }
        return null;
    }

    public int CodProducto() {//Codigo del producto 

        int cont = 0;
        int aux = 0;
        for (Producto indice = cab; indice != null; indice = indice.sgte) {
            cont = indice.getCodigo();
            if (aux < cont) {
                aux = cont;
            }
        }
        return aux;
    }

    public void Cargar() {
        int con = 1;
        if (con == 1) {
            try {
                bd.ConectarBDPostgres();
                ps = cn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Producto i = new Producto();
                    i.setCodigo(rs.getInt(1));
                    i.setDescripcion(rs.getString(2));
                    i.setPrecio(rs.getString(3));
                    i.setCosto(rs.getString(4));
                    i.setIva(rs.getString(5));
                    i.setCategoria(rs.getString(6));

                    InsertarFin(BuscarUltimo(), i);//se cargan a la lista desde la base de datos
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            con++;
        } else {
            System.out.println("Cargadoo.....");
        }
    }
//Cargar a la tabla 

    public DefaultTableModel Buscar_prod(String dato) {
        //etiquetas de la tabla
        String[] titulos = {"Cod", "Nombre", "Precio", "Cantidad", "Iva", "Categoria"};
        String[] Registros = new String[6];//Numero de columnas
        campos = new DefaultTableModel(null, titulos){
         public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Producto indice;

        for (indice = cab; indice != null; indice = indice.sgte) {//Recorre la lista  
            if ((dato.equals(indice.getCodigo() + "")) || (dato.equals(indice.getDescripcion())))//Se busca por codigo
            {
                Registros[0] = indice.getCodigo() + " ";//convertido a string
                Registros[1] = indice.getDescripcion();
                Registros[2] = indice.getPrecio();
                Registros[3] = indice.getCosto();
                Registros[4] = indice.getIva();
                Registros[5] = indice.getCategoria();
                campos.addRow(Registros);
            }
        }
        return campos;
    }
    public String CantidadProductos() {//Contar la cantidad de clientes
        Producto indice;
        int cont = 0;
        for (indice = cab; indice != null; indice = indice.sgte) {
            cont++;
        }
        return cont + "";
    }

}
