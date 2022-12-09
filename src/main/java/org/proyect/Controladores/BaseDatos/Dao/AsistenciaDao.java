package org.proyect.Controladores.BaseDatos.Dao;

import org.proyect.Modelos.InstanciaEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.LinkedList;

public class AsistenciaDao implements Create{
    // Creas el generador usando patron singleton
    InstanciaEmpleadosAsistencias generador = InstanciaEmpleadosAsistencias.singletonGenerador();
    // crea lista
    LinkedList<Atributo> lista = new LinkedList<>(generador.getAsistencias());
    @Override
    public void create(Atributo atributo) {
        lista.add(atributo);
        ArrayList<Atributo> listaNueva = new ArrayList<>(lista);
        // Actualiza la lista
        generador.actualizarListaAsistencias(listaNueva);
    }
}
