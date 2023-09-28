/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filereaderejemplo1;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author b15-06m
 */
public class Vista {
    public static void main(String[] args) {
        try {
            // Establecer el aspecto y sensación del sistema operativo actual
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(jfc);
        String path = jfc.getSelectedFile().getAbsolutePath();
        System.out.println(path);
        FileReaderEjemplo1.lecturaPasandoID(path, 2);
        FileReaderEjemplo1.File1BorraRegistros(path, 2);
        FileReaderEjemplo1.lecturaPasandoID(path, 2);
        FileReaderEjemplo1.File1RecuperaRegistros(path, 2);
        FileReaderEjemplo1.lecturaPasandoID(path, 2);
        
        
        
    }
}
