package org.proyect.Controladores.Algoritmos.Busqueda;

import org.proyect.Modelos.Atributo;

import java.util.ArrayList;

public class FactorySearch {
    private Buscar devolverAlgoritmoBusqueda(String algoritmo){
        switch (algoritmo) {
            case "LinealSearch" -> {
                System.out.println("LS");
                return new LinealSearch();
            }
            case "BinarySearch" -> {
                System.out.println("BS");
                return new BinarySearch();
            }
            default -> {
                System.out.println("Error");
                return new LinealSearch();
            }
        }
    }
    public int buscarLista(String metodo, ArrayList<Atributo> lista, String tipoObjetivo, String objetivo) throws Exception {
        Buscar algoritmo = devolverAlgoritmoBusqueda(metodo);
        return algoritmo.busqueda(lista,tipoObjetivo, objetivo);
    }
}
