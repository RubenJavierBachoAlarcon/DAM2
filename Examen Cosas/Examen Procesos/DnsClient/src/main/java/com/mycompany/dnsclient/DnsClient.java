package com.mycompany.dnsclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class DnsClient {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: DnsClient <servidor> <puerto>");
            System.exit(1);
        }

        String servidor = args[0];
        int puerto = Integer.parseInt(args[1]);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el mensaje para enviar al servidor DNS: ");
        String mensaje = scanner.nextLine();

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress direccionServidor = InetAddress.getByName(servidor);

            byte[] datos = mensaje.getBytes("UTF-8");
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccionServidor, puerto);

            socket.send(paquete);

            byte[] buffer = new byte[1400];
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRecibido);

            String respuesta = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength(), "UTF-8");
            System.out.println("Respuesta del servidor DNS: " + respuesta);
        } catch (SocketException ex) {
            System.err.println("Error de socket: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error de E/S: " + ex.getMessage());
        }
    }
}
