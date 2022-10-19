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
public class pruebahilo1 extends Thread {
    private String mensaje;

    public pruebahilo1(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void run(){
        try {
            mensaje(this.mensaje);
        } catch (InterruptedException ex) {
            Logger.getLogger(pruebahilo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void  mensaje(String mensaje) throws InterruptedException{
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println(mensaje);
        }
    }
    
}
