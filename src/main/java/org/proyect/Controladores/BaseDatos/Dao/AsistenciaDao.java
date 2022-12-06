package org.proyect.Controladores.BaseDatos.Dao;

import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.LinkedList;

public class AsistenciaDao implements Create{
    // Creas el generador usando patron singleton
    GenerarEmpleadosAsistencias generador = GenerarEmpleadosAsistencias.singletonGenerador();
    // crea lista
    LinkedList<Atributo> lista = new LinkedList<>(generador.generarAsistencias());
    @Override
    public void create(Atributo atributo) {
        lista.add(atributo);
        ArrayList<Atributo> listaNueva = new ArrayList<>(lista);
        // Actualiza la lista
        generador.actualizarListaAsistencias(listaNueva);
    }
}
