package controlador;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.InterrogaVista;

public class AnadirTarea extends Accion {

    @Override
    public void ejecutaAccion() {
        InterrogaVista vistaPanel = vista.getPanel();
        String tituloTarea = vistaPanel.getTitulo();
        String descripcionTarea = vistaPanel.getDescripcion();
        Prioridad prioridadTarea = vistaPanel.getPrioridad();
        boolean completado = vistaPanel.getCompletado();
        //TODO: estaría bien que la Tarea la creara la fabrica!
        Tarea tarea = new Tarea(tituloTarea, descripcionTarea, prioridadTarea, completado);
        gestorTareas.anadirTarea(tarea);
    }
}
