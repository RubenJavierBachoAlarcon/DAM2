/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author javie
 */
public class File2Creando {

    public static void main(String[] args) throws InterruptedException {

        try {
            File f = new File("./carpetilla"); 
            f.mkdir();
            f = new File("./carpetilla/file1.txt"); 
            f.createNewFile();
            f = new File("./carpetilla/file2.txt");
            f.createNewFile();
            File f2 = new File("./carpetilla/archivo2.txt");
            f.renameTo(f2);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
