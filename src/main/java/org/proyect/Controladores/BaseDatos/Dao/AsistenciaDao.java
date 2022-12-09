package org.proyect.Controladores.BaseDatos.Dao;

import org.proyect.Controladores.BaseDatos.Conexion;
import org.proyect.Modelos.InstanciaEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;

public class AsistenciaDao implements Create{
    private Connection acceso;
    private PreparedStatement preState;

    // Creas el generador usando patron singleton
    InstanciaEmpleadosAsistencias generador = InstanciaEmpleadosAsistencias.singletonGenerador();
    // crea lista
    LinkedList<Atributo> lista = new LinkedList<>(generador.getAsistencias());
    @Override
    public void create(Atributo atributo) {

        if(agregrAsistenciasBD(atributo)){
            lista.add(atributo);
            ArrayList<Atributo> listaNueva = new ArrayList<>(lista);
            // Actualiza la lista
            generador.actualizarListaAsistencias(listaNueva);
            javax.swing.JOptionPane.showMessageDialog(null,"Asistencia Registrada");
        }else{
            javax.swing.JOptionPane.showMessageDialog(null  ,"Error al Registrar Asistencia");
        }
    }

    private boolean agregrAsistenciasBD(Atributo asistencia){
        Conexion conexionAsistencia = new Conexion();
        String query = "insert into asistencia(id_empleado, fecha, hora) values(?, ?, ?);";
        try{
            acceso = conexionAsistencia.makeConnection();//se conecta
            preState = acceso.prepareStatement(query);//la coneccion se le carga la consulta
            Date sqlFecha = new java.sql.Date(((java.util.Date)asistencia.ObtenerAtributo("fecha")).getTime());
            preState.setInt(1, (Integer) asistencia.ObtenerAtributo("idEmpleado"));
            preState.setDate(2, sqlFecha);
            preState.setString(3, String.valueOf(asistencia.ObtenerAtributo("horaformateada")));
            preState.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("error: "+e);
            return false;
        }
    }
}
