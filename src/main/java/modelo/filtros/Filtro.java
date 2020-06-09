package modelo.filtros;

import modelo.tarea.Tarea;
import java.util.Collection;

/**
 * Esta interfaz define que es lo que un filtro debe hacer.
 * Se ha utilizado el patrón de diseño Strategy.
 * Para ello se ha encupsulado lo que varia en dos clases (FiltroPorEstado y FiltroPorPrioridad),
 * que serán quienes implementen esta interfaz.
 * La clase GestorTareas será quien utilice estas clases aprovechando el polimorfismo.
**/

public interface Filtro {
    Collection<Tarea> filtrar(Collection<Tarea> tareas);
}
