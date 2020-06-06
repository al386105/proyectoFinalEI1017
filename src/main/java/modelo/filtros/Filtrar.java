package modelo.filtros;

import modelo.tarea.Tarea;

import java.util.List;

public class Filtrar {
    private Filtro filtro;


    public Filtrar(Filtro filtro){
        this.filtro = filtro;
    }

    public void setFiltro(Filtro filtro){
        this.filtro = filtro;
    }

    public List<Tarea> filtrar(List<Tarea> tareas){
        return filtro.filtrar(tareas);
    }
}
