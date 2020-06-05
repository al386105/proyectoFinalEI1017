package modelo;
/**
 * Esta clase la he realizado para implementar el patron de diseño Factory.
 * Con ello pretendo desacoplar la clase Tareas de la Clase GestorTareas
 * */

public class FabricaTareas {
    public FabricaTareas() {super();}

    public Tarea getTarea(String titulo, String descripcion, Prioridad prioridad, boolean completada){
        return new Tarea(titulo, descripcion, prioridad, completada);
    }


}
