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
public class productor extends Thread {

    private PilaLenta lapila;

    public void producir() {
        Random numAleatorio = new Random();

        numAleatorio.setSeed(System.currentTimeMillis() + getId());

        int aleatorio;
        try {
            for (int i = 0; i < 15; i++) {

                aleatorio = numAleatorio.nextInt(100);

                

                int t_espera = numAleatorio.nextInt(3) + 1;
                t_espera = t_espera * 1000;
                Thread.sleep(t_espera);
                lapila.Apila(aleatorio);
                System.out.println("Hilo: " + this.getId() + " Apilo: " + aleatorio);

            }
        }catch(Exception ex){
            Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public productor(PilaLenta lapila) {
        this.lapila = lapila;
    }

    @Override
    public void run() {
        this.producir();
    }

}
