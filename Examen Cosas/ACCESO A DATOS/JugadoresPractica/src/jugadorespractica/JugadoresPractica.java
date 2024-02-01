/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jugadorespractica;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author javie
 */
public class JugadoresPractica {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        conectarBD();
        //insertar4Jugadores();
        //mostrarJugadores();
        //mostrarPaisConJugadores();
        //buscarPorId(1);
        //mostrarJugadores14();
        //actualizaEdad("asd");
        //borrarPais("Irlanda");
        //operacionesJugadores();
        visualizarNumJugadores("España");

        em.close();
        emf.close();
    }

    private static void conectarBD() {
        emf = Persistence.createEntityManagerFactory(
                "$objectdb/db/jugadores.odb");
        em = emf.createEntityManager();
    }

    private static void insertar4Jugadores() {
        em.getTransaction().begin();

        Pais pais1 = new Pais("Argentina");
        Pais pais2 = new Pais("Irlanda");
        Pais pais3 = new Pais("Italia");
        Pais pais4 = new Pais("Francia");
        Pais pais5 = new Pais("España");
        em.persist(pais1);
        em.persist(pais2);
        em.persist(pais3);
        em.persist(pais4);
        em.persist(pais5);

        Jugador jugador1 = new Jugador("Lionel Messi", 14, "Buenos Aires", pais1);
        Jugador jugador2 = new Jugador("Neymar Jr.", 29, "São Paulo", pais1);
        Jugador jugador3 = new Jugador("Sergio Ramos", 14, "Sevilla", pais2);
        Jugador jugador4 = new Jugador("Kylian Mbappé", 14, "Bondy", pais2);
        Jugador jugador5 = new Jugador("Diego Maradona", 60, "Buenos Aires", pais3);
        Jugador jugador9 = new Jugador("Pablo Alborán", 60, "Buenos Aires", pais1);
        Jugador jugador6 = new Jugador("Pelé", 80, "Três Corações", pais3);
        Jugador jugador7 = new Jugador("Zinedine Zidane", 49, "Marseille", pais4);
        Jugador jugador8 = new Jugador("Thierry Henry", 14, "Les Ulis", pais4);

        em.persist(jugador1);
        em.persist(jugador2);
        em.persist(jugador3);
        em.persist(jugador4);
        em.persist(jugador5);
        em.persist(jugador6);
        em.persist(jugador7);
        em.persist(jugador8);
        em.persist(jugador9);

        em.getTransaction().commit();
    }

    private static void mostrarJugadores() {
        Query q1 = em.createQuery("select from Jugador", Jugador.class);

        List<Jugador> jugadores = q1.getResultList();

        for (Jugador j : jugadores) {
            System.out.print(j.getId() + " ");
            System.out.print(j.getNombreJugador() + " ");
            System.out.println(j.getPais().getNombrePais());
        }
    }

    private static void mostrarPaisConJugadores() {
        Query q1 = em.createQuery("select from Pais", Pais.class);
        List<Pais> paises = q1.getResultList();

        List<Jugador> jugadores;
        for (Pais p : paises) {
            System.out.println("Pais " + p.getNombrePais() + " con jugadores: ");
            jugadores = p.getJugadores();

            for (Jugador j : jugadores) {
                System.out.println("    " + j.getNombreJugador());
            }
            System.out.println("");
        }
    }

    private static void buscarPorId(int id) {
        Jugador j = em.find(Jugador.class, id);
        System.out.println(j);
    }

    private static void mostrarJugadores14() {
        Query q1 = em.createQuery("select from Jugador j where j.edad = 14 AND (j.pais.nombrePais in ('Irlanda','Francia','Italia'))", Jugador.class);

        List<Jugador> jugadores = q1.getResultList();

        for (Jugador j : jugadores) {
            System.out.println(j);
        }
    }

    private static void actualizaEdad(String nombrePais) {
        try {
            TypedQuery<Pais> tq1 = em.createQuery("SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais", Pais.class);
            tq1.setParameter("nombrePais", nombrePais);

            Pais p = tq1.getSingleResult();
            System.out.println(p);

            if (p == null) {
                System.out.println("No existe el país con el nombre: " + nombrePais);
            } else {
                em.getTransaction().begin();
                List<Jugador> jugadores = p.getJugadores();
                for (Jugador jugador : jugadores) {
                    jugador.setEdad(jugador.getEdad() + 2);
                    em.merge(jugador);
                }
                em.getTransaction().commit();
            }
        } catch (javax.persistence.NoResultException e) {
            System.out.println("No se ha encontrado ningun pais");
        }

    }

    private static void borrarPais(String nombrePais) {
        em.getTransaction().begin();

        TypedQuery<Pais> tq1 = em.createQuery("select from Pais p where p.nombrePais = :nombrePais", Pais.class);
        tq1.setParameter("nombrePais", nombrePais);

        Pais p = tq1.getSingleResult();

        List<Jugador> jugadores = p.getJugadores();

        if (!jugadores.isEmpty()) {
            for (Jugador j : jugadores) {
                j.setPais(null);
            }
        }

        em.remove(p);

        em.getTransaction().commit();
    }

    private static void operacionesJugadores() {
        TypedQuery<Object[]> tq1 = em.createQuery("select p.nombrePais, count(p.jugadores.id), max(p.jugadores.edad), avg(p.jugadores.edad) from Pais p group by p.nombrePais", Object[].class);
        List<Object[]> lista = tq1.getResultList();

        for (Object[] e : lista) {
            System.out.println("Pais: " + e[0]);
            System.out.println("Tiene " + e[1] + " jugadores");
            System.out.println("Con un máximo de edad de " + e[2] + " años");
            System.out.println("Con una media de edad de " + e[3] + " años");
            System.out.println();
        }
    }

    private static void visualizarNumJugadores(String nombrePais) {
        TypedQuery<Object[]> tq1 = em.createQuery("SELECT j.ciudad, COUNT(j), AVG(j.edad) FROM Jugador j WHERE j.pais.nombrePais = :nombrePais GROUP BY j.ciudad", Object[].class);
        tq1.setParameter("nombrePais", nombrePais);

        List<Object[]> lista = tq1.getResultList();

        TypedQuery<Pais> tqPais = em.createQuery("SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais", Pais.class);
        tqPais.setParameter("nombrePais", nombrePais);

        List<Pais> listaPais = tqPais.getResultList();

        if (listaPais.isEmpty()) {
            System.out.println("El país no existe.");
        } else if (lista.isEmpty()) {
            System.out.println("El país existe, pero no tiene jugadores.");
        } else {
            for (Object[] o : lista) {
                System.out.println("Ciudad: " + o[0]);
                System.out.println("Con " + o[1] + " jugadores");
                System.out.println("Con media de edad de " + o[2]);
            }
        }
    }

}
