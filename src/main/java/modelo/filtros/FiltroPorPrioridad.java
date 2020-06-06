package modelo.filtros;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

import java.util.LinkedList;
import java.util.List;

public class FiltroPorPrioridad implements Filtro {
    Prioridad prioridad;

    @Override
    public List<Tarea> filtrar(List<Tarea> tareas) {
        if (tareas.isEmpty()) return tareas;
        LinkedList<Tarea> tareasConFiltro = new LinkedList<>();
        for (Tarea tarea : tareas) {
            //TODO: Esto comparación puede que no esté bien:
            if (tarea.getPrioridad().getDescripcion().equals(this.prioridad.getDescripcion())) tareasConFiltro.add(tarea) ;
        }
        return tareasConFiltro;
    }

}
