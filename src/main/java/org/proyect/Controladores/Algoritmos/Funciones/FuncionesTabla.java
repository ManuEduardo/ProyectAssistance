package org.proyect.Controladores.Algoritmos.Funciones;

import org.proyect.Controladores.Algoritmos.Busqueda.FactorySearch;
import org.proyect.Controladores.Algoritmos.Ordenamiento.FactorySort;
import org.proyect.Modelos.Atributo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class FuncionesTabla {
    private DefaultTableModel modeloTable = new DefaultTableModel();
    //INSTANCIARCLASES


    public void actualizarTabla(JTable tabla, ArrayList<Atributo> lista, ArrayList<String> caracteristicas) {
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


    public void ordenarTabla(JTable tabla, ArrayList<Atributo> lista, String metodo, String parametro,
                             ArrayList<String> caracteristicas) throws Exception {

        FactorySort algoritmos = new FactorySort();
        //lista = algoritmos.ordenarLista(metodo,lista,parametro);
        ArrayList<Object> listaObjeto = algoritmos.ordenarLista(metodo,lista,parametro);
        lista = new ArrayList<>((listaObjeto).size());
        for (Object object : listaObjeto) {
            lista.add((Atributo) object);
        }

        actualizarTabla(tabla,lista,caracteristicas);
    }


    public int buscarTabla(JTable tabla, ArrayList<Atributo> lista, ArrayList<String> caracteristicas, String tipoParametroBuscar,
                            String algoritmoBusqueda, String parametroBuscar ) throws Exception {

        modeloTable = (DefaultTableModel) tabla.getModel();
        FactorySearch algoritmo = new FactorySearch();
        int indice = algoritmo.buscarLista(algoritmoBusqueda,lista,tipoParametroBuscar, parametroBuscar);
        if(indice == -1){
            return indice;
        }
        ArrayList<Atributo> respuesta = new ArrayList<>(1);
        respuesta.add( lista.get(indice));
        actualizarTabla(tabla,respuesta,caracteristicas);
        return indice;
    }
}
