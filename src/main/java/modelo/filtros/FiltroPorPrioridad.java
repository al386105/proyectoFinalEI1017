package modelo.filtros;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FiltroPorPrioridad implements Filtro, Serializable {
    Prioridad prioridad;

    public FiltroPorPrioridad(){ super(); }

    public FiltroPorPrioridad(Prioridad prioridad){
        this.prioridad = prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public Collection<Tarea> filtrar(Collection<Tarea> tareas) {
        if (tareas.isEmpty()) return tareas;
        LinkedList<Tarea> tareasConFiltro = new LinkedList<>();
        for (Tarea tarea : tareas) {
            //TODO: Esto comparación puede que no esté bien:
            if (tarea.getPrioridad() == prioridad) tareasConFiltro.add(tarea) ;
        }
        return tareasConFiltro;
    }

}
