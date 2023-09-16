/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class File2Creando {

    public static void main(String[] args) {

        try {
            File f = new File("./carpetilla"); 
            f.mkdir();
            f = new File("./carpetilla/file1.txt"); 
            f.createNewFile();
            f = new File("./carpetilla/file2.txt");
            f.createNewFile(); 
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
