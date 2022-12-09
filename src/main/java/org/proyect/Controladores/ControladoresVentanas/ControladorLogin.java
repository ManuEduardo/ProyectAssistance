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
        if (!verificarCamposLogic(dniIngresado, contrasenaIngresado) ) return;
        if(Operaciones.verificarUsuario(dniIngresado, contrasenaIngresado)){
            controladorMenuPrincipal.iniciarVentana();
            ventana.cerrar();
        }
    }

    private boolean verificarCamposLogic(String dni, String contrasena){
        if(dni.equals("")||contrasena.equals("")){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Llene todos los campos");
            return false;
        }
        try {
            Integer.parseInt(dni);
        }catch (NumberFormatException e){
            javax.swing.JOptionPane.showMessageDialog((Component) ventana,"Tinene que ingresar un número en el dni");
            return false;
        }
        return true;
    }

    @Override
    public void iniciarVentana() {
        this.ventana.iniciar();
    }

}
