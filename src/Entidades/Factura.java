/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author JASON LOZADA
 */
public class Factura {
    private String cod_fac;
    private int id_prod;
    private String id_cliente;
    double total;
    double subtotal;
    double iva;
    String fecha;

    public Factura() {
    }
    

    public Factura(String cod_fac, int id_prod, String id_cliente, double total, double subtotal, double iva, String fecha) {
        this.cod_fac = cod_fac;
        this.id_prod = id_prod;
        this.id_cliente = id_cliente;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.fecha = fecha;
    }

    

    public String getCod_fac() {
        return cod_fac;
    }

    public void setCod_fac(String cod_fac) {
        this.cod_fac = cod_fac;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

   

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
