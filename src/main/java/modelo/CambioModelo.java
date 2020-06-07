package modelo;

import vista.InformaVista;

public interface CambioModelo {
    void setGestorTareas(GestorTareas gestorTareas);

    void setVista(InformaVista informaVista);

    GestorTareas getGestorTareas();
}
