/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoobjetosoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Properties;

/**
 *
 * @author b15-07m
 */
public class AccesoObjetosOracle {

    static String driver;
    static Connection conexion;
    
    public static void main(String[] args) {
        try {
            establecerConexion();
            
           ejemploConstulta();
           
            
            conexion.close();
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
    private static void ejemploConstulta() throws SQLException{
        Statement s = conexion.createStatement();
        s.executeQuery("insert into table (select direcciones from tabla_anidada_direcciones where id = 1) values (direccion('ejemplooooo', 'ejemplo2',123))");
        
        s.close();
    }
    
    
    private static void establecerConexion() throws ClassNotFoundException, SQLException {
        driver="oracle.jdbc.driver.OracleDriver";
        String urlconnection="jdbc:oracle:thin:@localhost:1521/ORCL18";
        
        Properties propiedades = new Properties();
        propiedades.setProperty("user", "dam2");
        propiedades.setProperty("password", "123");
        
        Class.forName(driver);
        conexion=DriverManager.getConnection(urlconnection, propiedades);
        System.out.println("Conectado a la BBDD.");
    }
    
    public static void miSelect() throws SQLException {
        String sql = "select pers, notaeva1, notaeva2, notaeva3 from alumnos2";
        
        Statement sentencia = conexion.createStatement();
        ResultSet resul = sentencia.executeQuery(sql);
        
        int nota1;
        int nota2;
        int nota3;
        String nombre;
        String ciudad;
        java.sql.Struct objeto;
        Object[] atributos;
        
        while (resul.next()) {
            objeto = (Struct)resul.getObject(1);
            atributos = objeto.getAttributes();
            nombre = (String) atributos[1];
            
            if (atributos[2] != null) {
                objeto = (java.sql.Struct) atributos[2];
                atributos = objeto.getAttributes();
                ciudad = (String) atributos[1];
            
                nota1 = resul.getInt(2);
                nota2 = resul.getInt(3);
                nota3 = resul.getInt(4);
            
                System.out.println("Nombre: "+nombre+". Ciudad: "+ciudad+". Notas: "+nota1+", "+nota2+", "+nota3);
            }
        }
        
        resul.close();
        sentencia.close();
    }
    
    public static void selectSinAlias() throws SQLException {
        String sql = "select A.pers.nombre, A.notaeva1 from alumnos2 A";
        
        Statement sentencia = conexion.createStatement();
        ResultSet resul = sentencia.executeQuery(sql);
        
        while (resul.next()) {
            System.out.println("Nombre: "+ resul.getString(1) +". Nota eva 1: " + resul.getInt(2));
        }
        
        resul.close();
        sentencia.close();
    }
}
