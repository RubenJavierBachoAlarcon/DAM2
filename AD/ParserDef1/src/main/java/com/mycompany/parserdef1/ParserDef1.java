package com.mycompany.parserdef1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.IntStream.builder;
import static java.util.stream.LongStream.builder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author pokem
 */
public class ParserDef1 {

    public static void main(String[] args) throws SAXException, IOException {

        try {
            Document archivoEmpleados = inicializar("Empleados");

            Element nodo = crearNodoPrincipal("Empleado", archivoEmpleados);
            // nodo = añadirNodo("Empleado", nodo, archivoEmpleados);
            añadirNodo("id", "1", nodo, archivoEmpleados);

            nodo = añadirNodo("direccion", nodo, archivoEmpleados);

            añadirNodo("calle", "Toledo", nodo, archivoEmpleados);
            añadirNodo("numero", "33", nodo, archivoEmpleados);

            mostrarPantalla(archivoEmpleados);
            generarArchivo(archivoEmpleados, "Empleados.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Empleados.xml"));
            document.getDocumentElement().normalize();
            String rootElementName = document.getDocumentElement().getNodeName();
            System.out.println("");
            System.out.println("Nombre del elemento raíz: " + rootElementName);

            NodeList empleados = document.getElementsByTagName("Empleado");
            for (int i = 0; i < empleados.getLength(); i++) {

                Node emple = empleados.item(i);
                Element elemento = (Element) emple;
                NodeList nodo1 = elemento.getElementsByTagName("id").item(0).getChildNodes();
                Node valornodo = (Node) nodo1.item(0);
                System.out.println(valornodo.getNodeValue());
                elemento.getElementsByTagName("id").item(0).getTextContent();
            }
            
          

        } catch (ParserConfigurationException pce) {
            System.out.println("Excepción.");
        }
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

    static void generarArchivo(Document archivo, String nombre) {
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
