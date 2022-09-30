package org.proyect.Controladores.Algoritmos.Busqueda;
import org.proyect.Modelos.Atributo;
import org.proyect.Controladores.Algoritmos.Ordenamiento.QuickSort;

import java.util.ArrayList;

public class BinarySearch implements Buscar {
    QuickSort QS = new QuickSort();
    @Override
    public int busqueda(ArrayList<Atributo> lista, String tipoObjetivo, String objetivo) throws Exception {
        Object tipo = lista.get(0).ObtenerAtributo(tipoObjetivo);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> buscarString(lista, tipoObjetivo,objetivo);
            case "Integer" -> buscarInt(lista, tipoObjetivo, objetivo);
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private int buscarInt(ArrayList<Atributo> lista, String tipoObjetivo, String objetivo) throws Exception {
        ArrayList<Object> listaOrdenada = QS.ordenamiento(lista,tipoObjetivo);
        lista = new ArrayList<>(listaOrdenada.size());
        for (Object object : listaOrdenada) {
            lista.add((Atributo) object);
        }
        int inicio = 0;
        int fin = lista.size() - 1;
        int pos;
        try {
            while (inicio <= fin) {
                pos = (inicio+fin) / 2;
                if ( (Integer) lista.get(pos).ObtenerAtributo(tipoObjetivo) == Integer.parseInt(objetivo) )
                    return pos;
                else if ( (Integer) lista.get(pos).ObtenerAtributo(tipoObjetivo) < Integer.parseInt(objetivo)) {
                    inicio = pos+1;
                } else {
                    fin = pos-1;
                }
            }
        }catch (Exception e) {
            return -1;
        }
        return -1;
    }
    private int buscarString(ArrayList<Atributo> lista, String tipoObjetivo, String objetivo) throws Exception {
        ArrayList<Object> listaOrdenada = QS.ordenamiento(lista,tipoObjetivo);
        lista = new ArrayList<>(listaOrdenada.size());
        for (Object object : listaOrdenada) {
            lista.add((Atributo) object);
        }
        int inicio = 0;
        int fin = lista.size() - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if (String.valueOf(lista.get(pos).ObtenerAtributo(tipoObjetivo)).equals(String.valueOf((objetivo))))
                return pos;
            else if (String.valueOf(lista.get(pos).ObtenerAtributo(tipoObjetivo)).compareTo(String.valueOf(objetivo))<0) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return -1;
    }
}