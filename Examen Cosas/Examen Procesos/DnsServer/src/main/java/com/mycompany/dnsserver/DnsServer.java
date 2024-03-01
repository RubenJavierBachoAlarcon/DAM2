/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dnsserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

public class DnsServer {

    private final static int MAX_BYTES = 1400;
    private final static String COD_TEXTO = "UTF-8";

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("ERROR, indicar: puerto.");
            System.exit(1);
        }

        int numPuerto = Integer.parseInt(args[0]);

        // Definición manual de los nombres de dominio y sus direcciones IP
        HashMap<String, String> Domin = new HashMap<>();
        Domin.put("example.com", "192.168.1.1");
        Domin.put("test.com", "192.168.1.2");
        Domin.put("notfounddomain.com", "192.168.1.3");

        try (DatagramSocket serverSocket = new DatagramSocket(numPuerto)) {
            System.out.printf("Creado socket DNS server Iterativo para puerto %s.\n", numPuerto);

            while (true) {
                System.out.println("Esperando peticiones");

                byte[] datosRecibidos = new byte[MAX_BYTES];
                DatagramPacket paqueteRecibido
                        = new DatagramPacket(datosRecibidos, datosRecibidos.length);

                serverSocket.receive(paqueteRecibido);

                String DomPedido = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength(), COD_TEXTO);

                String Respuesta = Domin.getOrDefault(DomPedido, "NO ENCONTRADO");

                byte[] b = Respuesta.getBytes(COD_TEXTO);
                InetAddress IPCliente = paqueteRecibido.getAddress();
                int puertoCliente = paqueteRecibido.getPort();
                DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length, IPCliente, puertoCliente);

                serverSocket.send(paqueteEnviado);
            }
        } catch (SocketException ex) {
            System.out.println("Excepción de sockets");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Excepción de E/S");
            ex.printStackTrace();
        }
    }
}
