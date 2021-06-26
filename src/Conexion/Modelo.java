package Conexion;

/**
 *
 * @author JASON LOZADA
 * @param <M> 
 */
public interface Modelo<M> {//clase interface con sus respectivos metodos vacios
    public abstract void Registrar(M dato);
    public abstract void Modificar(M dato);
    public abstract void Eliminar(M dato);
     
}