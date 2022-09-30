package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.Date;

public class MergeSort implements Ordenar{
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


    private ArrayList<Object> ordenarInt(ArrayList<Atributo> lista, String parametro, int left, int right) {
        if(left < right){
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            ordenarInt(lista, parametro, left, middle);
            ordenarInt(lista, parametro, middle+1, right);

            //Une las mitades.
            mergeInt(lista, parametro, left, middle, right);
        }
        return new ArrayList<>(lista);
    }
    private void mergeInt(ArrayList<Atributo> lista, String parametro, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        ArrayList<Atributo> leftArray = new ArrayList<Atributo> (n1);
        ArrayList<Atributo> rightArray = new ArrayList<Atributo> (n2);
        for (int i=0; i < n1; i++) {
            leftArray.set(i, lista.get(left + i));
        }
        for (int j=0; j < n2; j++) {
            rightArray.set(j, lista.get(middle + j + 1));
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if ((Integer) leftArray.get(i).ObtenerAtributo(parametro) <= (Integer) rightArray.get(j).ObtenerAtributo(parametro)) {
                lista.set(k, leftArray.get(i));
                i++;
            } else {
                lista.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista.set(k, leftArray.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            lista.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }


    private ArrayList<Object> ordenarString(ArrayList<Atributo> lista, String parametro, int left, int right) {
        if(left < right){
            int middle = (left + right) / 2;
            ordenarString(lista, parametro, left, middle);
            ordenarString(lista, parametro, middle+1, right);
            mergeString(lista, parametro, left, middle, right);
        }
        return new ArrayList<>(lista);
    }
    private void mergeString(ArrayList<Atributo> lista, String parametro, int left, int middle, int right){
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;
        ArrayList<Atributo> leftArray = new ArrayList<Atributo> (n1);
        ArrayList<Atributo> rightArray = new ArrayList<Atributo> (n2);
        for (int i=0; i < n1; i++) {
            leftArray.set(i, lista.get(left + i));
        }
        for (int j=0; j < n2; j++) {
            rightArray.set(j, lista.get(middle + j + 1));
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (String.valueOf(leftArray.get(i).ObtenerAtributo(parametro)).compareTo(String.valueOf(rightArray.get(j).ObtenerAtributo(parametro))) <=0) {
                lista.set(k, leftArray.get(i));
                i++;
            } else {
                lista.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista.set(k, leftArray.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            lista.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }


    private ArrayList<Object> ordenarDate(ArrayList<Atributo> lista, String parametro, int left, int right) {
        if(left < right){
            int middle = (left + right) / 2;
            ordenarDate(lista, parametro, left, middle);
            ordenarDate(lista, parametro, middle+1, right);
            mergeDate(lista, parametro, left, middle, right);
        }
        return new ArrayList<>(lista);
    }
    private void mergeDate(ArrayList<Atributo> lista, String parametro, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        ArrayList<Atributo> leftArray = new ArrayList<Atributo> (n1);
        ArrayList<Atributo> rightArray = new ArrayList<Atributo> (n2);
        for (int i=0; i < n1; i++) {
            leftArray.set(i, lista.get(left + i));
        }
        for (int j=0; j < n2; j++) {
            rightArray.set(j, lista.get(middle + j + 1));
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (((Date) leftArray.get(i).ObtenerAtributo(parametro)).compareTo((Date) rightArray.get(j).ObtenerAtributo(parametro)) <=0) {
                lista.set(k, leftArray.get(i));
                i++;
            } else {
                lista.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista.set(k, leftArray.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            lista.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}
