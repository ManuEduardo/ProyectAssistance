package org.proyect;

import org.proyect.Controladores.ControladoresVentanas.ControladorLogin;
import org.proyect.Vistas.VentanasPrincipales.VentanaLogin;

public class Main {

    static VentanaLogin ventanaL = new VentanaLogin();
    static ControladorLogin controladorL = ControladorLogin.singletonGenerador(ventanaL);

    public static void main(String[] args) throws Exception {
        controladorL.iniciarVentana();
    }
}