package modelo;

import vista.InformaVista;

public class ImplementacionModelo implements CambioModelo, InterrogaModelo{
    private InformaVista vista;
    private GestorTareas gestorTareas;

    public ImplementacionModelo(){ super(); }

    @Override
    public void setVista(InformaVista vista) {
        this.vista = vista;
        this.gestorTareas.setVista(vista);
    }

    @Override
    public void setGestorTareas(GestorTareas gestorTareas) { this.gestorTareas = gestorTareas; }

    @Override
    public GestorTareas getGestorTareas() { return this.gestorTareas; }
}
