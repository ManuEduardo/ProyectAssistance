package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

public class FactorySort {
    private Ordenar devolverAlgoritmoOrdenamiento(String algoritmo){
        switch (algoritmo) {
            case "Bubblesort" -> {
                return new BubbleSort();
            }
            case "Selectionsort" -> {
                return new SelectionSort();
            }
            case "Insertionsort" -> {
                return new InsertionSort();
            }
            case "Quicksort" -> {
                return new QuickSort();
            }
            case "Shellsort" -> {
                return new ShellSort();
            }
            case "Mergesort" -> {
                return new MergeSort();
            }
            default -> {
                System.out.println("Error");
                return new BubbleSort();
            }
        }
    }
    public Object[] ordenarLista(String metodo, Atributo[] lista, String parametro) throws Exception {
        Ordenar algoritmo = devolverAlgoritmoOrdenamiento(metodo);
        return algoritmo.ordenamiento(lista, parametro);
    }
}
