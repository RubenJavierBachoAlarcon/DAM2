/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicioexamen1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 *
 * @author javie
 */
public class EjercicioExamen1 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("netstat ", "-an");
        Process p = pb.start();

        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String linea;
        String split1[];
        String split2[];
        LinkedHashMap<String,String>lista = new LinkedHashMap<>();
        
        while ((linea = bf.readLine()) != null) {
            split1 = linea.split("\\s+");
            if (split1.length == 5){
                split2 = split1[3].split(Pattern.quote(":"));
                if (split2[0].equals("127.0.0.53")){
                    lista.put(linea, split2[0]);
                }
            }
        }
         List<Entry<String, String>> listaOrdenada= new ArrayList<>(lista.entrySet());
         listaOrdenada.sort(Entry.comparingByKey());
    }
}
