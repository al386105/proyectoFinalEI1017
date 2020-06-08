package vista;

import controlador.Controlador;
import modelo.GestorTareas;
import modelo.InterrogaModelo;
import modelo.TareaNoExistenteException;

import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;


public class Panel extends JPanel implements InterrogaVista{
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InformaVista vista;
    private ModeloTabla modeloTabla;
    private Tabla tabla;
    private JTextField jTextFieldTitulo;
    private JTextArea jTextAreaDescripcion;
    private JCheckBox jCheckBoxCompletada;
    private String tipoTarea;
    private String tipoFiltroPrioridad;
    private String tipoFiltroCompletado;


    public Panel(){
        super();
        creaPanel();
    }

    public void setModelo(InterrogaModelo modelo) { this.modelo = modelo; }

    public void setControlador(Controlador controlador) { this.controlador = controlador; }

    public void setVista(InformaVista vista) { this.vista = vista; }

    private void creaPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Escuchador de los botones:
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String comando = actionEvent.getActionCommand();
                if(comando.equals("NUEVO")) {
                    controlador.anadirTarea();
                }
                else if (comando.equals("BORRA")){
                    try{
                        controlador.borrarTarea();
                    } catch (TareaNoExistenteException exception){
                        vista.accionDenegada(exception.getMessage());
                    }
                }
                else if (comando.equals("ACTUALIZA")){
                    System.out.println(actionEvent);
                    cargarDatosTabla();
                }
                else {
                    System.out.println(actionEvent);
                    controlador.aplicarFiltros();
                }
            }
        };

        //SECCION FILTROS

        JPanel jPanelSeccionArriba = new JPanel();
        jPanelSeccionArriba.setLayout(new BoxLayout(jPanelSeccionArriba, BoxLayout.X_AXIS));


        //Prioridad
        JRadioButton jRButtonAlta = new JRadioButton("Alta");
        jRButtonAlta.setActionCommand("FILTRO ALTA");
        JRadioButton jRButtonNormal = new JRadioButton("Normal");
        jRButtonNormal.setActionCommand("FILTRO NORMAL");
        JRadioButton jRButtonBaja = new JRadioButton("Baja");
        jRButtonBaja.setActionCommand("FILTRO BAJA");
        JRadioButton jRButtonTodas = new JRadioButton("Todas", true);
        jRButtonTodas.setActionCommand("FILTRO TODAS");

        ActionListener escuchadorTipoFiltroPrioridad = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tipoFiltroPrioridad = actionEvent.getActionCommand();
                System.out.println(actionEvent);
            }
        };
        jRButtonAlta.addActionListener(escuchadorTipoFiltroPrioridad);
        jRButtonNormal.addActionListener(escuchadorTipoFiltroPrioridad);
        jRButtonBaja.addActionListener(escuchadorTipoFiltroPrioridad);
        jRButtonTodas.addActionListener(escuchadorTipoFiltroPrioridad);

        JPanel jPanelPrioridad = new JPanel();
        jPanelPrioridad.setLayout(new BoxLayout(jPanelPrioridad, BoxLayout.PAGE_AXIS));
        jPanelPrioridad.add(new JLabel("Prioridad"));
        jPanelPrioridad.add(jRButtonAlta);
        jPanelPrioridad.add(jRButtonNormal);
        jPanelPrioridad.add(jRButtonBaja);
        jPanelPrioridad.add(jRButtonTodas);

        ButtonGroup grupoPrioridad = new ButtonGroup();
        grupoPrioridad.add(jRButtonAlta);
        grupoPrioridad.add(jRButtonNormal);
        grupoPrioridad.add(jRButtonBaja);
        grupoPrioridad.add(jRButtonTodas);

        jPanelSeccionArriba.add(jPanelPrioridad);

        //Completadas
        JRadioButton jRButtonCompletada = new JRadioButton("Completada");
        jRButtonCompletada.setActionCommand("FILTRO COMPLETADAS");
        JRadioButton jRButtonNoCompletada = new JRadioButton("No completada");
        jRButtonNoCompletada.setActionCommand("FILTRO NO COMPLETADAS");
        JRadioButton jRButtonTodasB = new JRadioButton("Todas", true);
        jRButtonTodasB.setActionCommand("FILTRO TODAS");

        ActionListener escuchadorFiltroCompletado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tipoFiltroCompletado = actionEvent.getActionCommand();
                System.out.println(actionEvent);
            }
        };
        jRButtonCompletada.addActionListener(escuchadorFiltroCompletado);
        jRButtonNoCompletada.addActionListener(escuchadorFiltroCompletado);
        jRButtonTodasB.addActionListener(escuchadorFiltroCompletado);

        JPanel jPanelCompletadas = new JPanel();
        jPanelCompletadas.setLayout(new BoxLayout(jPanelCompletadas, BoxLayout.PAGE_AXIS));
        jPanelCompletadas.add(new JLabel("Completadas"));
        jPanelCompletadas.add(jRButtonCompletada);
        jPanelCompletadas.add(jRButtonNoCompletada);
        jPanelCompletadas.add(jRButtonTodasB);

        ButtonGroup grupoCompletadas = new ButtonGroup();
        grupoCompletadas.add(jRButtonCompletada);
        grupoCompletadas.add(jRButtonNoCompletada);
        grupoCompletadas.add(jRButtonTodasB);


        jPanelSeccionArriba.add(jPanelCompletadas);

        //Botón filtra:
        JButton jButtonAplicarFiltros = new JButton("Aplicar filtros");
        jButtonAplicarFiltros.setActionCommand("APLICARFILTROS");


        jPanelSeccionArriba.add(jButtonAplicarFiltros);

        this.add(jPanelSeccionArriba);


        //SECCION LISTA DE TAREAS

        JPanel jPanelSeccionMedia = new JPanel();
        jPanelSeccionMedia.setLayout(new BoxLayout(jPanelSeccionMedia, BoxLayout.X_AXIS));


        String[] columnas = {"Tarea","Descripcion", "Terminada", "Prioridad"};
