/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifo;
import java.io.*;


/**
 *
 * @author wilme
 */

public class Principal {
    
    public static void main(String args[]) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion,cedula;
        String nombre,apellido;
        Cola espera=new Cola();
        do{
            System.out.println("Ingrese cedula de la persona");
            cedula=Integer.parseInt(br.readLine());
            System.out.println("Ingrese nombre de la persona");
            nombre=br.readLine();
            System.out.println("Ingrese apellido de la persona");
            apellido=br.readLine();
            System.out.println("Desea ingresar otra persona?");
            System.out.println("1. SI 2. NO");
            opcion=Integer.parseInt(br.readLine());
            Persona persona=new Persona(cedula,nombre,apellido);
            espera.insertar(persona);
            
        }while(opcion==1);
        espera.extraer();
        espera.imprimir();
        
    }
}
