/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


public class detFactura {
    private String id_fac;
    private int cod_prod;
    private String nom_Prod;
    private int cant;
    private double precio;
    private double total;

    public detFactura() {
    }

    public detFactura(String id_fac, int cod_prod, String nom_Prod, int cant, double precio, double total) {
        this.id_fac = id_fac;
        this.cod_prod = cod_prod;
        this.nom_Prod = nom_Prod;
        this.cant = cant;
        this.precio = precio;
        this.total = total;
    }

   

    public String getId_fac() {
        return id_fac;
    }

    public void setId_fac(String id_fac) {
        this.id_fac = id_fac;
    }

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

  


    public String getNom_Prod() {
        return nom_Prod;
    }

    public void setNom_Prod(String nom_Prod) {
        this.nom_Prod = nom_Prod;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
