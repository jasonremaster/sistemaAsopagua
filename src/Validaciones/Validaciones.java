package Validaciones;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Belduma
 */
public class Validaciones {

    //pinta color normal de fondo y borde     

    public static void pinta_text(JTextField txt) {
        txt.setBorder(BorderFactory.createLineBorder(Color.gray));
        txt.setBackground(Color.white);
    }

    public static void pinta_Area(JTextArea txt) {
        txt.setBorder(BorderFactory.createLineBorder(Color.gray));
        txt.setBackground(Color.white);
    }
    /* public static void pinta_Date(JDateChooser txt)
     {
     txt.setBorder(BorderFactory.createLineBorder(Color.gray));
     txt.setBackground(Color.white);
     }*/

    //verifica si es requerido
     public static boolean esRequerido(JLabel txt) {
        boolean ok = true;
        if (txt.getText().trim().equals("")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }
    public static boolean esRequerido(JTextField txt) {
        boolean ok = true;
        if (txt.getText().trim().equals("")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }

    public static boolean esRequerid(JTextArea txt) {
        boolean ok = true;
        if (txt.getText().trim().equals("")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }

    //verifica flotantes    
    public static boolean esFlotante(JTextField txt) {
        boolean ok = true;
        if (!txt.getText().trim().matches("[0-9]{1,10}[.]{0,1}[0-9]{0,}")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;

        /*
         try{
         Double d=Double.parseDouble(txt.getText());
         return true;
         }catch(Exception ex){
         txt.setBorder(BorderFactory.createLineBorder(Color.red));
         txt.setBackground(Color.pink);
         }
         return false; 
         */
    }

    //verifica si es email
    public static boolean esEmail(JTextField txt) {
        boolean ok = true;
        //if (!txt.getText().trim().matches("[a-z]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}[.]{0,1}[a-z]{0,2}"))
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(txt.getText().trim());
        if (!mat.find()) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }

    public static boolean esTelefono(JTextField txt) {
        boolean ok = true;
        if (!txt.getText().trim().matches("[0-9]{7,10}")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }

    public static boolean esCedula(JTextField txt) {
        boolean ok = true;
        if (!((txt.getText().trim().length() == 10) || (txt.getText().trim().length() == 13))) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }

    public static boolean esLetras(JTextField txt) {
        boolean ok = true;
        if (!txt.getText().trim().matches("[a-zA-ZáéíóúÁÉÍÓÚÑñ]{2,}")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok = false;
        }
        return ok;
    }
    //colocar más métodos de validación
  /*  public static boolean Date(JDateChooser txt)
     {
     boolean ok=true;
     if(txt.getDate() == null){
     txt.setBorder(BorderFactory.createLineBorder(Color.red));
     txt.setBackground(Color.pink);
     ok=false;
        
     }       
     return ok;  
     }*/

    public static boolean validadorDeCedula(String cedula) {//Validar cedula
        boolean cedulaCorrecta = false;
        if (!cedula.equals("2222222222")){
        
        // String cedula = (txtCed.getText());//esto debe ingresarse diferente
        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        }else
        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null,"La Cédula ingresada es Incorrecta");
        }
        
        return cedulaCorrecta;
    }
    
}
