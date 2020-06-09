package modelo.tarea;

import java.io.Serializable;

public enum Prioridad implements Serializable {
    BAJA("Prioridad baja"),
    NORMAL("Prioridad media"),
    ALTA("Prioridad Alta");

    private final String descripcion;

    private Prioridad(String descripcion){ this.descripcion = descripcion; }

    public String getDescripcion(){ return descripcion; }
}
