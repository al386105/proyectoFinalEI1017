package modelo;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorTareasTest {
    private static GestorTareas gestorTareas;

    private static Tarea llamarDentista;
    private static Tarea irDentista;
    private static Tarea listarCompra;
    private static Tarea hacerCompra;
    private static Tarea hacerCompra2;

    @BeforeAll
    public static void init(){
        //Gestor
        gestorTareas = new GestorTareas();
        //Tareas:
        llamarDentista = new Tarea("Llamar al dentista", "Pedir cita para limpieza bucal", Prioridad.ALTA, false);
        irDentista = new Tarea("Ir al dentista", "Limpieza bucal a las 16 30", Prioridad.NORMAL, false);
        listarCompra = new Tarea("Listar Compra", "Hacer lista de la compra", Prioridad.BAJA, false);
        hacerCompra = new Tarea("Comprar", "Ir a comprar", Prioridad.ALTA, false);
        hacerCompra2 = new Tarea("Comprar", "Comprar mas", Prioridad.ALTA, false);
        //Añadimos tareas al gestor:
        gestorTareas.anadirTarea(llamarDentista);
        gestorTareas.anadirTarea(irDentista);
        gestorTareas.anadirTarea(listarCompra);
        gestorTareas.anadirTarea(hacerCompra);
    }

    @Test
    public void existeTareaTest(){
        assertThat(gestorTareas.existeTarea(llamarDentista.getCodigo()),is(true));
        assertThat(gestorTareas.existeTarea(irDentista.getCodigo()),is(true));
        assertThat(gestorTareas.existeTarea(listarCompra.getCodigo()),is(true));
        assertThat(gestorTareas.existeTarea(hacerCompra.getCodigo()),is(true));
        assertThat(gestorTareas.existeTarea(hacerCompra2.getCodigo()),is(false));
    }

    @Test
    public void anadirTareaTest(){

    }

    //TODO Mirar excepciones
    @Test
    public void borrarTareaTest(){
        assertThrows(TareaNoExistenteException.class,
                () -> gestorTareas.borrarTarea(-30));

    }

    @AfterAll
    public static void borrar(){ gestorTareas = null;}
}
