/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugadorespractica;

import javax.persistence.*;

/**
 *
 * @author javie
 */
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreJugador;

    private int edad;
    private String ciudad;
    
    @ManyToOne
    private Pais pais;

    public Jugador(String nombreJugador, int edad, String ciudad, Pais pais) {
        this.nombreJugador = nombreJugador;
        this.edad = edad;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    

    

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombreJugador=" + nombreJugador + ", pais=" + pais + '}';
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
