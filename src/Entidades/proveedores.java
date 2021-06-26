
package Entidades;

/**
 * 
 * @author JASON LOZADA
 */
public class proveedores extends Persona {
    private int cod_prove;
    

    public proveedores() {
    }

    public proveedores(int cod_prove, String ced, String nom, String ape, String direccion, String telf, String Ciudad, String Correo_cedula) {
        super(ced, nom, ape, direccion, telf, Ciudad, Correo_cedula);
        this.cod_prove = cod_prove;
    }

    public int getCod_prove() {
        return cod_prove;
    }

    public void setCod_prove(int cod_prove) {
        this.cod_prove = cod_prove;
    }

    
    
}
