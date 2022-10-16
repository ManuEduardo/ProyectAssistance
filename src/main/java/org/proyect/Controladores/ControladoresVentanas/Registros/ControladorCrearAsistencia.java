package org.proyect.Controladores.ControladoresVentanas.Registros;

import org.proyect.Controladores.Algoritmos.Busqueda.BusquedaLinkedList;
import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTablaLinkedList;
import org.proyect.Controladores.BaseDatos.Dao.AsistenciaDao;
import org.proyect.Controladores.Controlador;
import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Asistencia;
import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearAsistencia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class ControladorCrearAsistencia extends Controlador {

    GenerarEmpleadosAsistencias generador = GenerarEmpleadosAsistencias.singletonGenerador();
    LinkedList<Atributo> listaInicial = new LinkedList<>(generador.generarAsistencias());
    LinkedList<Atributo> listaInicialEmpleados = new LinkedList<>(generador.generarEmpleados());
    FuncionesTablaLinkedList funcionesTablaLinkedList = new FuncionesTablaLinkedList();
    AsistenciaDao AsDao = new AsistenciaDao();
    JButton JButtonBuscar;
    JButton JButtonRegistrar;
    JComboBox<String> jComboBoxParametro;
    JPasswordField jPasswordFieldContrasenia;
    JTable jTableBusqueda;
    JTextField jTextFieldBuscar;
    JTextField jTextFieldDni;
    ArrayList<String> caracteristicas = new ArrayList<>();

    public ControladorCrearAsistencia(VentanaCrearAsistencia ventana) {
        super(ventana);
        this.JButtonBuscar = ventana.jButtonBuscar;
        this.JButtonRegistrar = ventana.jButtonRegistrar;
        this.jComboBoxParametro = ventana.jComboBoxParametro;
        this.jPasswordFieldContrasenia = ventana.jPasswordFieldContrasenia;
        this.jTableBusqueda = ventana.jTableBusqueda;
        this.jTextFieldBuscar = ventana.jTextFieldBuscar;
        this.jTextFieldDni = ventana.jTextFieldDni;
        caracteristicas.add("id");
        caracteristicas.add("empleado");
        caracteristicas.add("fechaformateada");
        caracteristicas.add("horaformateada");

        ventana.jButtonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    registrar();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
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
        if(tipoParametroBuscar.equals("fecha")) tipoParametroBuscar = "fechaformateada";
        String parametroBuscar = (jTextFieldBuscar.getText()).trim();
        funcionesTablaLinkedList.buscarTabla(jTableBusqueda, listaInicial, caracteristicas, tipoParametroBuscar, parametroBuscar);
        if(parametroBuscar.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese un parametro al buscar");
            return;
        }
        int respuesta = -1;
        respuesta = funcionesTablaLinkedList.buscarTabla(jTableBusqueda,listaInicial,caracteristicas,tipoParametroBuscar,parametroBuscar);
        if(respuesta == -1) javax.swing.JOptionPane.showMessageDialog((Component) ventana,"BUSQUEDA NO ENCONTRADA");
    }

    private void registrar() throws Exception {
        String dni = (jTextFieldDni.getText().trim());
        String contrasena = (String.valueOf((jPasswordFieldContrasenia.getPassword()))).trim();
        Date fechaActual =  new Date();
        if(dni.equals("")||contrasena.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese parametros");
            return;
        }
        BusquedaLinkedList buscar = new BusquedaLinkedList();

        int indice = buscar.busqueda(listaInicialEmpleados,"id", dni);
        if(indice==-1){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Dni no encontrado");
            return;
        }
        Empleado empleado = (Empleado) listaInicialEmpleados.get(indice);
        if (contrasena.equals(empleado.getContrasena())){
             Asistencia nuevaAsistencia = new Asistencia(listaInicial.size(), empleado.getNombre(), fechaActual);
             AsDao.create(nuevaAsistencia);
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Asistencia Registrada");
            this.listaInicial = new LinkedList<>(generador.generarAsistencias());
            return;
        }
        javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Contraseña Incorrecta");
    }

    @Override
    public void iniciarVentana() {ventana.iniciar();}
}
