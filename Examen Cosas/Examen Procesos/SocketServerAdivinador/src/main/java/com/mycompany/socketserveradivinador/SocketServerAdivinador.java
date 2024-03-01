/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.socketserveradivinador;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

/**
 *
 * @author javie
 */
public class SocketServerAdivinador {

    public static void main(String[] args) throws SocketException, IOException {
        Random rand = new Random();

        int numeroSecreto = rand.nextInt(10) + 1;
        System.out.println("El numero secreto es: " + numeroSecreto);

        DatagramSocket serverSocket = new DatagramSocket(5000);
        
        System.out.printf("Creado servidor DNS en el puerto %s.\n", 5000);

        while (true) {
            byte[] datosRecibidos = new byte[1400];

            DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            
            serverSocket.receive(paqueteRecibido);
            
            String respuesta = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength(), "UTF-8");
            
            int numero = Integer.parseInt(respuesta);
            
            System.out.println("Cliente " + paqueteRecibido.getPort() + " ha dicho el " + numero);
            
            if (numeroSecreto == numero){
                System.out.println("El adivinador con ip " + paqueteRecibido.getAddress() + " con direccion " + paqueteRecibido.getPort() + " ha adivinado el numero");
            }
            
        }
    }
}
