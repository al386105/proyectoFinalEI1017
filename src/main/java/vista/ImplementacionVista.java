package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.LinkedList;

public class ImplementacionVista implements InformaVista{
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InformaVista vista;
    private ModeloTabla modeloTabla;

    @Override
    public void accionPermitida(String cadena){
        JOptionPane.showMessageDialog(null, cadena);
    }

    @Override
    public void accionDenegada(String cadena){
        JOptionPane.showMessageDialog(null, cadena,"Error", JOptionPane.WARNING_MESSAGE);
    }

    public void creaGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { ventanaPrincipal(); }
        });
    }

    private void ventanaPrincipal(){
        JFrame ventana = new JFrame("Mis tareas");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        //SECCION FILTROS

        JPanel jPanelSeccionArriba = new JPanel();
        jPanelSeccionArriba.setLayout(new BoxLayout(jPanelSeccionArriba, BoxLayout.X_AXIS));


        //Prioridad
        JRadioButton alta = new JRadioButton("Alta");
        //Alomejor interesa establecer a los botones un SetActionComand:
        alta.setActionCommand("ALTA");
        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton baja = new JRadioButton("Baja");
        JRadioButton todas = new JRadioButton("Todas");

        JPanel jPanelPrioridad = new JPanel();
        jPanelPrioridad.setLayout(new BoxLayout(jPanelPrioridad, BoxLayout.PAGE_AXIS));
        jPanelPrioridad.add(new JLabel("Prioridad"));
        jPanelPrioridad.add(alta);
        jPanelPrioridad.add(normal);
        jPanelPrioridad.add(baja);
        jPanelPrioridad.add(todas);

        ButtonGroup grupoPrioridad = new ButtonGroup();
        grupoPrioridad.add(alta);
        grupoPrioridad.add(normal);
        grupoPrioridad.add(baja);
        grupoPrioridad.add(todas);

        jPanelSeccionArriba.add(jPanelPrioridad);

        //Completadas
        JRadioButton completada = new JRadioButton("Completada");
        JRadioButton noCompletada = new JRadioButton("No completada");
        JRadioButton todas2 = new JRadioButton(("Todas"));

        JPanel jPanelCompletadas = new JPanel();
        jPanelCompletadas.setLayout(new BoxLayout(jPanelCompletadas, BoxLayout.PAGE_AXIS));
        jPanelCompletadas.add(new JLabel("Completadas"));
        jPanelCompletadas.add(completada);
        jPanelCompletadas.add(noCompletada);
        jPanelCompletadas.add(todas2);

        ButtonGroup grupoCompletadas = new ButtonGroup();
        grupoCompletadas.add(completada);
        grupoCompletadas.add(noCompletada);
        grupoCompletadas.add(todas2);


        jPanelSeccionArriba.add(jPanelCompletadas);

        //Botón filtra:
        JButton aplicarFiltros = new JButton("Aplicar filtros");

        jPanelSeccionArriba.add(aplicarFiltros);

        panel.add(jPanelSeccionArriba);


        //SECCION LISTA DE TAREAS

        JPanel jPanelSeccionMedia = new JPanel();
        jPanelSeccionMedia.setLayout(new BoxLayout(jPanelSeccionMedia, BoxLayout.X_AXIS));

        String[] columnas = {"Tarea","Descripcion", "Terminada", "Prioridad"};
        //TODO: ESTO HABRA QUE CAMBIARLO CUANDO SE HAGA MVC:
        Tarea llamarDentista = new Tarea("Llamar al dentista", "Pedir cita para limpieza bucal", Prioridad.ALTA, true);
        Tarea irDentista = new Tarea("Ir al dentista", "Limpieza bucal a las 16 30", Prioridad.ALTA, false);
        Tarea estudiar = new Tarea("Estudiar", "Estudiar programacion", Prioridad.ALTA, false);
        Tarea entrenar = new Tarea("Entrenar", "Ir al gimnasio", Prioridad.NORMAL, true);
        Tarea listarCompra = new Tarea("Listar Compra", "Hacer lista de la compra", Prioridad.NORMAL, false);
        Tarea hacerCompra = new Tarea("Comprar", "Ir a comprar", Prioridad.BAJA, true);
        Tarea hacerCompra2 = new Tarea("Comprar", "Comprar mas", Prioridad.BAJA, false);
        Collection<Tarea> tareas = new LinkedList<>();
        tareas.add(llamarDentista);
        tareas.add(irDentista);
        tareas.add(estudiar);
        tareas.add(entrenar);
        tareas.add(listarCompra);
        tareas.add(hacerCompra);
        tareas.add(hacerCompra2);
        modeloTabla = new ModeloTabla(columnas, tareas);
        Tabla tabla = new Tabla(modeloTabla);

        jPanelSeccionMedia.add(tabla);

        panel.add(jPanelSeccionMedia);

        //Clase (interna) para importarDatos al abrir y exportarDatos al cerrar
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                //controlador.importarDatos();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //controlador.exportarDatosYSalir();
                System.exit(0);
            }
        });

        ventana.add(panel);
        ventana.pack();
        ventana.setVisible(true);
    }
}
