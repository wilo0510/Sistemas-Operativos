/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author wilme
 */
public class Hilo extends Thread {
    public int numeroProceso,horaLlegada,tiempoEjecucion,tiempoFinalizacion,tiempoRetorno;
    public float tiempoNormalizadoRetorno;
    
    
    
    
    public Hilo(int tiempoEjecucion, int horaLlegada)
    {
        this.horaLlegada=horaLlegada;
        this.tiempoEjecucion=tiempoEjecucion;
       
        
        
    }
    
     @Override
     public void run() {
        // Presenta en pantalla informaciÃ³n sobre este hilo en particular
        System.out.println( "Corriendo hilo"+numeroProceso);
        }
    
}
