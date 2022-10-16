package org.proyect.Controladores.Algoritmos.Busqueda;

import org.proyect.Modelos.Atributo;

import java.util.LinkedList;

public class BusquedaLinkedList {
    public int busqueda(LinkedList<Atributo> lista, String tipoObjetivo, String objetivo) throws Exception {
        System.out.println(tipoObjetivo);
        Object tipo = lista.get(0).ObtenerAtributo(tipoObjetivo);
        return switch (tipo.getClass().getSimpleName()) {
            case "String" -> buscarString(lista,tipoObjetivo, objetivo);
            case "Integer" -> buscarInt(lista,tipoObjetivo, objetivo);
            default -> throw new Exception("Error al programar los parametros");
        };
    }

    private int buscarInt(LinkedList<Atributo> lista,String tipoObjetivo,String objetivo){
        int posicion = -1;
        try {
            int intObjetivo = Integer.parseInt(objetivo);
            for(int i = 0; i < lista.size(); i++){
                if((Integer) lista.get(i).ObtenerAtributo(tipoObjetivo) == intObjetivo){
                    posicion = i;
                    break;
                }
            }
        }catch (Exception e){
            return -1;
        }
        return posicion;
    }
    private int buscarString(LinkedList<Atributo> lista,String tipoObjetivo, String objetivo){
        int posicion = -1;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).ObtenerAtributo(tipoObjetivo).equals(objetivo)){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
}
