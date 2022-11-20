package org.proyect.Controladores.ControladoresVentanas;

import org.proyect.Controladores.BaseDatos.Operaciones;
import org.proyect.Controladores.Controlador;
import org.proyect.Vistas.VentanasPrincipales.VentanaLogin;
import org.proyect.Vistas.VentanasPrincipales.VentanaMenuPrincipal;

import javax.swing.*;
import java.awt.*;

public class ControladorLogin extends Controlador {
    public static ControladorLogin SingletonInstance = null;

    VentanaMenuPrincipal ventanaMenu = new VentanaMenuPrincipal();
    ControladorMenuPrincipal controladorMenuPrincipal = new ControladorMenuPrincipal(ventanaMenu);

    JPasswordField jPasswordFieldContrasenia;
    JTextField jTextFieldDni;

    public static ControladorLogin singletonGenerador(VentanaLogin ventana){
        if(SingletonInstance == null){
            SingletonInstance = new ControladorLogin(ventana);
        }
        return SingletonInstance;
    }

    private ControladorLogin(VentanaLogin ventana) {
        super(ventana);
        this.jTextFieldDni = ventana.jTextFieldDni;
        this.jPasswordFieldContrasenia = ventana.jPasswordFieldContrasenia;

        ventana.jButtonIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {loguear();}
        });
    }

    private void loguear(){
        String dniIngresado = this.jTextFieldDni.getText().trim();
        String contrasenaIngresado = (String.valueOf(this.jPasswordFieldContrasenia.getPassword())).trim();
        if(Operaciones.verificarUsuario(dniIngresado, contrasenaIngresado)){
            controladorMenuPrincipal.iniciarVentana();
            ventana.cerrar();
        }else{
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Usuario o contraseña Incorrecto");
        }
    }

    @Override
    public void iniciarVentana() {
        this.ventana.iniciar();
    }

}
