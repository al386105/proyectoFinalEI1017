package controlador;

import modelo.TareaNoExistenteException;
import vista.InterrogaVista;

public class BorrarTarea extends Accion {
    @Override
    public void ejecutaAccion() throws TareaNoExistenteException {
        InterrogaVista vistaPanel = vista.getPanel();
        int codigoTarea = vistaPanel.getCodigo();
        gestorTareas.borrarTarea(codigoTarea);
    }
}
