package modelo;

import modelo.tarea.Tarea;

import java.util.HashMap;
import java.util.Map;

public class GestorTareas {
    private Map<Integer, Tarea> tareas; //Clave --> codigo de la tarea
    //TODO; Si añadimos la tarea de la forma que hacemos ahora la fabrica no sirve para nada
    private FabricaTareas fabricaTareas;


    public GestorTareas(){
        this.tareas = new HashMap<Integer, Tarea>();
        this.fabricaTareas = new FabricaTareas();
    }

    public boolean existeTarea(int codigoTarea){
        if(tareas.containsKey(codigoTarea)) return true;
        return false;
    }

//    public void anadirTarea(String titulo, String descripcion, Prioridad prioridad, boolean completada){
//        Tarea nuevaTarea = fabricaTareas.getTarea(titulo, descripcion, prioridad, completada);
//
//    }

    public void anadirTarea(Tarea tarea){
        tareas.put(tarea.getCodigo(), tarea);

    }
    public void borrarTarea(int codigoTarea) throws TareaNoExistenteException{
        if(existeTarea(codigoTarea)) throw new TareaNoExistenteException();
        tareas.remove(codigoTarea);

    }

    //public void aplicarFiltros(){    }


}
