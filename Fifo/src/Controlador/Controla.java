/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cola;
import Modelo.Persona;

/**
 *
 * @author wilme
 */
public class Controla {
    Cola espera=new Cola();
    public void añadirPersona(int cedula,String nombre,String apellido){
        Persona persona=new Persona(cedula,nombre,apellido);
        espera.insertar(persona);
        System.out.println("Persona añadida a la cola");
        espera.imprimir();
    }
    public void atenderPersona(){
        espera.extraer();
        System.out.println("Persona atendida");
        espera.imprimir();
    }
    public boolean vacia(){
        return espera.vacia();
    }
}
