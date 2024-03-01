
package com.mycompany.ejercicioshilostodos;


/*
Un programa que haga lo siguiente:

-El programa principal elegirá un numero 1-50 para adivinar
-El programa principal lanzará 10 hilos que deberán intentar adivinar el numero
-Si el hilo acierta se motrara su nombre y el mensaje diciendo que ese hilo lo ha adivinado
 y este y los demas hilos terminaran
-En caso de errar ese hilo debe espearar un tiempo entre 0,5 3s

*/

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


class Numero                     //Clase que contendrá los recursos compartidos
{
  private int numero;       //El numero que tenemos que adivinar
  
  private boolean acertado; //Variable que indica si el numero se ha adivinado
 
  ArrayList<Integer> intentos = new ArrayList<Integer>();
  
  public Numero(int numero,boolean acertado)    //Constructor de la clase
  {
     this.numero=numero;
     this.acertado=acertado;
  
  }
  
  public synchronized void Intenta(int num,String nombre)             //Metodo usado por los hilos para hacer un intento
  {       
      
    if  ( (!this.getAcertado()) && (!this.intentos.contains(num))  )   //Solo podemos hacer intentos si no esta acertado y no se ha dicho antes
    {  
      System.out.print("El hilo "+nombre+" dice el "+num);
      
      if (num==this.numero)
      {
         this.acertado=true;      //Hemos acertado    
         
         System.out.println("  EL ADIVINADOR "+nombre+" -------- Ha acertado!!!!, era el:"+num);
      }
      else
      {
         System.out.println(" HAS FALLADO!!!! , no es el:"+num);
         
      }
      
      this.intentos.add(num);    //Añadimos el numero al arraylist de intentos
      
      
    } 
  }
  
  public synchronized boolean getAcertado()      //Getter de la variable adivinado
  {
    return this.acertado;
  }
  

}

class Adivinador implements Runnable 
{
   String nombre;    //Nombre del hilos

   private final Numero num;   //Recurso compartido
   
  public Adivinador(String nombre,Numero numero)       //Constructor que asigna el nombre a cada hilo
  {
     this.nombre=nombre;  //Nombre de ese hilo
     this.num=numero;     //Referencia a la clase Numero del recuerso compartido 
  }

  @Override
  public void run() 
  {
    int num;  
      
    Random r = new Random();
    
    num=1+r.nextInt(50);     //Elegimos un número entre 1-50
       
    int tiempo;
    
    while (!this.num.getAcertado() )    //Mientras el número no se haya acertado
    {    
        try {
            
              tiempo= 1000+r.nextInt(4001);  //Esperamos entre 1  y 5 segundos
            
              Thread.sleep(tiempo);
               
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(Adivinador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.num.Intenta(num, nombre);   //Intentamos con ese número
        
        num=1+r.nextInt(50);     //Elegimos otro número entre 1-50  
    }
    System.out.println("El adivinador "+nombre+ " termina ");
  }
  
}

class Adivina {

  private static final int NUM_HILOS = 5;
 

  public static void main(String[] args) 
  {
      
    int num;
    
    String nombre="Adivinador_";
    
    Random r = new Random();
    
    num=1+r.nextInt(50);     //Elegimos un número entre 1-50
      
    System.out.println("---El numero elegido es: "+num+" no se lo digas a los hilos-----");
    
    
    System.out.println();
    
    Numero numero = new Numero(num,false);   //Instanciamos la clase número compartida
    
 
    Thread[] hilos = new Thread[NUM_HILOS];  //Creamos el array de hilos
    
    String nombreH="";
    
    for (int i = 0; i < NUM_HILOS; i++) 
    {
      nombreH=nombre+i;   //Añadimos al nombre el numero de hilo  
        
      Thread th = new Thread(new Adivinador(nombreH,numero));  //Creamos ese hilo
      th.start();      //Lo lanzamos
      hilos[i] = th;   //Guardamos ese hilo en un array
    
    }
    for (Thread h: hilos)   //Para cade hilo hacemos que el principal espere
    {
      try {
        h.join();
      } catch (InterruptedException e) {
      }
    }
    
    System.out.println();
    
    System.out.printf("-----Programa principal terminado -----------");
  }

}
