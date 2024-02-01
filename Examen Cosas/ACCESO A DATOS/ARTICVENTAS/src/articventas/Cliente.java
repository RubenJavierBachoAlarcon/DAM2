/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package articventas;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author javie
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numcli;
    
    private String nombre;
    
    private String pobla;
    
    @OneToMany(mappedBy = "numcli")
    private List<Venta> ventas;

    public Cliente(String nombre, String pobla) {
        this.nombre = nombre;
        this.pobla = pobla;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numcli=" + numcli + ", nombre=" + nombre + ", pobla=" + pobla + '}';
    }

    public int getNumcli() {
        return numcli;
    }

    public void setNumcli(int numcli) {
        this.numcli = numcli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPobla() {
        return pobla;
    }

    public void setPobla(String pobla) {
        this.pobla = pobla;
    }

    

   
}
