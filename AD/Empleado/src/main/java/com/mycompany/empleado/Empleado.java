package com.mycompany.empleado;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Empleado {

    private int identificador;
    private String apellido;
    private int departamento;
    private double salario;

    public Empleado(int identificador, String apellido, int departamento, double salario) {
        this.identificador = identificador;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }

    public static void main(String[] args) {
        try {
            Empleado empleado1 = new Empleado(1, "Smith", 101, 50000.0);
            Empleado empleado2 = new Empleado(2, "Johnson", 102, 60000.0);
            Empleado empleado3 = new Empleado(3, "Brown", 103, 70000.0);

            RandomAccessFile archivo = new RandomAccessFile("empleados.dat", "rw");

            escribirEmpleado(archivo, empleado1);
            escribirEmpleado(archivo, empleado2);
            escribirEmpleado(archivo, empleado3);

            leerEmpleado(archivo, 0);
            leerEmpleado(archivo, 1);
            leerEmpleado(archivo, 2);

            Document document = crearArchivoXML(archivo);
            generarArchivo("empleados.xml", document);
            mostrarPantalla(document);

            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Document crearArchivoXML(RandomAccessFile archivo) {
        Document archivoEmpleados = null;

        try {
            archivoEmpleados = inicializar("Empleados");

            // Debes asegurarte de leer la misma cantidad de elementos que escribiste en el archivo
            for (int i = 0; i < 3; i++) {
                System.out.println("asd");
                System.out.println("asd" + archivo.readInt());
                Element nodo = crearNodoPrincipal("Empleado", archivoEmpleados);
                añadirNodo("id", Integer.toString(archivo.readInt()), nodo, archivoEmpleados);
                añadirNodo("nombre", leerCadenaConPadding(archivo, 20).trim(), nodo, archivoEmpleados);
                añadirNodo("departamente", Integer.toString(archivo.readInt()), nodo, archivoEmpleados);
                añadirNodo("salario", Double.toString(archivo.readDouble()), nodo, archivoEmpleados);

            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close(); // Cierra el archivo al finalizar
            } catch (IOException e) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return archivoEmpleados;
    }

    private static void escribirEmpleado(RandomAccessFile archivo, Empleado empleado) throws IOException {
        archivo.writeInt(empleado.identificador);
        escribirCadenaConPadding(archivo, empleado.apellido, 20);
        archivo.writeInt(empleado.departamento);
        archivo.writeDouble(empleado.salario);
    }

    private static void leerEmpleado(RandomAccessFile archivo, long posicion) throws IOException {
        archivo.seek(posicion * (4 + 20 + 4 + 8));
        int identificador = archivo.readInt();
        String apellido = leerCadenaConPadding(archivo, 20).trim();
        int departamento = archivo.readInt();
        double salario = archivo.readDouble();
        System.out.println("Identificador: " + identificador);
        System.out.println("Apellido: " + apellido);
        System.out.println("Departamento: " + departamento);
        System.out.println("Salario: " + salario);
        System.out.println();
    }

    private static void escribirCadenaConPadding(RandomAccessFile archivo, String cadena, int longitud) throws IOException {
        if (cadena.length() > longitud) {
            throw new IllegalArgumentException("La cadena es demasiado larga.");
        }
        archivo.writeBytes(cadena);
        for (int i = cadena.length(); i < longitud; i++) {
            archivo.writeByte(' ');
        }
    }

    private static String leerCadenaConPadding(RandomAccessFile archivo, int longitud) throws IOException {
        byte[] bytes = new byte[longitud];
        archivo.readFully(bytes);
        return new String(bytes);
    }

    static void mostrarPantalla(Document archivo) {
        Source source = new DOMSource(archivo);
        Result salida = new StreamResult(System.out);
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, salida);
        } catch (TransformerException te) {
            System.out.println("Excepción del transformer.");
        }
    }

    static void generarArchivo(String nombre, Document archivo) {
        Source source = new DOMSource(archivo);
        Result salida = new StreamResult(new File(nombre));
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, salida);
        } catch (TransformerException te) {
            System.out.println("Excepción del transformer.");
        }
    }

    static void añadirNodo(String datoEmple, String texto, Element raíz, Document documento) {
        Element dato = documento.createElement(datoEmple);
        Text textoDato = documento.createTextNode(texto);
        dato.appendChild(textoDato);
        raíz.appendChild(dato);

    }

    static Element añadirNodo(String datoEmple, Element raíz, Document documento) {
        Element dato = documento.createElement(datoEmple);
        raíz.appendChild(dato);
        return dato;
    }

    static Element crearNodoPrincipal(String nombreNodo, Document documento) {
        Element nodoPrincipal = documento.createElement(nombreNodo);
        documento.getDocumentElement().appendChild(nodoPrincipal);
        return nodoPrincipal;
    }

    static Document inicializar(String nombre) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document archivo = (Document) implementation.createDocument(null, nombre, null);
        archivo.setXmlVersion("1.0");
        return archivo;
    }

    static void crearArchivoXML(Document archivo, String nombre) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(archivo), new StreamResult(new File(nombre)));
        } catch (Exception e) {
            System.out.println("Excepción al crear el archivo XML.");
        }
    }
}
