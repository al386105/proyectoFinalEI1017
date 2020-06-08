package modelo.filtros;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

import java.util.Collection;
import java.util.LinkedList;


public class FiltroPorPrioridad implements Filtro {
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
            if (tarea.getPrioridad() == prioridad) tareasConFiltro.add(tarea) ;
        }
        return tareasConFiltro;
    }

}
