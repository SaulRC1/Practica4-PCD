/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_pcd;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author SaulRC1
 */
public class CanvasPila extends Canvas {

    private int cima;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private String mensaje;

    public CanvasPila(int capacidad) {

        super();
        setSize(1024, 768);
        setBackground(Color.DARK_GRAY);
        this.capacidad = capacidad;
        this.datos = new Integer[capacidad];
        this.mensaje = "";
        /*for (int i = 0; i < 10; i++) {
            datos[i] = i;
        }*/
        
        
        
        repaint();

    }

    @Override
    public void paint(Graphics g) {

        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics bg = offscreen.getGraphics();
        bg.setColor(Color.WHITE);
        int separacion = 0;
        //bg.fillRect(this.getWidth()/2 - 50, 25, 100, 75);
        //bg.fillRect(this.getWidth()/2 - 50, 125, 100, 75);
        int posx_cima = (this.getWidth() / 2 - 80);
        int posy_cima = 0;

        for (int i = capacidad - 1; i >= 0; i--) {
            bg.setColor(Color.WHITE);
            bg.fillRect(this.getWidth() / 2 - 50, 25 + separacion, 50, 50);
            bg.setColor(Color.black);
            if (datos[i] != null) {
                bg.drawString("" + datos[i], (this.getWidth() / 2 - 50) + 20, 50 + separacion);
                posy_cima = separacion + 50;
                
                //System.out.println("no nulo");
            }
            else{
                bg.drawString("", (this.getWidth() / 2 - 50) + 20, 50 + separacion);
                //System.out.println("nulo");
            }
            
            

            separacion = separacion + 60;
            //posy_cima = separacion + 50;

        }
        /*
        Posicion pila 10 - 25
        Posicion pila 9 - 85
        Posicion pila 8 - 145
        Posicion pila 7 - 205
        Posicion pila 6 - 265
        Posicion pila 5 - 325
        Posicion pila 4 - 385
        Posicion pila 3 - 445
        Posicion pila 2 - 505
        Posicion pila 1 - 565
         */
        
        /*for (int i = 0; i < 10; i++) {
            bg.setColor(Color.WHITE);
            bg.fillRect(this.getWidth() / 2 - 50, 25 + separacion, 50, 50);
            separacion = separacion + 60;
        }*/
        bg.setColor(Color.white);
        bg.fillOval(posx_cima, this.cima, 20, 20);

        Font f2 = new Font("Courier", Font.BOLD, 20);
        bg.setFont(f2);
        bg.setColor(Color.red);
        bg.drawString(mensaje, 50, 600);
        //bg.drawString("Pila Vacia", 800, 600);
        //bg.setColor(Color.red);
        //bg.drawLine(75, 75, 200, 50);

        g.drawImage(offscreen, 0, 0, null);

    }

    @Override
    public void update(Graphics g) {

        paint(g);

    }

    public void avisa(String mensaje) {

        this.mensaje = mensaje;
        repaint();

    }

    public void representa(Object[] buf, int cima, int numele) {

        this.datos = new Object[capacidad];
        int pos_cima[] = {565, 505, 445, 385, 325, 265, 205, 145, 85, 25};
        System.out.println("Cima: " + cima);
        this.cima = pos_cima[cima];
        this.numelementos = numele;
        
        for (int i = 0; i < numele; i++) {
            this.datos[i] = buf[i];
        }
        
        repaint();

    }

}
