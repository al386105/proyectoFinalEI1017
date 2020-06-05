package modelo;

public class Tarea {
    //ATRIBUTOS
    private int codigo;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    protected boolean completada;

    //CONSTRUCTORES
    public Tarea(){ super(); }

    public Tarea(String titulo, String descripcion, Prioridad prioridad, boolean completada){
        this.codigo = this.hashCode();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    //METODOS
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo(){ return titulo;}

    public String getDescripcion(){ return descripcion;}

    public boolean completada(){ return completada; }
}
