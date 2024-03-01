/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.xmlexist;
// METER LOS IMPORTS: PDF DE ACCESO A JAVA.
// VAN A DAR ERROR TODOS.

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

// ME ABRO LAS DEPENDENCIAS DEL POM Y A METER COSAS. 
/**
 *
 * @author b15-07m
 */
public class Xmlexist {
    
    // Variables para la conexión
    public static XQDataSource server;
    public static XQConnection con;
    
    // Variables para la consulta
    public static XQPreparedExpression consulta;
    public static XQResultSequence resultado;
    
    // Variables para modiciaciones
    public static XQExpression expresion;
    
    // PARA CREARME UN USUARIO EN EL EXIDE:
    // 1.- Entro en localhost:8080
    // 2.- Hago login con admin
    // 3.- Me voy al User Manager
    // 4.- Groups, le doy al +, "aplicacion", "Grupo para la aplicación de Java", de primeras da error, si le doy otra vez ya funciona
    // 5.- Me voy a users, le doy al +, nombre de usuario dam2, contraseña dam2, grupo elijo aplicacion, el resto lo dejo vacío
    // 6.- Me voy al launcher y al exide, tengo que estar logeado como admin, File > Manage > Carpeta nueva, colección dam2java
    // 7.- Tras crearla la selecciono, le doy a properties (la i), le cambio el owner y el group 
    // 8.- Le doy a logged as admin para desloggear, le doy otra vez, entro con dam2 y dam2
    // 9.- File > Manage > selecciono la carpeta recién creada ENTRO DENTRO DE LLA y le doy a subir (la nubecilla), le subo los archivos de ColeccionPruebas
    // Owner y Group tienen que ser dam2 y aplicacion.
    // 10.- New XQuery para hacer pruebas. Tras eso, me vuelvo a Java.
    

    public static void main(String[] args) {
        server = new ExistXQDataSource();
        try {
            server.setProperty("serverName", "localhost");
            server.setProperty("port", "8080");
            // hemos estado accediendo con el usuario admin, pero nos vamos a crear uno
            server.setProperty("user", "dam2");
            server.setProperty("password", "dam2");
            
            con = server.getConnection();
            
            ////////////////////////////////////////
            
            // Consulta
            consulta = con.prepareExpression("/EMPLEADOS");
            resultado = consulta.executeQuery();
            
            XQResultItem r_item;
            while (resultado.next()) {
                r_item = (XQResultItem) resultado.getItem();
                System.out.println(r_item.getItemAsString(null));
            }
            
            
            // Modificación: renombrar un nodo
            // Reemplazar un nodo, el contenido del nodo, etc, TODO LO QUE IMPLIQUE REESCRIBIR ALGO DEL XML, se hace igual
            expresion = con.createExpression();
            expresion.executeCommand("update rename /EMPLEADOS/fila_emple as 'fila_empleAAAAAAAAA'");
            
            
            
            con.close();
        } catch (XQException ex) {
            System.out.println(ex);
        }
    }
}
