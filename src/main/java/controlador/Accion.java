package controlador;

import modelo.GestorTareas;
import modelo.TareaNoExistenteException;
import vista.InterrogaVista;

public abstract class Accion {
    static GestorTareas gestorTareas;
    static InterrogaVista vista;

    public Accion() { super(); }

    public abstract void ejecutaAccion() throws TareaNoExistenteException;

}
