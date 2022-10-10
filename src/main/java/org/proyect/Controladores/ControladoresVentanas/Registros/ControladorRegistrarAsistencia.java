package org.proyect.Controladores.ControladoresVentanas.Registros;

import org.proyect.Controladores.Controlador;
import org.proyect.Vistas.Ventana;

public class ControladorRegistrarAsistencia extends Controlador {
    public ControladorRegistrarAsistencia(Ventana ventana) {
        super(ventana);
    }

    @Override
    public void iniciarVentana() {
        ventana.iniciar();
    }
}
