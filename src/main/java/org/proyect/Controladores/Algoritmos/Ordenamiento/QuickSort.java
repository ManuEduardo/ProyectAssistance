package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.Date;

public class QuickSort implements Ordenar {

    @Override
    public ArrayList<Object> ordenamiento(ArrayList<Atributo> lista, String parametro) throws Exception {
        Object tipo = lista.get(0).ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro, 0, lista.size() - 1);
            case "Integer" -> ordenarInt(lista, parametro, 0, lista.size() - 1);
            case "Date" -> ordenarDate(lista, parametro, 0, lista.size() - 1);
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private ArrayList<Object> ordenarInt(ArrayList<Atributo> lista, String parametro, int izq, int der) {
        Atributo pivote = lista.get(izq);
        int i = izq;
        int j = der;
        Atributo aux;

        while (i < j) {
            while ((Integer) lista.get(i).ObtenerAtributo(parametro) <= (Integer) pivote.ObtenerAtributo(parametro) && i < j)
                i++;
            while ((Integer) lista.get(j).ObtenerAtributo(parametro) > (Integer) pivote.ObtenerAtributo(parametro))
                j--;
            if (i < j) {
                aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
            }
        }

        lista.set(izq, lista.get(j));
        lista.set(j, pivote);

        if (izq < j - 1)
            ordenarInt(lista, parametro, izq, j - 1);
        if (j + 1 < der)
            ordenarInt(lista, parametro, j + 1, der);
        return new ArrayList<>(lista);
    }

    private ArrayList<Object> ordenarString(ArrayList<Atributo> lista, String parametro, int izq, int der) {
        Atributo pivote = lista.get(izq);
        int i = izq;
        int j = der;
        Atributo aux;

        while (i < j) {
            while (String.valueOf(lista.get(i).ObtenerAtributo(parametro)).compareTo(String.valueOf(pivote.ObtenerAtributo(parametro)))<=0 && i < j)
                i++;
            while (String.valueOf(lista.get(j).ObtenerAtributo(parametro)).compareTo(String.valueOf(pivote.ObtenerAtributo(parametro)))>0)
                j--;
            if (i < j) {
                aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
            }
        }

        lista.set(izq, lista.get(j));
        lista.set(j, pivote);

        if (izq < j - 1)
            ordenarString(lista, parametro, izq, j - 1);
        if (j + 1 < der)
            ordenarString(lista, parametro, j + 1, der);
        return new ArrayList<>(lista);
    }

    private ArrayList<Object> ordenarDate(ArrayList<Atributo> lista, String parametro, int izq, int der) {
        Atributo pivote = lista.get(izq);
        int i = izq;
        int j = der;
        Atributo aux;

        while (i < j) {
            while (((Date) lista.get(i).ObtenerAtributo(parametro)).compareTo((Date)pivote.ObtenerAtributo(parametro))<=0 && i < j)
                i++;
            while (((Date) lista.get(j).ObtenerAtributo(parametro)).compareTo((Date)pivote.ObtenerAtributo(parametro))>0)
                j--;
            if (i < j) {
                aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
            }
        }

        lista.set(izq, lista.get(j));
        lista.set(j, pivote);

        if (izq < j - 1)
            ordenarDate(lista, parametro, izq, j - 1);
        if (j + 1 < der)
            ordenarDate(lista, parametro, j + 1, der);
        return new ArrayList<>(lista);
    }
}
