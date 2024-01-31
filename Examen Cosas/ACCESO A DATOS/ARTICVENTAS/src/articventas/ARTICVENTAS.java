/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package articventas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author javie
 */
public class ARTICVENTAS {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        conectarBD();

        insertarDatos();
        
        em.close();
        emf.close();
    }

    private static void conectarBD() {
        emf = Persistence.createEntityManagerFactory(
                "$objectdb/db/ventas.odb");
        em = emf.createEntityManager();
    }

    private static void insertarDatos() {
        em.getTransaction().begin();

        // Insert Articulos
        Articulo articulo1 = new Articulo("Product A", 10, 19.99f);
        Articulo articulo2 = new Articulo("Product B", 5, 29.99f);
        Articulo articulo3 = new Articulo("Product C", 5, 29.99f);
        Articulo articulo4 = new Articulo("Product D", 5, 29.99f);
        Articulo articulo5 = new Articulo("Product E", 5, 29.99f);
        em.persist(articulo1);
        em.persist(articulo2);
        em.persist(articulo3);
        em.persist(articulo4);
        em.persist(articulo5);

        Cliente cliente1 = new Cliente("Cliente1", "Madrid");
        Cliente cliente2 = new Cliente("Cliente2", "Ciudad Real");
        Cliente cliente3 = new Cliente("Cliente3", "Toledo");

        em.persist(cliente1);
        em.persist(cliente2);
        em.persist(cliente3);

        // Insert Venta with multiple Articulos
        Venta venta1 = new Venta(1, cliente1, 2, "2024-01-31", List.of(articulo1, articulo2));
        Venta venta2 = new Venta(2, cliente2, 2, "2024-01-31", List.of(articulo1, articulo3));
        Venta venta3 = new Venta(3, cliente3, 2, "2024-01-31", List.of(articulo1, articulo2, articulo3));
        em.persist(venta1);
        em.persist(venta2);
        em.persist(venta3);

        em.getTransaction().commit();
    }

}
