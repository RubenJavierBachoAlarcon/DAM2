/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-06m
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls", "-ln");
        pb.inheritIO();
        try {
            Process p = pb.start();
            System.out.println("terminado");
        } catch (IOException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
