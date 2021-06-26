/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Plomo
 */
public class setIcon {
    


    public void setIconImage(Image image) {
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/lgsmall.png")).getImage());
    }
}
