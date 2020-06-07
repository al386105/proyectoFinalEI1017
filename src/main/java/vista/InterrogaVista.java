package vista;

import modelo.tarea.Prioridad;

public interface InterrogaVista {
    //TODO: como solo hay un metodo aqui a lo mejor es conveniente unir interrogaVista e InformaVista en Vista
    Panel getPanel();

    String getFiltroPrioridad();

    String getFiltroCompletado();

    String getTitulo();

    String getDescripcion();

    String getPrioridad();

    boolean getCompletado();

    int getCodigo();


}
