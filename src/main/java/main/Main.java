package main;

import controlador.ImplementacionControlador;
import modelo.GestorTareas;
import modelo.ImplementacionModelo;
import modelo.TareaNoExistenteException;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.ImplementacionVista;

import java.util.Collection;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();
//
//        //Parte de pruebas:
//        //TODO: ESTO HABRA QUE CAMBIARLO CUANDO SE HAGA MVC:
//        Tarea llamarDentista = new Tarea("Llamar al dentista", "Pedir cita para limpieza bucal", Prioridad.ALTA, true);
//        Tarea irDentista = new Tarea("Ir al dentista", "Limpieza bucal a las 16 30", Prioridad.ALTA, false);
//        Tarea estudiar = new Tarea("Estudiar", "Estudiar programacion", Prioridad.ALTA, false);
//        Tarea entrenar = new Tarea("Entrenar", "Ir al gimnasio", Prioridad.NORMAL, true);
//        Tarea listarCompra = new Tarea("Listar Compra", "Hacer lista de la compra", Prioridad.NORMAL, false);
//        Tarea hacerCompra = new Tarea("Comprar", "Ir a comprar", Prioridad.BAJA, true);
//        Tarea hacerCompra2 = new Tarea("Comprar", "Comprar mas", Prioridad.BAJA, false);
//
//        gestorTareas.anadirTarea(llamarDentista);
//        gestorTareas.anadirTarea(irDentista);
//        gestorTareas.anadirTarea(estudiar);


        //Arranque del GUI:
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
