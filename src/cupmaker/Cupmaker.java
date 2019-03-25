/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupmaker;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

/**
 *
 * @author wouter
 */
public class Cupmaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Can't set look and feel");
        }
        
        View view = new View();
    }
    
}
