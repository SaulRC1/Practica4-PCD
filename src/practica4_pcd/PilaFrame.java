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
 * @author SaulRC1
 */
public class PilaFrame extends java.awt.Frame {

    /**
     * Creates new form PilaFrame
     */
    public PilaFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        PilaFrame Ventana = new PilaFrame();
        CanvasPila cvp = new CanvasPila(10);
        PilaLenta pila = new PilaLenta(10, cvp);

        consumidor con = new consumidor(pila);
        //consumidor con2 = new consumidor(pila);
        //Thread consume = new Thread(con);
        productor prod = new productor(pila);
        productor prod2 = new productor(pila);
        productor prod3 = new productor(pila);
        productor prod4 = new productor(pila);

        Ventana.setSize(1024, 768);

        //cv.paint(g);
        //cv.avisa("Pila Llena");
        Ventana.add(cvp);
        Ventana.setVisible(true);
        //con.run();
        
        prod.start();
        prod2.start();
        prod3.start();
        prod4.start();
        con.start();

        //con2.start();
        //prod.join();
        //Thread.sleep(400);
        //prod.join();
        //prod2.join();
        //prod3.join();
        //prod4.join();
        //prod2.join();
        con.join();
        System.out.println("Consumidor ha finalizado");
        Thread.sleep(4000);
        System.out.println("AVISAMOS 1 VEZ");
        synchronized (pila) {
            pila.notifyAll();
        }

        Thread.sleep(1000);
        System.out.println("AVISAMOS 2da VEZ");
        synchronized (pila) {
            pila.notifyAll();
        }
        Thread.sleep(1000);
        System.out.println("AVISAMOS 3a VEZ");
        synchronized (pila) {
            pila.notifyAll();
        }

        prod.join();
        prod2.join();
        prod3.join();
        prod4.join();

        if (!prod.isAlive()) {
            System.out.println("Hilo Productor 1 esta muerto");
        }
        
        if (!prod2.isAlive()) {
            System.out.println("Hilo Productor 2 esta muerto");
        }
        
        if (!prod3.isAlive()) {
            System.out.println("Hilo Productor 3 esta muerto");
        }
        
        if (!prod4.isAlive()) {
            System.out.println("Hilo Productor 4 esta muerto");
        }
        
        System.exit(0);

        /*Object[] datos1 = new Object[6];
        
        for (int i = 0; i < 6; i++) {
            datos1[i] = i + 1;
        }
        
        cvp.representa(datos1, 5, 6);
        
        Object[] datos2 = new Object[3];
        
        for (int i = 0; i < 3; i++) {
            datos2[i] = i + 1;    
        }
        Thread.sleep(100);
        cvp.representa(datos2, 2, 3);*/
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
