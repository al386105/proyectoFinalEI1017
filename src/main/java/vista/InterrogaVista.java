package vista;

import modelo.tarea.Prioridad;

public interface InterrogaVista {
    //TODO: como solo hay un metodo aqui a lo mejor es conveniente unir interrogaVista e InformaVista en Vista
    Panel getPanel();

    String getTitulo();

    String getDescripcion();

    Prioridad getPrioridad();

    boolean getCompletado();

    int getCodigo();
}
