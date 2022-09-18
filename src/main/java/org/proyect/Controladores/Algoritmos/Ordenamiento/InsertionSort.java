package org.proyect.Controladores.Algoritmos.Ordenamiento;


import org.proyect.Modelos.Atributo;
import java.util.Date;

public class InsertionSort implements Ordenar {
    @Override
    public Object[] ordenamiento(Atributo[] lista, String parametro) throws Exception {
        Object tipo = lista[0].ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro);// lista,parametro,lista.length
            case "Integer" -> ordenarInt(lista, parametro);// lista,parametro,lista.length
            case "Date" -> ordenarDate(lista, parametro);// lista,parametro,lista.length
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private Object[] ordenarDate(Atributo[] lista, String parametro) {
        int largo = lista.length;

        for (int i = 1; i < lista.length; i++) {
            for (int j = i; j > 0; j--) {
                Atributo key = lista[j];
                int r = j-1;
                Date primero = (Date)(lista[r].ObtenerAtributo(parametro));
                Date segundo = (Date)(lista[j].ObtenerAtributo(parametro));
                int Datos = primero.compareTo(segundo);
                if (Datos>0) {
                    lista[j] = lista[j - 1];
                    lista[j - 1] = key;
                }
            }
        }
        return lista;
    }

    private Object[] ordenarString(Atributo[] lista, String parametro) {
        int largo = lista.length;

        for (int i = 1; i < lista.length; i++) {
            for (int j = i; j > 0; j--) {
                Atributo key = lista[j];
                int r = j-1;
                String primero = String.valueOf(lista[r].ObtenerAtributo(parametro));
                String segundo = String.valueOf(lista[j].ObtenerAtributo(parametro));
                int compare = primero.compareTo(segundo);

                if (compare>0) {
                    lista[j] = lista[j - 1];
                    lista[j - 1] = key;
                }
            }
        } return lista;
    }

    private Object[] ordenarInt(Atributo[] lista, String parametro) {
        int largo = lista.length;

        for (int i = 1; i < largo; ++i) {
            Atributo key = lista[i];
            int j = i - 1;
            while (j >= 0 && (Integer) lista[j].ObtenerAtributo(parametro) >
                    (Integer) key.ObtenerAtributo(parametro)
            ) {
                lista[j + 1] = lista[j];
                j = j - 1;
            }
            lista[j + 1] = key;
        }
        return lista;
    }


}
