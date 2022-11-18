package org.proyect.Controladores.ControladoresVentanas;

import org.proyect.Controladores.ControladoresVentanas.Crear.ControladorCrearAsistencia;
import org.proyect.Controladores.ControladoresVentanas.Crear.ControladorCrearUsuario;
import org.proyect.Controladores.ControladoresVentanas.Listar.ControladorListarAsistencias;
import org.proyect.Controladores.ControladoresVentanas.Listar.ControladorListarEmpleados;
import org.proyect.Vistas.VentanasListar.VentanaRegistroAsistencias;
import org.proyect.Vistas.VentanasListar.VentanaRegistroEmpleados;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearAsistencia;
import org.proyect.Vistas.VentanasRegistrar.VentanaCrearEmpleado;

public class ConexionVentanasMenu {
    private final VentanaRegistroEmpleados ventana1 = new VentanaRegistroEmpleados();
    public ControladorListarEmpleados listarEmpleados = new ControladorListarEmpleados(ventana1);
    private final VentanaRegistroAsistencias ventana2 = new VentanaRegistroAsistencias();
    public ControladorListarAsistencias listarAsistencias = new ControladorListarAsistencias(ventana2);

    private final VentanaCrearEmpleado ventana4 = new VentanaCrearEmpleado();
    public ControladorCrearUsuario crearUsuario = new ControladorCrearUsuario(ventana4);
    private final VentanaCrearAsistencia ventana3 = new VentanaCrearAsistencia();
    public ControladorCrearAsistencia crearAsistencia = new ControladorCrearAsistencia(ventana3);
}
