package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;
import java.util.Date;

public class SelectionSort implements Ordenar {

    @Override
    public Object[] ordenamiento(Atributo[] lista, String parametro) throws Exception {
        Object tipo = lista[0].ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro);
            case "Integer" -> ordenarInt(lista, parametro);
            case "Date" -> ordenarDate(lista, parametro);
            default -> throw new Exception("Error al programar los parametros");
        };
    }


    private Object[] ordenarDate(Atributo[] lista, String parametro) {
        int largo = lista.length;

        for (int i = 0; i < lista.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < lista.length; j++) {
                Date primero = (Date) (lista[j].ObtenerAtributo(parametro));
                Date segundo = (Date) (lista[min].ObtenerAtributo(parametro));
                if (primero.compareTo(segundo) < 0) {
                    min = j;
                }
            }
            // Swapping
            Atributo swap = lista[i];
            lista[i] = lista[min];
            lista[min] = swap;
        }
        return lista;
    }


    private Object[] ordenarString(Atributo[] lista, String parametro) {
        int largo = lista.length;

        for (int i = 0; i < lista.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < lista.length; j++) {
                String primero = String.valueOf(lista[j].ObtenerAtributo(parametro));
                String segundo = String.valueOf(lista[min].ObtenerAtributo(parametro));
                if (primero.compareTo(segundo) < 0) {
                    min = j;
                }
            }
            // Swapping
            Atributo swap = lista[i];
            lista[i] = lista[min];
            lista[min] = swap;
        }
        return lista;
    }


    private Object[] ordenarInt(Atributo[] lista, String parametro) {
        int largo = lista.length;

        for (int i = 0; i < largo - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < largo; j++) {
                if ((Integer) lista[j].ObtenerAtributo(parametro) < (Integer) lista[min_idx].ObtenerAtributo(parametro)) {
                    min_idx = j;
                }
            }
            Atributo temp = lista[min_idx];
            lista[min_idx] = lista[i];
            lista[i] = temp;
        }
        return lista;
    }
}
