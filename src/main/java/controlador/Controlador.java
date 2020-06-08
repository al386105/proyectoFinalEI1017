package controlador;

import modelo.TareaNoExistenteException;

public interface Controlador {
    void importarDatos();

    void exportarDatos();

    void anadirTarea();

    void borrarTarea() throws TareaNoExistenteException;

    void aplicarFiltros();

}
