/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciosphp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author ibachy
 */
public class EjerciciosPHP1 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java SumMemoryUsageByUser <nombre de usuario>");
            return;
        }

        String username = args[0];

        try {
            Process process = Runtime.getRuntime().exec("ps aux");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            double totalMemoryUsage = 0.0;

            while ((line = reader.readLine()) != null) {
                if (line.contains(username)) {
                    String[] parts = line.split("\\s+");
                    if (parts.length > 3) {
                        try {
                            double memoryUsage = Double.parseDouble(parts[3]);
                            totalMemoryUsage += memoryUsage;
                        } catch (NumberFormatException e) {
                            // Ignorar líneas que no tienen un valor válido de memoria
                        }
                    }
                }
            }

            reader.close();
            process.waitFor();
            System.out.println("Suma del porcentaje de memoria utilizado por " + username + ": " + totalMemoryUsage + "%");
        } catch (IOException | InterruptedException e) {
        }
    }
}
