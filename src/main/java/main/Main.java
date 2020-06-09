package main;

import controlador.ImplementacionControlador;
import modelo.GestorTareas;
import modelo.ImplementacionModelo;
import vista.ImplementacionVista;
import java.io.Serializable;


public class Main implements Serializable {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();

        //Arranque de la interfaz gráfica:
        ImplementacionControlador controlador = new ImplementacionControlador();
        ImplementacionModelo modelo = new ImplementacionModelo();
        ImplementacionVista vista = new ImplementacionVista();
        modelo.setGestorTareas(gestorTareas);
        modelo.setVista(vista);
        controlador.setModelo(modelo);
        controlador.setVista(vista);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}
