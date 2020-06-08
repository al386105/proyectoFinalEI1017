package controlador;

import modelo.TareaNoExistenteException;
import modelo.tarea.Prioridad;
import vista.InterrogaVista;


public class ActualizarTarea extends Accion {
    @Override
    public void ejecutaAccion() throws TareaNoExistenteException {
        InterrogaVista vistaPanel = vista.getPanel();
        int codigo = vistaPanel.getCodigo();
        String tituloTarea = vistaPanel.getTitulo();
        String descripcionTarea = vistaPanel.getDescripcion();
        String prioridadTarea = vistaPanel.getPrioridad().toUpperCase();
        boolean completado = vistaPanel.getCompletado();
        gestorTareas.actualizarTarea(codigo, tituloTarea, descripcionTarea, Prioridad.valueOf(prioridadTarea),completado);
    }
}
