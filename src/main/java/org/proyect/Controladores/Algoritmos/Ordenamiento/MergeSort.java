package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.Date;

public class MergeSort implements Ordenar{
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
    private Object[] ordenarInt(Atributo[] lista, String parametro, int left, int right) {
        if(left < right){
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            ordenarInt(lista, parametro, left, middle);
            ordenarInt(lista, parametro, middle+1, right);

            //Une las mitades.
            mergeInt(lista, parametro, left, middle, right);
        }
        return lista;
    }
    private void mergeInt(Atributo[] lista, String parametro, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Atributo[] leftArray = new Atributo [n1];
        Atributo[] rightArray = new Atributo [n2];
        for (int i=0; i < n1; i++) {
            leftArray[i] = lista[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = lista[middle + j + 1];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if ((Integer)leftArray[i].ObtenerAtributo(parametro) <= (Integer) rightArray[j].ObtenerAtributo(parametro)) {
                lista[k] = leftArray[i];
                i++;
            } else {
                lista[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            lista[k] = rightArray[j];
            j++;
            k++;
        }
    }


    private Object[] ordenarString(Atributo[] lista, String parametro, int left, int right) {
        if(left < right){
            int middle = (left + right) / 2;
            ordenarString(lista, parametro, left, middle);
            ordenarString(lista, parametro, middle+1, right);
            mergeString(lista, parametro, left, middle, right);
        }
        return lista;
    }
    private void mergeString(Atributo[] lista, String parametro, int left, int middle, int right){
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Atributo[] leftArray = new Atributo [n1];
        Atributo[] rightArray = new Atributo [n2];
        for (int i=0; i < n1; i++) {
            leftArray[i] = lista[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = lista[middle + j + 1];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (String.valueOf(leftArray[i].ObtenerAtributo(parametro)).compareTo(String.valueOf(rightArray[j].ObtenerAtributo(parametro))) <=0) {
                lista[k] = leftArray[i];
                i++;
            } else {
                lista[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            lista[k] = rightArray[j];
            j++;
            k++;
        }
    }


    private Object[] ordenarDate(Atributo[] lista, String parametro, int left, int right) {
        if(left < right){
            int middle = (left + right) / 2;
            ordenarDate(lista, parametro, left, middle);
            ordenarDate(lista, parametro, middle+1, right);
            mergeDate(lista, parametro, left, middle, right);
        }
        return lista;
    }
    private void mergeDate(Atributo[] lista, String parametro, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Atributo[] leftArray = new Atributo [n1];
        Atributo[] rightArray = new Atributo [n2];
        for (int i=0; i < n1; i++) {
            leftArray[i] = lista[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = lista[middle + j + 1];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (((Date)leftArray[i].ObtenerAtributo(parametro)).compareTo((Date) rightArray[j].ObtenerAtributo(parametro)) <=0) {
                lista[k] = leftArray[i];
                i++;
            } else {
                lista[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            lista[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            lista[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
