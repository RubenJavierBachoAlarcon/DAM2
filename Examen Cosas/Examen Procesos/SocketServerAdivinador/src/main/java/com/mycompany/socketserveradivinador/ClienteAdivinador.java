/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socketserveradivinador;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Adivinador implements Runnable {

    Random rand = new Random();

    int numero;

    @Override
    public void run() {

        try {
            DatagramSocket socket = new DatagramSocket();

            String numeroString = String.valueOf(rand.nextInt(10) + 1);
            byte[] datos = numeroString.getBytes("UTF-8");

            InetAddress direccionServidor = InetAddress.getByName("localhost");

            DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccionServidor, 5000);

            socket.send(paquete);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Adivinador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Adivinador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Adivinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

public class ClienteAdivinador {

    public static void main(String[] args) throws SocketException, IOException, InterruptedException {

        for (int i = 0; i < 50; i++) {
            Thread th = new Thread(new Adivinador());
            th.start();
        }

    }
}
