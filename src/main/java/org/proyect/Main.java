package org.proyect;

import org.proyect.Controladores.ControladoresVentanas.ControladorListarAsistencias;
import org.proyect.Controladores.ControladoresVentanas.ControladorListarEmpleados;

import org.proyect.Vistas.VentanasListar.VentanaRegistroAsistencias;
import org.proyect.Vistas.VentanasListar.VentanaRegistroEmpleados;

public class Main {
    static VentanaRegistroEmpleados ventana1 = new VentanaRegistroEmpleados();
    static ControladorListarEmpleados controlador1 = new ControladorListarEmpleados(ventana1);

    static VentanaRegistroAsistencias ventana2 = new VentanaRegistroAsistencias();
    static ControladorListarAsistencias controlador2 = new ControladorListarAsistencias(ventana2);

    public static void main(String[] args) throws Exception {
        controlador1.iniciarVentana();
        controlador2.iniciarVentana();
    }
}