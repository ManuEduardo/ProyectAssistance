package org.proyect.Modelos;

import org.proyect.Controladores.BaseDatos.Operaciones;

import java.util.ArrayList;

public class InstanciaEmpleadosAsistencias {
    public static InstanciaEmpleadosAsistencias SingletonInstance = null;

    private ArrayList<Atributo> listaEmpleadosArrayList;
    private ArrayList<Atributo> listaAsistenciasArrayList;

    public ArrayList<Atributo> getEmpleados(){
        return listaEmpleadosArrayList;
    }
    public ArrayList<Atributo> getAsistencias(){
        return listaAsistenciasArrayList;
    }

    public void actualizarListaEmpleados(ArrayList<Atributo> arrayList){
        this.listaEmpleadosArrayList = new ArrayList<>(arrayList);
    }
    public void actualizarListaAsistencias(ArrayList<Atributo> arrayList){
        this.listaAsistenciasArrayList = new ArrayList<>(arrayList);
        this.listaAsistenciasArrayList = Operaciones.generarAsistencias();
    }

    private InstanciaEmpleadosAsistencias() {
        //lista empleados
        listaEmpleadosArrayList = Operaciones.generarEmpleados();
        //lista asistencias
        listaAsistenciasArrayList = Operaciones.generarAsistencias();
    }

    public static InstanciaEmpleadosAsistencias singletonGenerador(){
        if(SingletonInstance == null){
            SingletonInstance = new InstanciaEmpleadosAsistencias();
        }
        return SingletonInstance;
    }
}
