package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JASON LOZADA
 */
public class Conexion {

    public static Connection conn = null;
    
    static String dbms = "postgres";
    static String server = "localhost";
    static String bd = "Asopagua";//
    static String user = "postgres";
    static String pass = "1234";
    static String puerto = "5432";
    static String driver = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://" + server + ":" + puerto + "/" + bd;

    public static Connection ConectarBDPostgres() {
        try {
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e.getMessage());
        }
         return conn;
    }

   
}
