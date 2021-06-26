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
public class Cliente extends Persona {
    private int cod_clie;
    public Cliente sgte;
   

    public Cliente() {
        
    }

    public Cliente(int cod_clie, Cliente sgte, String ced, String nom, String ape, String direccion, String telf, String Ciudad, String Correo_cedula) {
        super(ced, nom, ape, direccion, telf, Ciudad, Correo_cedula);
        this.cod_clie = cod_clie;
        this.sgte = sgte;
    }

    public Cliente getSgte() {
        return sgte;
    }

    public void setSgte(Cliente sgte) {
        this.sgte = sgte;
    }

    

    public int getCod_clie() {
        return cod_clie;
    }

    public void setCod_clie(int cod_clie) {
        this.cod_clie = cod_clie;
    }
    public void imprime(){
        
    
    
    
    
    }
    
    
}
