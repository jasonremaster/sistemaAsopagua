
package Entidades;

/**
 * 
 * @author JASON LOZADA
 */
public class Usuarios extends Persona{//hereda de la clase persona
    private int cod_usu;
    private String possward;
    private String tip_usuario;
    public Usuarios sgte;

    public Usuarios() {
    }

    public Usuarios(int cod_usu, String possward, String tip_usuario, Usuarios sgte, String ced, String nom, String ape, String direccion, String telf, String Ciudad, String Correo_cedula) {
        super(ced, nom, ape, direccion, telf, Ciudad, Correo_cedula);
        this.cod_usu = cod_usu;
        this.possward = possward;
        this.tip_usuario = tip_usuario;
        this.sgte = sgte;
    }

    public Usuarios getSgte() {
        return sgte;
    }

    public void setSgte(Usuarios sgte) {
        this.sgte = sgte;
    }

   

    public int getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(int cod_usu) {
        this.cod_usu = cod_usu;
    }

    public String getPossward() {
        return possward;
    }

    public void setPossward(String possward) {
        this.possward = possward;
    }

    public String getTip_usuario() {
        return tip_usuario;
    }

    public void setTip_usuario(String tip_usuario) {
        this.tip_usuario = tip_usuario;
    }
    
    
    
}
