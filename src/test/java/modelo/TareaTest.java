package modelo;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TareaTest {
    private static Tarea llamarDentista;
    private static Tarea irDentista;
    private static Tarea listarCompra;
    private static Tarea hacerCompra;
    private static Tarea hacerCompra2;

    @BeforeAll
    public static void init(){
        llamarDentista = new Tarea("Llamar al dentista", "Pedir cita para limpieza bucal", Prioridad.ALTA, false);
        irDentista = new Tarea("Ir al dentista", "Limpieza bucal a las 16 30", Prioridad.NORMAL, false);
        listarCompra = new Tarea("Listar Compra", "Hacer lista de la compra", Prioridad.BAJA, false);
        hacerCompra = new Tarea("Comprar", "Ir a comprar", Prioridad.ALTA, false);
        hacerCompra2 = new Tarea("Comprar", "Comprar mas", Prioridad.ALTA, false);

    }

    @Test
    public void compararTareaTest(){
        assertThat(hacerCompra2.equals(hacerCompra), is(false));
        assertThat(hacerCompra2.equals(hacerCompra2), is(true));
    }
}
