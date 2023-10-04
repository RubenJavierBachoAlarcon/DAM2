package com.mycompany.leeescribeobjetos;

import java.io.*;
import java.util.*;

public class LeeEscribeObjetos {

    public static void main(String[] args) {
        // Creamos un ArrayList de Personas
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Juan", "123456789", true));
        personas.add(new Persona("Maria", "987654321", false));
        personas.add(new Persona("Pedro", "555555555", false));
        ObjectInputStream ois = null;
        try {
            // Escribimos las Personas en un archivo
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.dat"));
            for (Persona persona : personas) {
                oos.writeObject(persona);
            }
            oos.close();

            // Leemos las Personas del archivo
            ois = new ObjectInputStream(new FileInputStream("personas.dat"));

            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    
                    if (persona.getIsAlta() == true){
                        System.out.print(persona.getNombre() + " - " + persona.getTelefono());
                        System.out.println(" Pertenece a la empresa");
                    }
                   
                } catch (EOFException e) {
                    // Llegamos al final del archivo
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de entrada.");
            }
        }
    }
}
