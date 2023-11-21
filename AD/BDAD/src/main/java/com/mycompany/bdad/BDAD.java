package com.mycompany.bdad;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class BDAD {

    static String driver;
    static Connection conexion;
    static DatabaseMetaData dbmd;

    public static void main(String[] args) {
        try {
            establecerConexion();
            dbmd = conexion.getMetaData();

            String sql = "CREATE TABLE \"departamentos\" (\n" +
"	\"dept_no\"	INTEGER NOT NULL,\n" +
"	\"dnombre\"	TEXT,\n" +
"	\"loc\"	TEXT,\n" +
"	PRIMARY KEY(\"dept_no\")\n" +
");";
            
            conexion.close();

        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe);
        }
    }

    private static void establecerConexion() throws ClassNotFoundException, SQLException {
        driver = "org.sqlite.JDBC";
        String urlconnection = "jdbc:sqlite:C:\\Users\\javie\\Desktop\\mydb.db";

        Properties propiedades = new Properties();

        Class.forName(driver);
        conexion = DriverManager.getConnection(urlconnection, propiedades);
        System.out.println("CONECTADO");
    }
}