//        GestorTareas gestorTareas = modelo.getGestorTareas();
//        Collection<Tarea> tareas = gestorTareas.devolverTareas();
        Collection<Tarea> tareas = new LinkedList<>();
        modeloTabla = new ModeloTabla(columnas, tareas);
        tabla = new Tabla(modeloTabla);

        //crea el escuchador de la tabla
        ListSelectionListener escuchadorTabla = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //si se ejecuta este metodo porque se da al boton de actualizar
                //y no se selecciona ninguna fila
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if(lsm.getMinSelectionIndex() == -1) return;

                if (!e.getValueIsAdjusting()) {
                    int fila = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                    //TODO: Aqui estaria muy bien obtener el codigo
                    String titulo = (String) modeloTabla.getValueAt(fila, 0);
                    //datosFactura(codTabla);
                }
            }
        };

//        ActionListener escuchadorActualiza = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                tabla.setModel(modeloTabla = new ModeloTabla(columnas, tareas));
//                tabla.ajustarAnchoColumnas();
//            }
//        };

        jPanelSeccionMedia.add(tabla);
        Scroll scroll = new Scroll();
        jPanelSeccionMedia = scroll.ejecuta(tabla, jPanelSeccionMedia, escuchadorTabla);
        this.add(jPanelSeccionMedia);


        //SECCION DETALLE DE LA TAREA
        JPanel jPanelseccionBaja = new JPanel();
        jPanelseccionBaja.setLayout(new BoxLayout(jPanelseccionBaja, BoxLayout.Y_AXIS));

        //Titulo:

        JPanel titulo = new JPanel();
        titulo.setLayout(new BoxLayout(titulo, BoxLayout.X_AXIS));

        titulo.add(new JLabel("Título: "));
        jTextFieldTitulo = new JTextField("Volver a mirar las estrellas. ");
        titulo.add(jTextFieldTitulo);

        jPanelseccionBaja.add(titulo);

        //Descripcion:
        JPanel descripcion = new JPanel();
        descripcion.setLayout(new BoxLayout(descripcion, BoxLayout.X_AXIS));

        descripcion.add(new JLabel("Descripcion: "));
        jTextAreaDescripcion = new JTextArea(5,1);
        descripcion.add(jTextAreaDescripcion);

        jPanelseccionBaja.add(descripcion);

        //Estado
        jCheckBoxCompletada = new JCheckBox("Completada");

        jPanelseccionBaja.add(jCheckBoxCompletada);

        //Prioridad
        JPanel prioridad = new JPanel();
        prioridad.setLayout(new BoxLayout(prioridad, BoxLayout.X_AXIS));

        JRadioButton jRButtonAlta2 = new JRadioButton("Alta");
        jRButtonAlta2.setActionCommand("ALTA");
        JRadioButton jRButtonNormal2 = new JRadioButton("Normal");
        jRButtonNormal2.setActionCommand("NORMAL");
        JRadioButton jRButtonBaja2 = new JRadioButton("Baja", true);
        jRButtonBaja2.setActionCommand("BAJA");

        ActionListener escuchadorTipoTarea = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tipoTarea = actionEvent.getActionCommand();
                System.out.println(actionEvent);
            }
        };
        jRButtonAlta2.addActionListener(escuchadorTipoTarea);
        jRButtonNormal2.addActionListener(escuchadorTipoTarea);
        jRButtonBaja2.addActionListener(escuchadorTipoTarea);


        prioridad.add(jRButtonAlta2);
        prioridad.add(jRButtonNormal2);
        prioridad.add(jRButtonBaja2);

        ButtonGroup grupoPrioridad2 = new ButtonGroup();
        grupoPrioridad2.add(jRButtonAlta2);
        grupoPrioridad2.add(jRButtonNormal2);
        grupoPrioridad2.add(jRButtonBaja2);

        jPanelseccionBaja.add(prioridad);

        //Botones:
        JPanel botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));

        JButton jButtonNuevo = new JButton("Nuevo");
        jButtonNuevo.setActionCommand("NUEVO");
        JButton jButtonActualiza = new JButton("Actualiza");
        jButtonActualiza.setActionCommand("ACTUALIZA");
        JButton jButtonBorra = new JButton("Borra");
        jButtonBorra.setActionCommand("BORRA");




        jButtonAplicarFiltros.addActionListener(escuchadorBoton);
        jButtonNuevo.addActionListener(escuchadorBoton);
        jButtonBorra.addActionListener(escuchadorBoton);
        jButtonActualiza.addActionListener(escuchadorBoton);


        botones.add(jButtonNuevo);
        botones.add(jButtonActualiza);
        botones.add(jButtonBorra);

        jPanelseccionBaja.add(botones);

        this.add(jPanelseccionBaja);

    }

    public void cargarDatosTabla(){
        String[] columnas = {"Tarea","Descripcion", "Terminada", "Prioridad"};
        GestorTareas gestorTareas = modelo.getGestorTareas();
        Collection<Tarea> tareas = gestorTareas.devolverTareas();
        tabla.setModel(modeloTabla = new ModeloTabla(columnas, tareas));
        tabla.ajustarAnchoColumnas();
    }

    @Override
    public Panel getPanel() {
        return this;
    }

    @Override
    public String getFiltroPrioridad() {
        System.out.println(tipoFiltroPrioridad+ " TFP");
        return tipoFiltroPrioridad;
    }

    @Override
    public String getFiltroCompletado() {
        System.out.println(tipoFiltroCompletado + " TFC");
        return tipoFiltroCompletado;
    }

    @Override
    public String getTitulo() {
        return jTextFieldTitulo.getText();
    }

    @Override
    public String getDescripcion() {
        return jTextAreaDescripcion.getText();
    }

    @Override
    public String getPrioridad() {
        System.out.println( tipoTarea + " TT");
        return tipoTarea;
    }

    @Override
    public boolean getCompletado() {
        System.out.println(jCheckBoxCompletada.isSelected());
        return jCheckBoxCompletada.isSelected();
    }

    @Override
    public int getCodigo() {
        return 0;
    }
}
