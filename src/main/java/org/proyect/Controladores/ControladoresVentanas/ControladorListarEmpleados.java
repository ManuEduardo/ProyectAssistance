package org.proyect.Controladores.ControladoresVentanas;

import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTabla;
import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;
import org.proyect.Vistas.VentanasListar.VentanaRegistroEmpleados;
import org.proyect.Controladores.Controlador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class ControladorListarEmpleados extends Controlador{
    GenerarEmpleadosAsistencias generador = new GenerarEmpleadosAsistencias();
    //generador de arraylist para prueba
    ArrayList<Atributo> listaInicial = new ArrayList<>(Arrays.asList(generador.generarEmpleados()));

    FuncionesTabla funcionesTabla = new FuncionesTabla();
    //Componentes de la ventana
    JTable jTablePrincipal;
    JTable jTableOrdenada;
    JComboBox<String> jCBAlgoritmo;
    JComboBox<String> jCBBuscar;
    JComboBox<String> jCBCriterio;
    JComboBox<String> jCBMetodo;
    JTextField jTFIngresar;
    JTable jTableBusqueda;
    ArrayList<String> caracteristicas = new ArrayList<>();//{"id","nombre","email","departamento"};

    public ControladorListarEmpleados(VentanaRegistroEmpleados ventana) {
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
        caracteristicas.add("nombre");
        caracteristicas.add("email");
        caracteristicas.add("departamento");

        ventana.jButtonListar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {listarEmpleados();}
        });

        ventana.jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    bucarEmpleados();
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

    private void listarEmpleados(){
        funcionesTabla.actualizarTabla(jTablePrincipal,listaInicial,caracteristicas);
    }
    private void ordenamientoTabla() throws Exception {
        String algoritmo = ((String) jCBAlgoritmo.getSelectedItem()).trim();
        String criterio = ((String) jCBCriterio.getSelectedItem()).toLowerCase();
        System.out.println("+++"+algoritmo+"+++");
        if (criterio.equals("dni")){
            funcionesTabla.ordenarTabla(jTableOrdenada,listaInicial,algoritmo,"id",caracteristicas);
            return;
        }
        funcionesTabla.ordenarTabla(jTableOrdenada,listaInicial,algoritmo,criterio,caracteristicas);
    }
    private void bucarEmpleados() throws Exception {
        String tipoParametroBuscar = (((String) jCBBuscar.getSelectedItem()).trim()).toLowerCase();
        if(tipoParametroBuscar.equals("dni")) tipoParametroBuscar = "id";
        String algoritmoBusqueda = ((String) jCBMetodo.getSelectedItem()).trim();
        String parametroBuscar = (jTFIngresar.getText()).trim();
        if(parametroBuscar.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese un parametro al buscar");
            return;
        }
        int respuesta = -1;
        respuesta =  funcionesTabla.buscarTabla(jTableBusqueda,listaInicial,caracteristicas,tipoParametroBuscar,algoritmoBusqueda,parametroBuscar);
        if(respuesta == -1) javax.swing.JOptionPane.showMessageDialog((Component) ventana,"BUSQUEDA NO ENCONTRADA");
    }
}
