/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoxml;

import java.util.Scanner;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class ProyectoXml {

    private static XQConnection con;

    public static void main(String[] args) {
        try {
            abrirConexion();

            eliminarEmpleado();

            con.close();
        } catch (XQException ex) {
            System.err.println("Error al conectar con la base de datos eXist-db: " + ex.getMessage());
        }
    }

    private static void abrirConexion() throws XQException {
        XQDataSource server = new ExistXQDataSource();
        server.setProperty("serverName", "localhost");
        server.setProperty("port", "8080");
        server.setProperty("user", "admin");
        server.setProperty("password", "");
        con = server.getConnection();

        System.out.println("Conexión exitosa!");
    }

    private static void consulta1() throws XQException {
        XQPreparedExpression consulta;
        XQResultSequence resultado;

        consulta = con.prepareExpression("/EMPLEADOS/EMP_ROW[DEPT_NO=10]");

        resultado = consulta.executeQuery();

        XQResultItem item;

        while (resultado.next()) {
            item = (XQResultItem) resultado.getItem();
            System.out.println("Elemento: " + item.getItemAsString(null));
        }
    }

    private static void insertarEmpleado() throws XQException {
        XQPreparedExpression consulta;

        String nuevoEmpleado = "<EMP_ROW>"
                + "<EMP_NO>9999</EMP_NO>"
                + "<APELLIDO>NUEVO</APELLIDO>"
                + "<OFICIO>EMPLEADO</OFICIO>"
                + "<DIR>7902</DIR>"
                + "<FECHA_ALT>2024-02-26</FECHA_ALT>"
                + "<SALARIO>2000</SALARIO>"
                + "<DEPT_NO>20</DEPT_NO>"
                + "</EMP_ROW>";

        consulta = con.prepareExpression("update rename /EMPLEADOS as 'asdasd'");

        consulta.executeQuery();
    }

    private static void eliminarEmpleado() throws XQException {
        XQPreparedExpression consulta;

        String numeroEmpleado = "7900";

        consulta = con.prepareExpression(
                "delete node /EMPLEADOS/EMP_ROW[EMP_NO=" + numeroEmpleado + "]"
        );

        consulta.executeQuery();
    }

    private static void anadirEmpleado() throws XQException {
        String nuevoEmpleado = "<empleado salario=\"2340\">"
                + "<puesto>Técnico</puesto>"
                + "<nombre>Pedro Fraile</nombre>"
                + "</empleado>";

        XQPreparedExpression consulta = con.prepareExpression(
                "insert node " + nuevoEmpleado + " into /universidad/departamento[2]"
        );

        consulta.executeQuery();
    }

    private static void actualizarSalario() throws XQException {
        XQPreparedExpression consulta = con.prepareExpression(
                "for $x in /universidad/departamento[codigo='MAT1']/empleado "
                + "return replace value of node $x/salario with ($x/salario + 100)"
        );

        consulta.executeQuery();
    }

    private static void visualizarEmpleados() throws XQException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el código del departamento:");
        String codigo = scanner.nextLine();

        XQPreparedExpression consulta = con.prepareExpression(
                "/universidad/departamento[codigo='" + codigo + "']/empleado"
        );

        XQResultSequence resultado = consulta.executeQuery();

        while (resultado.next()) {
            System.out.println(resultado.getItemAsString(null));
        }
    }

    private static void insertarDepartamento() throws XQException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el código del departamento:");
        String codigo = scanner.nextLine();

        // Comprobar si el departamento ya existe
        XQPreparedExpression consulta = con.prepareExpression(
                "/universidad/departamento[codigo='" + codigo + "']"
        );
        XQResultSequence resultado = consulta.executeQuery();

        if (resultado.next()) {
            System.out.println("El departamento ya existe.");
        } else {
            System.out.println("Introduce el nombre del departamento:");
            String nombre = scanner.nextLine();
            System.out.println("Introduce la localidad del departamento:");
            String localidad = scanner.nextLine();

            String nuevoDepartamento = "<departamento>"
                    + "<codigo>" + codigo + "</codigo>"
                    + "<nombre>" + nombre + "</nombre>"
                    + "<localidad>" + localidad + "</localidad>"
                    + "</departamento>";

            consulta = con.prepareExpression(
                    "insert node " + nuevoDepartamento + " into /universidad"
            );

            consulta.executeQuery();
        }
    }

    private static void eliminarDepartamento() throws XQException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el código del departamento:");
        String codigo = scanner.nextLine();

        XQPreparedExpression consulta = con.prepareExpression(
                "delete node /universidad/departamento[codigo='" + codigo + "']"
        );

        consulta.executeQuery();
    }

    private static void modificarDepartamento() throws XQException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el código del departamento:");
        String codigo = scanner.nextLine();

        // Comprobar si el departamento existe
        XQPreparedExpression consulta = con.prepareExpression(
                "/universidad/departamento[codigo='" + codigo + "']"
        );
        XQResultSequence resultado = consulta.executeQuery();

        if (resultado.next()) {
            System.out.println("Introduce el nuevo nombre del departamento:");
            String nuevoNombre = scanner.nextLine();
            System.out.println("Introduce la nueva localidad del departamento:");
            String nuevaLocalidad = scanner.nextLine();

            consulta = con.prepareExpression(
                    "replace value of node /universidad/departamento[codigo='" + codigo + "']/nombre with '" + nuevoNombre + "', "
                    + "replace value of node /universidad/departamento[codigo='" + codigo + "']/localidad with '" + nuevaLocalidad + "'"
            );

            consulta.executeQuery();
        } else {
            System.out.println("El departamento no existe.");
        }
    }

    private static void modificarNodo() throws XQException {
    String nodoAntiguo = "7900";
    String nodoNuevo = "7901";

    XQPreparedExpression consulta = con.prepareExpression(
            "rename node /EMPLEADOS/EMP_ROW[EMP_NO=" + nodoAntiguo + "] as " + nodoNuevo
    );

    consulta.executeQuery();
}

private static void modificarEtiquetaNodo() throws XQException {
    String etiquetaAntigua = "EMP_NO";
    String etiquetaNueva = "EMP_ID";

    XQPreparedExpression consulta = con.prepareExpression(
            "rename node /EMPLEADOS/EMP_ROW/" + etiquetaAntigua + " as '" + etiquetaNueva + "'"
    );

    consulta.executeQuery();
}

private static void modificarContenidoNodo() throws XQException {
    String nodo = "EMP_NO";
    String contenidoAntiguo = "7900";
    String contenidoNuevo = "7901";

    XQPreparedExpression consulta = con.prepareExpression(
            "replace value of node /EMPLEADOS/EMP_ROW[" + nodo + "=" + contenidoAntiguo + "]/" + nodo + " with '" + contenidoNuevo + "'"
    );

    consulta.executeQuery();
}
}
