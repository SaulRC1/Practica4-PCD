/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_pcd;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class consumidor extends Thread {

    private PilaLenta lapila;

    public consumidor(PilaLenta P) {
        this.lapila = P;
    }

    public void consumir() {
        try {
            for (int i = 0; i < 15; i++) {

                Random numAleatorio = new Random();

                numAleatorio.setSeed(System.nanoTime());

                int t_espera = numAleatorio.nextInt(3) + 1;
                t_espera = t_espera*1000;
                Thread.sleep(t_espera);
                System.out.println("Hilo: " + this.getId() + " Desapilo: " + lapila.Desapila());

            }
        } catch (Exception ex) {
            Logger.getLogger(consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        this.consumir();
    }

}
