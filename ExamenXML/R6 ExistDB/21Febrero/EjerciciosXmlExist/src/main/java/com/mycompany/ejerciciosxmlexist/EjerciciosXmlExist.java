/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciosxmlexist;

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
 * @author pokem
 */
public class EjerciciosXmlExist {

    
    // Variables para la conexión
    public static XQDataSource server;
    public static XQConnection con;
    
    
    public static void main(String[] args) {
        try {
            
            establecerConexion();
            
            //consultaPrueba();
            
            // APARTADO 1:
            //insertarEmpleado();
            //actualizarSalario();
            //visualizarEmpleados("IFC1");
            
            
            // APARTADO 2:
            //insertdep(60, "LAVADO DE DINERO", "VALDEPEÑAS");
            //borradep(50);
            //modificadep(10, "NOMBRE DE PRUEBA", "LOC DE PRUEBA");
            
            
            // APARTADO 3: HECHO EN CLASE
            
            
            // APARTADO 4:
            
            
            con.close();
            
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
            
        con = server.getConnection();
        System.out.println("Conexión establecida.");
    }
    
    
    public static void consultaPrueba() throws XQException {
        XQPreparedExpression consulta = con.prepareExpression("/EMPLEADOS/EMP_ROW");
        
        XQResultSequence resultado = consulta.executeQuery();
        XQResultItem item;
        String xml;
        
        while (resultado.next()) {
            item = (XQResultItem) resultado.getItem();
            xml = item.getItemAsString(null);
            System.out.println(xml);
        }
    }
    
    
    public static void insertarEmpleado() throws XQException {
        XQExpression expresion = con.createExpression();
        expresion.executeCommand("update insert <empleado salario=\"2340\"><puesto>Técnico</puesto><nombre>Pedro Fraile</nombre></empleado> into /universidad/departamento[2]");
    }
    
    public static void actualizarSalario() throws XQException {
        XQExpression expresion= con.createExpression();
        expresion.executeCommand("for $em in /universidad/departamento[codigo='MAT1']/empleado"
                + " let $sal := data($em/@salario) return update value $em/@salario with data($sal)+100");
    }
    
    public static void visualizarEmpleados(String codigo) throws XQException {
        XQPreparedExpression consulta = con.prepareExpression("/universidad/departamento[codigo='" + codigo + "']/empleado");
        XQResultSequence resultadoPrueba = consulta.executeQuery();
        XQResultSequence resultado = consulta.executeQuery();
        XQResultItem item;
        
        if (resultadoPrueba.next()) {
            while (resultado.next()) {
                item = (XQResultItem) resultado.getItem();
                System.out.println(item.getItemAsString(null));
            }
        } else {
            System.out.println("El departamento introducido no existe.");
        }
    }
    
    public static void insertdep(int depno, String nombre, String localidad) throws XQException {
        String depnoStr = String.valueOf(depno);
        
        XQPreparedExpression consulta = con.prepareExpression("/departamentos/DEP_ROW[DEPT_NO=" + depnoStr + "]");
        XQResultSequence resultado = consulta.executeQuery();
        XQResultItem item;
        
        if (resultado.next()) {
            System.out.println("El departamento introducido ya existe en la base de datos.");
        } else {
            XQExpression expresion = con.createExpression();
            expresion.executeCommand("update insert <DEP_ROW><DEPT_NO>" +depnoStr+ "</DEPT_NO><DNOMBRE>" +nombre+ "</DNOMBRE><LOC>" +localidad+ "</LOC></DEP_ROW> into /departamentos");
            System.out.println("Departamento correctamente insertado.");
        }
    }
    
    public static void borradep(int depno) throws XQException {
        String depnoStr = String.valueOf(depno);
        
        XQPreparedExpression consulta = con.prepareExpression("/departamentos/DEP_ROW[DEPT_NO="+depnoStr+"]");
        XQResultSequence resultado = consulta.executeQuery();
        
        if (resultado.next()) {
            XQExpression expresion = con.createExpression();
            expresion.executeCommand("update delete /departamentos/DEP_ROW[DEPT_NO="+depnoStr+"]");
            System.out.println("Departamento borrado correctamente.");
        } else {
            System.out.println("No existe el departamento indicado.");
        }
    }
    
    public static void modificadep(int depno, String nombreNuevo, String locNueva) throws XQException {
        String depnoStr = String.valueOf(depno);
        
        XQPreparedExpression consulta = con.prepareExpression("/departamentos/DEP_ROW[DEPT_NO="+depnoStr+"]");
        XQResultSequence resultado = consulta.executeQuery();
        
        if (resultado.next()) {
            XQExpression expresion1 = con.createExpression();
            expresion1.executeCommand("update value /departamentos/DEP_ROW[DEPT_NO="+depnoStr+"]/DNOMBRE with '"+nombreNuevo+"'");
            
            XQExpression expresion2 = con.createExpression();
            expresion2.executeCommand("update value /departamentos/DEP_ROW[DEPT_NO="+depnoStr+"]/LOC with '"+locNueva+"'");
            
            System.out.println("Departamento modificado correctamente.");
        } else {
            System.out.println("No es posible modificar el departamento indicado; dicho departamento no existe.");
        }
    }
}
