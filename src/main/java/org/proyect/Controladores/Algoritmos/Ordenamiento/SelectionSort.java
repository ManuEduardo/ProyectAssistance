package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.Date;

public class SelectionSort implements Ordenar {

    @Override
    public ArrayList<Object> ordenamiento(ArrayList<Atributo> lista, String parametro) throws Exception {
        Object tipo = lista.get(0).ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro);
            case "Integer" -> ordenarInt(lista, parametro);
            case "Date" -> ordenarDate(lista, parametro);
            default -> throw new Exception("Error al programar los parametros");
        };
    }


    private ArrayList<Object> ordenarDate(ArrayList<Atributo> lista, String parametro) {
        int largo = lista.size();

        for (int i = 0; i < lista.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < lista.size(); j++) {
                Date primero = (Date) (lista.get(j).ObtenerAtributo(parametro));
                Date segundo = (Date) (lista.get(min).ObtenerAtributo(parametro));
                if (primero.compareTo(segundo) < 0) {
                    min = j;
                }
            }
            // Swapping
            Atributo swap = lista.get(i);
            lista.set(i, lista.get(min));
            lista.set(min, swap);
        }
        return new ArrayList<>(lista);
    }


    private ArrayList<Object> ordenarString(ArrayList<Atributo> lista, String parametro) {
        int largo = lista.size();

        for (int i = 0; i < lista.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < lista.size(); j++) {
                String primero = String.valueOf(lista.get(j).ObtenerAtributo(parametro));
                String segundo = String.valueOf(lista.get(min).ObtenerAtributo(parametro));
                if (primero.compareTo(segundo) < 0) {
                    min = j;
                }
            }
            // Swapping
            Atributo swap = lista.get(i);
            lista.set(i, lista.get(min));
            lista.set(min, swap);
        }
        return new ArrayList<>(lista);
    }


    private ArrayList<Object> ordenarInt(ArrayList<Atributo> lista, String parametro) {
        int largo = lista.size();

        for (int i = 0; i < largo - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < largo; j++) {
                if ((Integer) lista.get(j).ObtenerAtributo(parametro) < (Integer) lista.get(min_idx).ObtenerAtributo(parametro)) {
                    min_idx = j;
                }
            }
            Atributo temp = lista.get(min_idx);
            lista.set(min_idx, lista.get(i));
            lista.set(i, temp);
        }
        return new ArrayList<>(lista);
    }
}
