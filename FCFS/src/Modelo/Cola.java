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
    Hilo hilo;
    public Nodo sig;
}

public class Cola {
   private Nodo nuevo,cabeza,p,aux;
    public Cola() {
        p=new Nodo();
        p.sig=p;
        cabeza=p;
    }
    
   public boolean vacia (){
         return p == p.sig;
    }
    public void insertar (Hilo hilo)
    {
        nuevo = new Nodo ();
        nuevo.hilo=hilo;
        cabeza.sig = nuevo;
        nuevo.sig=p;
        cabeza = nuevo;
      
    }
    public Hilo extraer ()
    {       
           Hilo informacion;
            aux=p;
            if(aux==aux.sig){
                return null;
            }
            else{
                informacion=aux.hilo;
                aux=p.sig;
                p.sig=aux.sig;
                aux=p.sig;                
            }                          
            return informacion; 
    }
    public void imprimir() {
        Nodo nuevo=p.sig;
        System.out.println("Listado de todos los elementos de la cola.");
        while (nuevo!=p) {
            System.out.println(nuevo.hilo.numeroProceso+" - "+nuevo.hilo.horaLlegada+" - "+ nuevo.hilo.tiempoEjecucion);
            nuevo=nuevo.sig;
        }
        System.out.println();
    }
     public int tamañoCola(){
          Nodo reco=p.sig;
          int contador=0;
          while(reco!=cabeza)
          {
              contador++;
              reco=reco.sig;
          }
          return contador;
      }
    
}
