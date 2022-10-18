package org.proyect;

import org.proyect.Controladores.ControladoresVentanas.Crear.ControladorListarAsistencias;
import org.proyect.Controladores.ControladoresVentanas.Crear.ControladorListarEmpleados;
import org.proyect.Vistas.VentanasListar.VentanaRegistroAsistencias;
import org.proyect.Vistas.VentanasListar.VentanaRegistroEmpleados;

import org.proyect.Controladores.ControladoresVentanas.Registros.ControladorCrearAsistencia;
import org.proyect.Controladores.ControladoresVentanas.Registros.ControladorCrearUsuario;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearEmpleado;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearAsistencia;


public class Main {
    static VentanaRegistroEmpleados ventana1 = new VentanaRegistroEmpleados();
    static ControladorListarEmpleados controlador1 = new ControladorListarEmpleados(ventana1);
    static VentanaRegistroAsistencias ventana2 = new VentanaRegistroAsistencias();
    static ControladorListarAsistencias controlador2 = new ControladorListarAsistencias(ventana2);

    static VentanaCrearEmpleado ventana4 = new VentanaCrearEmpleado();
    static ControladorCrearUsuario controlador3 = new ControladorCrearUsuario(ventana4);
    static VentanaCrearAsistencia ventana3 = new VentanaCrearAsistencia();
    static ControladorCrearAsistencia controlador4 = new ControladorCrearAsistencia(ventana3);


    public static void main(String[] args) throws Exception {
        controlador1.iniciarVentana();// Listar Empleados
        controlador2.iniciarVentana();// Listar Asistencias
        controlador3.iniciarVentana();// Crear Empleado
        controlador4.iniciarVentana();// Crear Asistencia
    }
}