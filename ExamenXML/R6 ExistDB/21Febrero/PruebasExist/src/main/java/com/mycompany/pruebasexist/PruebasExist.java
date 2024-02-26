/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebasexist;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

/**
 *
 * @author b15-07m
 */
public class PruebasExist {
    
    // Variables para la conexión
    public static XQDataSource server;
    public static XQConnection conexion;

    public static void main(String[] args) {
        try{
           establecerConexion(); 
            
           
           // APUNTES RÁPIDOS:
           // CONSULTA: XQPreparedExpression consulta = conexion.prepareExpression(String con la consulta);
           //           XQResultSequence resultado = consulta.executeQuery();
           //           XQResultItem item;
           //           while (resultado.next()) { item = (XQResultItem)resultado.getItem(); item.getItemAsString(null); } y resultado.close();
           // REESCRITURA:  XQExpression expresion = conexion.createExpression();
           //               expresion.executeCommand(String con la expresión de reescritura);
           // POSIBILIDADES DE REESCRITURA:
           // 1.- Insertar nodo: update insert (nodo hijo completo) into (nodo padre)
           // 2.- Borrar nodo: update delete (nodo hijo, con filtros, no hace falta indicar que se borre todo lo que contenga)
           // 3.- Renombrar etiqueta de nodo: update rename (nodo) as (nuevo nombre para el nodo)
           // 4.- Actualizar valor de nodo: update value (nodo cuyo valor se quiere actualizar) with (valor de actualización, entre comillas si es String)
           // 5.- Reemplazar nodo completo: update replace (nodo a sustituir, filtrando y eso) with (nuevo nodo completo que lo reemplazará)
           
           
           //ejemploConsulta();
           //ejemploInsert();
           //ejemploRename();
           //ejemploValue();
           //ejemploReplace();
           //ejemploBorrar();
            
           conexion.close();
        } catch (XQException xqe) {
            System.out.println(xqe);
        }
    }
    
    public static void establecerConexion() throws XQException {
        server = new ExistXQDataSource();
        
        server.setProperty("serverName", "localhost");
        server.setProperty("port", "8080");
        server.setProperty("user", "dam2");
        server.setProperty("password", "dam2");
        
        conexion = server.getConnection();
        System.out.println("Conexión establecida.");
    }
    
    public static void ejemploConsulta() throws XQException {
        XQPreparedExpression consulta = conexion.prepareExpression("/departamentos/DEP_ROW/DNOMBRE");
        XQResultSequence resultado = consulta.executeQuery();
        XQResultItem item;
        
        while (resultado.next()) {
            item = (XQResultItem) resultado.getItem();
            System.out.println(item.getItemAsString(null));
        }
        
        resultado.close();
    }
    
    public static void ejemploInsert() throws XQException {
        XQExpression expresion = conexion.createExpression();
        expresion.executeCommand("update insert <DEP_ROW><DEPT_NO>77</DEPT_NO><DNOMBRE>Ejemplillo</DNOMBRE><LOC>Ejemplillín</LOC></DEP_ROW> into /departamentos");
        System.out.println("Departamento insertado correctamente.");
    }
    
    public static void ejemploRename() throws XQException {
        XQExpression expresion = conexion.createExpression();
        expresion.executeCommand("update rename /departamentos/DEP_ROW[DEPT_NO=77]/DNOMBRE as 'NOMBREJEMPLO'");
        System.out.println("Nodo renombrado.");
    }
    
    public static void ejemploValue() throws XQException {
        XQExpression expresion = conexion.createExpression();
        expresion.executeCommand("update value /departamentos/DEP_ROW[DEPT_NO=77]/NOMBREJEMPLO with 'DEPARTAMENTOOOOOOOO'");
        System.out.println("Valor actualizado.");
    }
    
    public static void ejemploReplace() throws XQException {
        XQExpression expresion = conexion.createExpression();
        expresion.executeCommand("update replace /departamentos/DEP_ROW[DEPT_NO=77]/NOMBREJEMPLO with <DNOMBRE>Departamento con un nombre muy serio.</DNOMBRE>");
        System.out.println("Nodo reemplazado.");
    }
    
    public static void ejemploBorrar() throws XQException {
        XQExpression expresion = conexion.createExpression();
        expresion.executeCommand("update delete /departamentos/DEP_ROW[DEPT_NO=77]");
        System.out.println("Nodo borrado.");
    }
}
