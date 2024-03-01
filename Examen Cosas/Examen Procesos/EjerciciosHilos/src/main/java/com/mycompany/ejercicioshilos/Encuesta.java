/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioshilos;

import java.util.Random;

class Encuestador implements Runnable {

    Random rand = new Random();

    int numHilo;

    int numPersonas;

    int numRespuestas = 0;

    public Encuestador(int numHilo, int numPersonas) {
        this.numHilo = numHilo;
        this.numPersonas = numPersonas;
    }

    @Override
    public void run() {
        for (int i = 0; i < numPersonas; i++) {

            numRespuestas++;

            switch (rand.nextInt(10)) {
                case 0:
                    Encuesta.respuesta0++;
                    break;
                case 1:
                    Encuesta.respuesta1++;
                    break;
                case 2:
                    Encuesta.respuesta2++;
                    break;
                case 3:
                    Encuesta.respuesta3++;
                    break;
                case 4:
                    Encuesta.respuesta4++;
                    break;
                case 5:
                    Encuesta.respuesta5++;
                    break;
                case 6:
                    Encuesta.respuesta6++;
                    break;
                case 7:
                    Encuesta.respuesta7++;
                    break;
                case 8:
                    Encuesta.respuesta8++;
                    break;
                case 9:
                    Encuesta.respuesta9++;
                    break;
            }
        }
    }

    public int getNumRespuestas() {
        return numRespuestas;
    }
}

public class Encuesta {

    public static int respuesta0;
    public static int respuesta1;
    public static int respuesta2;
    public static int respuesta3;
    public static int respuesta4;
    public static int respuesta5;
    public static int respuesta6;
    public static int respuesta7;
    public static int respuesta8;
    public static int respuesta9;

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();

        
        
        Encuestador[] encuestadores = new Encuestador[20];

        for (int i = 0; i < 20; i++) {
            encuestadores[i] = new Encuestador(i, (rand.nextInt(201) + 100));
            Thread th = new Thread(encuestadores[i]);
            th.start();
            th.join(); // Espera a que el hilo termine su ejecución
            System.out.println("Número de respuestas del hilo " + i + ": " + encuestadores[i].numRespuestas);
        }

        System.out.println("Respuesta 0: " + respuesta0);
        System.out.println("Respuesta 1: " + respuesta1);
        System.out.println("Respuesta 2: " + respuesta2);
        System.out.println("Respuesta 3: " + respuesta3);
        System.out.println("Respuesta 4: " + respuesta4);
        System.out.println("Respuesta 5: " + respuesta5);
        System.out.println("Respuesta 6: " + respuesta6);
        System.out.println("Respuesta 7: " + respuesta7);
        System.out.println("Respuesta 8: " + respuesta8);
        System.out.println("Respuesta 9: " + respuesta9);

    }
}
