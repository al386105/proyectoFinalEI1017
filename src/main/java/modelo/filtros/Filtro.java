package modelo.filtros;

import modelo.tarea.Tarea;

import java.util.List;

public interface Filtro {
    List<Tarea> filtrar(List<Tarea> tareas);
}
