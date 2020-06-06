package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImplementacionVista {


    public void accionPermitida(String cadena){
        JOptionPane.showMessageDialog(null, cadena);
    }

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

        //SECCION FILTROS

        JPanel jPanelSeccion = new JPanel();
        jPanelSeccion.setLayout(new BoxLayout(jPanelSeccion, BoxLayout.X_AXIS));


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

        jPanelSeccion.add(jPanelPrioridad);

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


        jPanelSeccion.add(jPanelCompletadas);

        //Botón filtra:
        JButton aplicarFiltros = new JButton("Aplicar filtros");

        jPanelSeccion.add(aplicarFiltros);

        //SECCION LISTA DE TAREAS


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

        ventana.add(jPanelSeccion);
        ventana.pack();
        ventana.setVisible(true);
    }
}
