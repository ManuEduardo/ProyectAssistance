package org.proyect.Controladores.Algoritmos.Busqueda;

import org.proyect.Modelos.Atributo;

public class LinealSearch implements Buscar{
    //en dado caso no se encuentre devolver -1
    @Override
    public int busqueda(Atributo[] lista, String tipoObjetivo, String objetivo) throws Exception {
        Object tipo = lista[0].ObtenerAtributo(tipoObjetivo);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> buscarString(lista,tipoObjetivo, objetivo);
            case "Integer" -> buscarInt(lista,tipoObjetivo, objetivo);
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private int buscarInt(Atributo[] lista,String tipoObjetivo,String objetivo){
        int intObjetivo = Integer.parseInt(objetivo);
        int posicion = -1;
        for(int i = 0; i < lista.length; i++){
            if((Integer) lista[i].ObtenerAtributo(tipoObjetivo) == intObjetivo){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    private int buscarString(Atributo[] lista,String tipoObjetivo, String objetivo){
        int posicion = -1;
        for(int i = 0; i < lista.length; i++){
            if(lista[i].ObtenerAtributo(tipoObjetivo).equals(objetivo)){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
}

