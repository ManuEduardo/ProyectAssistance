package org.proyect.Controladores.BaseDatos;

import org.proyect.Modelos.Asistencia;
import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class Operaciones {

    private static Connection acceso;
    private static PreparedStatement preState;
    private static ResultSet resultado;

    private static Conexion conexion;

    public static boolean verificarUsuario(String dni, String contrasena){
        conexion = new Conexion();
        int dniIngresado = Integer.parseInt(dni);
        String query = "select id, (select nombre from departamento D where D.id = E.id_departamento), contrasena from empleado E;";
        try{
            acceso = conexion.makeConnection();
            preState = acceso.prepareStatement(query);
            resultado = preState.executeQuery();
            while(resultado.next()){
                if(resultado.getInt(1)==dniIngresado &&
                        resultado.getString(3).equals(contrasena)){

                    if(resultado.getString(2).equals("RR.HH")) return true;
                    javax.swing.JOptionPane.showMessageDialog(null,"No tiene permisos para inicar la Aplicación");
                    return false;
                }
            }
            javax.swing.JOptionPane.showMessageDialog(null,"Usuario o contraseña Incorrecto");
        }catch(Exception e){
            System.out.println("error: "+e);
            return false;
        }
        return false;
    }

    public static ArrayList<Atributo> generarEmpleados(){
        ArrayList<Atributo> listaEmpleados = new ArrayList<>();

        conexion = new Conexion();
        String query = "select id, (select nombre from departamento D where D.id = E.id_departamento), nombre, email, contrasena from empleado E;";
        try{
            acceso = conexion.makeConnection();
            preState = acceso.prepareStatement(query);
            resultado = preState.executeQuery();
            while(resultado.next()){
                int id = resultado.getInt(1);
                String departamento = resultado.getString(2);
                String nombre = resultado.getString(3);
                String email = resultado.getString(4);
                String contrasena = resultado.getString(4);
                Empleado empleado = new Empleado(id, nombre, email, contrasena, departamento);
                listaEmpleados.add(empleado);
            }
        }catch(Exception e){
            System.out.println("error: "+e);
        }
        return listaEmpleados;
    }

    public static ArrayList<Atributo> generarAsistencias(){
        ArrayList<Atributo> listarAsistencias = new ArrayList<>();

        conexion = new Conexion();
        String query = "select id, (select nombre from empleado E where E.id = A.id_empleado), fecha from asistencia A;";
        try{
            acceso = conexion.makeConnection();
            preState = acceso.prepareStatement(query);
            resultado = preState.executeQuery();
            while(resultado.next()){
                int id = resultado.getInt(1);
                String nombreEmpleado = resultado.getString(2);
                Date fecha = resultado.getDate(3);
                Asistencia asistencia = new Asistencia(id, nombreEmpleado, fecha);
                listarAsistencias.add(asistencia);
            }
        }catch(Exception e){
            System.out.println("error: "+e);
        }
        return listarAsistencias;
    }

}
