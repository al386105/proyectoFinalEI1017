package modelo.tarea;

public enum Prioridad {
    BAJA("Prioridad baja"),
    NORMAL("Prioridad media"),
    ALTA("Prioridad Alta");

    private String descripcion;

    private Prioridad(String descripcion){ this.descripcion = descripcion; }

    public String getDescripcion(){ return descripcion; }
}
