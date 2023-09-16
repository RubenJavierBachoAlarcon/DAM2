/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;

/**
 *
 * @author javie
 */
public class File1Mostrando {

    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio del proyecto: ");
        File fi = new File(".");
        String[] archivos = fi.list();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }
}
