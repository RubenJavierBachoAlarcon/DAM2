/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.filereaderejemplo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-06m
 */
public class FileReaderEjemplo1 {

    public static void leeFicheroCaracter(String ruta) {
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

    private static void File1Lectura(String ruta) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            int car;
            while ((car = br.read()) != -1) {
                System.out.print((char) car);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void File3Lectura(String ruta) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void File1Escritura(String ruta, char[] cars) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

            for (char car : cars) {
                bw.write(car);
            }

            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void File2Escritura(String ruta, String str) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void File3Escritura(String ruta, String str) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void File3Lectura(String name, String path) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(path + name + ".txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void File4Encripta(String rutaOriginal, String rutaEncripted) {

        try {
            BufferedReader original = new BufferedReader(new FileReader(rutaOriginal));
            BufferedWriter encripted = new BufferedWriter(new FileWriter(rutaEncripted));
            int car;
            while ((car = original.read()) != -1) {
                car = car + 3;
                encripted.write((char) car);
            }

            original.close();
            encripted.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void File5Desencripta(String rutaOriginal, String rutaDecrypted) {

        try {
            BufferedReader original = new BufferedReader(new FileReader(rutaOriginal));
            BufferedWriter decrypted = new BufferedWriter(new FileWriter(rutaDecrypted));
            int car;
            while ((car = original.read()) != -1) {
                car = car - 3;
                decrypted.write((char) car);
            }

            original.close();
            decrypted.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderEjemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
