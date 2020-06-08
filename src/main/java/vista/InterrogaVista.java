package vista;

import modelo.tarea.Tarea;

import java.util.Collection;

public interface InterrogaVista {
    Panel getPanel();

    String getFiltroPrioridad();

    String getFiltroCompletado();

    String getTitulo();

    String getDescripcion();

    String getPrioridad();

    boolean getCompletado();

    int getCodigo();

    void aplicarFiltros(Collection<Tarea> tareasFiltradas);




}
