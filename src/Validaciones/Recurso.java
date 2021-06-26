
package Validaciones;


import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Wilson Belduma
 */
public class Recurso {

    public String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
    private int dato;
    private int cont = 1;
    private String num = "";

    public void generar(int dato) {
        this.dato = dato;

        if ((this.dato >= 1000) || (this.dato < 10000)) {
            int can = cont + this.dato;
            num = "" + can;
        }
        if ((this.dato >= 100) || (this.dato < 1000)) {
            int can = cont + this.dato;
            num = "0" + can;
        }
        if ((this.dato >= 9) || (this.dato < 100)) {
            int can = cont + this.dato;
            num = "00" + can;
        }
        if (this.dato < 9) {
            int can = cont + this.dato;
            num = "000" + can;
        }

    }

    public String serie() {
        return this.num;
    }

    public void aumentarcantidad(String codi, String can) {
        int descontar = Integer.parseInt(can);
        String cap = " ";
        int desfinal;
        String consul = "SELECT * FROM producto WHERE  codigo='" + codi + "'";//los codigo no se aparecen
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(7);//obtiene la cantidad de la base de datos
            }
        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) + descontar;
        String modi = "UPDATE producto SET cantidad='" + desfinal + "' WHERE codigo = '" + codi + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void descontarAlquiler(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM peliculasalquiladas WHERE  CodPel='" + codi + "'";//falta
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(6);
            }
        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE peliculasalquiladas SET Cantidad='" + desfinal + "' WHERE CodPel = '" + codi + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void descontarcantidad(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM producto WHERE  codigo='" + codi + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(7);
            }
        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE producto SET cantidad='" + desfinal + "' WHERE codigo = '" + codi + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    }
     Conexion bd = new Conexion();
    Connection cn = bd.ConectarBDPostgres();
    
}
