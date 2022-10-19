/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_pcd;

/**
 *
 * @author usuario
 */
public interface IPila {
    
    public int GetNum();
    
    public void Apila(Object elemento) throws java.lang.Exception;
    
    public Object Desapila() throws java.lang.Exception;
    
    public Object Primero() throws java.lang.Exception;
   
    
}
