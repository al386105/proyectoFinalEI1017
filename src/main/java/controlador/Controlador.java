package controlador;

import modelo.TareaNoExistenteException;

public interface Controlador {
    void importarDatos();

    void exportarDatos();

    void anadirCliente();

    void borrarCliente() throws TareaNoExistenteException;

    void aplicarFiltros();

    void listarTareas();
}
