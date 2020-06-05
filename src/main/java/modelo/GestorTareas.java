package modelo;

import java.util.HashMap;
import java.util.Map;

public class GestorTareas {
    private Map<Integer, Tarea> tareas; //Clave --> codigo de la tarea
    private FabricaTareas fabricaTareas;

    public GestorTareas(){
        this.tareas = new HashMap<Integer, Tarea>();
        this.fabricaTareas = new FabricaTareas();
    }

    public void anadirTarea(String titulo, String descripcion, Prioridad prioridad, boolean completada){
        Tarea nuevaTarea = fabricaTareas.getTarea(titulo, descripcion, prioridad, completada);

    }

    public void borrarTarea(int codigoTarea) throws TareaNoExistenteException{
        if(tareas.containsKey(codigoTarea)) throw new TareaNoExistenteException();
        tareas.remove(codigoTarea);

    }

    //public void aplicarFiltros(){    }


}
