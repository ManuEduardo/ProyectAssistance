package org.proyect.Controladores.ControladoresVentanas;

import org.proyect.Controladores.Controlador;
import org.proyect.Vistas.VentanasPrincipales.VentanaLogin;
import org.proyect.Vistas.VentanasPrincipales.VentanaMenuPrincipal;

public class ControladorMenuPrincipal extends Controlador {
    private final ConexionVentanasMenu ventanas = new ConexionVentanasMenu();
    public ControladorMenuPrincipal(VentanaMenuPrincipal ventana) {
        super(ventana);
        ventana.jButtonBuscarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {ventanaBuscarAsistencias();}
        });
        ventana.jButtonBuscarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {ventanaBuscarEmpleados();}
        });
        ventana.jButtonRegistrarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaCrearAsistencia();}
        });
        ventana.jButtonRegistrarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {ventanaCrearEmpleado();}
        });
        ventana.jButtonCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {salir();}
        });
    }

    @Override
    public void iniciarVentana() {
        this.ventana.iniciar();
    }

    private void ventanaBuscarAsistencias(){
        this.ventanas.listarAsistencias.iniciarVentana();
    }
    private void ventanaBuscarEmpleados(){
        this.ventanas.listarEmpleados.iniciarVentana();
    }
    private void VentanaCrearAsistencia(){
        this.ventanas.crearAsistencia.iniciarVentana();
    }
    private void ventanaCrearEmpleado(){
        this.ventanas.crearUsuario.iniciarVentana();
    }
    private void salir(){
        this.ventana.cerrar();
        VentanaLogin ventanaLogin = new VentanaLogin();
        ControladorLogin login = ControladorLogin.singletonGenerador(ventanaLogin);
        login.iniciarVentana();
    }
}
