package org.proyect.Controladores.ControladoresVentanas.Crear;

import org.proyect.Controladores.Algoritmos.Busqueda.BusquedaLinkedList;
import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTablaLinkedList;
import org.proyect.Controladores.BaseDatos.Dao.AsistenciaDao;
import org.proyect.Controladores.Controlador;
import org.proyect.Modelos.InstanciaEmpleadosAsistencias;
import org.proyect.Modelos.Asistencia;
import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearAsistencia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ControladorCrearAsistencia extends Controlador {

    InstanciaEmpleadosAsistencias generador = InstanciaEmpleadosAsistencias.singletonGenerador(); // Patron Singelton
    LinkedList<Atributo> listaInicial = new LinkedList<>(generador.getAsistencias()); // Generas las Listas
    FuncionesTablaLinkedList funcionesTablaLinkedList = new FuncionesTablaLinkedList();
    AsistenciaDao AsDao = new AsistenciaDao();
    JComboBox<String> jComboBoxParametro;
    JPasswordField jPasswordFieldContrasenia;
    JTable jTableBusqueda;
    JTextField jTextFieldBuscar;
    JTextField jTextFieldDni;
    ArrayList<String> caracteristicas = new ArrayList<>();

    public ControladorCrearAsistencia(VentanaCrearAsistencia ventana) {
        super(ventana);
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
        if(parametroBuscar.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese un parametro al buscar");
            return;
        }
        funcionesTablaLinkedList.buscarTabla(jTableBusqueda, listaInicial, caracteristicas, tipoParametroBuscar, parametroBuscar);
        int respuesta = -1;
        respuesta = funcionesTablaLinkedList.buscarTabla(jTableBusqueda,listaInicial,caracteristicas,tipoParametroBuscar,parametroBuscar);
        if(respuesta == -1) javax.swing.JOptionPane.showMessageDialog((Component) ventana,"BUSQUEDA NO ENCONTRADA");
    }

    private void registrar() throws Exception {
        LinkedList<Atributo> listaInicialEmpleados = new LinkedList<>(generador.getEmpleados());
        String dni = (jTextFieldDni.getText().trim());
        String contrasena = (String.valueOf((jPasswordFieldContrasenia.getPassword()))).trim();
        Date fechaActual =  new Date();
        // Si las entradas estan vacias
        if(dni.equals("")||contrasena.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Ingrese parametros");
            return;
        }

        BusquedaLinkedList buscar = new BusquedaLinkedList();
        //Busca el dni
        int indice = buscar.busqueda(listaInicialEmpleados,"id", dni);
        if(indice==-1){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Dni no encontrado");
            return;
        }
        //Guarda el empleado dueño de dni
        Empleado empleado = (Empleado) listaInicialEmpleados.get(indice);
        //Comparas contraseñas
        if (!contrasena.equals(empleado.getContrasena())){
            //si no es igual envia mensaje
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Contraseña Incorrecta");
            return;
        }
        //Crea la asistencia
        Asistencia nuevaAsistencia = new Asistencia(listaInicial.size(), empleado.getNombre(), fechaActual);
        //Agreda la asistencia usando el dao
        AsDao.create(nuevaAsistencia);
        javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Asistencia Registrada");
        this.listaInicial = new LinkedList<>(generador.getAsistencias());
    }

    @Override
    public void iniciarVentana() {ventana.iniciar();}
}
