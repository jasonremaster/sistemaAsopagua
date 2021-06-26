
package Entidades;

/**
 * 
 * @author JASON LOZADA
 */
public class Producto {

    private int  codigo;
    private String descripcion;
    private String precio;
    private String costo;
    private String iva;
    private String categoria;
    public Producto sgte;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, String precio, String costo, String iva, String categoria, Producto sgte) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.costo = costo;
        this.iva = iva;
        this.categoria = categoria;
        this.sgte = sgte;
    }

    public Producto getSgte() {
        return sgte;
    }

    public void setSgte(Producto sgte) {
        this.sgte = sgte;
    }


    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
