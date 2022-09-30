package org.proyect.Controladores.Algoritmos.Busqueda;

import org.proyect.Modelos.Atributo;

import java.util.ArrayList;

public interface Buscar {
    int busqueda(ArrayList<Atributo> lista, String tipoObjetivo, String objetivo) throws Exception;
    //esta interfaz devolveria el numero de indice buscado
}
