package controlador;

import modelo.filtros.FiltroPorEstado;
import modelo.filtros.FiltroPorPrioridad;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.InterrogaVista;
import java.util.Collection;

public class AplicarFiltros extends Accion {

    @Override
    public void ejecutaAccion() {
        InterrogaVista vistaPanel = vista.getPanel();
        String completado =  vistaPanel.getFiltroCompletado();
        String prioridad = vistaPanel.getFiltroPrioridad();
        Collection<Tarea> todasTareas = gestorTareas.devolverTareas();
        Collection<Tarea> tareasFiltradas;

        if(prioridad.equals("FILTRO ALTA")){
            gestorTareas.setFiltro(new FiltroPorPrioridad(Prioridad.ALTA));
            tareasFiltradas = gestorTareas.filtrar(todasTareas);
        }
        else if (prioridad.equals("FILTRO NORMAL")){
            gestorTareas.setFiltro(new FiltroPorPrioridad((Prioridad.NORMAL)));
            tareasFiltradas = gestorTareas.filtrar(todasTareas);
        }
        else if (prioridad.equals("FILTRO BAJA")){
            gestorTareas.setFiltro(new FiltroPorPrioridad(Prioridad.BAJA));
            tareasFiltradas = gestorTareas.filtrar(todasTareas);
        }
        else tareasFiltradas = todasTareas;


        if(completado.equals("FILTRO COMPLETADAS")){
            gestorTareas.setFiltro(new FiltroPorEstado(true));
            tareasFiltradas = gestorTareas.filtrar(tareasFiltradas);
        }
        else if (completado.equals("FILTRO NO COMPLETADAS")){
            gestorTareas.setFiltro(new FiltroPorEstado(false));
            tareasFiltradas = gestorTareas.filtrar(tareasFiltradas);
        }

        //Esta llamada a la vista no la he realizado desde el modelo porque
        vista.mostrarTareasFiltradas(tareasFiltradas);
    }
}
