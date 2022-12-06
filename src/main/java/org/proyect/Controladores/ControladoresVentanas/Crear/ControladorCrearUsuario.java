package org.proyect.Controladores.ControladoresVentanas.Crear;

import org.proyect.Controladores.Algoritmos.Funciones.FuncionesTablaLinkedList;
import org.proyect.Controladores.BaseDatos.Dao.UsuarioDao;
import org.proyect.Controladores.Controlador;
import org.proyect.GenerarEmpleadosAsistencias;
import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearEmpleado;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ControladorCrearUsuario extends Controlador {

    GenerarEmpleadosAsistencias generador = GenerarEmpleadosAsistencias.singletonGenerador();
    LinkedList<Atributo> listaInicial = new LinkedList<>(generador.generarEmpleados());
    FuncionesTablaLinkedList funcionesTablaLinkedList = new FuncionesTablaLinkedList();
    UsuarioDao UsDao = new UsuarioDao();
    JComboBox<String> jComboBoxParametro;
    JPasswordField jPasswordField1;
    JPasswordField jPasswordField2;
    JTable jTableBusqueda;
    JTextField jTextFieldBuscarNombre;
    JTextField jTextFieldDni;
    JTextField jTextFieldEmail;
    JTextField jTextFieldNombre;
    JComboBox<String> jComboBoxDepartamento;
    ArrayList<String> caracteristicas = new ArrayList<>();

    public ControladorCrearUsuario(VentanaCrearEmpleado ventana) {
        super(ventana);
        this.jComboBoxParametro = ventana.jComboBoxParametro;
        this.jPasswordField1 = ventana.jPasswordField1;
        this.jPasswordField2 = ventana.jPasswordField2;
        this.jTableBusqueda = ventana.jTableBusqueda;
        this.jTextFieldBuscarNombre = ventana.jTextFieldBuscar;
        this.jComboBoxDepartamento = ventana.jComboBoxDepartamento;
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
                listaInicial = new LinkedList<>(generador.generarEmpleados());
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
        String contrasena1 = (String.valueOf(this.jPasswordField1.getPassword())).trim();
        String contrasena2 = String.valueOf(this.jPasswordField2.getPassword()).trim();
        String dni = (this.jTextFieldDni.getText().trim());
        String nombre = this.jTextFieldNombre.getText().trim();
        String  email = this.jTextFieldEmail.getText().trim();
        String departamento = ((String) this.jComboBoxDepartamento.getSelectedItem()).trim();

        if (contrasena1.equals("")||dni.equals("")||nombre.equals("")||email.equals("")||
                departamento.equals("")||contrasena2.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Rellene el formulario");
            return;
        }

        if(!contrasena1.equals(contrasena2)){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Las contraseñas son diferentes");
            return;
        }
        //comprobadores

        //fin de comprobadores
        Empleado nuevoEmpleado = new Empleado(Integer.parseInt(dni), nombre, email, contrasena1, departamento);
        UsDao.create(nuevoEmpleado);
    }

    @Override
    public void iniciarVentana() {ventana.iniciar();}
}
