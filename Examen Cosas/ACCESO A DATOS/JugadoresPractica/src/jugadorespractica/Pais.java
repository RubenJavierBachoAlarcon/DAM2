/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugadorespractica;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author javie
 */
@Entity
class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombrePais;
    
    @OneToMany(mappedBy = "pais")
    private List<Jugador> jugadores;

    public Pais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nombrePais=" + nombrePais;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
    
    
}
