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
public class Persona {
    public  int cedula;
    public String nombre;
    public String apellido;
    public Persona(int cedula,String nombre,String apellido){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        
    }
}
