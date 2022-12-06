package org.proyect.Controladores.BaseDatos.Dao;

import org.proyect.Controladores.BaseDatos.Conexion;
import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class UsuarioDao implements Create{
    GenerarEmpleadosAsistencias generador = GenerarEmpleadosAsistencias.singletonGenerador();
    LinkedList<Atributo> lista = new LinkedList<>(generador.generarEmpleados());

    private Conexion conexionUsuario = new Conexion();
    private Connection acceso;
    private PreparedStatement preState;
    private ResultSet resultado;

    @Override
    public void create(Atributo atributo) {
        if (agregarUsuarioBD(atributo)){
            lista.add(atributo);
            ArrayList<Atributo> listaNueva = new ArrayList<>(lista);
            generador.actualizarListaEmpleados(listaNueva);
            javax.swing.JOptionPane.showMessageDialog(null,"Usuario Creado");
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Error al Crear Usuario");
        }
    }
    private boolean agregarUsuarioBD(Atributo usuario) {
        Conexion conexionUsuario = new Conexion();
        String query = "insert into empleado values(?, ?, ?, ?, ?)";
        try{
            acceso = conexionUsuario.makeConnection();//se conecta
            preState = acceso.prepareStatement(query);//la coneccion se le carga la consulta
            preState.setInt(1, (Integer) usuario.ObtenerAtributo("id"));
            preState.setInt(2, devolverDepartamento((String) usuario.ObtenerAtributo("departamento")));
            preState.setString(3, (String) usuario.ObtenerAtributo("nombre"));
            preState.setString(4, (String) usuario.ObtenerAtributo("email"));
            preState.setString(5, (String) usuario.ObtenerAtributo("contrasena"));
            preState.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("error: "+e);
            return false;
        }
    }

    private int devolverDepartamento(String nombreDepartamento){
        return switch (nombreDepartamento) {
            case "Marketing" -> 1;
            case "Ventas" -> 2;
            case "Logistica" -> 3;
            case "Tic" -> 4;
            case "RR.HH" -> 6;
            case "Contabilidad" -> 7;
            case "Control Interno" -> 8;
            default -> 1;
        };
    }
}
