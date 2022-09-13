package org.proyect.Controladores.Algoritmos.Ordenamiento;

import org.proyect.Modelos.Atributo;

import java.util.Date;

public class BubbleSort implements Ordenar{
    @Override
    public Object[] ordenamiento(Atributo[] lista, String parametro) throws Exception {
    //LA FUNCION DE ARRIBA RECIBE LA LISTA DE CLASES Y EL PARAMETRO EN STRING
        //la variable tipo guarda el atributo que se pide para luego ver de que tipo es, dado que si yo le digo que lo
            //ordene por id, la funcion no sabe si id es un numero o string o date dado que el parametro viene en String.
        Object tipo = lista[0].ObtenerAtributo(parametro);//el metodo ObtenerAtributo lo tiene todas las clases que heredan de Atributo
        //LA DECLARACION DE ABAJO LO QUE HACE ES QUE VE QUE TIPO DE VARIABLE ES EL PARAMETRO QUE SE PIDE
            //PUEDE SER INT COMO EL ID, STRING COMO EL NOMBRE/DEPARTAMENTO O DATE COMO LA FECHA DE ASISTENCIA
        return switch (((Object) tipo).getClass().getSimpleName()) {
            case "String" -> ordenarString(lista, parametro);
            case "Integer" -> ordenarInt(lista, parametro);
            case "Date" -> ordenarDate(lista, parametro);
            //Si no es ninguno de estos 3 tipos se lanza un error, esto solo es para ayudarlos al programar dado que
                //en el programa final esto no va a dar error
            default -> throw new Exception("Error al programar los parametros");
        };
    }
    private Object[] ordenarString(Atributo[] lista, String parametro){
        int largo = lista.length;
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < largo - 1; j++) {
                String primerString = String.valueOf(lista[j].ObtenerAtributo(parametro));
                String segundoString = String.valueOf(lista[j+1].ObtenerAtributo(parametro));
                if (primerString.compareTo(segundoString)>0) {
                    Atributo temp = lista[j + 1];
                    lista[j + 1] = lista[j];
                    lista[j] = temp;
                }
            }
        }
        return lista;
    }
    private Object[] ordenarInt(Atributo[] lista, String parametro){
        //Usamos la clase Obtener Atributo para recuperar el atributo de la clase sin conocer el nombre de el atributo
        //pueden ver las clases Empleado, Asistencia y Departamento para más detalles
        int largo = lista.length;
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < largo - 1; j++) {
                if ((Integer)lista[j].ObtenerAtributo(parametro) > (Integer)lista[j+1].ObtenerAtributo(parametro)) {
                    Atributo temp = lista[j + 1];
                    lista[j + 1] = lista[j];
                    lista[j] = temp;
                }
            }
        }
        return lista;
    }
    private Object[] ordenarDate(Atributo[] lista, String parametro){
        int largo = lista.length;
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < largo - 1; j++) {
                Date primerString = (Date) lista[j].ObtenerAtributo(parametro);
                Date segundoString = (Date) lista[j+1].ObtenerAtributo(parametro);
                if (primerString.compareTo(segundoString)>0) {
                    Atributo temp = lista[j + 1];
                    lista[j + 1] = lista[j];
                    lista[j] = temp;
                }
            }
        }
        return lista;
    }
}
