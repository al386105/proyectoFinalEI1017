package vista;

import modelo.TareaNoExistenteException;
import modelo.tarea.Tarea;

import java.util.Collection;

public interface InterrogaVista {
    Panel getPanel();

    String getFiltroPrioridad();

    String getFiltroCompletado();

    String getTitulo();

    String getDescripcion();

    String getPrioridad();

    boolean getCompletado();



    int getCodigo() throws TareaNoExistenteException;





}
