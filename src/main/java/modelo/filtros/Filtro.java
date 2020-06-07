package modelo.filtros;

import modelo.tarea.Tarea;

import java.util.Collection;
import java.util.List;

public interface Filtro {
    Collection<Tarea> filtrar(Collection<Tarea> tareas);
}
