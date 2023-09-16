/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class File1Mostrando {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta:");
        String ruta = sc.next();
        File fi = new File(ruta);
        File[] fs = fi.listFiles();
        for (File f : fs) {
            if (f.isDirectory()) {
                System.out.println("Es un directorio con los siguientes datos:");
                System.out.println(f.getName());
                System.out.println(f.getPath());
                System.out.println(Arrays.toString(f.list()));
            } else {
                System.out.println("Es un fichero con los siguientes datos:");
                System.out.println(f.getName());
                System.out.println(f.getPath());
            }
        }
    }
}
