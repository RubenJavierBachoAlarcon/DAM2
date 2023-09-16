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
        File f = new File("./carpetilla/file1.txt");
        f.delete();
        f = new File("./carpetilla/file2.txt");
        f.delete();
        f = new File("./carpetilla");
        f.delete();
    }
}
