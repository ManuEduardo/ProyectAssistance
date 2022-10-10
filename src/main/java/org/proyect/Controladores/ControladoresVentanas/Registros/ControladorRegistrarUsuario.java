package org.proyect.Controladores.ControladoresVentanas.Registros;

import org.proyect.Controladores.Controlador;
import org.proyect.Vistas.Ventana;

public class ControladorRegistrarUsuario extends Controlador {
    public ControladorRegistrarUsuario(Ventana ventana) {
        super(ventana);
    }

    @Override
    public void iniciarVentana() {
        ventana.iniciar();
    }
}
