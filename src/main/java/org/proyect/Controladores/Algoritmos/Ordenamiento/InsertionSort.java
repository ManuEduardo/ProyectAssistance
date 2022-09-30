package org.proyect.Controladores.Algoritmos.Ordenamiento;


import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.Date;

public class InsertionSort implements Ordenar {
    @Override
    public ArrayList<Object> ordenamiento(ArrayList<Atributo> lista, String parametro) throws Exception {
        Object tipo = lista.get(0).ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro);// lista,parametro,lista.length
            case "Integer" -> ordenarInt(lista, parametro);// lista,parametro,lista.length
            case "Date" -> ordenarDate(lista, parametro);// lista,parametro,lista.length
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private ArrayList<Object> ordenarDate(ArrayList<Atributo> lista, String parametro) {
        int largo = lista.size();

        for (int i = 1; i < lista.size(); i++) {
            for (int j = i; j > 0; j--) {
                Atributo key = lista.get(j);
                int r = j-1;
                Date primero = (Date)(lista.get(r).ObtenerAtributo(parametro));
                Date segundo = (Date)(lista.get(j).ObtenerAtributo(parametro));
                int Datos = primero.compareTo(segundo);
                if (Datos>0) {
                    lista.set(j, lista.get(j - 1));
                    lista.set(j - 1, key);
                }
            }
        }
        return new ArrayList<>(lista);
    }

    private ArrayList<Object> ordenarString(ArrayList<Atributo> lista, String parametro) {
        int largo = lista.size();

        for (int i = 1; i < lista.size(); i++) {
            for (int j = i; j > 0; j--) {
                Atributo key = lista.get(j);
                int r = j-1;
                String primero = String.valueOf(lista.get(r).ObtenerAtributo(parametro));
                String segundo = String.valueOf(lista.get(j).ObtenerAtributo(parametro));
                int compare = primero.compareTo(segundo);

                if (compare>0) {
                    lista.set(j, lista.get(j - 1));
                    lista.set(j - 1, key);
                }
            }
        } return new ArrayList<>(lista);
    }

    private ArrayList<Object> ordenarInt(ArrayList<Atributo> lista, String parametro) {
        int largo = lista.size();

        for (int i = 1; i < largo; ++i) {
            Atributo key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && (Integer) lista.get(j).ObtenerAtributo(parametro) >
                    (Integer) key.ObtenerAtributo(parametro)
            ) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, key);
        }
        return new ArrayList<>(lista);
    }


}
