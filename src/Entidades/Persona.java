
package Entidades;

/**
 *
 * @author JASON LOZADA
 */
public class Persona {
    String ced;
    String nom;
    String ape;
    String direccion;
    String telf;
    String Ciudad;
    String Correo_cedula;

    public Persona() {
    }

    public Persona(String ced, String nom, String ape, String direccion, String telf, String Ciudad, String Correo_cedula) {
        this.ced = ced;
        this.nom = nom;
        this.ape = ape;
        this.direccion = direccion;
        this.telf = telf;
        this.Ciudad = Ciudad;
        this.Correo_cedula = Correo_cedula;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCorreo_cedula() {
        return Correo_cedula;
    }

    public void setCorreo_cedula(String Correo_cedula) {
        this.Correo_cedula = Correo_cedula;
    }
    
      
}
