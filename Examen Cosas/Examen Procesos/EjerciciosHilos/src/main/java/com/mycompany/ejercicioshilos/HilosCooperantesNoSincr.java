/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioshilos;

import java.util.Random;

class Contador {
    private int cuenta = 0;

    public synchronized void incrementa() {
        cuenta++;
    }

    public int getCuenta() {
        return cuenta;
    }
}

class Hilo implements Runnable {
    private final int numHilo;
    private final int miParte;
    private final Contador cont;

    public Hilo(int numHilo, int miParte, Contador c) {
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.cont = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < miParte; i++) {
            this.cont.incrementa();
        }
        System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilo, cont.getCuenta());
    }
}

public class HilosCooperantesNoSincr {
    public static void main(String[] args) {
        int num;

        int NUM_HILOS = 10;

        Random r = new Random();

        num = 1 + r.nextInt(49); // Elegimos un numero del 1 al 50

        Contador contador = new Contador();

        System.out.printf("El número elegido es: %d. No se lo digas a los hilos.\n", num);

        Thread[] hilos = new Thread[NUM_HILOS]; // Creamos el array de hilos

        int cuentaTotal = 100000;
        int partePorHilo = cuentaTotal / NUM_HILOS;

        for (int i = 0; i < NUM_HILOS; i++) {
            Thread th = new Thread(new Hilo(i, partePorHilo, contador));
            th.start();
            hilos[i] = th;
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Cuenta global: %d\n", contador.getCuenta());
    }
}

