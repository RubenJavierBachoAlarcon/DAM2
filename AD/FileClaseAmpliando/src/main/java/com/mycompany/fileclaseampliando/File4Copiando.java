/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fileclaseampliando;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author javie
 */
public class File4Copiando {

    public static void main(String[] args) {
        try {
            Files.copy(Paths.get("./Fuente/file1.txt"), Paths.get("./Destino/file2.txt"), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException e) {
        }
    }
}
