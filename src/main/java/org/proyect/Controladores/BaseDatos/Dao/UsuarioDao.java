package org.proyect.Controladores.BaseDatos.Dao;

import org.proyect.Controladores.BaseDatos.Create;
import org.proyect.Controladores.BaseDatos.Delete;
import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;

import java.util.ArrayList;
import java.util.LinkedList;

public class UsuarioDao implements Create, Delete {
    GenerarEmpleadosAsistencias generador = GenerarEmpleadosAsistencias.singletonGenerador();
    LinkedList<Atributo> lista = new LinkedList<>(generador.generarEmpleados());
    @Override
    public void create(Atributo atributo) {
        lista.add(atributo);
        ArrayList<Atributo> listaNueva = new ArrayList<>(lista);
        generador.actualizarListaEmpleados(listaNueva);
    }
}
