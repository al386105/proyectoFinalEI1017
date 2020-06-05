package modelo;

public class TareaNoExistenteException extends Exception {
    public TareaNoExistenteException() { super("Tarea no existente en la base de datos");}

}
