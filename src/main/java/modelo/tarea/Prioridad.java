package modelo.tarea;

import java.io.Serializable;

public enum Prioridad implements Serializable {
    BAJA("Baja"),
    NORMAL("Normal"),
    ALTA("Alta");

    private final String descripcion;

    private Prioridad(String descripcion){ this.descripcion = descripcion; }

    public String getDescripcion(){ return descripcion; }
}
