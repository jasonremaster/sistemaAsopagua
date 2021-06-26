/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import Conexion.Conexion;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JASON LOZADA
 */
public class ListaCliente {

    DefaultTableModel campos;
    public static Cliente cab;
   // private Nodo cabecera;

    Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();

    private PreparedStatement ps = null;
    //Consulta de base de datos
    private String consulta = "SELECT id_client, ced_cliente, nom_client, ape_client, telf_client, \n"
            + "       direc_client, correo_client\n"
            + "  FROM public.cliente;";

    public ListaCliente() {
        cab = null;
    }

    public boolean estaVacia() {
        boolean vacia = false;
        if (cab == null) {
            vacia = true;
        }
        return vacia;
    }

    public ListaCliente InsertarFin(Cliente ultimo, Cliente nuevo) {
        if (estaVacia()) {
            cab = nuevo;
        } else {
            ultimo.sgte = nuevo;
            ultimo = ultimo.sgte;
        }
        return this;
    }
 public int CodCliente() {//Codigo del producto 
     
        int cont = 0;
        int aux = 0;
        for ( Cliente indice = cab; indice != null; indice = indice.sgte) {
            cont = indice.getCod_clie();
            if (aux < cont) {
                aux = cont;
            }
        }
        return aux;
    }
    public Cliente BuscarUltimo() {
        Cliente indice;
        for (indice = cab; indice != null; indice = indice.sgte) {
            if (indice.sgte == null) {
                return indice;
            }
        }
        return null;
    }

    public void Cargar() {//Se carga la lista de datos
        int con = 1;
        if (con == 1) {
            try {
                ps = cn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Cliente i = new Cliente();
                    i.setCod_clie(rs.getInt(1));
                    i.setCed(rs.getString(2));
                    i.setNom(rs.getString(3));
                    i.setApe(rs.getString(4));
                    i.setTelf(rs.getString(5));
                    i.setDireccion(rs.getString(6));
                    i.setCorreo_cedula(rs.getString(7));
                    //insertar(i);//se cargan a la lista desde la base de datos
                    InsertarFin(BuscarUltimo(), i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            con++;
        } else {
            System.out.println("Cargadoo.....");
        }
    }
//Cargar datos a una tabla
    

    public DefaultTableModel  Buscar_cli(String dato) {//Buscar Cliente
        //etiquetas de la tabla
        String[] titulos = {"Cod", "Cedula", "Nombre", "Apellido", "Telefono", "Direccion", "Correo"};
        String[] Registros = new String[7];//Numero de columnas
        campos = new DefaultTableModel(null, titulos){
         public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Cliente indice = null;
        for (indice = cab; indice != null; indice = indice.sgte) {//Recorre la lista  
            if (indice.getCed().equals(dato)) {
                Registros[0] = indice.getCod_clie() + " ";//convertido a string
                Registros[1] = indice.getCed();
                Registros[2] = indice.getNom();
                Registros[3] = indice.getApe();
                Registros[4] = indice.getTelf();
                Registros[5] = indice.getDireccion();
                Registros[6] = indice.getCorreo_cedula();
                campos.addRow(Registros);
            }
        }
        return campos;

    }

    public String CantidadClientes() {//Contar la cantidad de clientes
        Cliente indice;
        int cont = 0;
        for (indice = cab; indice != null; indice = indice.sgte) {
            cont++;
        }
        return cont + "";
    }
}
