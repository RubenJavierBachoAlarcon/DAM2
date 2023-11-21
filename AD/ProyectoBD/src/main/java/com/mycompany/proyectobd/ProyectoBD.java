/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectobd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-06m
 */
public class ProyectoBD {

    static String driver;
    static Connection conection;
    static DatabaseMetaData dbmd;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conexion = null;

        try {
            // Cargar el controlador JDBC
            Class.forName("org.sqlite.JDBC");

            // Establecer la conexión a la base de datos
            String url = "jdbc:sqlite:C:/Users/b15-06m/Desktop/ejemplo.db";
            conexion = DriverManager.getConnection(url);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos");
                
                // Puedes realizar operaciones con la base de datos aquí
                
                // Cerrar la conexión cuando hayas terminado
                conexion.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Asegúrate de cerrar la conexión en caso de error
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void establecerConexion() {
        try {
            driver = "oracle.jdbc.driver.OracleDriver";
            String urlconnection = "jdbc:oracle:thin:@localhost/ORCL18";

            Properties propiedades = new Properties();
            propiedades.setProperty("user", "C##Dam2");
            propiedades.setProperty("password", "123");
            conection = DriverManager.getConnection(urlconnection, propiedades);
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void consultaSencilla() throws SQLException {
        String sql = "Select * from departamentos";
        Statement sentencia = conection.createStatement();
        ResultSet resul = sentencia.executeQuery(sql);

        while (resul.next()) {
            System.out.println("Departamento: " + resul.getInt(1) + " "
                    + "Nombre: " + resul.getString(2) + " "
                    + "Localidad: " + resul.getString(3));
        }
    }

    private static void consultaExecute() throws SQLException {
        String sql = "Select * from departamentes";
        Statement sentencia = conection.createStatement();
        Boolean valor = sentencia.execute(sql);
        ResultSet resul = sentencia.executeQuery(sql);
        if (valor) {
            while (resul.next()) {
                System.out.println("Departamento: " + resul.getInt(1) + " "
                        + "Nombre: " + resul.getString(2) + " "
                        + "Localidad: " + resul.getString(3));
            }
        }

    }

    private static void consultaPrepared() throws SQLException {
        String sql = "Select * from departamentos";
        PreparedStatement sentencia = conection.prepareStatement(sql);

        int filas = sentencia.executeUpdate();

        if (filas > 0) {
            ResultSet resul = sentencia.getResultSet();
            while (resul.next()) {
                System.out.println("Departamento: " + resul.getInt(1) + " "
                        + "Nombre: " + resul.getString(2) + " "
                        + "Localidad: " + resul.getString(3));
            }
            resul.close();
        }
        sentencia.close();
    }

    private static void insertarExecuteUpdate() throws SQLException {
        int dep = 4;
        String nombre = "Suministros";
        String localidad = "Sevilla";

        String sql = "insert into departamentos values (" + dep + ",'" + nombre + "','" + localidad + "')";

        Statement sentencia = conection.createStatement();
        int filas = sentencia.executeUpdate(sql);

        sentencia.close();

    }

    private static void insertarExecute() throws SQLException {
        int dep = 5;
        String nombre = "Exportación";
        String localidad = "Bilvao";

        String sql = "insert into departamentos values (" + dep + ",'" + nombre + "','" + localidad + "')";

        Statement sentencia = conection.createStatement();

        Boolean valor = sentencia.execute(sql);

        if (!valor) {
            int filas = sentencia.getUpdateCount();
            System.out.println("Se han insertado " + filas + " filas");
        }

        sentencia.close();

    }

    private static void insertarPrepared() throws SQLException {
        int dep = 6;
        String nombre = "Importación";
        String localidad = "Vigo";

        String sql = "insert into departamentos values (?,?,?)";

        PreparedStatement sentencia = conection.prepareStatement(sql);

        sentencia.setInt(1, dep);
        sentencia.setString(2, nombre);
        sentencia.setString(3, localidad);

        int filas = sentencia.executeUpdate();

        if (filas > 0) {
            System.out.println("Se han insertado " + filas + " filas");
        }

        sentencia.close();
    }

    private static void añadirCampo() throws SQLException {
        String sql = "alter table departamentos add (tlfn number(9))";
        Statement sentencia = conection.createStatement();

        int filas = sentencia.executeUpdate(sql);

    }

    private static void ejecutarProcedimiento() throws SQLException {
        String sql = "{call nombre_depart_p (?,?)}";

        CallableStatement llamada = conection.prepareCall(sql);

        int dep = 1;
        llamada.setInt(1, dep);

        llamada.registerOutParameter(2, Types.VARCHAR);

        llamada.executeUpdate();

        String returnSql = llamada.getString(2);

        System.out.println("El nombre del departamento es: " + returnSql);
    }

    private static void ejecutarFuncion(int dept) throws SQLException {
        String sql = "{call nombre_depart_p (?,?)}";

        CallableStatement llamada = conection.prepareCall(sql);

        llamada.registerOutParameter(1, Types.VARCHAR);

        llamada.setInt(2, dept);

        llamada.executeUpdate();

        String salida_return = llamada.getString(1);

        System.out.println("El nombre del departamento es " + salida_return);

    }

    private static void obtenerInformacionConexion() throws SQLException {
        String nombre = dbmd.getDatabaseProductName();

        String driver = dbmd.getDriverName();

        String url = dbmd.getURL();

        String usuario = dbmd.getUserName();

        System.out.println("Nombre del SGBDL: " + nombre);
        System.out.println("Nombre del Driver: " + driver);
        System.out.println("Nombre del Url: " + url);
        System.out.println("Nombre del usuario " + usuario);
    }

    private static void obtenerInformacionTablas() throws SQLException {
        ResultSet resul = null;
        String[] tipos = {"TABLE"};
        String nombre_usuario = "";
        String nombre_tabla = "";

        resul = dbmd.getTables("ORCL18", "DAM2_P6", null, tipos);

        while (resul.next()) {
            nombre_usuario = resul.getString("TABLE_SCHEM");
            nombre_tabla = resul.getString("TABLE_NAME");

            System.out.println("Nombre de Usuario: " + nombre_usuario);
            System.out.println("Nombre de Tabla: " + nombre_tabla);
        }
    }

    private static void obtenerInformacionColumnas() throws SQLException {
        ResultSet resul = dbmd.getTables("ORCL18", "DAM2_P6", "DEPARTAMENTOS", null);

        String nombre_tabla = "";
        String nombre_columna = "";
        
        while (resul.next()) {
            nombre_tabla = resul.getString("TABLE_NAME");
            nombre_columna = resul.getString("COLUMN_NAME");

            System.out.println("Nombre de Tabla: " + nombre_tabla);
            System.out.println("Nombre de Usuario: " + nombre_columna);
        }

    }

}
