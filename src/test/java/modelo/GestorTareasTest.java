package modelo;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


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
        assertTrue(gestorTareas.existeTarea(llamarDentista.getCodigo()));
        assertTrue(gestorTareas.existeTarea(irDentista.getCodigo()));
        assertTrue(gestorTareas.existeTarea(listarCompra.getCodigo()));
        assertTrue(gestorTareas.existeTarea(hacerCompra.getCodigo()));
        assertFalse(gestorTareas.existeTarea(hacerCompra2.getCodigo()));
    }

    @Test
    public void borrarTareaTest() throws TareaNoExistenteException {
        assertTrue(gestorTareas.existeTarea(llamarDentista.getCodigo()));
        assertTrue(gestorTareas.existeTarea(irDentista.getCodigo()));
        gestorTareas.borrarTarea(llamarDentista.getCodigo());
        gestorTareas.borrarTarea(irDentista.getCodigo());
        assertFalse(gestorTareas.existeTarea(llamarDentista.getCodigo()));
        assertFalse(gestorTareas.existeTarea(irDentista.getCodigo()));
    }

    @Test
    public void TareaNoExistenteExcepcionTest(){
        assertThrows(TareaNoExistenteException.class,
                () -> gestorTareas.borrarTarea(-1));
    }

    @Test
    public void actualizarTarea(){
        gestorTareas.actualizarTarea(listarCompra.getCodigo(), "titulo modificado",
                "descripcion modificada", Prioridad.ALTA, true);
        assertTrue(gestorTareas.existeTarea(listarCompra.getCodigo()));
        Tarea tareaActualizada = gestorTareas.devolverTarea(listarCompra.getCodigo());
        assertThat(tareaActualizada.getDescripcion(), is ("descripcion modificada"));
        assertThat(tareaActualizada.getTitulo(), is("titulo modificado"));
        assertThat(tareaActualizada.completada(), is(true));
        assertThat(tareaActualizada.getPrioridad(), is (Prioridad.ALTA));
    }

    @AfterAll
    public static void borrar(){ gestorTareas = null;}
}
