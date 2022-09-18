package org.proyect.Controladores.Algoritmos.Busqueda;
import org.proyect.Modelos.Atributo;
import org.proyect.Controladores.Algoritmos.Ordenamiento.BubbleSort;
public class BinarySearch implements Buscar {
    BubbleSort BS = new BubbleSort();
    @Override
    public int busqueda(Atributo[] lista, String tipoObjetivo, String objetivo) throws Exception {
        Object tipo = lista[0].ObtenerAtributo(tipoObjetivo);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> buscarString(lista, tipoObjetivo,objetivo);
            case "Integer" -> buscarInt(lista, tipoObjetivo, objetivo);
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private int buscarInt(Atributo[] lista, String tipoObjetivo, String objetivo) throws Exception {
        lista = (Atributo[]) BS.ordenamiento(lista,tipoObjetivo);
        int inicio = 0;
        int fin = lista.length - 1;
        int pos;
        try {
            while (inicio <= fin) {
                pos = (inicio+fin) / 2;
                if ( (Integer) lista[pos].ObtenerAtributo(tipoObjetivo) == Integer.parseInt(objetivo) )
                    return pos;
                else if ( (Integer)lista[pos].ObtenerAtributo(tipoObjetivo) < Integer.parseInt(objetivo)) {
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
    private int buscarString(Atributo[] lista, String tipoObjetivo, String objetivo) throws Exception {
        lista = (Atributo[]) BS.ordenamiento(lista,tipoObjetivo);
        int inicio = 0;
        int fin = lista.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if (String.valueOf(lista[pos].ObtenerAtributo(tipoObjetivo)).equals(String.valueOf((objetivo))))
                return pos;
            else if (String.valueOf(lista[pos].ObtenerAtributo(tipoObjetivo)).compareTo(String.valueOf(objetivo))<0) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return -1;
    }
}