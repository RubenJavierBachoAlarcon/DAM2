/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.parser;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-06m
 */
public class Parser {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");
            Element raiz = document.createElement("empleado");
            document.getDocumentElement().appendChild(raiz);
            Element elem = document.createElement("id");
            raiz.appendChild(elem);
            Text text = document.createTextNode("1");
            raiz.appendChild(elem);
            elem.appendChild(text);
            Parser.CrearNodo("asd", "5", raiz, document);
            Source source = new DOMSource(document);
            Result salida = new StreamResult(new File("Empleados.xml"));
        } catch (Exception ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void CrearNodo(String datoEmple, String valor, Element raiz, Document document) {

        Element elem = document.createElement(datoEmple); //creamos el hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor al elemento

    }
}
