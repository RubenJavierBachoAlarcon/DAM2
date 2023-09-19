/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.filereaderejemplo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-06m
 */
public class FileReaderEjemplo1 {

    public static void main(String[] args) {
        FileReaderEjemplo1.leeFicheroString("./ejemplo.txt");
    }

    private static void leeFicheroCaracter(String ruta) {
        try {
            FileReader fr = new FileReader(new File(ruta));
            int i = 0;
            while (i != -1) {
                i = fr.read();
                System.out.print((char) i);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void leeFicheroString(String ruta) {
        try {
            FileReader fr = new FileReader(new File(ruta));
            int i = 0;
            char[] cadena = new char[20];
            while (i != -1) {
                i = fr.read(cadena);
            }

            System.out.print(new String(cadena));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void leeFicheroBuffered(String ruta) {
        
    }
}
