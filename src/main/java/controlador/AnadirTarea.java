package controlador;

import modelo.tarea.Prioridad;

import vista.InterrogaVista;

public class AnadirTarea extends Accion {

    @Override
    public void ejecutaAccion() {
        InterrogaVista vistaPanel = vista.getPanel();
        String tituloTarea = vistaPanel.getTitulo();
        String descripcionTarea = vistaPanel.getDescripcion();
        String prioridadTarea = vistaPanel.getPrioridad().toUpperCase();
        boolean completado = vistaPanel.getCompletado();
        gestorTareas.anadirTarea(tituloTarea, descripcionTarea, Prioridad.valueOf(prioridadTarea), completado);
    }
}
