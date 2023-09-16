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
public class File3Eliminando {

    public static void main(String[] args) {
        eliminarFichero("./carpetilla");
    }

    public static void eliminarFichero(String ruta) {
        File d = new File(ruta);
        if (d.isDirectory()) {
            File[] fs = d.listFiles();
            for (File f : fs) {
                if (f.isDirectory()) {
                    eliminarFichero(f.getPath());
                }
                f.delete();
            }
        }
        d.delete();
    }
}
