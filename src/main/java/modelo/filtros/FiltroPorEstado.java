package modelo.filtros;


import modelo.tarea.Tarea;

import java.util.LinkedList;
import java.util.List;

public class FiltroPorEstado implements Filtro {
    boolean completada;

    public FiltroPorEstado(){ super(); }

    public FiltroPorEstado(boolean completada){ this.completada = completada; }

    public void setEstado(boolean completada) { this.completada = completada; }

    @Override
    public List<Tarea> filtrar(List<Tarea> tareas) {
        if (tareas.isEmpty()) return tareas;
        List<Tarea> tareasConFiltro = new LinkedList<>();
        for (Tarea tarea : tareas) {
            if (tarea.completada() == this.completada) tareasConFiltro.add(tarea);
        }
        return tareasConFiltro;
    }
}
