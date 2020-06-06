package main;

import controlador.ImplementacionControlador;
import modelo.GestorTareas;
import modelo.TareaNoExistenteException;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.ImplementacionVista;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();


        //Arranque del GUI:
        ImplementacionVista vista = new ImplementacionVista();
        vista.creaGUI();


//        Parte de pruebas
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
//        gestorTareas.anadirTarea(entrenar);
//        gestorTareas.anadirTarea(listarCompra);
//        gestorTareas.anadirTarea(hacerCompra);
//
//        System.out.println(gestorTareas.listarTareas());
//
//        try {
//            gestorTareas.borrarTarea(estudiar.getCodigo());
//            gestorTareas.borrarTarea(listarCompra.getCodigo());
//        } catch (TareaNoExistenteException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(gestorTareas.listarTareas());
//
//        try {
//           gestorTareas.borrarTarea(hacerCompra2.getCodigo());
//        } catch (TareaNoExistenteException e) {
//            e.printStackTrace();
//        }
    }
}
