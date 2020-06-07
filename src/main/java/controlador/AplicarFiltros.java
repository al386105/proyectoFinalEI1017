package controlador;


import modelo.TareaNoExistenteException;
import modelo.filtros.Filtro;
import modelo.filtros.FiltroPorEstado;
import modelo.filtros.FiltroPorPrioridad;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.InterrogaVista;

import java.lang.reflect.Field;
import java.util.Collection;

public class AplicarFiltros extends Accion {

    @Override
    public void ejecutaAccion() {
        InterrogaVista vistaPanel = vista.getPanel();
        String completado =  vistaPanel.getFiltroCompletado();
        String prioridad = vistaPanel.getFiltroPrioridad();
        Collection<Tarea> todasTareas = gestorTareas.devolverTareas();
        Collection<Tarea> tareasFiltradas;
        Filtro filtro;
        if(completado.equals("true")){
            filtro = new FiltroPorEstado(true);
            gestorTareas.setFiltro(filtro);
            tareasFiltradas = gestorTareas.filtrar(todasTareas);
        }
        else if (completado.equals("false")){
            filtro = new FiltroPorEstado(false);
            gestorTareas.setFiltro(filtro);
            tareasFiltradas = gestorTareas.filtrar(todasTareas);
        }
        else {
            tareasFiltradas = todasTareas;
        }
        if(prioridad.equals("ALTA")){
            filtro = new FiltroPorPrioridad(Prioridad.ALTA);
            gestorTareas.setFiltro(filtro);
            tareasFiltradas = gestorTareas.filtrar(tareasFiltradas);
        }
        else if (prioridad.equals("NORMAL")){
            filtro = new FiltroPorPrioridad(Prioridad.NORMAL);
            gestorTareas.setFiltro(filtro);
            tareasFiltradas = gestorTareas.filtrar(tareasFiltradas);
        }
        else if (prioridad.equals("BAJA")){
            filtro = new FiltroPorPrioridad(Prioridad.BAJA);
            gestorTareas.setFiltro(filtro);
            tareasFiltradas = gestorTareas.filtrar(tareasFiltradas);
        }


    }
}
