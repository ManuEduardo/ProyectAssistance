package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.Date;

public class QuickSort implements Ordenar {

    @Override
    public Object[] ordenamiento(Atributo[] lista, String parametro) throws Exception {
        Object tipo = lista[0].ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro, 0, lista.length - 1);
            case "Integer" -> ordenarInt(lista, parametro, 0, lista.length - 1);
            case "Date" -> ordenarDate(lista, parametro, 0, lista.length - 1);
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private Object[] ordenarInt(Atributo[] lista, String parametro, int izq, int der) {
        Atributo pivote = lista[izq];
        int i = izq;
        int j = der;
        Atributo aux;

        while (i < j) {
            while ((Integer) lista[i].ObtenerAtributo(parametro) <= (Integer) pivote.ObtenerAtributo(parametro) && i < j)
                i++;
            while ((Integer) lista[j].ObtenerAtributo(parametro) > (Integer) pivote.ObtenerAtributo(parametro))
                j--;
            if (i < j) {
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }
        }

        lista[izq] = lista[j];
        lista[j] = pivote;

        if (izq < j - 1)
            ordenarInt(lista, parametro, izq, j - 1);
        if (j + 1 < der)
            ordenarInt(lista, parametro, j + 1, der);
        return lista;
    }

    private Object[] ordenarString(Atributo[] lista, String parametro, int izq, int der) {
        Atributo pivote = lista[izq];
        int i = izq;
        int j = der;
        Atributo aux;

        while (i < j) {
            while (String.valueOf(lista[i].ObtenerAtributo(parametro)).compareTo(String.valueOf(pivote.ObtenerAtributo(parametro)))<=0 && i < j)
                i++;
            while (String.valueOf(lista[j].ObtenerAtributo(parametro)).compareTo(String.valueOf(pivote.ObtenerAtributo(parametro)))>0)
                j--;
            if (i < j) {
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }
        }

        lista[izq] = lista[j];
        lista[j] = pivote;

        if (izq < j - 1)
            ordenarString(lista, parametro, izq, j - 1);
        if (j + 1 < der)
            ordenarString(lista, parametro, j + 1, der);
        return lista;
    }

    private Object[] ordenarDate(Atributo[] lista, String parametro, int izq, int der) {
        Atributo pivote = lista[izq];
        int i = izq;
        int j = der;
        Atributo aux;

        while (i < j) {
            while (((Date)lista[i].ObtenerAtributo(parametro)).compareTo((Date)pivote.ObtenerAtributo(parametro))<=0 && i < j)
                i++;
            while (((Date)lista[j].ObtenerAtributo(parametro)).compareTo((Date)pivote.ObtenerAtributo(parametro))>0)
                j--;
            if (i < j) {
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }
        }

        lista[izq] = lista[j];
        lista[j] = pivote;

        if (izq < j - 1)
            ordenarDate(lista, parametro, izq, j - 1);
        if (j + 1 < der)
            ordenarDate(lista, parametro, j + 1, der);
        return lista;
    }
}
