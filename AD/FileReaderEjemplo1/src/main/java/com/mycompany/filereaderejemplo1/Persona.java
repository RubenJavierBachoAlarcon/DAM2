/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filereaderejemplo1;

import java.io.*;
import java.util.*;

public class Persona implements Serializable {
    private String nombre;
    private String telefono;
    private boolean isAlta;

    public Persona(String nombre, String telefono, boolean isAlta) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.isAlta = isAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public boolean getIsAlta() {
        return isAlta;
    }
}

