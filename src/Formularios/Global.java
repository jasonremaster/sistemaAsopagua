
package Formularios;

import Conexion.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author JASON LOZADA
 */
public class Global {
   
    //obtiene ruta de la carpeta de reportes
    public static String getPathReport(){
        return getPath()+"Reportes\\";
    }
    //obtiene ruta de la carpeta de vistas
    public static String getPathVistas(){
       // return getPath()+"proyinventario\\vistas";
        return getPath()+"Formularios\\";
    }
    //obtiene ruta de la carpeta de vistas
    public static String getPathImagenes(){
        return getPath()+"imagenes\\";
    }
    
    //obtiene ruta del código fuente del Proyecto
    public static String getPath(){
        //extraer ruta del proyecto
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path=path.substring(0,path.length()-2);
        return path+="\\src\\";
    }  
    
    //genera reportes sin parámetros
    public static void generarReporte(String reporte) throws JRException, FileNotFoundException
    {
        Map<String, Object> params = new HashMap<String, Object>();
        generarReporte(reporte,params);
    }  
    
    //carga reporte simple
    public static void generarReporte(String reporte,Map<String, Object> params) throws JRException, FileNotFoundException {     
        //conexión base de datos
        Connection con = new Conexion().ConectarBDPostgres();
      
        String path = Global.getPathReport()+reporte; 
        String pathlogo = Global.getPathImagenes()+"logoNV.png"; 
        //reporte fuente
        String reportSource = path+".jrxml";
        //archivo pdf destino
        String reportDest  = path+".pdf";     
     /*   System.out.println(reportSource);
        System.out.println(reportDest);
        System.out.println(pathlogo);*/
        
        //Map<String, Object> params = new HashMap<String, Object>();
        params.put("Titulo",new String("Empresa ABC"));
        params.put("Logo",new String(pathlogo));
        
        try
        {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con); //aqui           
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportDest);            
            JasperViewer.viewReport(jasperPrint, false);
        }
        catch (JRException ex)
        {
            ex.printStackTrace();
        }
    }
}
