/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cola;
import Modelo.Hilo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author wilme
 */
public class FrameFCFS extends JFrame{
    
    float mediaA,mediaF;
    ArrayList<Hilo> list=new ArrayList<>();
   
    public FrameFCFS(){
        int horaLlegada,tiempoEjecucion,cantidadProcesos;
        ArrayList<Hilo> temporal=new ArrayList<>();
        //pedir datos
        
         cantidadProcesos=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de procesos","No. de procesos",JOptionPane.QUESTION_MESSAGE));
        for(int i=0;i<cantidadProcesos;i++){
            horaLlegada=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de llegada del Proceso No "+(i+1),"No. de procesos",JOptionPane.QUESTION_MESSAGE));
            tiempoEjecucion=Integer.parseInt(JOptionPane.showInputDialog(null,"Y su tiempo de ejecucion","Tiempo de ejecucion del proceso",JOptionPane.QUESTION_MESSAGE));
            temporal.add(new Hilo(tiempoEjecucion,horaLlegada));
        }
        //ordenar arreglo
         boolean condicion=true;
         ArrayList<Hilo> FCFS=new ArrayList<>();
        while(condicion){
            int masPequeño=100;
            if(!temporal.isEmpty()){
                int contador=0,posicion=0;
                for(Hilo hilo:temporal){
                    if(hilo.horaLlegada<=masPequeño){
                        masPequeño=hilo.horaLlegada;
                        posicion=contador++;
                    }else{contador++;}
                }
                FCFS.add(temporal.remove(posicion));
            }else{condicion=false;}
        }
      
        
        //asignar atributos adicionales
        int tiempoFinal=0;
        float mediaTq=0,media=0,tiemponormalizado,tiempo,tiempo2;
        for(int i=0;i<FCFS.size();i++){
           FCFS.get(i).numeroProceso=i+1;
            if(i==0){
                //partimos del primer hilo para asignar tiempofinal
                tiempoFinal=FCFS.get(0).horaLlegada+tiempoFinal+FCFS.get(i).tiempoEjecucion;
            }
            else{tiempoFinal=tiempoFinal+FCFS.get(i).tiempoEjecucion;}
            FCFS.get(i).tiempoFinalizacion=tiempoFinal;
            FCFS.get(i).tiempoRetorno=tiempoFinal-FCFS.get(i).horaLlegada;
            tiemponormalizado=(float)FCFS.get(i).tiempoRetorno;
            FCFS.get(i).tiempoNormalizadoRetorno=tiemponormalizado/FCFS.get(i).tiempoEjecucion;
            tiempo=(float)FCFS.get(i).tiempoRetorno;
            mediaTq=mediaTq+tiempo;
            tiempo2=(float)FCFS.get(i).tiempoNormalizadoRetorno;
            media=media+tiempo;
            
        }
        mediaA=mediaTq/cantidadProcesos;
        mediaF=media/cantidadProcesos;
        list=FCFS;
        
        
        setTitle("Algoritmo de planificacion FCFS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,800,600);
        Object datos[][]=new Object[5][cantidadProcesos+1];
        for(int filas=0;filas<5;filas++){
            switch(filas){
                case 0:
                    datos[filas][0]="Hora de llegada : ";
                    break;
                case 1:
                    datos[filas][0]="Tiempo de servicio : ";
                    break;
                case 2:
                    datos[filas][0]="Tiempo fin : ";
                    break;
                case 3:
                    datos[filas][0]="Tiempo retorno : ";
                    break;
                case 4:
                    datos[filas][0]="Tiempo normalizado retorno : ";
                    break;
            }
            int con=0;
            for(int columnas=1;columnas<=cantidadProcesos;columnas++,con++){
                switch(filas){
                    case 0:
                        datos[filas][columnas]=FCFS.get(con).horaLlegada;
                        break;
                    case 1:
                        datos[filas][columnas]=FCFS.get(con).tiempoEjecucion;
                        break;
                    case 2:
                        datos[filas][columnas]=FCFS.get(con).tiempoFinalizacion;
                        break;
                    case 3:
                        datos[filas][columnas]=FCFS.get(con).tiempoRetorno;
                        break;
                    case 4:
                        datos[filas][columnas]=FCFS.get(con).tiempoNormalizadoRetorno;
                        break;
                }
            }
        }
        
        int in=0;
        Object columnas[]=new Object[cantidadProcesos+1];
        for(int i=0;i<cantidadProcesos+1;i++){
            if(i==0){columnas[i]="Numero de proceso";}
            else{
                columnas[i]=FCFS.get(in).numeroProceso;
                in++;
            }
        }
        JTable tablaDatos=new JTable(datos,columnas);
        JScrollPane panel=new JScrollPane(tablaDatos);
        
        getContentPane().add(panel,BorderLayout.CENTER);
        setVisible(true);
        
        
    }
    public void paint(Graphics g){
        super.paint(g);
        
        int tamañoLista=list.size();
        int tamaño=list.get(tamañoLista-1).tiempoFinalizacion;
        
        g.setColor(Color.BLACK);
        g.drawString("Media Tq : ", 550, 160);
        String tq=Float.toString(mediaA);
        g.drawString(tq, 640, 160);
        
        g.drawString("Media Tq/Ts : ", 550, 190);
        String tqs=Float.toString(mediaF);
        g.drawString(tqs, 640, 190);
        //Dibujar tabla
        g.drawString("FCFS/Procesos : ", 100, 200);
        int total=tamaño*22;
        g.drawLine(50, 249, total+50, 249);
        tamañoLista*=22;
        g.drawLine(50, 250, 50, tamañoLista+250);
        
        //Dibuja los numeros de quantum
        int lim=21;
        for(int ps=0;total>0;total-=22,ps++){
            String proc=Integer.toString(ps);
            if(ps==0)g.drawString(proc, 50, 248);
            else{
                g.drawString(proc, lim+50, 248);
                lim+=22;
            }
        }
        lim=22;
        for(int ps=1;tamañoLista>0;tamañoLista-=22,ps++){
            String proc=Integer.toString(ps);
            if(ps==1)g.drawString(proc, 41,271);
            else{
                g.drawString(proc, 41, lim+271);
                lim+=22;
            }            
        }
        //Dibujar procesos
        int posY=250,tFin=0;
        int iniq,inip;
        
        for(Hilo hilo:list){//22 numero de pixeles
            if(hilo.numeroProceso==1){
                iniq=hilo.horaLlegada*22;
                inip=0;
                tFin=hilo.tiempoFinalizacion;
            }
            else{
                iniq=tFin*22;
                inip=(hilo.numeroProceso-1)*22;
                tFin=hilo.tiempoFinalizacion;
            }
            int tims=hilo.tiempoEjecucion;
            //variable para el random del color
            int R=(int)(Math.random()*256);
            int G=(int)(Math.random()*256);
            int B=(int)(Math.random()*256);
            
            Color randomColor=new Color(R,G,B);
            
            int posx=50;
            g.setColor(randomColor);
            for(;tims>0;tims--){
                detenerTiempo();
                g.fillRect((posx+iniq),(posY+inip), 20, 20);
                posx+=22;
            }
        }        
    }
    public static void detenerTiempo(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){}
    }
   
    
}
