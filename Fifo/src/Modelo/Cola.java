/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author wilo
 */
class Nodo{
    Persona persona;
    public Nodo sig;
}

public class Cola {
   private Nodo raiz,fondo;
    public Cola() {
        raiz=null;   
        fondo=null;
    }
    
   public boolean vacia (){
         return raiz == null;
    }
    public void insertar (Persona persona)
    {
        Nodo nuevo;
        nuevo = new Nodo ();
        nuevo.persona=persona;
        if (vacia ()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }
    public Persona extraer ()
    {
        if (!vacia ())
        {
           Persona informacion;
            informacion=raiz.persona;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            return informacion;
        } else
            return null;
    }
    public void imprimir() {
        Nodo reco=raiz;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco!=null) {
            System.out.println(reco.persona.cedula+" - "+reco.persona.nombre+" - "+ reco.persona.apellido);
            reco=reco.sig;
        }
        System.out.println();
    }
     public int tamañoCola(){
          Nodo reco=raiz;
          int contador=0;
          while(reco!=null)
          {
              contador++;
              reco=reco.sig;
          }
          return contador;
      }
    
}
