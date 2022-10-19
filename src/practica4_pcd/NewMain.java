/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_pcd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            pruebahilo1 h1 = new pruebahilo1("Soy el hilo 1");
            pruebahilo1 h2 = new pruebahilo1("Soy el hilo 2");
            h1.start();
            h2.start();
            
            h1.join();
            h2.join();
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
