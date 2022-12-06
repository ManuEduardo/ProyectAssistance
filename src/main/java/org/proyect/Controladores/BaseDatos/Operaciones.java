package org.proyect.Controladores.BaseDatos;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operaciones {

    private static Connection acceso;
    private static PreparedStatement preState;
    private static ResultSet resultado;

    private static Conexion conexionLogin = new Conexion();

    public static boolean verificarUsuario(String dni, String contrasena){
        conexionLogin = new Conexion();
        int dniIngresado = Integer.parseInt(dni);
        String query = "select id, (select nombre from departamento D where D.id = E.id_departamento), contrasena from empleado E;";
        try{
            acceso = conexionLogin.makeConnection();
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


}
