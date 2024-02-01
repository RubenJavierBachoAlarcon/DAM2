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
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codventa;

    @ManyToOne
    private Cliente numcli;

    private int univen;

    private String fecha;

    @ManyToMany
    @JoinTable(name = "venta_articulo",
            joinColumns = @JoinColumn(name = "codventa"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    private List<Articulo> articulos;

    public Venta(int codventa, Cliente numcli, int univen, String fecha, List<Articulo> articulos) {
        this.codventa = codventa;
        this.numcli = numcli;
        this.univen = univen;
        this.fecha = fecha;
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Venta{" + "codventa=" + codventa + ", numcli=" + numcli + ", univen=" + univen + ", fecha=" + fecha + ", articulos=" + articulos + '}';
    }

    public int getCodventa() {
        return codventa;
    }

    public void setCodventa(int codventa) {
        this.codventa = codventa;
    }

    public Cliente getNumcli() {
        return numcli;
    }

    public void setNumcli(Cliente numcli) {
        this.numcli = numcli;
    }

    public int getUniven() {
        return univen;
    }

    public void setUniven(int univen) {
        this.univen = univen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

}
