/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pruebatodaslascombinacionessqlite;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class PruebaTodasLasCombinacionesSQLite {

    private static Connection conexion;
    private static DatabaseMetaData db;

    public static void main(String[] args) throws SQLException {
        establecerConexionSQLite();
        db = conexion.getMetaData();

        mostrarColumnaPrimaryKey();

        conexion.close();
    }

    private static void establecerConexionSQLite() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\javie\\Desktop\\mydb.db");
            System.out.println("Conexion establecida");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Conexion rechazada");
            System.out.println(ex);
        }
    }

    private static void crearTablaEstudiantes() {

        try {
            String sql = "CREATE TABLE \"estudiantes\" (\n"
                    + "	\"id\"	INTEGER,\n"
                    + "	\"nombre\"	TEXT,\n"
                    + "	\"edad\"	INTEGER,\n"
                    + "	\"curso\"	TEXT,\n"
                    + "	\"calificacion\"	NUMERIC\n"
                    + ")";

            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(PruebaTodasLasCombinacionesSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void insertarEstudiantePrepared() throws SQLException {
        String sql = "INSERT INTO estudiantes VALUES (?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, 1);
        ps.setString(2, "Paco");
        ps.setInt(3, 24);
        ps.setString(4, "DAM2");
        ps.setDouble(5, 7.45);

        ps.execute();
    }

    private static void insertarEstudianteSinPrepared(int id, String nombre) throws SQLException {
        String sql = "INSERT INTO estudiantes (id,nombre) VALUES (" + id + ",'" + nombre + "')";
        Statement statement = conexion.createStatement();
        statement.execute(sql);
    }

    private static void actualizarEstudiante() throws SQLException {
        String sql = "UPDATE estudiantes SET edad = ?, curso = ?, calificacion = ? WHERE id = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, 20);
        ps.setString(2, "DAM1-t");
        ps.setDouble(3, 4.5);
        ps.setInt(4, 2);
        ps.execute();
        ps.close();
    }

    private static void eliminarEstudiante(int id) throws SQLException {
        String sql = "DELETE FROM estudiantes WHERE id=" + id;
        Statement statement = conexion.createStatement();
        statement.execute(sql);
    }

    private static void mostrarColumnaPrimaryKey() throws SQLException {
        ResultSet rs = db.getPrimaryKeys(null, null, "estudiantes");

        System.out.println("Columna que forma parte de la clave primaria en la tabla Estudiantes:");

        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            System.out.println(" - " + columnName);
        }

        rs.close();
    }

    private static double llamarProcedimiento() throws SQLException {
        String sql = "{call ActualizarSalario(?,?)}";
        CallableStatement cs = conexion.prepareCall(sql);

        cs.setInt(1, 10);
        cs.registerOutParameter(2, Types.DECIMAL);

        cs.execute();

        return cs.getDouble(2);
    }

    private static double llamarFuncion() throws SQLException {
        String sql = "{? = call CalcularBonificacion(?,?)}";
        CallableStatement cs = conexion.prepareCall(sql);
        
        cs.registerOutParameter(1, Types.DECIMAL);
        cs.setInt(2, 3);
        cs.setInt(3, 5);
        
        cs.execute();
        
        cs.close();
        return cs.getDouble(1);
    }

}
