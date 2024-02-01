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
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String denom;

    private int stock;
    private float pvp;

    @ManyToMany(mappedBy = "articulos")
    private List<Venta> Compras;

    public Articulo(String denom, int stock, float pvp) {
        this.denom = denom;
        this.stock = stock;
        this.pvp = pvp;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", denom=" + denom + ", stock=" + stock + ", pvp=" + pvp + ", Compras=" + Compras + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public List<Venta> getCompras() {
        return Compras;
    }

    public void setCompras(List<Venta> Compras) {
        this.Compras = Compras;
    }

}
