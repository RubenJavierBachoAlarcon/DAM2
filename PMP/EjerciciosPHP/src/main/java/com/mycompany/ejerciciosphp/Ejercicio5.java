/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciosphp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author ibachy
 */
public class Ejercicio5 {

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length != 1) {
            System.out.println("Entrada no válida");
            System.exit(1);
        }

        String ip = args[0];

        Process process = Runtime.getRuntime().exec("ping " + ip);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                process.destroy();
                System.out.println("Proceso de ping detenido después de 5 segundos.");
            }
        }, 5000); // 5000 milisegundos = 5 segundos
        
        Double suma = 0.0;
        int divisor = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String linea;
        while ((linea = bf.readLine()) != null) {
            if (linea.contains("time=")) {
                int start = linea.indexOf("time=");
                int end = linea.indexOf("ms", start);

                suma += Double.parseDouble(linea.substring(start + 5, end));
                divisor++;

                System.out.println(linea);
            }
        }

        if (divisor > 0) {
            System.out.println("La media es " + suma / divisor);
        } else {
            System.out.println("No se encontraron tiempos en la salida del ping.");
        }

    }
}
