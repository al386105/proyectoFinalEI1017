package modelo;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

/**
 * Esta clase se ha realizado para implementar el patron de diseño Factory.
 * Con ello pretendo desacoplar la clase Tareas de la clase GestorTareas
 * eliminando el operador new de esta última clase.
 * */

public class FabricaTareas {
    public FabricaTareas() {super();}

    public Tarea getTarea(String titulo, String descripcion, Prioridad prioridad, boolean completada){
        return new Tarea(titulo, descripcion, prioridad, completada);
    }


}


