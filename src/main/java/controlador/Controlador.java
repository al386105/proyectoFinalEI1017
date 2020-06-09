package controlador;

import modelo.TareaNoExistenteException;

/**
 * En esta interfaz se difinen las acciones que el controlador va a realizar.
 * */

public interface Controlador {
    void importarDatos();

    void exportarDatos();

    void anadirTarea();

    void borrarTarea() throws TareaNoExistenteException;

    void aplicarFiltros();

    void actualizarTarea() throws TareaNoExistenteException;

}
