package modelo;

import modelo.filtros.Filtrar;
import modelo.filtros.FiltroPorEstado;
import modelo.filtros.FiltroPorPrioridad;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FiltrarTest {
    private static List<Tarea> listaTareasVacia;
    private static List<Tarea> listaTareas;
    private static Filtrar filtrar;
    private static FiltroPorPrioridad filtroPorPrioridad;
    private static FiltroPorEstado filtroPorEstado;

    //TODO: para eliminar codigo repetido a lo mejor es buena idea usar beforeEach y afterEach para inicializar cda listaFiltrada


    @BeforeAll
    public static void init(){
        filtrar = new Filtrar();
        filtroPorEstado = new FiltroPorEstado();
        filtroPorPrioridad = new FiltroPorPrioridad();
        //Instanciamos las listas
        listaTareasVacia = new LinkedList<>();
        listaTareas = new LinkedList<>();
        //Instanciamos las tareas
        Tarea llamarDentista = new Tarea("Llamar al dentista", "Pedir cita para limpieza bucal", Prioridad.ALTA, true);
        Tarea irDentista = new Tarea("Ir al dentista", "Limpieza bucal a las 16 30", Prioridad.ALTA, false);
        Tarea estudiar = new Tarea("Estudiar", "Estudiar programacion", Prioridad.ALTA, false);
        Tarea entrenar = new Tarea("Entrenar", "Ir al gimnasio", Prioridad.NORMAL, true);
        Tarea listarCompra = new Tarea("Listar Compra", "Hacer lista de la compra", Prioridad.NORMAL, false);
        Tarea hacerCompra = new Tarea("Comprar", "Ir a comprar", Prioridad.BAJA, true);
        Tarea hacerCompra2 = new Tarea("Comprar", "Comprar mas", Prioridad.BAJA, false);
        //Añadimos las tareas a la lista.
        listaTareas.add(llamarDentista);
        listaTareas.add(irDentista);
        listaTareas.add(entrenar);
        listaTareas.add(estudiar);
        listaTareas.add(listarCompra);
        listaTareas.add(hacerCompra);
        listaTareas.add(hacerCompra2);
    }

    @Test
    public void filtrarPorCompletado() {
        //Se filtrará por aquellas tareas que han sido completadas (completadas == true)
        filtroPorEstado.setEstado(true);
        filtrar.setFiltro(filtroPorEstado);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        for (Tarea tarea : listaFiltrada) {
            assertTrue(tarea.completada());
        }
        //Tambien se comprueba que si se filtra una lista sin tareas nos devuelve la lista vacia
        List<Tarea> listaFiltradaVacia = filtrar.filtrar(listaTareasVacia);
        assertTrue(listaFiltradaVacia.isEmpty());
    }

    @Test
    public void filtrarPorNoCompletado(){
        //Ahora, por aquellas que aún no han sido completadas (completadas==false)
        filtroPorEstado.setEstado(false);
        filtrar.setFiltro(filtroPorEstado);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        for (Tarea tarea : listaFiltrada) {
            assertFalse(tarea.completada());
        }
        //Tambien se comprueba que si se filtra una lista sin tareas nos devuelve la lista vacia
        List<Tarea> listaFiltradaVacia = filtrar.filtrar(listaTareasVacia);
        assertTrue(listaFiltradaVacia.isEmpty());
    }


    @Test
    public void filtrarPorPrioridadAlta(){
        filtroPorPrioridad.setPrioridad(Prioridad.ALTA);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        for (Tarea tarea : listaFiltrada) {
            assertEquals(Prioridad.ALTA, tarea.getPrioridad());
        }
        //Tambien se comprueba que si se filtra una lista sin tareas nos devuelve la lista vacia
        List<Tarea> listaFiltradaVacia = filtrar.filtrar(listaTareasVacia);
        assertTrue(listaFiltradaVacia.isEmpty());
    }

    @Test
    public void filtrarPorPrioridadNormal(){
        filtroPorPrioridad.setPrioridad(Prioridad.NORMAL);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        for (Tarea tarea : listaFiltrada) {
            assertEquals(Prioridad.NORMAL, tarea.getPrioridad());
        }
        //Tambien se comprueba que si se filtra una lista sin tareas nos devuelve la lista vacia
        List<Tarea> listaFiltradaVacia = filtrar.filtrar(listaTareasVacia);
        assertTrue(listaFiltradaVacia.isEmpty());
    }

    @Test
    public void filtrarPorPrioridadBaja(){
        filtroPorPrioridad.setPrioridad(Prioridad.BAJA);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        for (Tarea tarea : listaFiltrada) {
            assertEquals(Prioridad.BAJA, tarea.getPrioridad());
        }
        //Tambien se comprueba que si se filtra una lista sin tareas nos devuelve la lista vacia
        List<Tarea> listaFiltradaVacia = filtrar.filtrar(listaTareasVacia);
        assertTrue(listaFiltradaVacia.isEmpty());
    }

    @Test
    public void filtrarPorPrioridadAltaCompletado(){
        filtroPorPrioridad.setPrioridad(Prioridad.ALTA);
        filtroPorEstado.setEstado(true);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        filtrar.setFiltro(filtroPorEstado);
        listaFiltrada = filtrar.filtrar(listaFiltrada);
        for(Tarea tarea : listaFiltrada){
            assertEquals(Prioridad.ALTA, tarea.getPrioridad());
            assertTrue(tarea.completada());
        }
    }
    @Test
    public void filtrarPorPrioridadAltaNoCompletado(){
        filtroPorPrioridad.setPrioridad(Prioridad.ALTA);
        filtroPorEstado.setEstado(false);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        filtrar.setFiltro(filtroPorEstado);
        listaFiltrada = filtrar.filtrar(listaFiltrada);
        for(Tarea tarea : listaFiltrada){
            assertEquals(Prioridad.ALTA, tarea.getPrioridad());
            assertFalse(tarea.completada());
        }
    }

    @Test
    public void filtrarPorPrioridadNormalCompletado(){
        filtroPorPrioridad.setPrioridad(Prioridad.NORMAL);
        filtroPorEstado.setEstado(true);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        filtrar.setFiltro(filtroPorEstado);
        listaFiltrada = filtrar.filtrar(listaFiltrada);
        for(Tarea tarea : listaFiltrada){
            assertEquals(Prioridad.NORMAL, tarea.getPrioridad());
            assertTrue(tarea.completada());
        }
    }
    @Test
    public void filtrarPorPrioridadNormalNoCompletado(){
        filtroPorPrioridad.setPrioridad(Prioridad.NORMAL);
        filtroPorEstado.setEstado(false);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        filtrar.setFiltro(filtroPorEstado);
        listaFiltrada = filtrar.filtrar(listaFiltrada);
        for(Tarea tarea : listaFiltrada){
            assertEquals(Prioridad.NORMAL, tarea.getPrioridad());
            assertFalse(tarea.completada());
        }
    }

    @Test
    public void filtrarPorPrioridadBajaCompletado(){
        filtroPorPrioridad.setPrioridad(Prioridad.BAJA);
        filtroPorEstado.setEstado(true);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        filtrar.setFiltro(filtroPorEstado);
        listaFiltrada = filtrar.filtrar(listaFiltrada);
        for(Tarea tarea : listaFiltrada){
            assertEquals(Prioridad.BAJA, tarea.getPrioridad());
            assertTrue(tarea.completada());
        }
    }
    @Test
    public void filtrarPorPrioridadBajaNoCompletado(){
        filtroPorPrioridad.setPrioridad(Prioridad.BAJA);
        filtroPorEstado.setEstado(false);
        filtrar.setFiltro(filtroPorPrioridad);
        List<Tarea> listaFiltrada = filtrar.filtrar(listaTareas);
        filtrar.setFiltro(filtroPorEstado);
        listaFiltrada = filtrar.filtrar(listaFiltrada);
        for(Tarea tarea : listaFiltrada){
            assertEquals(Prioridad.BAJA, tarea.getPrioridad());
            assertFalse(tarea.completada());
        }
    }


    @AfterAll
    public static void borra(){
        listaTareas = null;
    }


}
