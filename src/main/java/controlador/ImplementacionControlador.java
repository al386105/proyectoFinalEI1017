package controlador;

import modelo.CambioModelo;
import modelo.TareaNoExistenteException;
import vista.InterrogaVista;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControlador(){ super(); }

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
        Accion.gestorTareas = modelo.getGestorTareas();

    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
        Accion.vista = vista;
    }

    public InterrogaVista getVista() { return vista; }

    @Override
    public void importarDatos() { new ImportarDatos().cargarDatos(modelo); }

    @Override
    public void exportarDatos() { new ExportarDatos().guardarDatos(modelo.getGestorTareas());  }

    @Override
    public void anadirTarea() {
        new AnadirTarea().ejecutaAccion();
    }

    @Override
    public void borrarTarea() throws TareaNoExistenteException {
        new BorrarTarea().ejecutaAccion();
    }


    @Override
    public void aplicarFiltros() { new AplicarFiltros().ejecutaAccion(); }

}
