package modelo;

import modelo.filtros.Filtro;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import vista.InformaVista;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorTareas implements Serializable {
    private Map<Integer, Tarea> tareas; //Clave --> codigo de la tarea
    private transient InformaVista vista;
    private transient Filtro filtro;



    public GestorTareas(){
        this.tareas = new HashMap<Integer, Tarea>();
    }

    public void setVista(InformaVista vista) { this.vista = vista; }

    public void setFiltro(Filtro filtro) { this.filtro = filtro; }

    public boolean existeTarea(int codigoTarea){
        if(tareas.containsKey(codigoTarea)) return true;
        return false;
    }


    public void anadirTarea(Tarea tarea){
        tareas.put(tarea.getCodigo(), tarea);
    }

    public void borrarTarea(int codigoTarea) throws TareaNoExistenteException{
        if(!existeTarea(codigoTarea)) throw new TareaNoExistenteException();
        tareas.remove(codigoTarea);
    }

    public Collection<Tarea> filtrar(Collection<Tarea> tareas){
        return filtro.filtrar(tareas);
    }

    public Collection<Tarea> devolverTareas(){
        return tareas.values();
    }


}
