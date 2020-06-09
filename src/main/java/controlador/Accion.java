package controlador;

import modelo.GestorTareas;
import modelo.TareaNoExistenteException;
import vista.InterrogaVista;

/**
 * Esta clase abstracta será heredada/extendida por las acciones que el usario puede realizar.
 * Estas acciones son: actualizar tareas, añadir tareas, aplicar filtros, y borrar tareas.
 * Con ello pretendo eliminar codigo repetido y desacoplar estas clases de la vista
 * (que es quien las usa) para hacer el programa más versátil.
 * Para realizarlo me he basado en el patrón de diseño Command
 * */

public abstract class Accion {
    static GestorTareas gestorTareas;
    static InterrogaVista vista;

    public Accion() { super(); }

    public abstract void ejecutaAccion() throws TareaNoExistenteException;

}
