package modelo;

import modelo.filtros.Filtro;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.InformaVista;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GestorTareas implements Serializable {
    private Map<Integer, Tarea> tareas; //Clave --> codigo de la tarea
    private transient InformaVista vista;
    private transient Filtro filtro;
    private static FabricaTareas fabricaTareas;


    public GestorTareas(){
        this.tareas = new HashMap<Integer, Tarea>();
        fabricaTareas = new FabricaTareas();
    }


    public void setVista(InformaVista vista) { this.vista = vista; }

    public void setFiltro(Filtro filtro) { this.filtro = filtro; }

    public boolean existeTarea(int codigoTarea){
        return tareas.containsKey(codigoTarea);
    }

    // El siguiente método se utiliza unicamente para los tests
    public void anadirTarea(Tarea tarea){
        tareas.put(tarea.getCodigo(), tarea);
    }

    public void anadirTarea(String titulo, String descripcion, Prioridad prioridad, boolean completada){
        Tarea tareaNueva = fabricaTareas.getTarea(titulo, descripcion, prioridad, completada);
        tareas.put(tareaNueva.getCodigo(), tareaNueva);
    }

    public void borrarTarea(int codigoTarea) throws TareaNoExistenteException{
        if(!existeTarea(codigoTarea)) throw new TareaNoExistenteException();
        tareas.remove(codigoTarea);
    }

    public void actualizarTarea(int codigoTarea, String titulo, String descripcion, Prioridad prioridad, boolean completada){
        Tarea tarea = tareas.get(codigoTarea);
        tarea.setTitulo(titulo);
        tarea.setDescripcion(descripcion);
        tarea.setPrioridad(prioridad);
        tarea.setCompletada(completada);
    }

    public Collection<Tarea> filtrar(Collection<Tarea> tareas){
        return filtro.filtrar(tareas);
    }

    public void mostrarFiltros(Collection<Tarea> tareasFiltradas) { vista.mostrarFiltros(tareasFiltradas);}

    public Tarea devolverTarea(int codigoTarea){ return tareas.get(codigoTarea); }


    public Collection<Tarea> devolverTareas(){
        return tareas.values();
    }

}
