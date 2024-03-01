/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioshilos;

import java.util.logging.Level;
import java.util.logging.Logger;

class Cuenta {
    int dinero = 0;
}

class Cobrador implements Runnable {
    Cuenta cuenta;
    int tiempo = 0;
    int limite = 0;

    Cobrador(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        while (true) {
            if (tiempo >= 90 || limite >= 6000) {
                break;
            }
            try {
                if (cuenta.dinero > 300) {
                    cuenta.dinero -= 300;
                    limite += 300;
                    System.out.println("Cobrador retiró 300€. Dinero restante: " + cuenta.dinero);
                }
                tiempo += 3;
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cobrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Ingresador implements Runnable {
    Cuenta cuenta;
    int tiempo = 0;

    Ingresador(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        while (true) {
            if (tiempo >= 90) {
                break;
            }
            try {
                if (cuenta.dinero < 4500) {
                    cuenta.dinero += 500;
                    System.out.println("Ingresador depositó 500€. Dinero restante: " + cuenta.dinero);
                }
                tiempo += 2;
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ingresador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class MainBanco {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        Cobrador cobrador = new Cobrador(cuenta);
        Ingresador ingresador = new Ingresador(cuenta);

        Thread cobradorThread = new Thread(cobrador);
        Thread ingresadorThread = new Thread(ingresador);

        cobradorThread.start();
        ingresadorThread.start();

        try {
            cobradorThread.join();
            ingresadorThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Dinero restante en la cuenta: " + cuenta.dinero);
    }
}

