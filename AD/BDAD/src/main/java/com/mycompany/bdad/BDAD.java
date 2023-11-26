package com.mycompany.bdad;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BDAD {

    static String driver;
    static Connection conexion;
    static DatabaseMetaData dbmd;

    public static void main(String[] args) {
        try {
            establecerConexion();
            dbmd = conexion.getMetaData();
            
            System.out.println("\nTablas y vistas del esquema:");

            File3SelectSQLite();
            
            conexion.close();

        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe);
        }
    }

    private static void establecerConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\javie\\Desktop\\mydb.db");
        System.out.println("CONECTADO");
    }

    private static void executeNoSelect(String sql) throws SQLException {
        Statement statement = conexion.createStatement();
        statement.execute(sql);
    }

    private static ResultSet executeSelect(String sql) throws SQLException {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }

    private static void File2SelectSQLite(int departamento) throws SQLException {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT apellido, oficio, salario FROM empleados WHERE dept_no = "+ departamento +" GROUP BY emp_no ;");
        while(rs.next()){
            System.out.println("Departamento: " + departamento +":\nApellido: " + rs.getString(1) + "\nOficio: " + rs.getString(2) + "\nSalario: " + rs.getDouble(3));
            System.out.println();
        }
    }
    
    private static void File3SelectSQLite() throws SQLException {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT apellido, salario, dept_no FROM empleados WHERE salario=(SELECT MAX(salario) FROM empleados);");
        
        while(rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getInt(3));
            System.out.println();
        }    
    }
    
    
}
