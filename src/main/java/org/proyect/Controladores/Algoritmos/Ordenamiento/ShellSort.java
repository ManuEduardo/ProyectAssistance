package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.ArrayList;
import java.util.Date;

public class ShellSort implements Ordenar{

    @Override
    public ArrayList<Object> ordenamiento(ArrayList<Atributo> lista, String parametro) throws Exception {
        Object tipo = lista.get(0).ObtenerAtributo(parametro);
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro);
            case "Integer" -> ordenarInt(lista, parametro);
            case "Date" -> ordenarDate(lista, parametro);
            default -> throw new Exception("Error al programar los parametros");
        };
    }
    private ArrayList<Object> ordenarString(ArrayList<Atributo> lista, String parametro){
        int salto, i;
        Atributo aux;
        boolean cambios;
        for (salto = lista.size() / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (i = salto; i < lista.size(); i++){
                    //Guardamos los atributos de las clases en la lista
                    String primerString = String.valueOf(lista.get(i - salto).ObtenerAtributo(parametro));
                    String segundoString = String.valueOf(lista.get(i).ObtenerAtributo(parametro));
                    if (primerString.compareTo(segundoString)>0) {
                        aux = lista.get(i);
                        lista.set(i, lista.get(i - salto));
                        lista.set(i - salto, aux);
                        cambios = true;
                    }
                }
            }
        }
        return new ArrayList<>(lista);
    }
    private ArrayList<Object> ordenarInt(ArrayList<Atributo> lista, String parametro){
            int salto, i;
            Atributo aux;
            boolean cambios;
            for (salto = lista.size() / 2; salto != 0; salto /= 2) {
                cambios = true;
                while (cambios) {
                    cambios = false;
                    for (i = salto; i < lista.size(); i++){
                        //Guardamos los atributos de las clases en la lista
                        int anterior = (Integer) lista.get(i - salto).ObtenerAtributo(parametro);
                        int posterior = (Integer) lista.get(i).ObtenerAtributo(parametro);
                        if (anterior > posterior) {
                            aux = lista.get(i);
                            lista.set(i, lista.get(i - salto));
                            lista.set(i - salto, aux);
                            cambios = true;
                        }
                    }
                }
            }
        return new ArrayList<>(lista);
    }
    private ArrayList<Object> ordenarDate(ArrayList<Atributo> lista, String parametro){
        int salto, i;
        Atributo aux;
        boolean cambios;
        for (salto = lista.size() / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (i = salto; i < lista.size(); i++){
                    //Guardamos los atributos de las clases en la lista
                    Date primerString = (Date) lista.get(i - salto).ObtenerAtributo(parametro);
                    Date segundoString = (Date) lista.get(i).ObtenerAtributo(parametro);
                    if (primerString.compareTo(segundoString)>0) {
                        aux = lista.get(i);
                        lista.set(i, lista.get(i - salto));
                        lista.set(i - salto, aux);
                        cambios = true;
                    }
                }
            }
        }
        return new ArrayList<>(lista);
    }
}
