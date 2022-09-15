package org.proyect.Controladores.Algoritmos.Busqueda;

import org.proyect.Controladores.Algoritmos.Ordenamiento.Ordenar;
import org.proyect.Modelos.Atributo;

public class FactorySearch {
    private Buscar devolverAlgoritmoBusqueda(String algoritmo){
        switch (algoritmo) {
            case "LinealSearch" -> {
                System.out.println("LS");
                return new BinarySearch();
            }
            case "BinarySearch" -> {
                System.out.println("BS");
                return new LinealSearch();
            }
            default -> {
                System.out.println("Error");
                return new LinealSearch();
            }
        }
    }
    public int buscarLista(String metodo, Atributo[] lista, String tipoObjetivo, String objetivo) throws Exception {
        Buscar algoritmo = devolverAlgoritmoBusqueda(metodo);
        return algoritmo.busqueda(lista,tipoObjetivo, objetivo);
    }
}
