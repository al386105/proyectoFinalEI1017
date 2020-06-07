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

    }

    @Override
    public void importarDatos() {

    }

    @Override
    public void exportarDatos() {

    }

    @Override
    public void anadirCliente() {

    }

    @Override
    public void borrarCliente() throws TareaNoExistenteException {

    }

    @Override
    public void aplicarFiltros() {

    }

    @Override
    public void listarTareas() {

    }
}
