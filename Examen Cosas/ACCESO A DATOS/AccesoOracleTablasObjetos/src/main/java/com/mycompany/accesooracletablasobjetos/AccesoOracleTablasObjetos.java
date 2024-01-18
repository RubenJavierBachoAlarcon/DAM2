/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesooracletablasobjetos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-07m
 */
public class AccesoOracleTablasObjetos {

    static String driver;
    static Connection conexion;
    
    // 05/12/2023
    // Desde Java, insertar objetos en tablas de objetos
    
    public static void main(String[] args) {
        try {
            establecerConexion();
            
            //insertar();
            //insertarPrepared();
            
            
            
            //miInsertSinPrepared();
            //miUpdateSinPrepared();
            //miDeleteSinPrepared();
            
            
            //miUpdateConPrepared();
            miDeleteConPrepared();
            
            
            conexion.close(); 
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private static void establecerConexion() throws ClassNotFoundException, SQLException {
        driver = "oracle.jdbc.driver.OracleDriver";
        String urlconnection = "jdbc:oracle:thin:@localhost:1521/ORCL18"; 
            
        Properties propiedades = new Properties();
        propiedades.setProperty("user", "dam2");
        propiedades.setProperty("password", "dam2");       
            
        Class.forName(driver);
        conexion = DriverManager.getConnection(urlconnection, propiedades); 
    }
    
    private static void insertar() {
        try {
            String sql = "INSERT INTO alumnos VALUES (new Persona2(3,'Antonio García',new Direccion('Toledo','Ciudad Real',13003),to_date('01/01/2024','dd/mm/yyyy')))";
            // Intentar hacer un insert de un objeto, sin andar haciendo los news en la String
            // (Investigarlo)
            Statement sentencia = conexion.createStatement();
            
            sentencia.executeUpdate(sql);
            sentencia.close();    
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    private static void insertarPrepared() {
        try {
            String sql = "INSERT INTO alumnos VALUES (new Persona2(?,?,new Direccion(?,?,?),?))";

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            sentencia.setInt(1,66);
            sentencia.setString(2, "Ana Gómez");
            sentencia.setString(3, "Calatrava");
            sentencia.setString(4, "Ciudad Real");
            sentencia.setInt(5, 13003);   

            // Orden: años-meses-días
            java.sql.Date fechaDate = Date.valueOf("2023-12-05");
            sentencia.setDate(6, fechaDate);
            
            
            
            sentencia.executeUpdate();
            sentencia.close();    
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private static void miInsertSinPrepared() throws SQLException {
        String sql = "insert into alumnos values(7, 'Jaimito', DIRECCION('mi calle','mi ciudad',13660), to_date('23/07/1995','dd/mm/yyyy'))";
        
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(sql);
        sentencia.close();
    }
    
    private static void miUpdateSinPrepared() throws SQLException {
        String sql = "update alumnos A set A.direc.ciudad='¡¡¡LAS LABORES!!!' where A.direc.calle='mi calle'";
        
        Statement sentencia = conexion.createStatement();
        int num = sentencia.executeUpdate(sql);
        System.out.println("Se han actualizado " + num + " líneas.");
        sentencia.close();
    }
    
    public static void miDeleteSinPrepared() throws SQLException {
        String sql = "delete from alumnos A where A.direc.calle='mi calle'";
        
        Statement sentencia = conexion.createStatement();
        int num = sentencia.executeUpdate(sql);
        System.out.println("Se han actualizado "+ num +" líneas.");
        sentencia.close();
    }
    
    public static void miUpdateConPrepared() throws SQLException {
        String sql = "update alumnos A set A.nombre=? where A.direc.calle=?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, "AAAAAAAAAAAAAAAA");
        sentencia.setString(2, "Toledo");
        
        int num = sentencia.executeUpdate();
        
        System.out.println("Se han actualizado "+ num +" filas.");
        
        sentencia.close();
    }
    
    public static void miDeleteConPrepared() throws SQLException {
        String sql = "delete from alumnos A where A.direc.calle=?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, "Toledo");
        int num = sentencia.executeUpdate();
        System.out.println("Se han borrado " + num + " líneas.");
        sentencia.close();
    }
}
