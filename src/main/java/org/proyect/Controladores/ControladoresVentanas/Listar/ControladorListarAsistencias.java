package org.proyect.Controladores.ControladoresVentanas.Listar;

import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTablaArrayList;
import org.proyect.Controladores.Controlador;
import org.proyect.Modelos.InstanciaEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;
import org.proyect.Vistas.VentanasListar.VentanaRegistroAsistencias;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ControladorListarAsistencias extends Controlador {
    InstanciaEmpleadosAsistencias generador = InstanciaEmpleadosAsistencias.singletonGenerador();
    //generador de arraylist para prueba
    ArrayList<Atributo> listaInicial = generador.getAsistencias();

    FuncionesTablaArrayList funcionesTablaArrayList = new FuncionesTablaArrayList();
    //Componentes de la ventana
    JTable jTablePrincipal;
    JTable jTableOrdenada;
    JComboBox<String> jCBAlgoritmo;
    JComboBox<String> jCBBuscar;
    JComboBox<String> jCBCriterio;
    JComboBox<String> jCBMetodo;
    JTextField jTFIngresar;
    JTable jTableBusqueda;
    ArrayList<String> caracteristicas = new ArrayList<>();//{"id","empleado","fechaformateada","horaformateada"};

    public ControladorListarAsistencias(VentanaRegistroAsistencias ventana) {
        super(ventana);
        jTablePrincipal = ventana.jTablePrincipal;
        jTableOrdenada = ventana.jTableOrdenada;
        jTableBusqueda = ventana.jTableBusqueda;
        jCBAlgoritmo = ventana.jCBAlgoritmo;
        jCBBuscar = ventana.jCBBuscar;
        jCBCriterio = ventana.jCBCriterio;
        jCBMetodo = ventana.jCBMetodo;
        jTFIngresar = ventana.jTFIngresar;
        caracteristicas.add("id");
        caracteristicas.add("empleado");
        caracteristicas.add("fechaformateada");
        caracteristicas.add("horaformateada");

        ventana.jButtonListar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {listarAsistencias();}
        });

        ventana.jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    bucarAsistencias();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ventana.jButtonOrdenar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    ordenamientoTabla();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void iniciarVentana() {
        ventana.iniciar();
    }

    private void listarAsistencias(){
        this.listaInicial = generador.getAsistencias();
        funcionesTablaArrayList.actualizarTabla(jTablePrincipal,listaInicial,caracteristicas);
    }

    private void ordenamientoTabla() throws Exception {
        listaInicial = generador.getAsistencias();
        String algoritmo = (String) jCBAlgoritmo.getSelectedItem();
        String criterio = (String) jCBCriterio.getSelectedItem();
        criterio = criterio.toLowerCase();
        algoritmo = algoritmo.trim();
        System.out.println("+++"+algoritmo+"+++");
        if (criterio.equals("dni")){
            funcionesTablaArrayList.ordenarTabla(jTableOrdenada,listaInicial,algoritmo,"id",caracteristicas);
            return;
        }
        funcionesTablaArrayList.ordenarTabla(jTableOrdenada,listaInicial,algoritmo,criterio,caracteristicas);
    }


    private void bucarAsistencias() throws Exception {
        listaInicial = generador.getAsistencias();
        String tipoParametroBuscar = (((String) jCBBuscar.getSelectedItem()).trim()).toLowerCase();
        if(tipoParametroBuscar.equals("fecha")) tipoParametroBuscar = "fechaformateada";
        String algoritmoBusqueda = ((String) jCBMetodo.getSelectedItem()).trim();
        String parametroBuscar = (jTFIngresar.getText()).trim();
        if(parametroBuscar.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese un parametro al buscar");
            return;
        }
        int respuesta = -1;
        respuesta = funcionesTablaArrayList.buscarTabla(jTableBusqueda,listaInicial,caracteristicas,tipoParametroBuscar,algoritmoBusqueda,parametroBuscar);
        if(respuesta == -1) javax.swing.JOptionPane.showMessageDialog((Component) ventana,"BUSQUEDA NO ENCONTRADA");
    }
}
