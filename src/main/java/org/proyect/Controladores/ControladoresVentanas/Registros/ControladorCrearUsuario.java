package org.proyect.Controladores.ControladoresVentanas.Registros;

import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTablaArrayList;
import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTablaLinkedList;
import org.proyect.Controladores.Controlador;
import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearEmpleado;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ControladorCrearUsuario extends Controlador {

    GenerarEmpleadosAsistencias generador = GenerarEmpleadosAsistencias.singletonGenerador();
    LinkedList<Atributo> listaInicial = new LinkedList<>(generador.generarEmpleados());
    FuncionesTablaLinkedList funcionesTablaLinkedList = new FuncionesTablaLinkedList();
    JButton jButtonBuscar;
    JButton jButtonRegistrar;
    JComboBox<String> jComboBoxParametro;
    JPasswordField jPasswordField1;
    JPasswordField jPasswordField2;
    JTable jTableBusqueda;
    JTextField jTextFieldBuscarNombre;
    JTextField jTextFieldDepartamento;
    JTextField jTextFieldDni;
    JTextField jTextFieldEmail;
    JTextField jTextFieldNombre;
    ArrayList<String> caracteristicas = new ArrayList<>();

    public ControladorCrearUsuario(VentanaCrearEmpleado ventana) {
        super(ventana);
        this.jButtonBuscar = ventana.jButtonBuscar;
        this.jButtonRegistrar = ventana.jButtonRegistrar;
        this.jComboBoxParametro = ventana.jComboBoxParametro;
        this.jPasswordField1 = ventana.jPasswordField1;
        this.jPasswordField2 = ventana.jPasswordField2;
        this.jTableBusqueda = ventana.jTableBusqueda;
        this.jTextFieldBuscarNombre = ventana.jTextFieldBuscar;
        this.jTextFieldDepartamento = ventana.jTextFieldDepartamento;
        this.jTextFieldDni = ventana.jTextFieldDni;
        this.jTextFieldEmail = ventana.jTextFieldEmail;
        this.jTextFieldNombre = ventana.jTextFieldNombre;
        caracteristicas.add("id");
        caracteristicas.add("nombre");
        caracteristicas.add("email");
        caracteristicas.add("departamento");

        ventana.jButtonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {registrar();}
        });

        ventana.jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    buscar();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void buscar() throws Exception {
        String tipoParametroBuscar = (((String) jComboBoxParametro.getSelectedItem()).trim()).toLowerCase();
        if(tipoParametroBuscar.equals("dni")) tipoParametroBuscar = "id";
        String parametroBuscar = (jTextFieldBuscarNombre.getText()).trim();
        funcionesTablaLinkedList.buscarTabla(jTableBusqueda, listaInicial, caracteristicas, tipoParametroBuscar, parametroBuscar);
        if(parametroBuscar.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese un parametro al buscar");
            return;
        }
        int respuesta = -1;
        respuesta = funcionesTablaLinkedList.buscarTabla(jTableBusqueda,listaInicial,caracteristicas,tipoParametroBuscar,parametroBuscar);
        if(respuesta == -1) javax.swing.JOptionPane.showMessageDialog((Component) ventana,"BUSQUEDA NO ENCONTRADA");
    }

    private void registrar(){

    }

    @Override
    public void iniciarVentana() {ventana.iniciar();}
}
