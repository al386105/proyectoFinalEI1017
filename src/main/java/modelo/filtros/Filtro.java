package modelo.filtros;

import modelo.tarea.Tarea;
import java.util.Collection;

public interface Filtro {
    Collection<Tarea> filtrar(Collection<Tarea> tareas);
}
