package org.proyect.Controladores.Algoritmos.Funciones;

import org.proyect.Controladores.Algoritmos.Busqueda.BusquedaLinkedList;
import org.proyect.Modelos.Atributo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.LinkedList;

public class FuncionesTablaLinkedList {

    private DefaultTableModel modeloTable = new DefaultTableModel();
    //INSTANCIARCLASES

    public void actualizarTabla(JTable tabla, LinkedList<Atributo> lista, ArrayList<String> caracteristicas) {
        modeloTable = (DefaultTableModel) tabla.getModel();
        vaciarTabla(tabla);
        ArrayList<Object> ob = new ArrayList<>();
        for (Atributo atributo : lista) {
            for (int j = 0; j < caracteristicas.size(); j++) {
                ob.add(atributo.ObtenerAtributo(caracteristicas.get(j)));
            }
            modeloTable.addRow(ob.toArray());
            ob.clear();
        }
        tabla.setModel(modeloTable);
    }

    public void vaciarTabla(JTable tabla) {
        modeloTable = (DefaultTableModel) tabla.getModel();
        modeloTable.setRowCount(0);
        tabla.setModel(modeloTable);
    }

    public int buscarTabla(JTable tabla, LinkedList<Atributo> lista,
                           ArrayList<String> caracteristicas,
                           String tipoParametroBuscar, String parametroBuscar ) throws Exception {

        modeloTable = (DefaultTableModel) tabla.getModel();
        BusquedaLinkedList busquedaAlgoritmo = new BusquedaLinkedList();
        int indice = busquedaAlgoritmo.busqueda(lista,tipoParametroBuscar, parametroBuscar);
        if(indice == -1){
            return indice;
        }


        LinkedList<Atributo> respuesta = new LinkedList<>();
        respuesta.add( lista.get(indice));
        actualizarTabla(tabla,respuesta,caracteristicas);
        return indice;
    }
}
