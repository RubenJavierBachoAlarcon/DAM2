/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioshilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Adivinador implements Runnable {

    Random rand = new Random();

    int numHilo;

    public Adivinador(int numHilo) {
        this.numHilo = numHilo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = rand.nextInt(51);
                System.out.println("Hilo " + numHilo + " dice " + numero);
                if (EjericioAdivinador.numSecreto == numero ) {
                    break;
                } else {
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Adivinador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hilo " + numHilo + " ha adivinado el numero");
    }
}

public class EjericioAdivinador {

    public static int numSecreto;

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        numSecreto = rand.nextInt(51);
        
        System.out.println("El numero secreto es: " + numSecreto);
        
        for (int i = 0; i < 10; i++){
            Thread th = new Thread(new Adivinador(i));
            th.start();

        }
    }
}
