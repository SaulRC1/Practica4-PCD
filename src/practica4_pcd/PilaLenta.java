/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_pcd;

//import Vista.CanvasPila;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class PilaLenta implements IPila {

    private int cima;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private CanvasPila canvas;

    public PilaLenta(int capacidad, CanvasPila elcanvas) {
        this.capacidad = capacidad;
        this.datos = new Object[this.capacidad];
        this.cima = 0;
        this.numelementos = 0;
        this.canvas = elcanvas;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    /**
     *
     * @param elemento
     * @throws Exception
     */
    @Override
    public synchronized void Apila(Object elemento) throws java.lang.Exception {
        int n = 0;
        while (pilallena()) {
            n++;
            if (n == 3) {
                this.canvas.avisa("Pila Llena");
                //Thread.sleep(100);
                throw new java.lang.Exception("La pila esta llena");
            } else {
                wait();
            }

        }
        

            this.datos[this.numelementos] = elemento;

            this.numelementos++;
            this.cima = this.numelementos - 1;

            this.canvas.representa(datos, cima, numelementos);

            this.canvas.avisa("");
            notifyAll();
        

    }

    /**
     *
     * @return @throws java.lang.Exception
     */
    @Override
    public synchronized Object Desapila() throws java.lang.Exception {

        int n = 0;
        while (pilavacia()) {
            n++;
            if (n == 3) {
                this.canvas.avisa("Pila Vacia");
                //Thread.sleep(100);
                throw new java.lang.Exception("La pila esta vacia");
            } else {
                wait();
            }

        }
        

            this.numelementos--;

            if (this.cima != 0) {
                this.cima--;
            }

            this.canvas.representa(datos, cima, numelementos);

            this.canvas.avisa("");
            notifyAll();
            return this.datos[this.cima];
        

    }

    @Override
    public Object Primero() throws java.lang.Exception {
        if (!this.pilavacia()) {
            return this.datos[0];
        } else {
            throw new java.lang.Exception("La pila esta vacia");
        }
    }

    private boolean pilavacia() {
        return this.numelementos == 0;
    }

    private boolean pilallena() {
        return this.numelementos == this.capacidad;
    }

}
